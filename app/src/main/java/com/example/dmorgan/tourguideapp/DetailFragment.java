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
        String Place = intent.getStringExtra("Place");
        Integer Image = intent.getIntExtra("Image", 0);
        String Address = intent.getStringExtra("Address");
        String Phone = intent.getStringExtra("Phone");

        actionBar.setTitle(Place);

        ImageView imageView = findViewById(R.id.DetailImage);

        imageView.setImageResource(Image);

        TextView addressView = findViewById(R.id.DetailAddress);

        addressView.setText(Address);

        TextView phoneView = findViewById(R.id.DetailPhone);

        phoneView.setText(Phone);



    }
}
