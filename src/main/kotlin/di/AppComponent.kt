package di

import com.example.datalayer.redisImplementation
import com.example.service.actions.TaskActions
import com.example.service.actions.UserActions
import com.example.service.impl.TasksImplemetation
import com.example.service.impl.UsersImplementation
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun getUserService(): UsersImplementation
    fun getTaskService(): TasksImplemetation
    fun getRedisService(): redisImplementation

    companion object {
        fun create(): AppComponent = DaggerAppComponent.create()
    }
}






