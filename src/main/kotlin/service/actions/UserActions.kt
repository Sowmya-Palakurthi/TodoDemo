package com.example.service.actions
import com.example.database.dataclasses.UpdatePasswordRequest
import com.example.database.dataclasses.userRequest
import com.example.database.dataclasses.userResponse

interface UserActions {
    suspend fun getUser(emailId: String): userResponse?
    suspend fun addUser(request: userRequest): Boolean
    suspend fun deleteUser(request: userRequest): Boolean
    suspend fun updateUser(request: UpdatePasswordRequest): Boolean

}
