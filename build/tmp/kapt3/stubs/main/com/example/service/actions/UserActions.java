package com.example.service.actions;

import com.example.database.dataclasses.UpdatePasswordRequest;
import com.example.database.dataclasses.userRequest;
import com.example.database.dataclasses.userResponse;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000eH\u00a6@\u00a2\u0006\u0002\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/example/service/actions/UserActions;", "", "addUser", "", "request", "Lcom/example/database/dataclasses/userRequest;", "(Lcom/example/database/dataclasses/userRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteUser", "getUser", "Lcom/example/database/dataclasses/userResponse;", "emailId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUser", "Lcom/example/database/dataclasses/UpdatePasswordRequest;", "(Lcom/example/database/dataclasses/UpdatePasswordRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-demo"})
public abstract interface UserActions {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUser(@org.jetbrains.annotations.NotNull()
    java.lang.String emailId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.database.dataclasses.userResponse> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addUser(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.userRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteUser(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.userRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.UpdatePasswordRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}