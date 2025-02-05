package di;

import com.example.datalayer.redisActions;
import com.example.datalayer.redisImplementation;
import com.example.datalayer.redisImplementation_Factory;
import com.example.service.impl.TasksImplemetation;
import com.example.service.impl.UsersImplementation;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class DaggerAppComponent {
  private DaggerAppComponent() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppComponent create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    public AppComponent build() {
      return new AppComponentImpl();
    }
  }

  private static final class AppComponentImpl implements AppComponent {
    private final AppComponentImpl appComponentImpl = this;

    private Provider<redisActions> bindRedisServiceProvider;

    private AppComponentImpl() {

      initialize();

    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.bindRedisServiceProvider = DoubleCheck.provider((Provider) redisImplementation_Factory.create());
    }

    @Override
    public UsersImplementation getUserService() {
      return new UsersImplementation(bindRedisServiceProvider.get());
    }

    @Override
    public TasksImplemetation getTaskService() {
      return new TasksImplemetation(bindRedisServiceProvider.get());
    }

    @Override
    public redisImplementation getRedisService() {
      return new redisImplementation();
    }
  }
}
