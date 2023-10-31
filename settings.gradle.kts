pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://storage.zego.im/maven") } // Corrected
        maven { url = uri("https://www.jitpack.io") } // Corrected


    }
}

rootProject.name = "bottom_navigation_view_tutorial"
include(":app")
 