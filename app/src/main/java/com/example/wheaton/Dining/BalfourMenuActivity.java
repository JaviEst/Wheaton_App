package com.example.wheaton.Dining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.LinearLayout;


import com.example.wheaton.R;

public class BalfourMenuActivity extends AppCompatActivity {

    private WebView BalfourWebViewMenu;
    private Button BalfourMenuButton;
    private String BalfourMenuUrlString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balfour);
        BalfourMenuUrlString = "https://wheatoncollege.campusdish.com/LocationsAndMenus/HoodEcoCafe";


        BalfourWebViewMenu = (WebView) findViewById(R.id.BalfourWebViewMenu);
        BalfourWebViewMenu.setWebViewClient(new WebViewClient());
        BalfourWebViewMenu.loadUrl(BalfourMenuUrlString);
        WebSettings webSettings = BalfourWebViewMenu.getSettings();
    }
}