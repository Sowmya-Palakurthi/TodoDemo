package com.example

import com.example.db.UpdatePasswordRequest
import com.example.db.isDoneUpdateRequest
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import com.example.db.taskRequest
import com.example.db.userRequest
import com.example.users
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureRouting() {

    routing {
        route("/hi") {
            get {
                call.respondText("Hello, Ktor!")
            }
        }

        route("/users") {
            get {
                val userlist = getUsers()
                call.respond(userlist)
            }
        }

        route("/users") {
            post {
                val userRequest = call.receive<userRequest>()
                val emailid = userRequest.emailid
                val username = userRequest.username
                val password = userRequest.password

                try {
                    addUser(emailid, username, password)
                    call.respond(HttpStatusCode.Created, mapOf("message" to "User created successfully"))
                } catch (e: Exception) {
                    call.respond(HttpStatusCode.BadRequest, "${e.message}")
                }
            }
        }

        route("/users/{emailid}") {
            delete {
                val emailId = call.parameters["emailid"] ?: run {
                    call.respond(HttpStatusCode.BadRequest, "Invalid email ID")
                    return@delete
                }

                val request = call.receive<Map<String, String>>()
                val password = request["password"] ?: run {
                    call.respond(HttpStatusCode.BadRequest, "Password is required")
                    return@delete
                }

                val isDeleted = deleteUser(emailId, password)
                if (isDeleted) {
                    call.respond(HttpStatusCode.OK, "User deleted successfully")
                } else {
                    call.respond(HttpStatusCode.Unauthorized, "Invalid email ID or password")
                }
            }
        }

        route("/users/update-password") {
            put {
                val updatePasswordRequest = call.receive<UpdatePasswordRequest>()

                val isUpdated = updatePassword(updatePasswordRequest.emailid,updatePasswordRequest.currentPassword, updatePasswordRequest.newPassword)

                if (isUpdated) {
                    call.respond(HttpStatusCode.OK, "Password updated successfully.")
                } else {
                    call.respond(HttpStatusCode.Unauthorized, "Invalid email or current password.")
                }
            }

        }


        //tasks related

       route("/tasks/getinfo/{title}"){
           get{
               val title = call.parameters["title"]?.toString()
               if(title!=null){
                   val tasksdata=getTaskInfo(title)
                   call.respond(tasksdata)
               }
               else{
                   call.respond(HttpStatusCode.BadRequest, "Invalid user ID")
               }
           }
       }

            route("/tasks/{emailid}") {
                get {
                    val emailid = call.parameters["emailid"]?.toString()
                    if (emailid != null) {
                        val tasks = getTasks(emailid)
                        call.respond(tasks)
                    } else {
                        call.respond(HttpStatusCode.BadRequest, "Invalid email ID")
                    }
                }

                post {
                    val emailid = call.parameters["emailid"]?.toString()
                    try {
                        if (emailid != null) {
                            val taskRequest = call.receive<taskRequest>()
                            addTask(taskRequest, emailid)
                            call.respond(HttpStatusCode.Created, "Task created")
                        }
                    } catch (e: Exception) {
                        call.respond(HttpStatusCode.BadRequest, "${e.message}")
                    }
                }

                put {
                    // Extract parameters from the request
                    val emailId = call.parameters["emailid"] ?: return@put call.respond(HttpStatusCode.BadRequest, "Missing emailId")
                    // Receive the taskRequest data
                    val isDoneUpdateRequest = call.receive<isDoneUpdateRequest>()
                    // Call the function to update the task
                    val updated = updateTask(emailId,isDoneUpdateRequest )
                    if (updated) {
                        call.respond(HttpStatusCode.OK, "Task updated successfully")
                    } else {
                        call.respond(HttpStatusCode.NotFound, "Task not found")
                    }
                }
            }









        route("/tasks/{emailid}/{title}") {
            delete {
                val emailid = call.parameters["emailid"]?.toString()
                val title = call.parameters["title"]?.toString()

                // Extract password from the request body
                val request = call.receive<Map<String, String>>()
                val password = request["password"] ?: run {
                    call.respond(HttpStatusCode.BadRequest, "Password is required")
                    return@delete
                }

                if (emailid != null && title != null) {
                    try {
                        // Call the deleteTask function with the password for validation
                        val isDeleted = deleteTask(emailid, title, password)
                        if (isDeleted) {
                            call.respond(HttpStatusCode.OK, "Task deleted successfully")
                        } else {
                            call.respond(HttpStatusCode.Unauthorized, "Invalid password or task not found")
                        }
                    } catch (e: Exception) {
                        call.respond(HttpStatusCode.BadRequest, "Failed to delete task: ${e.message}")
                    }
                } else {
                    call.respond(HttpStatusCode.BadRequest, "Missing email or title parameters")
                }
            }
        }}}







