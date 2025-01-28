package com.example.db

import kotlinx.serialization.Serializable

@Serializable
data class taskRequest(
    val title: String,
    val description: String,
    val isdone: Boolean,
    val deadline:String
)
