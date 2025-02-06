package com.example.datalayer

import redis.clients.jedis.Jedis

object RedisClient {
    // FIXME: Keep config values in config file and don't hard code the values read from properties file
    private const val REDIS_HOST = "localhost"
    private const val REDIS_PORT = 6379

    val jedis: Jedis by lazy {
        Jedis(REDIS_HOST, REDIS_PORT).apply {
            println("Connected to Redis")
        }
    }
}





