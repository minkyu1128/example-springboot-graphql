plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.jpa") version "1.9.25"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot GraphQL
    implementation("org.springframework.boot:spring-boot-starter-graphql")

    // Spring Web (서버 실행 목적)
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Spring Data JPA (H2 데이터베이스 연동 목적)
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // Database
    runtimeOnly("com.h2database:h2")

    // Kotlin 관련 의존성
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // 테스트 관련
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testImplementation("org.springframework.graphql:spring-graphql-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
