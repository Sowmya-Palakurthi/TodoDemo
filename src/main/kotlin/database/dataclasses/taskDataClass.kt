package com.example.database.dataclasses

import kotlinx.serialization.Serializable

@Serializable
data class taskResponse(
    val title: String,
    val description: String,
    val isdone: Boolean,
    val emailid: String,
    var deadline:String
)
@Serializable
data class UpdateTaskStatusRequest(
    val emailid: String,
    val title: String,
    val isDone: Boolean
)