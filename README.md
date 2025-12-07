# ToremaruUtil

## 概要
画面右下にアプリ名とバージョン（任意でビルド番号）を表示する軽量 Android ライブラリ。開発/QAでビルド識別を容易にします。

## 前提
- Android: minSdk 24+、compileSdk 36
- ビルド環境: Kotlin 2.x / AGP 8.x

## 導入（ソース導入／composite build）
### ローカルでの取得と配置
以下のコマンドでライブラリをアプリと同じ親ディレクトリに取得・配置します。
```zsh
# 親ディレクトリに移動（あなたのプロジェクト構成に合わせて変更）
cd ..
# HTTPSでクローン（SSH利用者は git@github.com:... を使用しても可）
(cd ..; git clone https://github.com/officeharukaze/ToremaruUtil.git)
# 期待する配置: ../ToremaruUtil
ls -la ../ | grep ToremaruUtil
```

### Gradle設定（アプリ側）
`settings.gradle.kts` に以下を追加します（存在する場合のみ取り込む安全な記述）。
```kotlin
if (file("../ToremaruUtil").exists()) {
  includeBuild("../ToremaruUtil")
}
```
リポジトリ設定は通常どおりです。
```kotlin
dependencyResolutionManagement {
  repositories { google(); mavenCentral() }
}
```

### 動作確認
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

## CI（GitHub Actionsの例）
CIでも同様に親ディレクトリへクローンして配置します。
```yaml
- name: Prepare ToremaruUtil (composite)
  run: |
    git -C .. clone https://github.com/officeharukaze/ToremaruUtil.git || true
    test -d ../ToremaruUtil && echo "ToremaruUtil prepared"
```
> CIで `../ToremaruUtil` が存在すると composite build が有効化されます。存在しない場合は安全にスキップします。

## 注意
- 本番で常時表示したくない場合は、ビルドタイプやフラグで `install()` 呼び出しを制御（例: `if (BuildConfig.DEBUG) { ... }`）。
- 環境識別を強化したい場合は、アクセント色や追加ラベルの運用を推奨。

## ライセンス
Apache License 2.0（SPDX-License-Identifier: Apache-2.0）。詳細は `LICENSE` を参照してください。
