package com.example.wheaton.events;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.wheaton.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class events_fragment_adapter extends ArrayAdapter<events_fragment_class> implements Filterable {



    public events_fragment_adapter(Context activity, ArrayList<events_fragment_class> theList){
        super(activity, 0, theList);


    }





    ///////////////////////////////
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

        String dateFormatted = null;
        try {
            dateFormatted = formatDate(currentEvent.getDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        TextView dateTV = listItemView.findViewById(R.id.date);
        dateTV.setText(dateFormatted);

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