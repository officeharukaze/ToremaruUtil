# ToremaruUtil

Small Android utility library. First feature: App info overlay that shows app name, version and build code in the bottom-right of the screen.

## Usage

Add dependency (via JitPack after publishing):

1. Add JitPack to your repositories (root `build.gradle` or `settings.gradle.kts`):

```kotlin
repositories {
    maven { url = uri("https://jitpack.io") }
}
```

2. Add dependency:

```kotlin
dependencies {
    implementation("com.github.<your-org>:ToremaruUtil:0.1.0")
}
```

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

## Publishing

- Tag a release (e.g. `v0.1.0`) and push to GitHub. JitPack can build from tags and provide a Maven coordinate.
- Alternatively configure GitHub Packages in `build.gradle.kts` and a GH Actions workflow to publish.

## Notes

- The overlay is intended to be visible in production; avoid showing sensitive data (keep commit SHAs out unless explicitly desired).
- API is intentionally minimal; expand with Compose support, customization attributes, or additional overlays in later releases.
