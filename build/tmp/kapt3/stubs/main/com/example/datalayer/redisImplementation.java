package com.example.datalayer;

import com.example.database.dataclasses.taskResponse;
import com.example.database.dataclasses.userRequest;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/example/datalayer/redisImplementation;", "Lcom/example/datalayer/redisActions;", "()V", "addTaskData", "", "request", "Lcom/example/database/dataclasses/taskResponse;", "addUserData", "Lcom/example/database/dataclasses/userRequest;", "deleteTaskData", "emailId", "", "title", "deleteUserData", "getTaskData", "", "getUserData", "setUserData", "data", "time", "", "emailid", "ktor-demo"})
public final class redisImplementation implements com.example.datalayer.redisActions {
    
    @javax.inject.Inject()
    public redisImplementation() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.String getUserData(@org.jetbrains.annotations.NotNull()
    java.lang.String emailId) {
        return null;
    }
    
    @java.lang.Override()
    public boolean deleteUserData(@org.jetbrains.annotations.NotNull()
    java.lang.String emailId) {
        return false;
    }
    
    @java.lang.Override()
    public boolean addUserData(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.userRequest request) {
        return false;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.util.List<com.example.database.dataclasses.taskResponse> getTaskData(@org.jetbrains.annotations.NotNull()
    java.lang.String emailId) {
        return null;
    }
    
    @java.lang.Override()
    public boolean deleteTaskData(@org.jetbrains.annotations.NotNull()
    java.lang.String emailId, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
        return false;
    }
    
    @java.lang.Override()
    public boolean addTaskData(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.taskResponse request) {
        return false;
    }
    
    @java.lang.Override()
    public boolean setUserData(@org.jetbrains.annotations.NotNull()
    java.lang.String data, long time, @org.jetbrains.annotations.NotNull()
    java.lang.String emailid) {
        return false;
    }
}