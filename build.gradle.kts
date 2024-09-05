plugins {
    kotlin("jvm") version "2.0.20"
    kotlin("plugin.spring") version "2.0.20"
    id("org.springframework.boot") version "3.3.3"
    kotlin("plugin.serialization") version "2.0.20"
    id("org.graalvm.buildtools.native") version "0.10.2"
    id("io.spring.dependency-management") version "1.1.6"

    id("com.gradleup.shadow") version "8.3.0"
}

group = "net.wh64"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }

    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

val exposed_version: String by project

repositories {
    mavenCentral()
}

dependencies {
    runtimeOnly("org.postgresql:postgresql")

    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("com.zaxxer:HikariCP:5.1.0")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.exposed:exposed-core:${exposed_version}")
    implementation("org.jetbrains.exposed:exposed-jdbc:${exposed_version}")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.1")
    implementation("org.jetbrains.exposed:exposed-spring-boot-starter:${exposed_version}")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")

    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks{
    withType<Test> {
        useJUnitPlatform()
    }

    processResources {
        filesMatching("*.properties") {
            expand(project.properties)
        }
    }
}
