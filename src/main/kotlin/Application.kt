package com.example

import com.example.db.DatabaseFactory
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 8081, host = "0.0.0.0") {
        module()
    }.start(wait = true)
}
fun Application.module() {
    DatabaseFactory.init()
    install(ContentNegotiation) {
        json()
    }
    configureRouting()
}
