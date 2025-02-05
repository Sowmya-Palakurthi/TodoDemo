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
public final class UsersImplementation_Factory implements Factory<UsersImplementation> {
  private final Provider<redisActions> redisCacheProvider;

  public UsersImplementation_Factory(Provider<redisActions> redisCacheProvider) {
    this.redisCacheProvider = redisCacheProvider;
  }

  @Override
  public UsersImplementation get() {
    return newInstance(redisCacheProvider.get());
  }

  public static UsersImplementation_Factory create(Provider<redisActions> redisCacheProvider) {
    return new UsersImplementation_Factory(redisCacheProvider);
  }

  public static UsersImplementation newInstance(redisActions redisCache) {
    return new UsersImplementation(redisCache);
  }
}
