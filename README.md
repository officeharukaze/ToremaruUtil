# ToremaruUtil

---

このリポジトリは、画面右下にアプリ名とバージョンを表示する小さな Android 用ユーティリティを提供します。

## 開発（推奨ワークフロー）

速い反復開発のために、ローカル中心のワークフローを推奨します。

- Composite build（開発時の推奨）

  アプリのルート `settings.gradle.kts` に次を追加します：

  ```kotlin
  includeBuild("../ToremaruUtil")
  ```

  アプリ側のモジュール `build.gradle.kts` に通常通り依存を記述します。

- mavenLocal（ローカル公開）

  ライブラリで `./gradlew publishToMavenLocal` を実行し、アプリ側で `mavenLocal()` を使って依存を取得します。

## 使い方（Activity）

```kotlin
// 表示
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))

// 除去
AppInfoOverlay.remove(this)
```

## 公開

必要に応じて `maven-publish` と CI（例: GitHub Actions）を設定し、好みのレジストリへ公開してください。

---

English (short)

Tiny Android utility that shows app name and version as an overlay in the bottom-right corner.

Recommended development workflow: use a local composite build (`includeBuild("../ToremaruUtil")`) or publish to `mavenLocal()` for iteration.
# ToremaruUtil

---

## 概要

このライブラリは、画面右下にアプリ名とバージョン（およびビルド番号）を表示するための小さな Android 用ユーティリティです。
開発時はローカルでの反復開発（ローカル composite build や `mavenLocal()`）を利用するワークフローを推奨します。

## 使い方（導入例）

- composite build（開発時の推奨）

  1. アプリのルート `settings.gradle.kts` に次を追加します：

  ```kotlin
  includeBuild("../ToremaruUtil")
  ```

  2. アプリのモジュール `build.gradle.kts` に通常通り依存を記述します：

  ```kotlin
  dependencies {
      implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
  }
  ```

  `includeBuild` を使うと Gradle がローカルのライブラリソースをビルドに差し替えます。

- mavenLocal（ローカル公開）

  1. ライブラリ側で `./gradlew publishToMavenLocal` を実行します。
  2. アプリ側の `repositories` に `mavenLocal()` を追加して依存を解決します。

```kotlin
repositories {
    mavenLocal()
    mavenCentral()
    google()
}
```

注：このリポジトリの `group` は `com.github.officeharukaze`、`version` は `0.1.1` です。

## Activity からの利用例

```kotlin
// オーバーレイを表示
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))

// オーバーレイを除去
AppInfoOverlay.remove(this)
```

## 開発上のヒント

- composite build を使う場合、アプリ側の `pluginManagement` で AGP/Kotlin のバージョンをルート側で解決しておくとプラグインの衝突を避けられます。
- 公開アーティファクトが必要な場合は `maven-publish` を利用して GitHub Packages 等へ公開する運用を検討してください。

---

## English (short)

Tiny Android utility that shows app name and version as an overlay in the bottom-right corner.

Recommended development workflow: use a local composite build (`includeBuild("../ToremaruUtil")`) or `mavenLocal()` for fast iteration.

Example (composite build):

```kotlin
// app root settings.gradle.kts
includeBuild("../ToremaruUtil")

// app module build.gradle.kts
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

Publishing: configure `maven-publish` and CI to publish artifacts to your preferred registry when needed.

Notes: README intentionally concise and focused on local development workflows.
# ToremaruUtil

---

# ToremaruUtil

---

Short README (clean): no external build service names included.

Purpose: small Android utility to show app name and version as an overlay in the bottom-right.

Usage (development): prefer local composite builds (`includeBuild("../ToremaruUtil")`) or publishing to `mavenLocal()` for iterative development.

Example (composite build):

```kotlin
// settings.gradle.kts (app)
includeBuild("../ToremaruUtil")

// app module build.gradle.kts
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

Publishing: configure `maven-publish` and CI (e.g. GitHub Actions) to publish artifacts to GitHub Packages or another registry when needed.

Notes: keep README concise for library consumers; for development use local workflows to iterate quickly.
# ToremaruUtil

---

## 概要

このライブラリは、画面右下にアプリ名とバージョン（およびビルド番号）を表示するための小さな Android 用ユーティリティです。
開発中はローカルの composite build（`../ToremaruUtil` を参照）や `mavenLocal()` を利用したワークフローを推奨します。

## 使い方 — 依存の追加

