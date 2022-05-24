plugins {

    // Application
    id(libs.plugins.agp.application.get().pluginId)

    // Kotlin
    id("kotlin-android")

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
    implementation(libs.coroutines.android)

    // Lifecycle
    implementation(libs.bundles.lifecycle)

    // Firebase Platform BoM
    implementation(platform(libs.firebase.platform))

    // Firebase Authentication
    implementation(libs.firebase.auth)
}