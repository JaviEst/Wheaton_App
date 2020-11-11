package com.example.wheaton.Dining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;


import com.example.wheaton.R;

public class BalfourActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balfour);

        webView = (WebView) findViewById(R.id.BalfourWebView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://wheatoncollege.campusdish.com/LocationsAndMenus/HoodEcoCafe");

        WebSettings webSettings = webView.getSettings();

        Intent call_intent = getIntent();
    }
}