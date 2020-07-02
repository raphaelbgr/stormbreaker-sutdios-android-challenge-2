package com.stormbreakerstudios.android.challenge;

import android.content.Context;
import android.content.Intent;

public class Navigator {
    void navigateToOnboardingScreen(Context context) {
        context.startActivity(new Intent(context, OnboardingActivity.class));
    }

    void navigateToMainScreen(Context context) {
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
