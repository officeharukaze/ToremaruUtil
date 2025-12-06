# ToremaruUtil

Small Android utility library. First feature: App info overlay that shows app name, version and build code in the bottom-right of the screen.

## Usage

Add dependency (recommended: use the local composite build or mavenLocal for development):

Examples:

- Using the local composite build (recommended for development)

    1. In the app root `settings.gradle.kts` add:

    ```kotlin
    includeBuild("../ToremaruUtil")
    ```

    2. Then in your app `build.gradle.kts` add the dependency using the library coordinate (Gradle will substitute the included build automatically):

    ```kotlin
    dependencies {
            implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
    }
    ```

- Using a project dependency (if you include the library as a project/module inside the same repo)

    ```kotlin
    // settings.gradle.kts
    include(":ToremaruUtil")

    // app build.gradle.kts
    dependencies {
            implementation(project(":ToremaruUtil"))
    }
    ```

- Using `mavenLocal()` (after `./gradlew publishToMavenLocal` in the library)

    ```kotlin
    repositories {
            mavenLocal()
            mavenCentral()
            google()
    }

    dependencies {
            implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
    }
    ```

Note: this repository's `group` is `com.github.officeharukaze` and `version` is `0.1.1`, so use that coordinate when depending on a published/local artifact.

3. Use in Activity:

```kotlin
// show overlay (will use build config if available, otherwise PackageManager)
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))

// remove
AppInfoOverlay.remove(this)
```

## Development

You can develop locally and test via one of these approaches:

- `includeBuild("../ToremaruUtil")` in app `settings.gradle.kts` (composite build)
- publish locally with `./gradlew publishToMavenLocal` and use `mavenLocal()` in app repositories

### Recommended: Composite local development (used here)

Keep a sibling checkout of this library at `../ToremaruUtil` and use Gradle composite builds so the
app always consumes the latest local code. Example steps:

1. In your app root `settings.gradle.kts` add:

```kotlin
includeBuild("../ToremaruUtil")
```

2. Ensure plugin versions are resolved from the app's root `pluginManagement` so both projects use the same AGP/Kotlin versions. Example (root `settings.gradle.kts`):

```kotlin
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.android.application", "com.android.library" -> useModule("com.android.tools.build:gradle:8.13.1")
                "org.jetbrains.kotlin.jvm", "org.jetbrains.kotlin.android" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
```

3. From the app root run `./gradlew assembleDebug` or open the app in Android Studio — the composite build will compile the library sources as part of the build.

4. If you prefer not to use composite builds, publish locally with `./gradlew publishToMavenLocal` inside this library and add `mavenLocal()` to your app repositories.

## Publishing

- Tag a release (e.g. `v0.1.0`) and push to GitHub. JitPack can build from tags and provide a Maven coordinate.
- Alternatively configure GitHub Packages in `build.gradle.kts` and a GH Actions workflow to publish.

## Notes

- The overlay is intended to be visible in production; avoid showing sensitive data (keep commit SHAs out unless explicitly desired).
- API is intentionally minimal; expand with Compose support, customization attributes, or additional overlays in later releases.
