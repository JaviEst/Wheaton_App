package com.example.wheaton.Dining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.wheaton.R;

import java.io.IOException;
import java.io.InputStream;

public class MealPlanSelectionActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_plan_selection);

        WebView webview = (WebView) findViewById(R.id.MPSWebView);
        webview.getSettings().setJavaScriptEnabled(true);
        String pdf = "https://wheatoncollege.campusdish.com/-/media/Local/Higher-Education/GroupA/WheatonCollege/Files/WheatonMealPlanSelection2020.ashx";
        webview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);

    }

}