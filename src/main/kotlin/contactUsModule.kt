package com.example

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.contactUsModule(){
    routing {
        get("/contactus")
        {
            call.respond("Contact us")
        }


    }
}