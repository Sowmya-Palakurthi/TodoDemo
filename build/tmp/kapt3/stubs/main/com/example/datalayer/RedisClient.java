package com.example.datalayer;

import redis.clients.jedis.Jedis;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/example/datalayer/RedisClient;", "", "()V", "REDIS_HOST", "", "REDIS_PORT", "", "jedis", "Lredis/clients/jedis/Jedis;", "getJedis", "()Lredis/clients/jedis/Jedis;", "jedis$delegate", "Lkotlin/Lazy;", "ktor-demo"})
public final class RedisClient {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String REDIS_HOST = "localhost";
    private static final int REDIS_PORT = 6379;
    @org.jetbrains.annotations.NotNull()
    private static final kotlin.Lazy jedis$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.datalayer.RedisClient INSTANCE = null;
    
    private RedisClient() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final redis.clients.jedis.Jedis getJedis() {
        return null;
    }
}