package com.example.db

import kotlinx.serialization.Serializable

@Serializable
data class UpdateTaskStatusRequest(
    val email: String,
    val title: String,
    val isDone: Boolean
)