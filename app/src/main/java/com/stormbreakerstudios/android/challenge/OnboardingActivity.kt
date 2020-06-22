package com.stormbreakerstudios.android.challenge

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.constraintlayout.widget.ConstraintLayout
import com.stormbreakerstudios.android.challenge.databinding.ActivityOnboardingBinding
import com.stormbreakerstudios.android.challenge.util.DatePickerFragment
import com.stormbreakerstudios.android.challenge.util.TimePickerFragment


class OnboardingActivity : BaseActivity(), DatePickerFragment.DatePickerListener,
    TimePickerFragment.TimePickerListener, AdapterView.OnItemSelectedListener {

    private val TAG = OnboardingActivity::class.java.simpleName

    private lateinit var viewBinding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setTransparentStatusBarForKitKatAndAbove()
        setMarginForSaveButton()
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
        viewBinding.btSave.layoutParams = params
    }

    fun showDatePickerDialog(view: View) {
        val newFragment = DatePickerFragment(this)
        newFragment.show(supportFragmentManager, "datePicker")
    }

    fun showTimePickerDialog(view: View) {
        val newFragment = TimePickerFragment(this)
        newFragment.show(supportFragmentManager, "timePicker")
    }

    fun showTimeZoneSpinnerDialog(view: View) {
        val spinner = viewBinding.spTimeZone
        ArrayAdapter.createFromResource(
            this, R.array.timezone_array, android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = this
            spinner.performClick()
        }
    }

    override fun onDatePicked(year: Int, month: Int, day: Int) {
        viewBinding.etBirth.text = String.format("%02d/%02d/%s", month, day, year)
    }

    override fun onTimePicked(hourOfDay: Int, minute: Int) {
        viewBinding.etMeditationTime.text = String.format("%02d:%02d", hourOfDay, minute)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewBinding.etTimeZone.text = parent?.getItemAtPosition(position).toString()
    }

    private fun isFormValid(): Boolean {
        return viewBinding.etBirth.text.isNotEmpty()
                && viewBinding.etMeditationTime.text.isNotEmpty()
                && viewBinding.etTimeZone.text.isNotEmpty()
    }

    fun onBoardSaved(view: View) {
        if (isFormValid())
            finish()
        else
            toastLong("There are missing fields to fill.")
    }
}