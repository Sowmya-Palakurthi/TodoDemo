package com.example.database.dataclasses

import kotlinx.serialization.Serializable

@Serializable
data class userRequest(
    val emailid:String,
    val username:String,
    val password:String
    )

@Serializable
data class userResponse(val emailid: String,val username: String)

@Serializable
data class UpdatePasswordRequest(
    val emailid: String,
    val currentPassword: String,
    val newPassword: String
)
