package com.example.service.actions
import com.example.database.dataclasses.UpdateTaskStatusRequest
import com.example.database.dataclasses.taskResponse

interface TaskActions {


    suspend fun getTasks(emailId: String): List<taskResponse>
    suspend fun addTask(request: taskResponse): Boolean
    suspend fun updateTask(request: UpdateTaskStatusRequest): Boolean
    suspend fun deleteTask(emailId: String, title: String,password:String): Boolean

}



