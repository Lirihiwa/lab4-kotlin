// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
    }
    dependencies {
        val navVersion = "2.7.5"
        val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion"
        classpath(safeArgs)
    }
}
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}