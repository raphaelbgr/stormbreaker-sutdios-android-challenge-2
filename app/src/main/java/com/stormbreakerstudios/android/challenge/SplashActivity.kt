package com.stormbreakerstudios.android.challenge

import android.os.Bundle


class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTransparentStatusBarForKitKatAndAbove()
        setContentView(R.layout.activity_splash)
        navigator.navigateToOnboardingScreen(this)
        finish()
    }
}