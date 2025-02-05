package com.example.routes;

import com.example.MyApplication;
import com.example.service.actions.TaskActions;
import com.example.database.dataclasses.UpdateTaskStatusRequest;
import com.example.database.dataclasses.taskResponse;
import com.example.service.impl.TasksImplemetation;
import io.ktor.http.*;
import io.ktor.server.routing.*;
import io.ktor.server.response.*;
import io.ktor.server.request.*;
import java.time.LocalDate;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"TaskRoutes", "", "Lio/ktor/server/routing/Route;", "taskService", "Lcom/example/service/impl/TasksImplemetation;", "ktor-demo"})
public final class TaskRoutesKt {
    
    public static final void TaskRoutes(@org.jetbrains.annotations.NotNull()
    io.ktor.server.routing.Route $this$TaskRoutes, @org.jetbrains.annotations.NotNull()
    com.example.service.impl.TasksImplemetation taskService) {
    }
}