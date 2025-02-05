package di

    import com.example.datalayer.redisActions
    import com.example.datalayer.redisImplementation
    import dagger.Binds
    import dagger.Module
    import com.example.service.impl.UsersImplementation
    import com.example.service.impl.TasksImplemetation
    import com.example.service.actions.UserActions
    import com.example.service.actions.TaskActions
    import javax.inject.Singleton

@Module
interface AppModule {

    @Binds
    @Singleton
    abstract fun BindUserService(usersImplementation: UsersImplementation): UserActions

    @Binds
    @Singleton
    abstract fun BindTaskService(tasksImplementation: TasksImplemetation): TaskActions

    @Binds
    @Singleton
    abstract fun bindRedisService(redisImplementation: redisImplementation): redisActions

}



