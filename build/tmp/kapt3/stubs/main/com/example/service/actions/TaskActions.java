package com.example.service.actions;

import com.example.database.dataclasses.UpdateTaskStatusRequest;
import com.example.database.dataclasses.taskResponse;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0011H\u00a6@\u00a2\u0006\u0002\u0010\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/example/service/actions/TaskActions;", "", "addTask", "", "request", "Lcom/example/database/dataclasses/taskResponse;", "(Lcom/example/database/dataclasses/taskResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTask", "emailId", "", "title", "password", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTasks", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTask", "Lcom/example/database/dataclasses/UpdateTaskStatusRequest;", "(Lcom/example/database/dataclasses/UpdateTaskStatusRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-demo"})
public abstract interface TaskActions {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getTasks(@org.jetbrains.annotations.NotNull()
    java.lang.String emailId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.example.database.dataclasses.taskResponse>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addTask(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.taskResponse request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateTask(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.UpdateTaskStatusRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteTask(@org.jetbrains.annotations.NotNull()
    java.lang.String emailId, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}