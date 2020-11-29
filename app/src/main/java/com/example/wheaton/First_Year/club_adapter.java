package com.example.wheaton.First_Year;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wheaton.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class club_adapter extends ArrayAdapter<clubs_class> {

    public club_adapter(Activity context, ArrayList<clubs_class> list){
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View list_clubs_view = convertView;

        // Check if convertView is null
        if(list_clubs_view == null){
            list_clubs_view = LayoutInflater.from(getContext()).inflate(R.layout.clubs_layout, parent, false);
        }

        // Get the object located at this position in the list
        clubs_class current_club = getItem(position);

        // Update content of name text view
        TextView name = list_clubs_view.findViewById(R.id.club_name);
        name.setText(current_club.getClub_name());

        // Update content of description text view
        TextView description = list_clubs_view.findViewById(R.id.club_description);
        description.setText(current_club.getClub_desc());

        // Check if image is available for Club
        ImageView previewImageView = list_clubs_view.findViewById(R.id.club_picture);
        if(current_club.getClub_pic().equals("")){
            previewImageView.setImageResource(R.drawable.wheatonlogo);
        }
        else {
            LoadImage loadImage = new LoadImage(previewImageView, current_club.getClub_pic());
            loadImage.execute(current_club.getClub_pic());
        }

        // Set Visibility of the layout
        LinearLayout layout_show = list_clubs_view.findViewById(R.id.club_vis_layout);
        layout_show.setVisibility(current_club.getLayout_vis());

        return list_clubs_view;
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
