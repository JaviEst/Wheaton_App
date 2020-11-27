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

public class DavisActivity extends AppCompatActivity {

    ImageView DavisBG;
    String URLlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_davis);

        DavisBG = findViewById(R.id.DavisBG);
        URLlink = "https://wheatoncollege.campusdish.com/-/media/Local/Higher-Education/GroupA/WheatonCollege/Images/menu-for-davis.ashx";

        LoadImage loadImage = new LoadImage(DavisBG);
        loadImage.execute(URLlink);

    }

    public void DavisMenuButton(View view) {
        DavisBG.setVisibility(View.VISIBLE);
    }
    public void DavisHomeButton(View view) {
        DavisBG.setVisibility(View.GONE);
    }


    private class LoadImage extends AsyncTask<String,Void, Bitmap> {
        ImageView imageView;
        public LoadImage(ImageView DavisBG) {
            this.imageView = DavisBG;
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
            DavisBG.setImageBitmap(bitmap);
        }
    }
}