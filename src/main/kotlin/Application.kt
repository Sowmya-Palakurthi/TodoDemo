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