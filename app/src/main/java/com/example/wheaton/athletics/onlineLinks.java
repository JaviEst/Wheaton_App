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
        Intent athleticslIntent = new Intent(Intent.ACTION_VIEW);
        athleticslIntent.setData(Uri.parse("https://wheatoncollegelyons.com/landing/index"));

        startActivity(athleticslIntent);


    }

    public void newmacButton(View view) {
        Intent newmacIntent = new Intent(Intent.ACTION_VIEW);
        newmacIntent.setData(Uri.parse("https://www.newmacsports.com/landing/index"));
        startActivity(newmacIntent);


    }

    public void covidButton(View view) {
        Intent covidIntent = new Intent(Intent.ACTION_VIEW);
        covidIntent.setData(Uri.parse("https://pappasfitnesscenter.youcanbook.me/"));
        startActivity(covidIntent);


    }

    public void ptButton(View view) {
        Intent ptIntent = new Intent(Intent.ACTION_VIEW);
        ptIntent.setData(Uri.parse("https://www.marathonphysicaltherapy.com/"));
        startActivity(ptIntent);


    }




}

