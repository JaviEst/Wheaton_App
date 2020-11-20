package com.example.wheaton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class events_fragment_adapter extends ArrayAdapter<events_fragment_class> {



    public events_fragment_adapter(Context activity, ArrayList<events_fragment_class> theList){
        super(activity, 0, theList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.events_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        events_fragment_class currentEvent = getItem(position);

        TextView titleTV = listItemView.findViewById(R.id.title);
        titleTV.setText(currentEvent.getTitle());

        TextView dateTV = listItemView.findViewById(R.id.date);
        dateTV.setText(currentEvent.getDate());

        TextView locationTV = listItemView.findViewById(R.id.location);
        locationTV.setText(currentEvent.getLocation());
        ImageView previewImageView = listItemView.findViewById(R.id.previewPic);
        if(currentEvent.getImage().equals("")){
            previewImageView.setImageResource(R.drawable.wheaton_event_preview);
        }
        else {
            LoadImage loadImage = new LoadImage(previewImageView, currentEvent.getImage());
            loadImage.execute(currentEvent.getImage());
        }

        // Set visibility of button
        ConstraintLayout showingInfoMenu = listItemView.findViewById(R.id.buttonLayout);
        showingInfoMenu.setVisibility(currentEvent.getButtonVisibility());

        return listItemView;
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