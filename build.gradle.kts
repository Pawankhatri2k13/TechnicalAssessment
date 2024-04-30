plugins {
    id("java")
}

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("nu.studer:gradle-jooq-plugin:1.0.5")
        classpath("org.beanio:beanio:2.1.0")
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.beanio:beanio:2.1.0")
}

tasks.test {
    useJUnitPlatform()
}