# ToremaruUtil

---

## 日本語（前半）

ToremaruUtil は、画面右下に小さくアプリ名とバージョン（オプションでビルド番号）を表示する小さな Android ライブラリです。開発時の動作確認に使います。

導入（開発向け、最短）:

1. ライブラリをアプリと同じ階層にチェックアウトする（例: sibling）。
2. アプリの `settings.gradle.kts` に次を追加します：

```kotlin
includeBuild("../ToremaruUtil")
```

3. アプリの `build.gradle.kts` に依存を追加します（例）：

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

Activity からは次のように呼び出します：

```kotlin
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))
AppInfoOverlay.remove(this)
```

---

## English（後半）

ToremaruUtil is a small Android library that displays the app name and version (optionally with a build number) as a compact overlay in the bottom-right corner. Use it for quick verification during development.

Quick start (development):

1. Keep a sibling checkout of this library next to your app.
2. In the app root `settings.gradle.kts` add `includeBuild("../ToremaruUtil")`.
3. Add the dependency in your app module (example):

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

Call from an Activity:

```kotlin
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))
AppInfoOverlay.remove(this)
```

---

Notes: This README intentionally contains a single Japanese section first and a single English section second.
# ToremaruUtil

---

## 日本語（前半）

ToremaruUtil は、画面右下に小さくアプリ名とバージョン（オプションでビルド番号）を表示する小さな Android ライブラリです。開発時の動作確認に使います。

導入（開発向け、最短）:

1. ライブラリをアプリと同じ階層にチェックアウトする（例: sibling）。
2. アプリの `settings.gradle.kts` に `includeBuild("../ToremaruUtil")` を追加する。
3. アプリの `build.gradle.kts` に依存を追加する: `implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")`。

Activity からは `AppInfoOverlay.install(...)` / `AppInfoOverlay.remove(...)` を呼び出してください。

---

## English（後半）

ToremaruUtil is a small Android library that shows the app name and version (optionally with a build number) as a compact overlay in the bottom-right corner. Use it for quick verification during development.

Quick start:

1. Keep a sibling checkout of this library next to your app.
2. In the app root `settings.gradle.kts` add `includeBuild("../ToremaruUtil")`.
3. Add the dependency in your app module: `implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")`.

Call `AppInfoOverlay.install(...)` / `AppInfoOverlay.remove(...)` from an Activity.

---

Notes: This README intentionally contains a single Japanese section first and a single English section second.

---

## 日本語 — 利用者向け導入手順

### 1) 概要

このライブラリはアプリ画面の右下にアプリ名とバージョンをオーバーレイ表示します。軽量で依存が少なく、開発時の動作確認に向きます。

### 2) 推奨ワークフロー（開発）

- 1: Composite build（推奨、ローカル開発）

  - 手順:
    1. このライブラリをアプリと同じ階層にチェックアウト（例: sibling に `ToremaruUtil` を置く）。
    2. アプリのルート `settings.gradle.kts` に次を追加します：

    ```kotlin
    includeBuild("../ToremaruUtil")
    ```

    3. アプリの `build.gradle.kts` に通常どおり依存を書きます（座標は後述）。Composite build を使うとローカルのソースでビルドされます。

- 2: mavenLocal（代替、ローカル公開）

  - 手順:
    1. ライブラリ側で `./gradlew publishToMavenLocal` を実行してローカルレポジトリに公開します。
    2. アプリ側の `repositories` に `mavenLocal()` を追加します。

### 3) 依存の例

アプリの `build.gradle.kts` に次を記述します（公開アーティファクトを利用する場合の例）:

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

（Composite build を使う場合、上記依存は同じままでローカルソースが差し替えられます。）

### 4) Activity での使い方

```kotlin
// オーバーレイを表示
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))

// オーバーレイを削除
AppInfoOverlay.remove(this)
```

`AppInfoOverlay.Config` の省略可能なオプション例:

```kotlin
data class Config(
  val accentColorRes: Int? = null,
  val showBuildNumber: Boolean = false
)
```

（実際の API はライブラリの `AppInfoOverlay` を参照してください）

### 5) 注意点

- この README は開発者向けの最小導入手順を示します。カスタム表示やプロガード設定などの詳細はコード内のコメントやサンプルを参照してください。

---

## English — Consumer Quickstart

### Overview

ToremaruUtil displays the app name and version (optionally build number) as a small overlay in the bottom-right corner of the screen. It is intended for fast verification during development.

### Recommended workflows (development)

- Composite build (recommended)

  1. Keep a sibling checkout of this library next to your app project.
  2. Add the following to the app root `settings.gradle.kts`:

  ```kotlin
  includeBuild("../ToremaruUtil")
  ```

  3. Keep the dependency declaration in your app module as usual — Gradle will substitute the included build.

- Local publishing (`mavenLocal`)

  1. Run `./gradlew publishToMavenLocal` inside the library project.
  2. Add `mavenLocal()` to your app's `repositories`.

### Dependency example

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

### Usage (Activity)

```kotlin
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))
AppInfoOverlay.remove(this)
```

### Notes

- This README provides minimal, practical steps to get started. For integration into CI or publishing workflows, add a dedicated `DEPLOY.md` or CI config with `maven-publish`.


# ToremaruUtil
---

