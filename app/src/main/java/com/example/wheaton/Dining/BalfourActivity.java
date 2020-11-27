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
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.wheaton.R;

import java.io.IOException;
import java.io.InputStream;

public class BalfourActivity extends AppCompatActivity {
    ImageView BalfourBG;
    String URLlink;
    WebView BalfourWebView;
    LinearLayout hiddenStuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balfour);

        WebView webview = (WebView) findViewById(R.id.BalfourWebView);
        webview.getSettings().setJavaScriptEnabled(true);
        String pdf = "https://wheatoncollege.campusdish.com/-/media/Local/Higher-Education/GroupA/WheatonCollege/Files/32x21-Menu-Boards.ashx";
        webview.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);

        BalfourBG = findViewById(R.id.BalfourBG);
        URLlink = "https://restauracionnews.com/wp-content/uploads/2019/11/1200x628_Dominos-RollExtra.jpg";



        BalfourActivity.LoadImage loadImage = new BalfourActivity.LoadImage(BalfourBG);
        loadImage.execute(URLlink);

    }
    public void BalfourMenuButton(View view) {

    }
    public void BalfourHomeButton(View view) {
        hiddenStuff.setVisibility(View.VISIBLE);
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