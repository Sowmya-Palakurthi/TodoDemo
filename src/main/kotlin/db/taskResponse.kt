package com.example.db

import kotlinx.serialization.Serializable
import java.time.LocalDateTime

@Serializable
data class taskResponse(
    val title: String,       // The title of the task
    val description: String, // Description of the task
    val isdone: Boolean,     // Boolean to indicate if the task is completed
    val emailid: String,
    val deadline:String

)