## 日本語（前半）

### 概要

ToremaruUtil は、画面右下に小さく「アプリ名」と「バージョン（オプションでビルド番号）」を表示する軽量な Android ライブラリです。開発時の動作確認やデバッグに使います。

### 簡単な導入（開発向け）

1. このライブラリをアプリと同じ階層にチェックアウトしておきます（例: sibling に配置）。
2. アプリの `settings.gradle.kts` に以下を追加します：

```kotlin
includeBuild("../ToremaruUtil")
```

3. アプリの `build.gradle.kts` で通常どおり依存を宣言します（例）：

## 日本語（前半）

### 概要

ToremaruUtil は、画面右下に小さく「アプリ名」と「バージョン（オプションでビルド番号）」を表示する軽量な Android ライブラリです。開発時の動作確認に使います。

### 開発向け（最短導入）

1. ライブラリをアプリと同じ階層にチェックアウトします（例: sibling に配置）。
2. アプリの `settings.gradle.kts` に次を追加します：

```kotlin
includeBuild("../ToremaruUtil")
```

3. アプリの `build.gradle.kts` に依存を追加します（例）：

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

4. Activity から呼び出します：

```kotlin
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))
AppInfoOverlay.remove(this)
```

必要に応じて `./gradlew publishToMavenLocal` でローカル公開し、`mavenLocal()` 経由で利用できます。

---

## English（後半）

### Overview

ToremaruUtil is a small Android library that displays the app name and version (optionally with a build number) as a compact overlay in the bottom-right corner of the screen. Use it for quick verification during development.

### Quick start (development)

1. Keep a sibling checkout of this library next to your app.
2. Add the following to the app root `settings.gradle.kts`:

```kotlin
includeBuild("../ToremaruUtil")
```

3. Add the dependency in your app module:

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

4. Call from an Activity:

```kotlin
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))
AppInfoOverlay.remove(this)
```

For CI-based publishing, configure `maven-publish` and your preferred registry.

---

この README は「前半日本語／後半英語」の単一ブロック構成です。
```kotlin
includeBuild("../ToremaruUtil")
```

2. アプリ側の `build.gradle.kts` で通常通り依存を宣言します（例）：

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

3. Activity から呼び出します：

```kotlin
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))
AppInfoOverlay.remove(this)
```

必要に応じて `mavenLocal()` に公開して使うこともできます。

---

## English

### Overview

ToremaruUtil is a small Android library that displays the app name and version (optionally with a build number) as a compact overlay in the bottom-right corner of the screen. It is useful for quick verification during development.

### Quick start (development)

1. Keep a sibling checkout of this library and add to the app's `settings.gradle.kts`:

```kotlin
includeBuild("../ToremaruUtil")
```

2. Add the dependency in the app module:

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

3. Call from an Activity:

```kotlin
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))
AppInfoOverlay.remove(this)
```

For CI-based publishing, configure `maven-publish` and your preferred registry.
# ToremaruUtil

---

## 概要

ToremaruUtil は、画面右下にアプリ名とバージョン（およびビルド番号）を小さく表示するための軽量な Android 用ユーティリティです。

このリポジトリは開発者向けにローカル中心のワークフローを想定しています。公開アーティファクトが必要な場合は別途パブリッシュ手順を設定してください。

## 推奨ワークフロー（開発時）

- ローカル composite build（推奨）

  1. アプリのルート `settings.gradle.kts` に次を追加します：

  ```kotlin
  includeBuild("../ToremaruUtil")
  ```

  2. アプリのモジュール `build.gradle.kts` に通常どおり依存を記述します。

  ```kotlin
  dependencies {
      implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
  }
  ```

  - `includeBuild` を使用すると、Gradle はローカルのライブラリソースをアプリのビルドに自動で差し替えます。

- ローカル公開（`mavenLocal()`）

  1. ライブラリ側で `./gradlew publishToMavenLocal` を実行します。
  2. アプリ側の `repositories` に `mavenLocal()` を追加して依存を解決します。

## 使い方（Activity）

```kotlin
// 表示
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200))

// 除去
AppInfoOverlay.remove(this)
```

## 公開（必要時）

ホストされたアーティファクトが必要なら、`maven-publish` と CI（例: GitHub Actions）を設定して GitHub Packages 等へ公開してください。

## 備考

- README は開発ワークフローに集中させ、外部サービス固有の手順やリンクは含めていません。必要なら別途 `DEPLOY.md` 等で公開手順を管理してください。

---

## English (short)

Tiny Android library that shows the app name and version as a small overlay in the bottom-right corner.

Recommended for development: use a local composite build (`includeBuild("../ToremaruUtil")`) or publish locally to `mavenLocal()` for fast iteration.

Example (composite build):

```kotlin
// app root settings.gradle.kts
includeBuild("../ToremaruUtil")

// app module build.gradle.kts
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

Publishing: configure `maven-publish` and CI to publish artifacts to your preferred registry if necessary.
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

- Alternatively configure GitHub Packages in `build.gradle.kts` and a GH Actions workflow to publish.

## Notes

- The overlay is intended to be visible in production; avoid showing sensitive data (keep commit SHAs out unless explicitly desired).
- API is intentionally minimal; expand with Compose support, customization attributes, or additional overlays in later releases.
