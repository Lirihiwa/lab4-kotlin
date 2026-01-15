plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.lab4"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.lab4"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    viewBinding {
        enable = true
    }
}

val daggerVersion = "2.57.2"
val dagger = "com.google.dagger:dagger:$daggerVersion"
val daggerCompiler = "com.google.dagger:dagger-compiler:$daggerVersion"

val navVersion = "2.7.5"
val navFragment = "androidx.navigation:navigation-fragment-ktx:$navVersion"
val navUi = "androidx.navigation:navigation-ui-ktx:$navVersion"
val navDynamicFeatureFragment = "androidx.navigation:navigation-dynamic-features-fragment:$navVersion"

val roomVersion = "2.8.4"
val room = "androidx.room:room-ktx:$roomVersion"
var roomRuntime = "androidx.room:room-runtime:$roomVersion"
val roomCompiler = "androidx.room:room-compiler:$roomVersion"

val lifecycleVersion = "2.10.0"
val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion"
val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"

val viewBindingVersion = "1.5.9"
val viewBinding = "com.github.kirich1409:viewbindingpropertydelegate-full:$viewBindingVersion"

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(viewBinding)

    implementation(dagger)
    kapt(daggerCompiler)

    implementation(navFragment)
    implementation(navUi)
    implementation(navDynamicFeatureFragment)

    implementation(room)
    implementation(roomRuntime)
    kapt(roomCompiler)

    implementation(lifecycleViewModel)
    implementation(lifecycleLiveData)
    implementation(lifecycleRuntime)
}