以下は代表的な導入方法です。開発時は外部ビルドサービスへの依存を避け、ローカル中心の手順（`includeBuild` / `mavenLocal`）をおすすめします。

- composite build（推奨、開発時）

  1. アプリのルート `settings.gradle.kts` に次を追加します：

  ```kotlin
  includeBuild("../ToremaruUtil")
  ```

  2. アプリの `build.gradle.kts` で通常通りライブラリ座標を指定します（例）：

  ```kotlin
  dependencies {
      implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
  }
  ```

  Gradle が `includeBuild` を検出するとローカルのライブラリリソースでビルドを行います。
# ToremaruUtil

---

## 概要

このライブラリは、画面右下にアプリ名とバージョン（およびビルド番号）を表示するための小さな Android 用ユーティリティです。
開発時はローカルの composite build（`../ToremaruUtil` を参照）や `mavenLocal()` を利用したワークフローを推奨します。

## 使い方 — 依存の追加

以下は代表的な導入方法です。開発時は外部ビルドサービスへの依存を避け、ローカル中心の手順（`includeBuild` / `mavenLocal` 等）をおすすめします。

- composite build（推奨、開発時）

  1. アプリのルート `settings.gradle.kts` に次を追加します：

  ```kotlin
  includeBuild("../ToremaruUtil")
  ```

  2. アプリの `build.gradle.kts` で通常通りライブラリ座標を指定します（例）：

  ```kotlin
  dependencies {
      implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
  }
  ```

  Gradle が `includeBuild` を検出するとローカルのライブラリリソースでビルドを行います。

- project モード（同一リポジトリ内にライブラリを配置する場合）

  ```kotlin
  // settings.gradle.kts
  include(":ToremaruUtil")

  // app build.gradle.kts
  dependencies {
      implementation(project(":ToremaruUtil"))
  }
  ```

- mavenLocal（ローカル公開）

  1. ライブラリで `./gradlew publishToMavenLocal` を実行します。
  2. アプリの `repositories` に `mavenLocal()` を追加し、通常の座標を使って依存を指定します：

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

注：このリポジトリの `group` は `com.github.officeharukaze`、`version` は `0.1.1` です。

## 使い方 — Activity 内での呼び出し

```kotlin
// オーバーレイを表示（BuildConfig が使えなければ PackageManager を参照）
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))

// オーバーレイを除去
AppInfoOverlay.remove(this)
```

## 開発・運用のヒント

- composite build を使う場合、アプリ側の `pluginManagement` で AGP/Kotlin のバージョンをルートで解決する設定を行うと、プラグインの衝突を避けられます。
- 公開アーティファクトが必要な場合は `maven-publish` を用いて GitHub Packages 等に公開する運用を検討してください。

---

## English (Overview)

Small Android utility library. The first feature is an app info overlay that shows the app name, version and build number in the bottom-right corner of the screen.
For iterative development we recommend using a local composite build (`../ToremaruUtil`) or `mavenLocal()`.

## English (Usage — Adding the dependency)

Examples for including the library in your app:

- Local composite build (recommended for development)

  1. Add to your app root `settings.gradle.kts`:

  ```kotlin
  includeBuild("../ToremaruUtil")
  ```

  2. In your app's `build.gradle.kts` add the dependency using the library coordinate:

  ```kotlin
  dependencies {
      implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
  }
  ```

- Project mode (if the library is added as a module in the same repository)

  ```kotlin
  dependencies {
      implementation(project(":ToremaruUtil"))
  }
  ```

- Using `mavenLocal()` (after running `./gradlew publishToMavenLocal` in the library)

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

Note: the project's `group` is `com.github.officeharukaze` and `version` is `0.1.1`.

---

## Development

You can develop locally using the composite build approach or by publishing to `mavenLocal()` and consuming the artifact from the app.

### Recommended: Composite local development

Keep a sibling checkout of this library at `../ToremaruUtil` and use Gradle composite builds so the app always consumes the latest local code.

1. In your app root `settings.gradle.kts` add:

```kotlin
includeBuild("../ToremaruUtil")
```

2. Ensure plugin versions are resolved from the app's root `pluginManagement` so both projects use the same AGP and Kotlin versions.

3. From the app root run `./gradlew assembleDebug` or open the app in Android Studio — the composite build will compile the library sources as part of the build.

4. If you prefer not to use composite builds, publish locally with `./gradlew publishToMavenLocal` inside this library and add `mavenLocal()` to your app repositories.

## Publishing

