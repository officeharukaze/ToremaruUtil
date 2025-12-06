package net.harukaze.libs.toremaruutil

import android.app.Activity
import android.content.pm.PackageManager
import android.graphics.Color
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

object AppInfoOverlay {

    data class Config(
        val textSizeSp: Float = 14f,
        val accentColorRes: Int? = null,
        val showInRelease: Boolean = true,
        val alpha: Float = 0.9f
    )

    private const val TAG_VIEW = "ToremaruUtilAppInfoView"

    fun install(activity: Activity, config: Config = Config(), explicitText: String? = null) {
        val root = activity.findViewById<ViewGroup>(android.R.id.content)
        try {
            val existing = root.findViewWithTag<View>(TAG_VIEW)
            if (existing != null) root.removeView(existing)
        } catch (_: Exception) {}

        val versionText = explicitText ?: run {
            try {
                val bc = Class.forName(activity.packageName + ".BuildConfig")
                val nameField = bc.getField("APP_VERSION_NAME")
                val codeField = bc.getField("APP_VERSION_CODE")
                val name = nameField.get(null) as? String
                val code = codeField.getInt(null)
                if (!name.isNullOrEmpty()) {
                    "${activity.getString(activity.applicationInfo.labelRes)} Version $name (Build: $code)"
                } else {
                    fallbackVersionText(activity)
                }
            } catch (_: Exception) {
                fallbackVersionText(activity)
            }
        }

        val tv = TextView(activity).apply {
            text = versionText
            setTextSize(TypedValue.COMPLEX_UNIT_SP, config.textSizeSp)
            setBackgroundColor(Color.TRANSPARENT)
            setTextColor(Color.WHITE)
            alpha = config.alpha
            includeFontPadding = false
            isClickable = false
            isFocusable = false
            maxLines = 1
            tag = TAG_VIEW
            setShadowLayer(2f, 1f, 1f, Color.argb(160, 0, 0, 0))
            gravity = Gravity.END or Gravity.BOTTOM
        }

        try {
            val appName = activity.getString(activity.applicationInfo.labelRes)
            val idx = versionText.indexOf(appName)
            if (idx >= 0) {
                val span = SpannableString(versionText)
                val accent = config.accentColorRes?.let { ContextCompat.getColor(activity, it) } ?: ContextCompat.getColor(activity, android.R.color.holo_blue_light)
                span.setSpan(ForegroundColorSpan(accent), idx, idx + appName.length, 0)
                tv.text = span
            }
        } catch (_: Exception) {}

        val lp = FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
            gravity = Gravity.END or Gravity.BOTTOM
            setMargins(0, 0, 8, 8)
        }

        try { root.addView(tv, lp) } catch (_: Exception) {}
    }

    fun remove(activity: Activity) {
        val root = activity.findViewById<ViewGroup>(android.R.id.content)
        try {
            val existing = root.findViewWithTag<View>(TAG_VIEW)
            if (existing != null) root.removeView(existing)
        } catch (_: Exception) {}
    }

    private fun fallbackVersionText(activity: Activity): String {
        return try {
            val pkg = activity.packageName
            val pinfo = activity.packageManager.getPackageInfo(pkg, 0)
            val vname = pinfo.versionName ?: "?"
            val vcode = try { if (android.os.Build.VERSION.SDK_INT >= 28) pinfo.longVersionCode.toString() else pinfo.versionCode.toString() } catch (_: Exception) { "?" }
            "${activity.getString(activity.applicationInfo.labelRes)} Version $vname (Build: $vcode)"
        } catch (_: Exception) {
            activity.getString(activity.applicationInfo.labelRes)
        }
    }
}
