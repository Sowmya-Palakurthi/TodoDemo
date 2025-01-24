package com.example.db

import kotlinx.serialization.Serializable

@Serializable
data class isDoneUpdateRequest (
    val title: String,
    val isdone: Boolean)