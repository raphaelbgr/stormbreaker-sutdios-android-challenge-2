package com.stormbreakerstudios.android.challenge

import android.content.Context
import android.content.Intent

class Navigator {
    fun navigateToOnboardingScreen(context: Context) {
        context.startActivity(Intent(context, OnboardingActivity::class.java))
    }
}