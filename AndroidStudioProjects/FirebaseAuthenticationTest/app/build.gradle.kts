plugins {

    // Application
    id(libs.plugins.agp.application.get().pluginId)


    // Kotlin
    id("kotlin-android")

    // Kapt
    id("kotlin-kapt")

    // Hilt
    id(libs.plugins.hilt.android.get().pluginId)

    // Google Services
    id(libs.plugins.google.services.get().pluginId)
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.timplifier.firebaseauthenticationtest"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    //ViewBinding
    buildFeatures.viewBinding = true
}

dependencies {


    // UI Components
    implementation(libs.bundles.uiComponents)

    // Core
    implementation(libs.android.core)

    // Navigation
    implementation(libs.bundles.navigation)

    // Coroutines
    implementation(libs.bundles.coroutines)

    // Lifecycle
    implementation(libs.bundles.lifecycle)

    // Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    // Firebase Authentication
    implementation(libs.bundles.firebase)

    // Firebase Platform BoM
    implementation(platform(libs.firebase.platform))

}