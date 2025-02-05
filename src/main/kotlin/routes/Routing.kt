package com.example.routes

import com.example.modules.userRoutes
import com.example.routes.TaskRoutes
import com.example.service.actions.TaskActions
import com.example.service.actions.UserActions
import com.example.service.impl.TasksImplemetation
import com.example.service.impl.UsersImplementation
import io.ktor.server.application.*
import io.ktor.server.routing.*
fun Application.configureRouting(taskService: TasksImplemetation, userService: UsersImplementation) {
        routing {
                userRoutes(userService)
                TaskRoutes(taskService)
        }
}
