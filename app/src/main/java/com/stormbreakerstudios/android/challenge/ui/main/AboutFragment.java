package com.stormbreakerstudios.android.challenge.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;
import com.stormbreakerstudios.android.challenge.R;
import com.stormbreakerstudios.android.challenge.util.CircularTransformation;

public class AboutFragment extends Fragment {

    public static AboutFragment newInstance() {
        AboutFragment fragment = new AboutFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_playlist_about, container, false);
        Picasso.get().load(R.drawable.flower).fit().transform(new CircularTransformation()).into((ImageView) root.findViewById(R.id.iv_article_pic));
        return root;
    }
}