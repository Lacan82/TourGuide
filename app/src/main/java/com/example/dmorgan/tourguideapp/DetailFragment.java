package com.example.dmorgan.tourguideapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFragment extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.fragment_detail);

        Intent intent = getIntent();
        String Place = intent.getStringExtra(getString(R.string.Extra1));
        Integer Image = intent.getIntExtra(getString(R.string.Extra2), 0);
        String Address = intent.getStringExtra(getString(R.string.Extra3));
        String Phone = intent.getStringExtra(getString(R.string.Extra4));

        actionBar.setTitle(Place);

        ImageView imageView = findViewById(R.id.DetailImage);

        imageView.setImageResource(Image);

        TextView addressView = findViewById(R.id.DetailAddress);

        addressView.setText(Address);

        TextView phoneView = findViewById(R.id.DetailPhone);

        phoneView.setText(Phone);



    }
}
