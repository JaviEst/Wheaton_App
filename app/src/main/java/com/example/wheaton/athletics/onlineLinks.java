package com.example.wheaton.athletics;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.wheaton.R;

public class onlineLinks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online_links);
        Intent callerIntent = getIntent();


    }



    public void athleticsButton(View view) {
        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse("https://wheatoncollegelyons.com/landing/index"));

        startActivity(urlIntent);


    }

    public void newmacButton(View view) {
        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse("https://www.newmacsports.com/landing/index"));
        startActivity(urlIntent);


    }

    public void covidButton(View view) {
        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse("https://pappasfitnesscenter.youcanbook.me/"));
        startActivity(urlIntent);


    }

    public void ptButton(View view) {
        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse("https://www.marathonphysicaltherapy.com/"));
        startActivity(urlIntent);


    }




}

