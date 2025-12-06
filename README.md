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

ToremaruUtil displays the app name and version (optionally with a build number) as a compact overlay in the bottom-right corner for quick verification during development.

Quick start (development)

Use a local Gradle composite build; see the Japanese quick start above for exact commands and the single dependency example.

Local publishing (mavenLocal)

If you prefer to publish locally, run `./gradlew publishToMavenLocal` in the library directory and enable `mavenLocal()` in your app repositories.

Usage (Activity)

Refer to the Japanese section's minimal Activity example for the usage snippet.

Notes

Add `DEPLOY.md` for CI/publishing workflows if you plan to publish artifacts.
