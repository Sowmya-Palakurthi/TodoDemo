package com.example.database.dataclasses;

import org.jetbrains.exposed.sql.ReferenceOption;
import org.jetbrains.exposed.sql.Table;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0018\u0010\u000f\u001a\u00060\u0010R\u00020\u0001X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007\u00a8\u0006\u0015"}, d2 = {"Lcom/example/database/dataclasses/tasks;", "Lorg/jetbrains/exposed/sql/Table;", "()V", "deadline", "Lorg/jetbrains/exposed/sql/Column;", "", "getDeadline", "()Lorg/jetbrains/exposed/sql/Column;", "description", "getDescription", "emailid", "getEmailid", "isdone", "", "getIsdone", "primaryKey", "Lorg/jetbrains/exposed/sql/Table$PrimaryKey;", "getPrimaryKey", "()Lorg/jetbrains/exposed/sql/Table$PrimaryKey;", "title", "getTitle", "ktor-demo"})
public final class tasks extends org.jetbrains.exposed.sql.Table {
    @org.jetbrains.annotations.NotNull()
    private static final org.jetbrains.exposed.sql.Column<java.lang.String> title = null;
    @org.jetbrains.annotations.NotNull()
    private static final org.jetbrains.exposed.sql.Column<java.lang.String> description = null;
    @org.jetbrains.annotations.NotNull()
    private static final org.jetbrains.exposed.sql.Column<java.lang.Boolean> isdone = null;
    @org.jetbrains.annotations.NotNull()
    private static final org.jetbrains.exposed.sql.Column<java.lang.String> emailid = null;
    @org.jetbrains.annotations.NotNull()
    private static final org.jetbrains.exposed.sql.Column<java.lang.String> deadline = null;
    @org.jetbrains.annotations.NotNull()
    private static final org.jetbrains.exposed.sql.Table.PrimaryKey primaryKey = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.database.dataclasses.tasks INSTANCE = null;
    
    private tasks() {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.exposed.sql.Column<java.lang.String> getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.exposed.sql.Column<java.lang.String> getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.exposed.sql.Column<java.lang.Boolean> getIsdone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.exposed.sql.Column<java.lang.String> getEmailid() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final org.jetbrains.exposed.sql.Column<java.lang.String> getDeadline() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public org.jetbrains.exposed.sql.Table.PrimaryKey getPrimaryKey() {
        return null;
    }
}