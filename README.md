# ToremaruUtil

## 概要
画面右下にアプリ名とバージョン（任意でビルド番号）を表示する軽量 Android ライブラリ。開発/QAでビルド識別を容易にします。

## 前提
- Android: minSdk 24+、compileSdk 36
- ビルド環境: Kotlin 2.x / AGP 8.x

## 導入（ソース導入／composite build）
1. ライブラリをアプリと同じ親ディレクトリに配置（例: `../ToremaruUtil`）。
2. アプリ側 `settings.gradle.kts` に追加:
```kotlin
if (file("../ToremaruUtil").exists()) {
  includeBuild("../ToremaruUtil")
}
```
3. アプリのリポジトリ設定は通常どおり:
```kotlin
dependencyResolutionManagement {
  repositories { google(); mavenCentral() }
}
```
4. CIでの準備（GitHub Actionsの例）:
```yaml
- name: Prepare ToremaruUtil (composite)
  run: |
    git -C .. clone https://github.com/officeharukaze/ToremaruUtil.git || true
    test -d ../ToremaruUtil && echo "ToremaruUtil prepared"
```
> CIでも `../ToremaruUtil` を用意すると、上記の存在チェックが真になり composite build が有効化されます。存在しない場合は安全にスキップされます。

5. 動作確認:
```zsh
./gradlew :app:assembleDebug
```

## 使い方
### 表示
```kotlin
AppInfoOverlay.install(
  this,
  AppInfoOverlay.Config(
    accentColorRes = R.color.teal_200,
    showBuildNumber = false
  )
)
```

### 削除
```kotlin
AppInfoOverlay.remove(this)
```

## 仕組み
- 表示内容: アプリ名（`applicationInfo.label`）とバージョン名（`PackageInfo.versionName`）。
- ビルド番号: `Config.showBuildNumber = true` の場合、標準のバージョンコード（APIにより `versionCode` / `longVersionCode`）を併記可能。
- レイアウト: `Activity` のウィンドウ直下にオーバレイビューを追加し、右下に配置。

## 設定（Config）
- `accentColorRes: Int? = null` — オーバレイのアクセント色。
- `showBuildNumber: Boolean = false` — バージョンコードの併記可否。

## 注意
- 本番で常時表示したくない場合は、ビルドタイプやフラグで `install()` 呼び出しを制御（例: `if (BuildConfig.DEBUG) { ... }`）。
- 環境識別を強化したい場合は、アクセント色や追加ラベルの運用を推奨。

## ライセンス
Apache License 2.0（SPDX-License-Identifier: Apache-2.0）。詳細は `LICENSE` を参照してください。
