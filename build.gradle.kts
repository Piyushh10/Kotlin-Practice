plugins {
    kotlin("jvm") version "1.7.22"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
}

application {
    mainClass.set("MainKt")
}

kotlin {
    jvmToolchain(11)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "11"
        languageVersion = "1.7"
        apiVersion = "1.7"
        // Disable the problematic compiler optimization
        freeCompilerArgs += listOf(
            "-Xdisable-const-evaluation",
            "-Xno-optimize",
            "-Xuse-old-backend"
        )
    }
}
