package com.dev.gocar.ui.activities;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.dev.gocar.R;
import com.dev.gocar.databinding.ActivityDetailCarBinding;
import com.squareup.picasso.Picasso;

public class DetailCarActivity extends AppCompatActivity {

    public static String URL_IMAGE = "url_image";

    private ActivityDetailCarBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        init();

        addListener();
    }

    private void init() {

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_car);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            String url = extras.getString(URL_IMAGE);

            Picasso.with(this).load(url).into(binding.imageViewDetailCarImage);
        }

    }

    private void addListener() {

    }


}
