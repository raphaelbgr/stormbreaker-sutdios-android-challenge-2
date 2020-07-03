package com.stormbreakerstudios.android.challenge;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.stormbreakerstudios.android.challenge.databinding.ActivityPlaylistBinding;
import com.stormbreakerstudios.android.challenge.ui.main.SectionsPagerAdapter;

public class PlaylistActivity extends BaseActivity {

    private ActivityPlaylistBinding playlistBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playlistBinding = ActivityPlaylistBinding.inflate(getLayoutInflater());
        setContentView(playlistBinding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        setSupportActionBar(playlistBinding.toolbar);
        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            getSupportActionBar().setTitle(R.string.playlist);
            bar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}