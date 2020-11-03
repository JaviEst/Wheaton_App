package com.example.wheaton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void directoryButton(View view) {
        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse("https://wheatoncollegelyons.com/information/directory/index"));
        if (urlIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(urlIntent);
        }
        startActivity(urlIntent);

    }




}