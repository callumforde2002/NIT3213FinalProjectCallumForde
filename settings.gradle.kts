// settings.gradle.kts
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }  // Add any other repositories here
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)  // Ensures repositories are only managed here
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }  // Add other repositories here
    }
}

rootProject.name = "NIT3213FinalProject"
include(":app")
