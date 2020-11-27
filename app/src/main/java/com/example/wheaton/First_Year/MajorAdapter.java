package com.example.wheaton.First_Year;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.wheaton.R;

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
        departmentText.setText(current.getCategory());

        // description
        TextView descriptionText = listItemView.findViewById(R.id.summary);
        descriptionText.setText(current.getSummary());


        //expanded view visibility
        View expand = listItemView.findViewById(R.id.expandContent);
        expand.setVisibility(current.getExpandedVisibility());

        // description
        TextView reqSheetLink = listItemView.findViewById(R.id.reqSheetLink);
        String linkText = "Course Requirements: " + current.sheetURL;
        reqSheetLink.setText(linkText);

        return listItemView;
    }
}