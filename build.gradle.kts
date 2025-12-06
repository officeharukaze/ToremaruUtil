plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

group = "com.github.officeharukaze"
version = "0.1.1"

android {
    namespace = "net.harukaze.libs.toremaruutil"
    compileSdk = 36

    defaultConfig {
        minSdk = 24
        consumerProguardFiles("consumer-rules.pro")
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
