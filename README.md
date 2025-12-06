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
