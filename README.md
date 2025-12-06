# ToremaruUtil

---

## 概要

ToremaruUtil は、画面右下に小さくアプリ名とバージョン（オプションでビルド番号）を表示する小さな Android ライブラリです。開発時の動作確認やデバッグに使います。

## クイックスタート（開発向け）

推奨: ローカルの composite build を使う方法。

1. ライブラリをアプリと同じ階層にチェックアウトする（例: sibling に `ToremaruUtil`）。
2. アプリのルート `settings.gradle.kts` に次を追加します：

```kotlin
includeBuild("../ToremaruUtil")
```

3. アプリのモジュール `build.gradle.kts` に依存を追加します（例）：

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

Composite build を使うと、上記の依存宣言のままローカルのライブラリリソースがビルドに差し替えられます。

### ローカル公開（代替）

1. ライブラリ側でローカル公開を行う:

```bash
./gradlew publishToMavenLocal
```

2. アプリ側に `mavenLocal()` を追加して依存を解決します。

## Activity からの利用例

```kotlin
// オーバーレイを表示
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200, showBuildNumber = false))

// オーバーレイを削除
AppInfoOverlay.remove(this)
```

例: `AppInfoOverlay.Config` の代表的なオプション

```kotlin
data class Config(
  val accentColorRes: Int? = null,
  val showBuildNumber: Boolean = false
)
```

## 注意点

- この README はライブラリ利用者向けの最小導入手順を示します。CI 連携や公開手順が必要な場合は別ファイル（例: `DEPLOY.md`）で詳述してください。

---

## Overview

ToremaruUtil is a small Android library that displays the app name and version (optionally with a build number) as a compact overlay in the bottom-right corner. It is intended for quick verification during development.

## Quick start (development)

Recommended: use a local composite build.

1. Keep a sibling checkout of this library next to your app (e.g. `../ToremaruUtil`).
2. In the app root `settings.gradle.kts` add:

```kotlin
includeBuild("../ToremaruUtil")
```

3. Add the dependency in your app module (example):

```kotlin
dependencies {
  implementation("com.github.officeharukaze:ToremaruUtil:0.1.1")
}
```

With composite builds, Gradle substitutes the included build so the app compiles against local library sources.

### Local publishing (alternative)

1. Publish locally from the library directory:

```bash
./gradlew publishToMavenLocal
```

2. Add `mavenLocal()` to your app repositories and resolve the dependency.

## Usage (Activity)

```kotlin
AppInfoOverlay.install(this, AppInfoOverlay.Config(accentColorRes = R.color.teal_200, showBuildNumber = false))
AppInfoOverlay.remove(this)
```

Example `Config`:

```kotlin
data class Config(
  val accentColorRes: Int? = null,
  val showBuildNumber: Boolean = false
)
```

## Notes

- This README provides concise, practical steps for developers. Add `DEPLOY.md` or CI configs for publishing workflows when needed.


## 日本語

これはテストです。

## English

This is a test.
