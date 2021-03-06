package com.example.wheaton.First_Year;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.wheaton.R;

public class academic_calendar extends AppCompatActivity {

    // Declare webview
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_academic_calendar);

        // Get intent
        Intent call_intent = getIntent();

        // Set up and call web view
        webView = (WebView) findViewById(R.id.academic_web_view);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(getString(R.string.academic_calendar_url));

        WebSettings webSettings = webView.getSettings();
    }
}