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

public class BalfourActivity extends AppCompatActivity {

    private WebView BalfourwebView;
    private String BalfourHomeUrlString;
    private Button BalfourMenuButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balfour);

        BalfourHomeUrlString = "https://wheatoncollege.campusdish.com/LocationsAndMenus/HoodEcoCafe";

        BalfourwebView = (WebView) findViewById(R.id.BalfourWebView);
        BalfourwebView.setWebViewClient(new WebViewClient());
        BalfourwebView.loadUrl(BalfourHomeUrlString);
        WebSettings webSettings = BalfourwebView.getSettings();


    }

    public void BalfourMenuButton(View view){
        Intent i = new Intent(this, BalfourMenuActivity.class);
        startActivity(i);
    }

}