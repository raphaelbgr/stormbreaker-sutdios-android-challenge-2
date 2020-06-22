package com.stormbreakerstudios.android.challenge

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.view.WindowManager

abstract class BaseActivity : AppCompatActivity() {
    val navigator: Navigator by lazy(LazyThreadSafetyMode.PUBLICATION) { Navigator() }

    fun setTransparentStatusBarForKitKatAndAbove() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }
}