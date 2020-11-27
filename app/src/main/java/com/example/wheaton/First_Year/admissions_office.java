package com.example.wheaton.First_Year;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.wheaton.R;

public class admissions_office extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admissions_office);

        Intent call_intent = getIntent();

        // Phone link
        TextView phone_num = findViewById(R.id.ad_num);
        Linkify.addLinks(phone_num, Linkify.PHONE_NUMBERS);

        // Make textview clickable
        TextView website_fin = findViewById(R.id.ad_link);
        website_fin.setClickable(true);
    }

    public void ad_link(View view){
        // Set up and call web view
        WebView webView = (WebView) findViewById(R.id.admissions_web_view);
        webView.setVisibility(View.VISIBLE);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(getString(R.string.admissions_office_url));

        WebSettings webSettings = webView.getSettings();
    }
}