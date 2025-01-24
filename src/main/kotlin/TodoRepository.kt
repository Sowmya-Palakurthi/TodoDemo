package com.example

import com.example.db.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import com.example.users
import com.example.tasks
import com.example.users.password
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

fun addUser(emailId: String, username: String, password: String) {
    transaction {
        users.insert {
            it[emailid] = emailId
            it[users.username] = username
            it[users.password] = password
        }
    }
}

fun getUsers(): List<userResponse> {
    return transaction {
        users.selectAll().map {
            userResponse(
                emailid = it[users.emailid],
                username = it[users.username]
            )
        }
    }
}
fun updatePassword(emailid:String, currentPassword:String, newPassword:String): Boolean {
    return transaction {
        val updatedRows = users.update({ users.emailid eq emailid and (users.password eq currentPassword) }) {
            it[password] = newPassword
        }
        updatedRows > 0 // Return true if rows were updated
    }
}

fun deleteUser(emailId: String, password: String): Boolean {
    return transaction {
        val user = users.select { users.emailid eq emailId }.singleOrNull()

        if (user != null && user[users.password] == password) {
            val deletedRows = users.deleteWhere { users.emailid eq emailId }
            return@transaction deletedRows > 0
        }
        return@transaction false
    }
}



fun addTask(taskRequest: taskRequest, emailId: String) {
    transaction {
        // Parse the deadlineDays string to an integer
        val deadlineDays = taskRequest.deadline.toIntOrNull()

        if (deadlineDays != null) {
            // Calculate the deadline date by adding the deadlineDays to the current date
            val deadlineDate = LocalDate.now().plusDays(deadlineDays.toLong())

            tasks.insert {
                it[emailid] = emailId
                it[title] = taskRequest.title
                it[isdone] = taskRequest.isdone
                it[description] = taskRequest.description
                it[deadline] = deadlineDate.toString() // Store the deadline date in the database
            }
        } else {
            throw IllegalArgumentException("Invalid deadline days provided")
        }
    }
}



fun getTasks(emailId: String): List<taskResponse> {
    return transaction {
        tasks.select { tasks.emailid eq emailId }
            .map {
                taskResponse(
                    title = it[tasks.title],
                    isdone = it[tasks.isdone],
                    description = it[tasks.description],
                    emailid = it[tasks.emailid],
                    deadline = it[tasks.deadline] // Return deadline in response
                )
            }
    }
}

fun getTaskInfo(title: String): List<taskResponse> {
    return transaction {
        tasks.select { tasks.title eq title }
            .map {
                taskResponse(
                    title = it[tasks.title],
                    isdone = it[tasks.isdone],
                    description = it[tasks.description],
                    emailid = it[tasks.emailid],
                    deadline = it[tasks.deadline] // Return deadline in response
                )
            }
    }
}



fun updateTask(emailId: String, isDoneUpdateRequest: isDoneUpdateRequest): Boolean {
    return transaction {
        val updatedRows = tasks.update({ tasks.emailid eq emailId and (tasks.title eq isDoneUpdateRequest.title) }) {
            it[title]=isDoneUpdateRequest.title
            it[isdone] = isDoneUpdateRequest.isdone

        }
        updatedRows > 0 // Return true if rows were updated
    }
}
fun updateDeadline(emailId: String, title: String, deadlineDays: Int): Boolean {
    val currentDate = LocalDateTime.now()
    val newDeadline = currentDate.plus(deadlineDays.toLong(), ChronoUnit.DAYS)

    return transaction {
        val updatedRows = tasks.update({ tasks.emailid eq emailId and (tasks.title eq title) }) {
            it[deadline] = deadline
        }
        updatedRows > 0
    }
}

fun deleteTask(emailId: String, title: String, password: String): Boolean {
    return transaction {
        // First, check if the password is correct
        val user = users.select { users.emailid eq emailId }.singleOrNull()
        if (user != null && user[users.password] == password) {
            // Delete the task if the password matches
            val deletedRows = tasks.deleteWhere { tasks.emailid eq emailId and (tasks.title eq title) }
            return@transaction deletedRows > 0
        }
        return@transaction false // Return false if password doesn't match or user doesn't exist
    }
}

