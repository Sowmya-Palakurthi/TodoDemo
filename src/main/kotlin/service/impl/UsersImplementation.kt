package com.example.service.impl

import com.example.database.dataclasses.UpdatePasswordRequest
import com.example.database.dataclasses.userRequest
import com.example.database.dataclasses.userResponse
import com.example.database.dataclasses.users
import com.example.database.dataclasses.users.emailid
import org.jetbrains.exposed.sql.and
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import com.example.datalayer.RedisClient.jedis
import com.example.datalayer.redisActions
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import com.example.service.actions.UserActions
import javax.inject.Inject

/**
 * Feedback:
 * 1. Repository Layer is missing
 * 2. Keep all DB operations in Repository Layer and implement there and inject in service layer
 * 3. Primary key should be
 * **/
class UsersImplementation @Inject constructor(  private val redisCache: redisActions) : UserActions {

    override suspend fun getUser(emailId: String): userResponse? {
        val cachedUser = redisCache.getUserData(emailId)
        if (cachedUser != null) {
            return Json.decodeFromString(cachedUser)
        }
        val userFromDb = transaction {
            // FIXME: Write Repository Layer and move this logic in that and do Dependency Injection In Service Class
            users.select { users.emailid eq emailId }.singleOrNull()?.let {
                userResponse(
                    emailid = it[users.emailid],
                    username = it[users.username]
                )
            }
        }
        userFromDb?.let {
            redisCache.setUserData(Json.encodeToString(it), 3600, emailId)
        }
        return userFromDb
    }

    override suspend fun addUser(request: userRequest): Boolean {
        // FIXME: Move this in Repository Layer
        return transaction {
            users.insert {
                it[emailid] = request.emailid
                it[username] = request.username
                it[password] = request.password
            }
            redisCache.addUserData(request) // Cache new user
            true
        }
    }

    override suspend fun deleteUser(request: userRequest): Boolean {
        return transaction {
            val user = users.select { users.emailid eq request.emailid }.singleOrNull()
            if (user != null && user[users.password] == request.password) {
                redisCache.deleteUserData(request.emailid) // Remove from cache
                val deletedRows = users.deleteWhere { users.emailid eq request.emailid }
                deletedRows > 0
            } else {
                false
            }
        }
    }

    override suspend fun updateUser(request: UpdatePasswordRequest): Boolean {
        return transaction {
            redisCache.deleteUserData(request.emailid) // Invalidate cache
            val updatedRows = users.update({ users.emailid eq request.emailid and (users.password eq request.currentPassword) }) {
                it[password] = request.newPassword
            }
            updatedRows > 0
        }
    }
}


// i am storing the data in redis in form of json string, in key,value pairs
//emailid-->corresponding to an emailid we have {emailid: ,name: , password: )
//I am storing the title of the tasks associated with emailid in a list,
// then for a title i am storing a json string containing the