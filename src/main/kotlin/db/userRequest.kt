package com.example.db

import kotlinx.serialization.Serializable

@Serializable
data class userRequest(
    val emailid:String,
    val username:String,
    val password:String,

)
