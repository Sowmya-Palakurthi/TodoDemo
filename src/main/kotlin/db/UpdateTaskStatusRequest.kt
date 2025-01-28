package com.example.db

import kotlinx.serialization.Serializable

@Serializable
data class UpdateTaskStatusRequest(
    val emailid: String,
    val title: String,
    val isDone: Boolean
)