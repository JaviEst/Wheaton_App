package com.example.wheaton.Dining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.wheaton.R;

public class EmersonActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emerson);

        webView = (WebView) findViewById(R.id.EmersonWebView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://wheatoncollege.campusdish.com/LocationsAndMenus/EmersonDining");

        WebSettings webSettings = webView.getSettings();

        Intent call_intent = getIntent();
    }
}