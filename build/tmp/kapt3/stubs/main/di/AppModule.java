package di;

import com.example.datalayer.redisActions;
import com.example.datalayer.redisImplementation;
import dagger.Binds;
import dagger.Module;
import com.example.service.impl.UsersImplementation;
import com.example.service.impl.TasksImplemetation;
import com.example.service.actions.UserActions;
import com.example.service.actions.TaskActions;
import javax.inject.Singleton;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'\u00a8\u0006\u000e"}, d2 = {"Ldi/AppModule;", "", "BindTaskService", "Lcom/example/service/actions/TaskActions;", "tasksImplementation", "Lcom/example/service/impl/TasksImplemetation;", "BindUserService", "Lcom/example/service/actions/UserActions;", "usersImplementation", "Lcom/example/service/impl/UsersImplementation;", "bindRedisService", "Lcom/example/datalayer/redisActions;", "redisImplementation", "Lcom/example/datalayer/redisImplementation;", "ktor-demo"})
public abstract interface AppModule {
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.service.actions.UserActions BindUserService(@org.jetbrains.annotations.NotNull()
    com.example.service.impl.UsersImplementation usersImplementation);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.service.actions.TaskActions BindTaskService(@org.jetbrains.annotations.NotNull()
    com.example.service.impl.TasksImplemetation tasksImplementation);
    
    @dagger.Binds()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.datalayer.redisActions bindRedisService(@org.jetbrains.annotations.NotNull()
    com.example.datalayer.redisImplementation redisImplementation);
}