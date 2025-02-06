package com.example.database.dataclasses

import kotlinx.serialization.Serializable

// FIXME: Create Separate POJO classes
@Serializable
data class userRequest(
    val emailid:String,
    val username:String,
    val password:String
    )

@Serializable
data class userResponse(val emailid: String,val username: String) // FIXME: Variable Naming Convention Not Correct

@Serializable
data class UpdatePasswordRequest(
    val emailid: String,
    val currentPassword: String,
    val newPassword: String
)
