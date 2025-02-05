package com.example.datalayer;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
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
public final class redisImplementation_Factory implements Factory<redisImplementation> {
  @Override
  public redisImplementation get() {
    return newInstance();
  }

  public static redisImplementation_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static redisImplementation newInstance() {
    return new redisImplementation();
  }

  private static final class InstanceHolder {
    private static final redisImplementation_Factory INSTANCE = new redisImplementation_Factory();
  }
}
