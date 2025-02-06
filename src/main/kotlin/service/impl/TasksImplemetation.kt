package com.example.service.impl
import com.example.database.dataclasses.UpdateTaskStatusRequest
import com.example.database.dataclasses.taskResponse
import com.example.database.dataclasses.tasks
import com.example.database.dataclasses.users
import org.jetbrains.exposed.sql.and
import com.example.datalayer.redisActions
import com.example.datalayer.redisImplementation
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.deleteWhere
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update
import com.example.service.actions.TaskActions
import io.ktor.http.*
import java.time.LocalDate
import javax.inject.Inject

import java.time.temporal.ChronoUnit



class TasksImplemetation @Inject constructor(private val redisCache: redisActions) : TaskActions {

    // TODO: Remove unused methods
    // FIXME: Instead of String use Instant
    fun calculateDeadline(daysLeft: String): String {
        val days = daysLeft.toLongOrNull() ?: throw IllegalArgumentException("Invalid number format")

        return LocalDate.now().plusDays(days).toString() // Add daysLeft to the current date
    }

    override suspend fun getTasks(emailId: String): List<taskResponse> {
        return try {
            val cachedTasks = redisCache.getTaskData(emailId)
            if (cachedTasks != null) {
                cachedTasks
            } else {
                val tasksList = transaction {
                    tasks.select { tasks.emailid eq emailId }.map {
                        taskResponse(
                            title = it[tasks.title],
                            description = it[tasks.description],
                            isdone = it[tasks.isdone],
                            emailid = it[tasks.emailid],
                            deadline = it[tasks.deadline]
                        )
                    }
                }
                if (tasksList.isNotEmpty()) {
                    redisCache.addTaskData(tasksList.first()) // Cache first task as example
                }
                tasksList
            }
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun addTask(request: taskResponse): Boolean {


        return transaction {

            if(request.emailid.isNotBlank()){
            tasks.insert {
                it[emailid] = request.emailid
                it[title] = request.title
                it[description] = request.description
                it[deadline] = request.deadline
                it[isdone] = request.isdone
            }
            redisCache.addTaskData(request)
                true// Cache new task
        }
        else{
             false
            //throw IllegalArgumentException("emailid cannot be empty")
        }
    }}

    override suspend fun updateTask(request: UpdateTaskStatusRequest): Boolean {
        return transaction {
            redisCache.deleteTaskData(request.emailid, request.title) // Remove from cache
            val updatedRows = tasks.update({ (tasks.emailid eq request.emailid) and (tasks.title eq request.title) }) {
                it[isdone] = request.isDone
            }
            updatedRows > 0
        }
    }


    override suspend fun deleteTask(emailId: String, title: String, password: String): Boolean {
        return try {
            transaction {
                // Step 1: Check if the password is valid (this can be a separate query)
                val isValidPassword = users
                    .select { users.emailid eq emailId and (users.password eq password) }
                    .count() > 0

                if (isValidPassword) {
                    // Step 2: Remove the task from the cache
                    redisCache.deleteTaskData(emailId, title)

                    // Step 3: Delete the task from the database
                    val deletedRows = tasks.deleteWhere {
                        (tasks.emailid eq emailId) and (tasks.title eq title)
                    }

                    // Return true if the task was successfully deleted
                    deletedRows > 0
                } else {
                    // Invalid password
                    false
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            false
        }
    }






//    override suspend fun deleteTask(emailId: String, title: String,password:String): Boolean {
//        return try {
//            transaction {
//                redisCache.deleteTaskData(emailId, title) // Remove task from cache
//                val deletedRows = tasks.deleteWhere {
//                    (tasks.emailid eq emailId) and (tasks.title eq title)(users.password eq password)
//                }
//                deletedRows > 0
//            }
//        } catch (e: Exception) {
//            e.printStackTrace()
//            false
//        }
//    }
}
