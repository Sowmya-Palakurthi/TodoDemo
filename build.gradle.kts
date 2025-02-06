val ktor_version = "2.1.0"  // Update this if needed
val serialization_version = "1.6.0" // Updated to latest
val dagger_version = "2.48"
group = "com.example"
version = "0.0.1"

plugins {
    alias(libs.plugins.kotlin.jvm) // Uses alias if configured
    application
    alias(libs.plugins.ktor)
    kotlin("kapt")
    kotlin("plugin.serialization") version "1.9.22"
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    google()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap") } // Optional: Ktor EAP repo
}

dependencies {

    implementation(kotlin("stdlib", version = "1.8.20")) // Make sure the version matches the Kotlin plugin
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation("io.ktor:ktor-client-serialization:2.2.2") // Ktor serialization (if needed)
    // Serialization
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:$serialization_version")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

    // Logging
    implementation("ch.qos.logback:logback-classic:1.4.12")

    // PostgreSQL & Exposed ORM
    implementation("org.postgresql:postgresql:42.6.0")
    implementation("org.jetbrains.exposed:exposed-core:0.41.1")
    implementation("org.jetbrains.exposed:exposed-dao:0.41.1")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1")
    implementation("org.jetbrains.exposed:exposed-java-time:0.41.1")

    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("redis.clients:jedis:5.0.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")

    // Dependency Injection with Dagger
    implementation("com.google.dagger:dagger:$dagger_version")
    kapt("com.google.dagger:dagger-compiler:$dagger_version")

    // Testing
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)

    // Kotlin Standard Library
    implementation(kotlin("stdlib-jdk8"))
}

kotlin {
    jvmToolchain(11) // Uses Java 20
}
kapt {
    correctErrorTypes = true
}
