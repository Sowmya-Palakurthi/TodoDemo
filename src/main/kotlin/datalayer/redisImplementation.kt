package com.example.datalayer

import com.example.database.dataclasses.taskResponse
import com.example.database.dataclasses.userRequest
import javax.inject.Inject
import com.example.datalayer.RedisClient.jedis
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString


class redisImplementation @Inject constructor():redisActions {

        override fun getUserData(emailId: String): String? {
            return jedis.get("user:$emailId")
        }

        override fun deleteUserData(emailId: String): Boolean {
            return try {
                jedis.del("user:$emailId") // Delete user data from Redis
                true
            } catch (e: Exception) {
                false
            }
        }

        override fun addUserData(request: userRequest): Boolean {
            return try {
                val userJson = Json.encodeToString(request)
                jedis.setex("user:${request.emailid}", 3600, userJson) // Cache user for 1 hour
                true
            } catch (e: Exception) {
                false
            }
        }

        override fun getTaskData(emailId: String): List<taskResponse>? {
            return try {
                val cachedData = jedis.get("tasks:$emailId")
                cachedData?.let { Json.decodeFromString(it) }
            } catch (e: Exception) {
                null
            }
        }

        override fun deleteTaskData(emailId: String, title: String): Boolean {
            return try {
                jedis.del("task:$emailId:$title") // Delete specific task
                true
            } catch (e: Exception) {
                false
            }
        }

        override fun addTaskData(request: taskResponse): Boolean {
            return try {
                val taskJson = Json.encodeToString(request)
                jedis.setex("task:${request.emailid}:${request.title}", 3600, taskJson) // Cache task for 1 hour // FIXME: Caching strategy of task is not correct
                true
            } catch (e: Exception) {
                false
            }
        }

    override fun setUserData(data: String, time:Long, emailid: String): Boolean {
        return try {
            jedis.setex("user:$emailid", time, data)
            true
        } catch (exception: Exception) {
            exception.printStackTrace()
            false
        }
    }



}



/*
override fun getUserData(emailid: String): String?{
    val UserData=jedis.get("user:$emailid")
        return UserData
    }

    override fun deleteUserData(emailid: String): Boolean {
        try{
        jedis.srem("user:${emailid}")
        jedis.del("user:${emailid}")}
        catch (e:Exception) {
            return false
        }
        return true
    }

    override fun addUserData(request: userRequest): Boolean {

    }

    override fun getTaskData(emailid: String): List<taskResponse>? {

    }

    override fun deleteTaskData(emailid: String, title: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun addTaskData(request: taskResponse): Boolean {
        TODO("Not yet implemented")
    }

    override fun setUserData(data:String, time: Int, emailid: String): Boolean {
      val isUpdated =  jedis.setex("user:$emailid", 3600, data)
        return isUpdated!=null

    }

*/
