# ToremaruUtil

ToremaruUtil は画面右下にアプリ名とバージョン（必要に応じてビルド番号）を小さく表示する軽量な Android ライブラリです。開発中の視認や簡易デバッグ確認を目的としています。

---

概要

この README は最小導入手順と利用例を示します。CI や公開手順を記載する場合は `DEPLOY.md` を別途追加してください。

---

クイックスタート（推奨: ローカル開発 / composite build）

1. ライブラリをアプリと同じ親ディレクトリにチェックアウトします（例: `../ToremaruUtil`）。
2. アプリのルート `settings.gradle.kts` に次を追加します：

```kotlin
includeBuild("../ToremaruUtil")
```

3. アプリのモジュール `build.gradle.kts` に依存を一箇所だけ追加します（例）：

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.0")
}
```

この手順により、ローカルのライブラリソースがアプリビルドに差し替えられます。

---

ローカル公開（必要な場合）

ライブラリをローカルに公開して参照するにはライブラリ側で以下を実行してください：

```bash
./gradlew publishToMavenLocal
```

アプリ側で `mavenLocal()` を有効にしてください。

---

使い方（Activity の最小例）

```kotlin
// 表示
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200, showBuildNumber = false))

// 削除
AppInfoOverlay.remove(this)
```

---

設定例（ライブラリ側の Config）

```kotlin
data class Config(
  val accentColorRes: Int? = null,
  val showBuildNumber: Boolean = false
)
```

---

注意

- この README は導入と最小利用例に絞っています。公開/配布手順を追加する場合は `DEPLOY.md` を作成してください。
- ライブラリ変更後はアプリ側で `./gradlew :app:assembleDebug` 等を実行して動作確認を行ってください。

---


Overview

ToremaruUtil shows the app name and version (optionally including a build number) in a compact overlay at the bottom-right of the screen. It is intended to help developers quickly verify which build is running during development and testing.

Quick start (development)

Recommended: use a local Gradle composite build to develop the library side-by-side with your app.

- Place this library next to your app (for example `../ToremaruUtil`).
- Add `includeBuild("../ToremaruUtil")` to the app root `settings.gradle.kts`.
- See the Japanese quick start above for the single dependency example to add in your app module.

When using a composite build, Gradle substitutes the included build so your app compiles against local library sources.

Local publishing (optional)

If you prefer to publish a local artifact instead of using a composite build, see the Japanese section for the local publish command and add `mavenLocal()` to your app repositories.

Usage (Activity)

Call the library from an Activity to install or remove the overlay; see the Japanese section's minimal usage snippet for the concrete code example.

Configuration

See the Japanese `Config` example above for available configuration options.

Notes

- This README provides concise setup and usage instructions. If you plan to add CI or publishing workflows, add a `DEPLOY.md` with details.
- After modifying the library, run `./gradlew :app:assembleDebug` in your app to verify the change.
