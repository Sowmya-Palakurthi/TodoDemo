package com.example.service.impl;

import com.example.database.dataclasses.UpdatePasswordRequest;
import com.example.database.dataclasses.userRequest;
import com.example.database.dataclasses.userResponse;
import com.example.database.dataclasses.users;
import com.example.datalayer.redisActions;
import org.jetbrains.exposed.sql.*;
import com.example.service.actions.UserActions;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0011H\u0096@\u00a2\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/example/service/impl/UsersImplementation;", "Lcom/example/service/actions/UserActions;", "redisCache", "Lcom/example/datalayer/redisActions;", "(Lcom/example/datalayer/redisActions;)V", "addUser", "", "request", "Lcom/example/database/dataclasses/userRequest;", "(Lcom/example/database/dataclasses/userRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUser", "getUser", "Lcom/example/database/dataclasses/userResponse;", "emailId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "Lcom/example/database/dataclasses/UpdatePasswordRequest;", "(Lcom/example/database/dataclasses/UpdatePasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-demo"})
public final class UsersImplementation implements com.example.service.actions.UserActions {
    @org.jetbrains.annotations.NotNull()
    private final com.example.datalayer.redisActions redisCache = null;
    
    @javax.inject.Inject()
    public UsersImplementation(@org.jetbrains.annotations.NotNull()
    com.example.datalayer.redisActions redisCache) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getUser(@org.jetbrains.annotations.NotNull()
    java.lang.String emailId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.database.dataclasses.userResponse> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addUser(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.userRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteUser(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.userRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateUser(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.UpdatePasswordRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}