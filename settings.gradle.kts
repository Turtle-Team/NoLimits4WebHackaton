pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        id("com.squareup.sqldelight").version("1.5.5").apply(false)
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "NoLimits4WebApp"
include(":androidApp")
include(":shared")
