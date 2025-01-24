package com.example.db

import kotlinx.serialization.Serializable


@kotlinx.serialization.Serializable
data class UpdatePasswordRequest(
    val emailid: String,
    val currentPassword: String,
    val newPassword: String
)

