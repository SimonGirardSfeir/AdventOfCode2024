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

    testLogging {
        events("PASSED","FAILED","SKIPPED")

        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        showExceptions = true
        showStackTraces = true
        showCauses = true
    }

    addTestListener(object : TestListener {
        override fun beforeSuite(suite: TestDescriptor) {}
        override fun afterSuite(suite: TestDescriptor, result: TestResult) {}
        override fun beforeTest(testDescriptor: TestDescriptor) {}

        override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {
            val durationMillis = result.endTime - result.startTime
            println("Test ${testDescriptor.className}.${testDescriptor.name} ${result.resultType} in ${durationMillis} ms")
        }
    })
}