package com.example.wheaton.Dining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.wheaton.R;

public class BalfourWebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balfour_web_view);

        webView = (WebView) findViewById(R.id.BalfourWebWebView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://wheatoncollege.campusdish.com/LocationsAndMenus/HoodEcoCafe");


    }

    public void MenuBalfourButton(View view){
        Intent i = new Intent(this,BalfourActivity.class);
        startActivity(i);
    }
}