- Tag a release (e.g. `v0.1.0`) and push to GitHub. Configure `maven-publish` and a CI workflow to publish artifacts to GitHub Packages or another registry if you need hosted artifacts.

## Notes

- The overlay is intended to be visible in production; avoid showing sensitive data such as commit SHAs unless explicitly desired.
- The API is intentionally minimal. Consider adding Compose helpers, additional customization options, or other overlays in future releases.
- project モード（同一リポジトリ内にライブラリを配置する場合）

  ```kotlin
  // settings.gradle.kts
  include(":ToremaruUtil")

  // app build.gradle.kts
  dependencies {
      implementation(project(":ToremaruUtil"))
  }
  ```

- mavenLocal（ローカル公開）

  1. ライブラリで `./gradlew publishToMavenLocal` を実行します。
  2. アプリの `repositories` に `mavenLocal()` を追加し、通常の座標を使って依存を指定します：

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

注：このリポジトリの `group` は `com.github.officeharukaze`、`version` は `0.1.1` です。

## 使い方 — Activity 内での呼び出し

```kotlin
// オーバーレイを表示（BuildConfig が使えなければ PackageManager を参照）
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))

// オーバーレイを除去
AppInfoOverlay.remove(this)
```

## 開発・運用のヒント

- composite build を使う場合、アプリ側の `pluginManagement` で AGP/Kotlin のバージョンをルートで解決する設定を行うと、プラグインの衝突を避けられます。
- 本リポジトリはローカル中心の反復を重視しています。公開アーティファクトが必要な場合は `maven-publish` を設定して GitHub Packages 等に流す運用を検討してください。

---

Small Android utility library. The first feature is an app info overlay that shows the app name,
version and build number in the bottom-right corner of the screen. For iterative development we
recommend using a local composite build (`../ToremaruUtil`) or `mavenLocal()` rather than depending
on remote build services.

## Overview

This repository provides a tiny library to display app name and version as an overlay. For rapid
development prefer the composite build workflow or local publishing to `mavenLocal()`.

## Usage — Adding the dependency

Examples for including the library in your app:

- Local composite build (recommended for development)

  1. Add to your app root `settings.gradle.kts`:

  ```kotlin
  includeBuild("../ToremaruUtil")
  ```

  2. In your app's `build.gradle.kts` add the dependency using the library coordinate:

  ```kotlin
  dependencies {
      implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
  }
  ```

  Gradle will substitute the included build automatically so the app compiles against the local
  library sources.

- Project mode (if the library is added as a module in the same repository)

  ```kotlin
  dependencies {
      implementation(project(":ToremaruUtil"))
  }
  ```

- Using `mavenLocal()` (after running `./gradlew publishToMavenLocal` in the library)

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

Note: the project's `group` is `com.github.officeharukaze` and `version` is `0.1.1`.

## Usage — Activity

```kotlin
// show overlay
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))

// remove overlay
AppInfoOverlay.remove(this)
```

## Development

You can develop locally using the composite-build approach or by publishing to `mavenLocal()` and
consuming the artifact from the app. If you choose composite builds, ensure plugin resolution is
handled at the app root so both projects use the same AGP and Kotlin versions.

## Publishing

- Tag a release (e.g. `v0.1.0`) and push to GitHub. Alternatively, configure `maven-publish` and a GitHub Actions workflow to publish artifacts to GitHub Packages or another repository manager.

## Notes

- The overlay is intended to be visible in production; avoid showing sensitive data such as commit
  SHAs unless explicitly desired.
- The API is intentionally minimal. Consider adding Compose helpers, additional customization
  options, or other overlays in future releases.
# ToremaruUtil

---

## 日本語（概要）

このライブラリは、画面右下にアプリ名とバージョン（およびビルド番号）を表示するための小さな Android ユーティリティです。
開発時は JitPack に公開する代わりに、ローカルの composite build（`../ToremaruUtil` を参照）や `mavenLocal()` を使って反復開発することを推奨します。

---

## 日本語（使い方 — 依存の追加）

以下は代表的な導入方法です。開発中は「composite build」または「mavenLocal」を使うのが便利です。

- composite build（推奨、開発時）

  1. アプリのルート `settings.gradle.kts` に次を追加します：

  ```kotlin
  includeBuild("../ToremaruUtil")
  ```

  2. アプリの `build.gradle.kts` では通常通りライブラリ座標を指定します（例）：

  ```kotlin
  dependencies {
      implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
  }
  ```

  Gradle はローカルの `includeBuild` を自動で差し替え、ライブラリのソースを直接ビルドに取り込みます。

