package com.stormbreakerstudios.android.challenge;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;

import com.stormbreakerstudios.android.challenge.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    ActivityMainBinding viewBindingMainBinding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBindingMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(viewBindingMainBinding.getRoot());
        setSupportActionBar(viewBindingMainBinding.toolbar);
        ActionBar bar = getSupportActionBar();
        if (bar != null)
            getSupportActionBar().setTitle(R.string.peace_time);
        viewBindingMainBinding.rvMain.setAdapter(new MainAdapter());
    }
}
