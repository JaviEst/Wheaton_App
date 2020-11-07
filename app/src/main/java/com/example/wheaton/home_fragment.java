package com.example.wheaton;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

public class home_fragment extends Fragment {

    // Declare view
    View root_view;

    public home_fragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.home, container, false);

        // Move to library fragment when on click of library button
        Button library = root_view.findViewById(R.id.library_button);
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).setCurrentItem(0);
            }
        });

        // Move to dining fragment when on click of dining button
        Button dining = root_view.findViewById(R.id.dining_button);
        dining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).setCurrentItem(1);
            }
        });

        // Move to events fragment when on click of events button
        Button events = root_view.findViewById(R.id.events_button);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).setCurrentItem(2);
            }
        });

        // Move to map fragment when on click of map button
        Button map = root_view.findViewById(R.id.map_button);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).setCurrentItem(4);
            }
        });

        // Move to athletics fragment when on click of athletics button
        Button athletics = root_view.findViewById(R.id.athletics_button);
        athletics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).setCurrentItem(5);
            }
        });

        // Move to first_years fragment when on click of first_years button
        Button first_years = root_view.findViewById(R.id.first_years_button);
        first_years.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).setCurrentItem(6);
            }
        });

        return root_view;
    }
}