plugins {
    kotlin("jvm") version "2.2.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.arrow-kt:arrow-core:2.1.0")
}

application {
    mainClass.set("io.github.t45k.either_trial.MainKt")
}
