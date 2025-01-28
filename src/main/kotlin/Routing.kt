
package com.example

import com.example.db.*
import com.example.tasks.isdone
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate

fun Application.configureRouting() {

    routing {
        route("/users/{emailid}") {
            get {
                val emailId = call.parameters["emailid"] ?: return@get call.respond(HttpStatusCode.BadRequest, "Missing email ID")
                val user = getUserByEmail(emailId)

                if (user != null) {
                    call.respond(user)
                } else {
                    call.respond(HttpStatusCode.NotFound, "User with email '$emailId' not found")
                }
            }
        }

        route("/users") {
            post {
                val userRequest = call.receive<userRequest>()
                try {
                    addUser(userRequest.emailid, userRequest.username, userRequest.password)
                    call.respond(HttpStatusCode.Created, "User created successfully")
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, e.message ?: "Error occurred")
                }
            }
        }

        route("/users/{emailid}") {
            delete {
                val emailId = call.parameters["emailid"] ?: return@delete call.respond(HttpStatusCode.BadRequest, "Invalid email ID")
                val request = call.receive<Map<String, String>>()
                val password = request["password"] ?: return@delete call.respond(HttpStatusCode.BadRequest, "Password is required")

                val isDeleted = deleteUser(emailId, password)

                if (isDeleted) {
                    call.respond(HttpStatusCode.OK, "User deleted successfully")
                } else {
                    call.respond(HttpStatusCode.Unauthorized, "Invalid email or password")
                }
            }
        }

        route("/users/update-password") {
            put {
                val updatePasswordRequest = call.receive<UpdatePasswordRequest>()
                val isUpdated = updatePassword(updatePasswordRequest.emailid, updatePasswordRequest.currentPassword, updatePasswordRequest.newPassword)
                if (isUpdated) {
                    call.respond(HttpStatusCode.OK, "Password updated successfully.")
                } else {
                    call.respond(HttpStatusCode.Unauthorized, "Invalid email or current password.")
                }
            }
        }


        route("/tasks") {

            get("/{emailid}") {
                val emailid = call.parameters["emailid"] ?: return@get call.respond(
                    HttpStatusCode.BadRequest,
                    "Email ID missing."
                )
                val redis = RedisClient.jedis
                try {
                    val cachedTasks = redis.get("tasks:$emailid")
                    if (cachedTasks != null) {
                        val tasks = Json.decodeFromString<List<taskResponse>>(cachedTasks)
                        call.respond(HttpStatusCode.OK, tasks)
                        return@get
                    }
                    val tasksList = fetchTasksFromDatabase(emailid)
                    if (tasksList.isNotEmpty()) {
                        redis.setex("tasks:$emailid", 3600, Json.encodeToString(tasksList))
                        call.respond(HttpStatusCode.OK, tasksList)
                    } else {
                        call.respond(HttpStatusCode.NotFound, "No tasks found for $emailid.")
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    call.respond(HttpStatusCode.InternalServerError, "Error retrieving tasks.")
                }
            }


            post("/add") {
                val taskRequest = call.receive<taskResponse>()
                val title = taskRequest.title
                val emailid = taskRequest.emailid
                val description = taskRequest.description
                val isdone = taskRequest.isdone
                val deaddate=taskRequest.deadline.toInt()?:null
                val deadline = if (deaddate == null) {
                    "No Deadline" // Handle null case
                } else if (deaddate < 0) {
                    call.respond(HttpStatusCode.BadRequest, "Deadline cannot be negative")
                    return@post
                } else {
                    LocalDate.now().plusDays(deaddate.toLong()).toString()
                }
                transaction {
                    tasks.insert {
                        it[this.title] = title
                        it[this.emailid] = emailid
                        it[this.description] = description
                        it[this.deadline] = deadline
                        it[this.isdone] = isdone
                    }
                }
                RedisClient.jedis.del("tasks:$emailid")
                call.respond(HttpStatusCode.Created, "Task added successfully.")
            }


            // DELETE /tasks/{emailid}/{title}



            delete("/{emailid}/{title}") {
                val emailid = call.parameters["emailid"] ?: return@delete call.respond(
                    HttpStatusCode.BadRequest,
                    "Email ID missing."
                )
                val title = call.parameters["title"] ?: return@delete call.respond(
                    HttpStatusCode.BadRequest,
                    "Task title missing."
                )

                val redis = RedisClient.jedis

                try {
                    redis.del("tasks:$emailid")
                    val isDeleted = deleteTaskFromDatabase(emailid, title)
                    if (isDeleted) {
                        call.respond(HttpStatusCode.OK, "Task '$title' deleted successfully.")
                    } else {
                        call.respond(HttpStatusCode.NotFound, "Task '$title' not found for $emailid.")
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    call.respond(HttpStatusCode.InternalServerError, "Error deleting task.")
                } finally {
                    redis.close()
                }
            }





            put("/update-status") {
                try {
                    // Deserialize the request body into UpdateTaskStatusRequest
                    val request = call.receive<UpdateTaskStatusRequest>()

                    // Extract the properties from the deserialized request object
                    val emailId = request.emailid
                    val title = request.title
                    val isDone = request.isDone
                    if (emailId.isNullOrBlank() || title.isNullOrBlank()) {
                        call.respond(HttpStatusCode.BadRequest, "Email ID and Title are required.")
                        return@put
                    }

                    val isUpdated = updateTaskStatus(emailId, title, isDone)
                    if (isUpdated) {
                        call.respond(HttpStatusCode.OK, "Task status updated successfully.")
                    } else {
                        call.respond(HttpStatusCode.NotFound, "Task not found.")
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    call.respond(HttpStatusCode.InternalServerError, "Error updating task status.")
                }
            }

        }
    }
}
