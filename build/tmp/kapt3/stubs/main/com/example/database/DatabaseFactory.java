package com.example.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.example.database.dataclasses.tasks;
import com.example.database.dataclasses.users;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.exposed.sql.Database;
import org.jetbrains.exposed.sql.SchemaUtils;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/database/DatabaseFactory;", "", "()V", "init", "", "ktor-demo"})
public final class DatabaseFactory {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.database.DatabaseFactory INSTANCE = null;
    
    private DatabaseFactory() {
        super();
    }
    
    public final void init() {
    }
}