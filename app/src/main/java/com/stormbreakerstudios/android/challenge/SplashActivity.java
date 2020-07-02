package com.stormbreakerstudios.android.challenge;

import android.os.Bundle;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTransparentStatusBarForKitKatAndAbove();
        setContentView(R.layout.activity_splash);
        navigator.navigateToOnboardingScreen(this);
        finish();
    }
}
