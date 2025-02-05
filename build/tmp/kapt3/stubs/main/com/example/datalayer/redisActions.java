package com.example.datalayer;

import com.example.database.dataclasses.taskResponse;
import com.example.database.dataclasses.userRequest;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e2\u0006\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\nH&J \u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u0014"}, d2 = {"Lcom/example/datalayer/redisActions;", "", "addTaskData", "", "request", "Lcom/example/database/dataclasses/taskResponse;", "addUserData", "Lcom/example/database/dataclasses/userRequest;", "deleteTaskData", "emailid", "", "title", "deleteUserData", "getTaskData", "", "getUserData", "setUserData", "data", "time", "", "ktor-demo"})
public abstract interface redisActions {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getUserData(@org.jetbrains.annotations.NotNull()
    java.lang.String emailid);
    
    public abstract boolean deleteUserData(@org.jetbrains.annotations.NotNull()
    java.lang.String emailid);
    
    public abstract boolean addUserData(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.userRequest request);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.util.List<com.example.database.dataclasses.taskResponse> getTaskData(@org.jetbrains.annotations.NotNull()
    java.lang.String emailid);
    
    public abstract boolean deleteTaskData(@org.jetbrains.annotations.NotNull()
    java.lang.String emailid, @org.jetbrains.annotations.NotNull()
    java.lang.String title);
    
    public abstract boolean addTaskData(@org.jetbrains.annotations.NotNull()
    com.example.database.dataclasses.taskResponse request);
    
    public abstract boolean setUserData(@org.jetbrains.annotations.NotNull()
    java.lang.String data, long time, @org.jetbrains.annotations.NotNull()
    java.lang.String emailid);
}