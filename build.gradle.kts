plugins {
    id("java")
}

group = "org.girardsimon"
version = "1.0-SNAPSHOT"

val jUnitVersion = "5.11.3"
val jUnitPlatformLauncherVersion = "1.11.3"
val assertjVersion = "3.26.3"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:$jUnitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$jUnitVersion")
    testImplementation("org.assertj:assertj-core:$assertjVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:$jUnitPlatformLauncherVersion")
}

tasks.test {
    useJUnitPlatform()
}