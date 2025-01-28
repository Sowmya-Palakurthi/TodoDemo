package com.example
import com.example.RedisClient.jedis
//import redis.clients.jedis.Jedis
import com.example.db.*
import jdk.internal.org.jline.utils.ShutdownHooks
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.insert


//val redisCommands = Jedis("localhost", 6379)


fun addUser(emailId: String, username: String, password: String) {
    transaction {
        users.insert {
            it[emailid] = emailId
            it[users.username] = username
            it[users.password] = password
        }
    }
}

fun getUserByEmail(emailId: String): userRequest? {
    val cachedUser = jedis.get("user:$emailId")
    if (cachedUser != null) {
        return Json.decodeFromString(userRequest.serializer(), cachedUser)
    }
    val userFromDb = transaction {
        val user = users
            .select { users.emailid eq emailId }
            .singleOrNull()

        user?.let {
            userRequest(
                emailid = it[users.emailid],
                username = it[users.username],
                password = it[users.password]
            )
        }
    }
    userFromDb?.let {
        val userJson = Json.encodeToString(it)
        jedis.setex("user:$emailId", 3600, userJson)
    }
    return userFromDb
}


fun deleteUser(emailId: String, password: String): Boolean {
    val isDeleted = transaction {
        val user = users.select { users.emailid eq emailId }.singleOrNull()

        if (user != null && user[users.password] == password) {

            jedis.srem("users", emailId)
            jedis.del("user:$emailId")

            val deletedRows = users.deleteWhere { emailid eq emailId }
            deletedRows > 0
        } else {
            false
        }
    }
    return isDeleted
}

fun updatePassword(emailid: String, currentPassword: String, newPassword: String): Boolean {
    return transaction {
        jedis.del("user:$emailid")
        val updatedRows = users.update({ users.emailid eq emailid and (users.password eq currentPassword) }) {
            it[password] = newPassword
        }
        if (updatedRows > 0) {
            return@transaction true
        }
        false
    }

}



//related to tasks


fun fetchTasksFromDatabase(emailid: String): List<taskResponse> {
    return transaction {
        tasks.select { tasks.emailid eq emailid }.map {
            taskResponse(
                title = it[tasks.title],
                description = it[tasks.description],
                isdone = it[tasks.isdone],
                emailid = it[tasks.emailid],
                deadline = it[tasks.deadline]
            )
        }
    }
}

fun deleteTaskFromDatabase(emailid: String, title: String): Boolean {
    return transaction {
        tasks.deleteWhere { (tasks.emailid eq emailid) and (tasks.title eq title) } > 0
    }
}

fun addTask(emailid: String, title: String, description: String,isdone: Boolean, deadline: String): Boolean {
    return transaction {
        tasks.insert {
            it[tasks.emailid] = emailid
            it[tasks.title] = title
            it[tasks.description] = description
            it[tasks.deadline] = deadline
            it[tasks.isdone]=isdone
        }
        val redis = jedis
        redis.del("tasks:$emailid") // Invalidate cache
        true
    }
}

fun updateTaskStatus(emailid: String, title: String, isDone: Boolean): Boolean {
    return transaction {
        jedis.del("user:$emailid")
        val updatedRows = tasks.update({ tasks.emailid eq emailid and (tasks.title eq title) }) {
            it[isdone] = isDone
        }
        if (updatedRows > 0) {
            return@transaction true
        }
        return@transaction false
    }
}

