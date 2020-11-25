package com.example.wheaton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class event_fragment_item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_fragment_item);



        Intent callerIntent = getIntent();
        String title = callerIntent.getStringExtra("title");
        String date = callerIntent.getStringExtra("date");
        try {
            date = formatDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String [] dateParts = date.split(" ");
        String image = callerIntent.getStringExtra("largeImage");
        String location = callerIntent.getStringExtra("location");
        String cost = callerIntent.getStringExtra("cost");
        String filter = callerIntent.getStringExtra("filter");
        String organizerName = callerIntent.getStringExtra("organizerName");
        String organizerPhone = callerIntent.getStringExtra("organizerPhone");
        String organizerEmail = callerIntent.getStringExtra("organizerEmail");
        String link = callerIntent.getStringExtra("link");


        TextView titleText = findViewById(R.id.itemTitleText);
        TextView dateText = findViewById(R.id.itemDateInput);
        TextView timeText = findViewById(R.id.itemTimeInput);
        ImageView previewImageView = findViewById(R.id.itemPreviewPic);
        TextView locationText = findViewById(R.id.itemLocationInput);
        TextView costText = findViewById(R.id.itemCostInput);
        TextView filterText = findViewById(R.id.itemFilterInput);
        TextView organName = findViewById(R.id.itemOrganizerInput);
        TextView organPhone = findViewById(R.id.itemPhoneInput);
        TextView organEmail = findViewById(R.id.itemEmailInput);
        TextView linkText = findViewById(R.id.itemLinkText);

        titleText.setText(title);
        dateText.setText(dateParts[0]);
        timeText.setText(dateParts[1] + " " + dateParts[2]);
        locationText.setText(location);
        costText.setText(cost);
        filterText.setText(filter);
        organName.setText(organizerName);
        organPhone.setText(organizerPhone);
        organEmail.setText(organizerEmail);
        linkText.setText(link);



        if(image.equals("")){
            previewImageView.setImageResource(R.drawable.wheaton_event_preview);
        }
        else {
            LoadImage loadImage = new LoadImage(previewImageView, image);
            loadImage.execute(image);
        }








    }

    public String formatDate(String input) throws ParseException {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = parser.parse(input);
        SimpleDateFormat formatter = new SimpleDateFormat("MMM-dd-yyyy hh:mm aa");
        String formattedDate = formatter.format(date);

        return formattedDate;
    }


    private class LoadImage extends AsyncTask<String,Void, Bitmap> {
        ImageView imageView;
        String url;
        public LoadImage(ImageView ivResult, String url){
            this.imageView = ivResult;
            this.url = url;
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String urlLink = url;
            Bitmap bitmap = null;
            InputStream inputStream = null;
            try {
                inputStream = new URL(urlLink).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            imageView.setImageBitmap(bitmap);
        }
    }

}