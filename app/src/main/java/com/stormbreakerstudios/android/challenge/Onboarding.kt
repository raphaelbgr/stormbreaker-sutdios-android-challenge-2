package com.stormbreakerstudios.android.challenge

import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.stormbreakerstudios.android.challenge.databinding.ActivityOnboardingBinding
import kotlinx.android.synthetic.main.activity_onboarding.*


class Onboarding : BaseActivity() {
    private lateinit var viewBinding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityOnboardingBinding.inflate(layoutInflater)
        setTransparentStatusBarForKitKatAndAbove()
        setContentView(R.layout.activity_onboarding)
        setMarginForSaveButton()
        setDatePickerForBirthdayEditText()
    }

    private fun setMarginForSaveButton() {
        val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
        val navbarHeight = resources.getDimensionPixelSize(resourceId)

        val params = viewBinding.btSave.layoutParams as ConstraintLayout.LayoutParams
        params.setMargins(
            params.leftMargin,
            params.topMargin,
            params.rightMargin,
            params.bottomMargin + navbarHeight
        )
        bt_save.layoutParams = params
    }

    private fun setDatePickerForBirthdayEditText() {

    }
}