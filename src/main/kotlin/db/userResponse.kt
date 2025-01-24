package com.example.db

import kotlinx.serialization.Serializable

@Serializable
data class userResponse(val emailid: String,val username: String)
