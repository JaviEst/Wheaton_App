package com.example.wheaton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class registrar_office extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_office);

        Intent call_intent = getIntent();

        // Phone link
        TextView phone_num = findViewById(R.id.reg_num);
        Linkify.addLinks(phone_num, Linkify.PHONE_NUMBERS);

        // Make textview clickable
        TextView website_reg = findViewById(R.id.reg_link);
        website_reg.setClickable(true);

        // Make textview clickable
        TextView website_courses = findViewById(R.id.course_link);
        website_courses.setClickable(true);
    }

    public void reg_link(View view){
        // Set up and call web view
        WebView webView = (WebView) findViewById(R.id.registrar_web_view);
        webView.setVisibility(View.VISIBLE);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(getString(R.string.registrar_office_url));

        WebSettings webSettings = webView.getSettings();
    }

    public void course_link(View view){
        // Set up and call chrome intent
        Uri webpage = Uri.parse(getString(R.string.course_schedule_url));
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        try {
            startActivity(intent);
        }
        catch (android.content.ActivityNotFoundException ex){
            Toast toast = Toast.makeText(this, "We have encounter a problem while accessing the Course Schedule.\nSorry for the inconvenience.", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
            toast.show();
        }
    }

}