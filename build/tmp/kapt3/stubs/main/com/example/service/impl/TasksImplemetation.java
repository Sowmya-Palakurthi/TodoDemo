package com.example.service.impl;

import com.example.database.dataclasses.UpdateTaskStatusRequest;
import com.example.database.dataclasses.taskResponse;
import com.example.database.dataclasses.tasks;
import com.example.database.dataclasses.users;
import com.example.datalayer.redisActions;
import com.example.datalayer.redisImplementation;
import com.example.service.actions.TaskActions;
import io.ktor.http.*;
import java.time.LocalDate;
import javax.inject.Inject;
import java.time.temporal.ChronoUnit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ&\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\u0011J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\u000e\u001a\u00020\u000bH\u0096@\u00a2\u0006\u0002\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0016H\u0096@\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/example/service/impl/TasksImplemetation;", "Lcom/example/service/actions/TaskActions;", "redisCache", "Lcom/example/datalayer/redisActions;", "(Lcom/example/datalayer/redisActions;)V", "addTask", "", "request", "Lcom/example/database/dataclasses/taskResponse;", "(Lcom/example/database/dataclasses/taskResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateDeadline", "", "daysLeft", "deleteTask", "emailId", "title", "password", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTasks", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "Lcom/example/database/dataclasses/UpdateTaskStatusRequest;", "(Lcom/example/database/dataclasses/UpdateTaskStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-demo"})
public final class TasksImplemetation implements com.example.service.actions.TaskActions {
    @org.jetbrains.annotations.NotNull()
    private final com.example.datalayer.redisActions redisCache = null;
    
    @javax.inject.Inject()
    public TasksImplemetation(@org.jetbrains.annotations.NotNull()
    com.example.datalayer.redisActions redisCache) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String calculateDeadline(@org.jetbrains.annotations.NotNull()
    java.lang.String daysLeft) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getTasks(@org.jetbrains.annotations.NotNull()
    java.lang.String emailId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.database.dataclasses.taskResponse>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object addTask(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.taskResponse request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object updateTask(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.UpdateTaskStatusRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object deleteTask(@org.jetbrains.annotations.NotNull()
    java.lang.String emailId, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}