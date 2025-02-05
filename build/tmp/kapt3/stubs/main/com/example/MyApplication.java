package com.example;

import com.example.database.*;
import io.ktor.serialization.kotlinx.json.*;
import io.ktor.server.application.*;
import io.ktor.server.engine.*;
import io.ktor.server.netty.*;
import io.ktor.server.plugins.contentnegotiation.*;
import di.AppComponent;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lcom/example/MyApplication;", "", "()V", "Companion", "ktor-demo"})
public final class MyApplication {
    public static di.AppComponent appComponent;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.MyApplication.Companion Companion = null;
    
    public MyApplication() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/example/MyApplication$Companion;", "", "()V", "appComponent", "Ldi/AppComponent;", "getAppComponent", "()Ldi/AppComponent;", "setAppComponent", "(Ldi/AppComponent;)V", "ktor-demo"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final di.AppComponent getAppComponent() {
            return null;
        }
        
        public final void setAppComponent(@org.jetbrains.annotations.NotNull()
        di.AppComponent p0) {
        }
    }
}