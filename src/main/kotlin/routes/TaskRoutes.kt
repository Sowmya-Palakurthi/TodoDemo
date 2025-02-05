
package com.example.routes

import com.example.MyApplication
import com.example.service.actions.TaskActions
import com.example.database.dataclasses.UpdateTaskStatusRequest
import com.example.database.dataclasses.taskResponse
import com.example.database.dataclasses.users.password
import com.example.service.impl.TasksImplemetation
import io.ktor.http.*
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import java.time.LocalDate
import javax.inject.Inject


fun Route.TaskRoutes(taskService: TasksImplemetation){

    route("/tasks") {
        get("/{emailid}") {
            try {
                val emailid = call.parameters["emailid"] ?: return@get call.respond(
                    HttpStatusCode.BadRequest,
                    "Email ID missing."
                )
                val tasksList = taskService.getTasks(emailid)
                if (tasksList.isNotEmpty()) {
                    call.respond(HttpStatusCode.OK, tasksList)
                } else {
                    call.respond(HttpStatusCode.NotFound, "No tasks found for $emailid.")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                call.respond(HttpStatusCode.InternalServerError, "Error fetching tasks.")
            }
        }

        post("/add") {
            try {
                var taskReq = call.receive<taskResponse>()
               var title=taskReq.title
                if(title.isBlank()){  call.respond(HttpStatusCode.BadRequest, "Title cannot be empty")}

                    val deaddate = taskReq.deadline.toIntOrNull()
                val deadLine = when {
                    deaddate == null -> "No Deadline"
                    deaddate < 0 -> {
                        call.respond(HttpStatusCode.BadRequest, "Deadline cannot be negative")
                        return@post
                    }
                    else -> LocalDate.now().plusDays(deaddate.toLong()).toString()
                }
                taskReq.deadline=deadLine
                val isAdded = taskService.addTask(taskReq)
                if (isAdded) {
                    call.respond(HttpStatusCode.Created, "Task added successfully.")
                } else {
                    call.respond(HttpStatusCode.BadRequest, "Task not added due to some issue")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                call.respond(HttpStatusCode.InternalServerError, "Error adding task.")
            }
        }

        delete("/{emailid}/{title}/{password}") {
            try {
                val emailid = call.parameters["emailid"] ?: return@delete call.respond(
                    HttpStatusCode.BadRequest,
                    "Email ID missing."
                )
                val title = call.parameters["title"] ?: return@delete call.respond(
                    HttpStatusCode.BadRequest,
                    "Task title missing."
                )

                val password = call.parameters["password"] ?: return@delete call.respond(
                    HttpStatusCode.BadRequest,
                    "Password missing."
                )

                val isDeleted = taskService.deleteTask(emailid, title,password)
                if (isDeleted) {
                    call.respond(HttpStatusCode.OK, "Task '$title' deleted successfully.")
                } else {
                    call.respond(HttpStatusCode.NotFound, "Task '$title' not found for $emailid.")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                call.respond(HttpStatusCode.InternalServerError, "Error deleting task.")
            }
        }

        put("/update-status") {
            try {
                val request = call.receive<UpdateTaskStatusRequest>()
                if (request.emailid.isNullOrBlank() || request.title.isNullOrBlank()) {
                    call.respond(HttpStatusCode.BadRequest, "Email ID and Title are required.")
                    return@put
                }
                val isUpdated = taskService.updateTask(request)
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
    }}
