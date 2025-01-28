val ktor_version = "2.1.0"  // Use the appropriate Ktor version you are using
val serialization_version = "1.4.0"

group = "com.example"
version = "0.0.1"

plugins {
    alias(libs.plugins.kotlin.jvm)  // Use the alias if you prefer
    application
    alias(libs.plugins.ktor)
    id("org.jetbrains.kotlin.plugin.serialization") version "1.4.0"
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.logback.classic)
    implementation(libs.ktor.server.config.yaml)
    testImplementation(libs.ktor.server.test.host)
    testImplementation(libs.kotlin.test.junit)
    implementation("redis.clients:jedis:5.0.0")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0") // Jackson Kotlin module
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0") // Jackson core module
    implementation ("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0") // Update to the latest version
    implementation("org.postgresql:postgresql:42.6.0")  // PostgreSQL driver
    implementation("org.jetbrains.exposed:exposed-core:0.41.1") // Exposed ORM Core
    implementation("org.jetbrains.exposed:exposed-dao:0.41.1") // Exposed DAO
    implementation("org.jetbrains.exposed:exposed-jdbc:0.41.1") // Exposed JDBC
    implementation("com.zaxxer:HikariCP:5.0.1") // Connection pooling
    implementation("org.jetbrains.exposed:exposed-java-time:0.41.1")
    // Ktor dependencies
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    implementation("io.ktor:ktor-server-core:$ktor_version")
    implementation("io.ktor:ktor-server-netty:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0" )// Update version if needed
    implementation ("io.ktor:ktor-client-serialization:2.2.2")// For Ktor serialization (if needed)
    implementation("redis.clients:jedis:4.4.3")

}
// Serialization dependencies


kotlin {
    jvmToolchain(20)
}
