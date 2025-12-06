# ToremaruUtil

---

## 概要

ToremaruUtil は、画面右下に小さくアプリ名とバージョン（オプションでビルド番号）を表示する小さな Android ライブラリです。開発時の動作確認やデバッグに使います。

## クイックスタート（開発向け）

推奨: ローカルの composite build を使う方法。

1. ライブラリをアプリと同じ階層にチェックアウトする（例: sibling に `ToremaruUtil`）。
2. アプリのルート `settings.gradle.kts` に次を追加します：



3. アプリのモジュール `build.gradle.kts` に依存を追加します（例）：



Composite build を使うと、上記の依存宣言のままローカルのライブラリリソースがビルドに差し替えられます。

### ローカル公開（代替）

1. ライブラリ側でローカル公開を行う:



2. アプリ側に `mavenLocal()` を追加して依存を解決します。

## Activity からの利用例



例: `AppInfoOverlay.Config` の代表的なオプション



## 注意点

- この README はライブラリ利用者向けの最小導入手順を示します。CI 連携や公開手順が必要な場合は別ファイル（例: `DEPLOY.md`）で詳述してください。

---

## Overview

ToremaruUtil is a small Android library that displays the app name and version (optionally with a build number) as a compact overlay in the bottom-right corner. It is intended for quick verification during development.

## Quick start (development)

Recommended: use a local composite build.

1. Keep a sibling checkout of this library next to your app (e.g. `../ToremaruUtil`).
2. In the app root `settings.gradle.kts` add:



3. Add the dependency in your app module (example):



With composite builds, Gradle substitutes the included build so the app compiles against local library sources.

### Local publishing (alternative)

1. Publish locally from the library directory:



2. Add `mavenLocal()` to your app repositories and resolve the dependency.

## Usage (Activity)



Example `Config`:



## Notes

- This README provides concise, practical steps for developers. Add `DEPLOY.md` or CI configs for publishing workflows when needed.
