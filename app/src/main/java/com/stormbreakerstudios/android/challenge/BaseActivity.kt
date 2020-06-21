package com.stormbreakerstudios.android.challenge

import android.support.v7.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    val navigator: Navigator by lazy(LazyThreadSafetyMode.PUBLICATION) { Navigator() }
}