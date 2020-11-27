package com.example.wheaton.Dining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wheaton.R;

import java.io.IOException;
import java.io.InputStream;

public class BalfourActivity extends AppCompatActivity {
    ImageView BalfourBG;
    String URLlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balfour);

        WebView webview = (WebView) findViewById(R.id.BalfourWebView);
        webview.getSettings().setJavaScriptEnabled(true);
        String pdf = "https://wheatoncollege.campusdish.com/-/media/Local/Higher-Education/GroupA/WheatonCollege/Files/32x21-Menu-Boards.ashx";
        webview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);

        BalfourBG = findViewById(R.id.BalfourBG);
        URLlink = "https://wheatoncollege.campusdish.com/-/media/Local/Higher-Education/GroupA/WheatonCollege/Images/logo.ashx?h=80&mh=350&mw=350&w=270&hash=9AE01A88BF49188F02531112DA7F6799";



        BalfourActivity.LoadImage loadImage = new BalfourActivity.LoadImage(BalfourBG);
        loadImage.execute(URLlink);

    }
    public void BalfourMenuButton(View view) {
        BalfourBG.setVisibility(View.VISIBLE);
    }
    public void BalfourHomeButton(View view) {
        BalfourBG.setVisibility(View.GONE);
    }

    private class LoadImage extends AsyncTask<String,Void, Bitmap> {
        ImageView imageView;
        public LoadImage(ImageView BalfourBG) {
            this.imageView = BalfourBG;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String url = strings[0];
            Bitmap bitmap = null;
            try {
                InputStream inputStream = new java.net.URL(URLlink).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            BalfourBG.setImageBitmap(bitmap);
        }
    }
}