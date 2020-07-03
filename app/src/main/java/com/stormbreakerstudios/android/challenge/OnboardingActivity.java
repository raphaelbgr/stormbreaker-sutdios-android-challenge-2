package com.stormbreakerstudios.android.challenge;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.stormbreakerstudios.android.challenge.databinding.ActivityOnboardingBinding;
import com.stormbreakerstudios.android.challenge.util.DatePickerFragment;
import com.stormbreakerstudios.android.challenge.util.TimePickerFragment;


public class OnboardingActivity extends BaseActivity implements DatePickerFragment.DatePickerListener,
        TimePickerFragment.TimePickerListener, AdapterView.OnItemSelectedListener {

    private ActivityOnboardingBinding viewBinding = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        setContentView(viewBinding.getRoot());
        setTransparentStatusBarForKitKatAndAbove();
        setMarginForSaveButton();
    }

    private void setMarginForSaveButton() {
        int resourceId = getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        int navbarHeight = getResources().getDimensionPixelSize(resourceId);

        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) viewBinding.btSave.getLayoutParams();
        params.setMargins(
                params.leftMargin,
                params.topMargin,
                params.rightMargin,
                params.bottomMargin + navbarHeight
        );
        viewBinding.btSave.setLayoutParams(params);
    }

    public void showDatePickerDialog(View view) {
        DatePickerFragment newFragment = new DatePickerFragment(this);
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public void showTimePickerDialog(View view) {
        TimePickerFragment newFragment = new TimePickerFragment(this);
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showTimeZoneSpinnerDialog(View view) {
        Spinner spinner = viewBinding.spTimeZone;
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(
                this, R.array.timezone_array, android.R.layout.simple_spinner_item
        );
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);
        spinner.performClick();
    }

    public void onDatePicked(int year, int month, int day) {
        viewBinding.etBirth.setText(String.format("%02d/%02d/%s", month, day, year));
    }

    public void onTimePicked(int hourOfDay, int minute) {
        viewBinding.etMeditationTime.setText(String.format("%02d:%02d", hourOfDay, minute));
    }

    public void onNothingSelected(AdapterView<?> parent) {
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        viewBinding.etTimeZone.setText(parent.getItemAtPosition(position).toString());
    }

    private boolean isFormValid() {
        return !viewBinding.etBirth.getText().toString().isEmpty()
                && !viewBinding.etMeditationTime.getText().toString().isEmpty()
                && !viewBinding.etTimeZone.getText().toString().isEmpty();
    }

    public void onBoardSaved(View view) {
        if (isFormValid()) {
            navigator.navigateToMainScreen(this);
            finish();
        } else
            toastLong("There are missing fields to fill.");
    }
}