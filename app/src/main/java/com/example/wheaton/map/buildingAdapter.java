package com.example.wheaton.map;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.wheaton.R;

import java.util.ArrayList;

public class buildingAdapter extends ArrayAdapter<Building> {
    public buildingAdapter(Activity context, ArrayList<Building> theList){
        super(context, 0, theList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.building, parent, false);
        }
        Building currentBuilding = getItem(position);

        TextView stringTextView = listItemView.findViewById(R.id.nameTextView);
        stringTextView.setText(currentBuilding.getName());

        return listItemView;
    }

}
