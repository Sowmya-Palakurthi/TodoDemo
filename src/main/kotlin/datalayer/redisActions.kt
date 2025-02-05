package com.example.datalayer

import com.example.database.dataclasses.taskResponse
import com.example.database.dataclasses.userRequest

interface redisActions {
    fun getUserData(emailid:String):String?
    fun deleteUserData(emailid:String):Boolean
    fun addUserData(request:userRequest):Boolean
    fun getTaskData(emailid:String):List<taskResponse>?
    fun deleteTaskData(emailid:String,title:String):Boolean
    fun addTaskData(request:taskResponse):Boolean
    fun setUserData(data:String,time:Long, emailid:String):Boolean
}