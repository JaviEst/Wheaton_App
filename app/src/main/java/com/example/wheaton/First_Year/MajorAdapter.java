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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wheaton.R;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class MajorAdapter extends ArrayAdapter<Major> {
    public MajorAdapter(Activity context, ArrayList<Major> list) {
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.library_item_layout, parent, false);
        }


        Major current = getItem(position);
        assert current != null;

        // entry title
        TextView titleText = listItemView.findViewById(R.id.TitleText);
        titleText.setText(current.getTitle());

        //department name
        TextView departmentText = listItemView.findViewById(R.id.departmentText_1);
        String curr_department = "Department: " + current.getCategory();
        departmentText.setText(curr_department);

        // description
        TextView descriptionText = listItemView.findViewById(R.id.summary);
        descriptionText.setText(current.getSummary());


        //expanded view visibility
        View expand = listItemView.findViewById(R.id.expandContent);
        expand.setVisibility(current.getExpandedVisibility());

        LoadImage loadImage = new LoadImage(listItemView.findViewById(R.id.imageView), current.previewImageURL);
        loadImage.execute(current.previewImageURL);

        return listItemView;
    }

    private class LoadImage extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;
        String url;

        public LoadImage(ImageView ivResult, String url) {
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