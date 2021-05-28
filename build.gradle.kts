plugins {
    kotlin("jvm") version Versions.kotlin
    kotlin("plugin.serialization") version Versions.kotlin
}

group = "xyz.cssxsh.github"
version = "0.1.0-dev-1"

repositories {
    mavenLocal()
    maven(url = "https://maven.aliyun.com/repository/releases")
    maven(url = "https://maven.aliyun.com/repository/public")
    mavenCentral()
    jcenter()
    maven(url = "https://maven.aliyun.com/repository/gradle-plugin")
    gradlePluginPortal()
}

dependencies {
    implementation(ktor("client", Versions.ktor))
    implementation(ktor("client-serialization", Versions.ktor))
    implementation(ktor("client-encoding", Versions.ktor))
    implementation(ktor("client-okhttp", Versions.ktor))
    testImplementation(kotlin("test-junit5"))
    testImplementation(junit("jupiter", Versions.junit))
}

kotlin {
    sourceSets {
        all {
            languageSettings.useExperimentalAnnotation("kotlin.ExperimentalStdlibApi")
            languageSettings.useExperimentalAnnotation("kotlinx.serialization.ExperimentalSerializationApi")
            languageSettings.useExperimentalAnnotation("kotlinx.serialization.InternalSerializationApi")
            languageSettings.useExperimentalAnnotation("kotlin.time.ExperimentalTime")
        }
    }
}

tasks {

    test {
        useJUnitPlatform()
    }

    compileKotlin {
        kotlinOptions.freeCompilerArgs += "-Xjvm-default=all"
        kotlinOptions.jvmTarget = "11"
    }

    compileTestKotlin {
        kotlinOptions.freeCompilerArgs += "-Xjvm-default=all"
        kotlinOptions.jvmTarget = "11"
    }
}