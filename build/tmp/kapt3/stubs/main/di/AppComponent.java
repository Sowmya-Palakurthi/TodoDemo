package di;

import com.example.datalayer.redisImplementation;
import com.example.service.actions.TaskActions;
import com.example.service.actions.UserActions;
import com.example.service.impl.TasksImplemetation;
import com.example.service.impl.UsersImplementation;
import dagger.Component;
import javax.inject.Singleton;

@javax.inject.Singleton()
@dagger.Component(modules = {di.AppModule.class})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\t"}, d2 = {"Ldi/AppComponent;", "", "getRedisService", "Lcom/example/datalayer/redisImplementation;", "getTaskService", "Lcom/example/service/impl/TasksImplemetation;", "getUserService", "Lcom/example/service/impl/UsersImplementation;", "Companion", "ktor-demo"})
public abstract interface AppComponent {
    @org.jetbrains.annotations.NotNull()
    public static final di.AppComponent.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.service.impl.UsersImplementation getUserService();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.service.impl.TasksImplemetation getTaskService();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.datalayer.redisImplementation getRedisService();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Ldi/AppComponent$Companion;", "", "()V", "create", "Ldi/AppComponent;", "ktor-demo"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final di.AppComponent create() {
            return null;
        }
    }
}