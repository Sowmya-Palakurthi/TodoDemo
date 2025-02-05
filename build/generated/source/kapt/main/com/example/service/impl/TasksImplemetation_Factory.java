package com.example.service.impl;

import com.example.datalayer.redisActions;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class TasksImplemetation_Factory implements Factory<TasksImplemetation> {
  private final Provider<redisActions> redisCacheProvider;

  public TasksImplemetation_Factory(Provider<redisActions> redisCacheProvider) {
    this.redisCacheProvider = redisCacheProvider;
  }

  @Override
  public TasksImplemetation get() {
    return newInstance(redisCacheProvider.get());
  }

  public static TasksImplemetation_Factory create(Provider<redisActions> redisCacheProvider) {
    return new TasksImplemetation_Factory(redisCacheProvider);
  }

  public static TasksImplemetation newInstance(redisActions redisCache) {
    return new TasksImplemetation(redisCache);
  }
}