- project モード（同リポジトリ内にライブラリを置く場合）

  ```kotlin
  // settings.gradle.kts
  include(":ToremaruUtil")

  // app build.gradle.kts
  dependencies {
      implementation(project(":ToremaruUtil"))
  }
  ```

- mavenLocal（ローカル公開）

  1. ライブラリで `./gradlew publishToMavenLocal` を実行します。
  2. アプリ側の `repositories` に `mavenLocal()` を追加し、次のように依存を指定します：

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

注：このリポジトリの `group` は `com.github.officeharukaze`、`version` は `0.1.1` です。公開済み／ローカル公開アーティファクトを使う場合はこの座標を使用してください。

---

## 日本語（開発・運用）

- 開発中は composite build を使うと素早い反復が可能です。アプリ側の `pluginManagement` で AGP/Kotlin のバージョンをルート側で解決する設定にしておくと、複合ビルドでのプラグイン衝突を避けられます。

- 公開したい場合は `maven-publish` を追加して GitHub Packages に公開するか、JitPack を利用する方法がありますが、本リポジトリではローカルでの composite ワークフローを推奨しています。

---

## English (Overview)

Small Android utility library. The first feature is an app info overlay that shows the app name,
version and build number in the bottom-right corner of the screen. For iterative development we
recommend using a local composite build (`../ToremaruUtil`) or `mavenLocal()` rather than depending
on a remote artifact provider.

---

## English (Usage — Adding the dependency)

Examples for including the library in your app:

- Local composite build (recommended for development)

  1. Add to your app root `settings.gradle.kts`:

  ```kotlin
  includeBuild("../ToremaruUtil")
  ```

  2. In your app's `build.gradle.kts` add the dependency using the library coordinate:

  ```kotlin
  dependencies {
      implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
  }
  ```

  Gradle will substitute the included build automatically so the app compiles against the local
  library sources.

- Project mode (if the library is added as a module in the same repository)

  ```kotlin
  dependencies {
      implementation(project(":ToremaruUtil"))
  }
  ```

- Using `mavenLocal()` (after running `./gradlew publishToMavenLocal` in the library)

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

Note: the project's `group` is `com.github.officeharukaze` and `version` is `0.1.1`.

---

## English (Development)

You can develop locally using the composite build approach or by publishing to `mavenLocal()` and
consuming the artifact from the app. If you choose composite builds, ensure plugin resolution is
handled at the app root (see `pluginManagement` examples) so both projects use the same AGP and
Kotlin versions.

## Publishing

- Tag a release (e.g. `v0.1.0`) and push to GitHub. Configure `maven-publish` and a CI workflow to publish artifacts to GitHub Packages or similar services if you need hosted artifacts.

## Notes

- The overlay is intended to be visible in production; avoid showing sensitive data such as commit
  SHAs unless explicitly desired.
- The API is intentionally minimal. Consider adding Compose helpers, additional customization
  options, or other overlays in future releases.
# ToremaruUtil

Small Android utility library. First feature: App info overlay that shows app name, version and build
code in the bottom-right of the screen.

---

## 日本語（概要）

このライブラリは、画面右下にアプリ名とバージョン（およびビルド番号）を表示するための小さなユーティリティです。
開発時は JitPack に公開する代わりに、ローカルの composite build（`../ToremaruUtil` を参照）か `mavenLocal()` を利用して反復開発することを推奨します。

---

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

---

## 日本語（利用方法）

- composite build（推奨）

  1. アプリ側の `settings.gradle.kts` に `includeBuild("../ToremaruUtil")` を追加します。
  2. アプリの `build.gradle.kts` で通常の座標（例: `implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")`）を記述します。Gradle がローカルの includeBuild を自動で差し替えます。

- project モード

  同一リポジトリ内にライブラリを置く場合は `implementation(project(":ToremaruUtil"))` を使用してください。

- mavenLocal

  ライブラリで `./gradlew publishToMavenLocal` を実行し、アプリの `repositories` に `mavenLocal()` を追加して `implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")` を使います。

---

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
- Alternatively configure GitHub Packages in `build.gradle.kts` and a GitHub Actions workflow to publish on tag push.

## Notes

- The overlay is intended to be visible in production; avoid showing sensitive data (keep commit SHAs out unless explicitly desired).
- API is intentionally minimal; expand with Compose support, customization attributes, or additional overlays in later releases.
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
