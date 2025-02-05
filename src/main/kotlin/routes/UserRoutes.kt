
package com.example.modules
import com.example.MyApplication
import com.example.database.dataclasses.UpdatePasswordRequest
import com.example.database.dataclasses.userRequest
import com.example.service.actions.UserActions
import com.example.service.impl.UsersImplementation
import io.ktor.http.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Route.userRoutes(userService: UsersImplementation){
    route("/users") {
        get("/{emailid}") {
            try {
                val emailId = call.parameters["emailid"] ?: return@get call.respond(HttpStatusCode.BadRequest, "Missing email ID")
                val user = userService.getUser(emailId)
                if (user != null) {
                    call.respond(user)
                } else {
                    call.respond(HttpStatusCode.NotFound, "User with email '$emailId' not found")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                call.respond(HttpStatusCode.InternalServerError, "Error fetching user.")
            }
        }

        post("/add") {
            try {
                val userRequest = call.receive<userRequest>()

                var email=userRequest.emailid
                if(email.isBlank() || userRequest.username.isBlank() || userRequest.password.isBlank()){  call.respond(HttpStatusCode.BadRequest, "some details are missing")}



                userService.addUser(userRequest)
                call.respond(HttpStatusCode.Created, "User created successfully")
            } catch (e: Exception) {
                e.printStackTrace()
                call.respond(HttpStatusCode.BadRequest, e.message ?: "Error occurred")
            }
        }

        delete("/{emailid}") {
            try {
                val emailId = call.parameters["emailid"] ?: return@delete call.respond(
                    HttpStatusCode.BadRequest,
                    "Invalid email ID"
                )
                val request = call.receive<userRequest>()
                val password = request.password ?: return@delete call.respond(HttpStatusCode.BadRequest, "Password is required")

                val isDeleted = userService.deleteUser(request)

                if (isDeleted) {
                    call.respond(HttpStatusCode.OK, "User deleted successfully")
                } else {
                    call.respond(HttpStatusCode.Unauthorized, "Invalid email or password")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                call.respond(HttpStatusCode.InternalServerError, "Error deleting user.")
            }
        }

        put("/update-password") {
            try {
                val updatePasswordRequest = call.receive<UpdatePasswordRequest>()
                val isUpdated = userService.updateUser(updatePasswordRequest)
                if (isUpdated) {
                    call.respond(HttpStatusCode.OK, "Password updated successfully.")
                } else {
                    call.respond(HttpStatusCode.Unauthorized, "Invalid email or current password.")
                }
            } catch (e: Exception) {
                e.printStackTrace()
                call.respond(HttpStatusCode.InternalServerError, "Error updating password.")
            }
        }
    }

}


