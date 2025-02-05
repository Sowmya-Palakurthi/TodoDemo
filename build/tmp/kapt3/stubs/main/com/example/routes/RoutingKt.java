package com.example.routes;

import com.example.service.actions.TaskActions;
import com.example.service.actions.UserActions;
import com.example.service.impl.TasksImplemetation;
import com.example.service.impl.UsersImplementation;
import io.ktor.server.application.*;
import io.ktor.server.routing.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"configureRouting", "", "Lio/ktor/server/application/Application;", "taskService", "Lcom/example/service/impl/TasksImplemetation;", "userService", "Lcom/example/service/impl/UsersImplementation;", "ktor-demo"})
public final class RoutingKt {
    
    public static final void configureRouting(@org.jetbrains.annotations.NotNull()
    io.ktor.server.application.Application $this$configureRouting, @org.jetbrains.annotations.NotNull()
    com.example.service.impl.TasksImplemetation taskService, @org.jetbrains.annotations.NotNull()
    com.example.service.impl.UsersImplementation userService) {
    }
}