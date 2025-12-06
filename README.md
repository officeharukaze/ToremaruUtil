# ToremaruUtil
---

## 概要

ToremaruUtil は画面右下にアプリ名とバージョン（オプションでビルド番号）を表示する小さな Android ライブラリです。開発時の動作確認やデバッグで使うことを目的としています。

---

## 動作環境（短記）

- Android Gradle Plugin 7.x〜8.x（プロジェクトに合わせてください）
- Kotlin 1.8〜2.x（プロジェクトに合わせてください）

---

## クイックスタート（開発向け — 推奨）

ローカルでライブラリを編集しながらアプリからすぐに確認するには、Gradle の composite build を使うのが便利です。

1. ライブラリをアプリと同じ階層にチェックアウトします（例: `../ToremaruUtil`）。
2. アプリのルート `settings.gradle.kts` に以下を追加します：

```kotlin
includeBuild("../ToremaruUtil")
```

3. アプリのモジュール `build.gradle.kts` に依存を追加します（例）:

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.0")
}
```

Composite build を使うと、上記の依存宣言のまま Gradle がローカルのライブラリリソースを差し替えます。

---

## 代替：ローカル公開（mavenLocal）

ローカルにビルド済みアーティファクトを置いて参照する場合は `publishToMavenLocal` を使えます。

```bash
./gradlew publishToMavenLocal
```

アプリ側に `mavenLocal()` を追加して依存を解決してください。

---

## Activity での使い方（例）

```kotlin
// 表示
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200, showBuildNumber = false))

// 削除
AppInfoOverlay.remove(this)
```

### Config の代表的なオプション（例）

```kotlin
data class Config(
  val accentColorRes: Int? = null,
  val showBuildNumber: Boolean = false
)
```

実際の API シグネチャは `AppInfoOverlay` のソースを参照してください。

---

## トラブルシューティング

- Overlay が表示されない場合：Activity のレイアウトやテーマでオーバーレイが隠れていないか確認してください。必要なら `z` 座標の調整やウィンドウ属性を見直します。
- 依存解決でローカルが使われない場合：`includeBuild` のパス、`settings.gradle.kts` の `pluginManagement`／`dependencyResolutionManagement` を確認してください。

---

## 開発のヒント

- アプリとライブラリで AGP / Kotlin のバージョンを揃えるため、ルートの `pluginManagement` でプラグイン解決を集中させると衝突を避けられます。
- ライブラリを変更したらアプリ側で `./gradlew :app:assembleDebug` を実行して動作確認してください。

---

## ライセンス

このリポジトリに適用するライセンス（例: MIT）をここに記載してください。まだ決めていない場合は `LICENSE` ファイルを追加してください。

---

## Overview

ToremaruUtil is a small Android library that displays the app name and version (optionally with a build number) as a compact overlay in the bottom-right corner. It is intended for quick verification during development.

---

## Quick start (development)

Recommended: use a local Gradle composite build.

1. Keep a sibling checkout of this library next to your app (e.g. `../ToremaruUtil`).
2. In the app root `settings.gradle.kts` add:

```kotlin
includeBuild("../ToremaruUtil")
```

3. Add the dependency in your app module (example):

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.0")
}
```

With composite builds, Gradle substitutes the included build so the app compiles against local library sources.

---

## Alternative: Local publishing (mavenLocal)

1. From the library directory:

```bash
./gradlew publishToMavenLocal
```

2. Add `mavenLocal()` to your app repositories and resolve the dependency.

---

## Usage (Activity)

```kotlin
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200, showBuildNumber = false))
AppInfoOverlay.remove(this)
```

---

## Notes

- This README contains concise, practical instructions for consumers. For CI/publishing workflows, add a `DEPLOY.md` and appropriate CI configuration if you plan to publish artifacts.

1. From the library directory:

```bash
./gradlew publishToMavenLocal
```

2. Add `mavenLocal()` to your app repositories and resolve the dependency.

---

## Usage (Activity)

```kotlin
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200, showBuildNumber = false))
AppInfoOverlay.remove(this)
```

---

## Notes

- This README contains concise, practical instructions for consumers. For CI/publishing workflows, add a `DEPLOY.md` and appropriate CI configuration if you plan to publish artifacts.
