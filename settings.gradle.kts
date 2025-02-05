
pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
    plugins {
        kotlin("jvm") version "2.0.21"
        kotlin("kapt") version "2.0.21" // Add kapt plugin
        kotlin("plugin.serialization") version "1.9.22"
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "ktor-demo"



