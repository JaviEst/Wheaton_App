package com.example.wheaton;

import android.app.Activity;
import android.content.Context;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class phone_num_adapter extends ArrayAdapter<phone_nums> {

    public phone_num_adapter(Activity context, ArrayList<phone_nums> list){
        super(context, 0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View list_phone_view = convertView;

        // Check if convertView is null
        if(list_phone_view == null){
            list_phone_view = LayoutInflater.from(getContext()).inflate(R.layout.phone_nums_layout, parent, false);
        }

        phone_nums current_phone_num = getItem(position);

        // Update content of location text view
        TextView loc = list_phone_view.findViewById(R.id.name_text_view);
        loc.setText(current_phone_num.getLocation());

        // Update content of phone number text view
        TextView phone_num = list_phone_view.findViewById(R.id.phone_number_text);
        phone_num.setText(current_phone_num.getPhone_num());
        Linkify.addLinks(phone_num, Linkify.PHONE_NUMBERS);

        // Set Visibility of the layout
        LinearLayout layout_show = list_phone_view.findViewById(R.id.phone_num_layout);
        layout_show.setVisibility(current_phone_num.getLayout_vis());

        return list_phone_view;
    }
}
