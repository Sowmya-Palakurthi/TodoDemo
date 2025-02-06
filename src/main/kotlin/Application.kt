package com.example

import com.example.MyApplication.Companion.appComponent
import com.example.database.*
import com.example.routes.configureRouting
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import di.AppComponent
/**
 * Feedback:
 * 1. Dependency injection needs to be corrected
 * 2. Data layer need to be segregated
 * 3. Expose data layer trough Repository
 * 4. Naming conventions should be followed
 * 5. Data read write strategy need to be otimized(Like redis caching)
 * 6. Remove hardcoding from everywhere
 * **/

class MyApplication {
    companion object {
        lateinit var appComponent: AppComponent
    }
}

fun main() {
    MyApplication.appComponent = AppComponent.create()
    embeddedServer(Netty, port = 8083, host = "0.0.0.0") {
        module()
    }.start(wait = true)
}

fun Application.module() {
    val taskService = appComponent.getTaskService()
    val userService = appComponent.getUserService()
    DatabaseFactory.init()
    configureRouting(taskService, userService  )
    install(ContentNegotiation) {
        json()
    }
}