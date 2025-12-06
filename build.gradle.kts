plugins {
    id("com.android.library") version "7.4.2"
    id("org.jetbrains.kotlin.android") version "1.8.21"
}

android {
    namespace = "net.harukaze.toremaruutil"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        consumerProguardFiles("consumer-rules.pro")
        versionName = "0.1.0"
        versionCode = 1
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
}
