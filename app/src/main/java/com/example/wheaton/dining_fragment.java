package com.example.wheaton;
import android.content.Intent;
import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;

import com.example.wheaton.Dining.BalfourActivity;
import com.example.wheaton.Dining.ChaseActivity;
import com.example.wheaton.Dining.DavisActivity;
import com.example.wheaton.Dining.EmersonActivity;

public class dining_fragment extends Fragment {

    View root_view;
    public dining_fragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.dining, container, false);


        Button Balfour = root_view.findViewById(R.id.BalfourButton);
        Balfour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bal = new Intent(getContext(), BalfourActivity.class);
                try{
                    startActivity(bal);
                }catch (android.content.ActivityNotFoundException ex){
                    Toast toast = Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        Button Chase = root_view.findViewById(R.id.ChaseButton);
        Chase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bal = new Intent(getContext(), ChaseActivity.class);
                try{
                    startActivity(bal);
                }catch (android.content.ActivityNotFoundException ex){
                    Toast toast = Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        Button Emerson = root_view.findViewById(R.id.EmersonButton);
        Emerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bal = new Intent(getContext(), EmersonActivity.class);
                try{
                    startActivity(bal);
                }catch (android.content.ActivityNotFoundException ex){
                    Toast toast = Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        Button Davis = root_view.findViewById(R.id.DavisButton);
        Davis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent bal = new Intent(getContext(), DavisActivity.class);
                try{
                    startActivity(bal);
                }catch (android.content.ActivityNotFoundException ex){
                    Toast toast = Toast.makeText(getContext(),"Error",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        Button LocationsButton = root_view.findViewById(R.id.LocationsButton);
        LocationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button LyonBucks = root_view.findViewById(R.id.LyonBucksButton);
                LyonBucks.setVisibility(View.GONE);

                Button MealPlans = root_view.findViewById(R.id.MealPlansButton);
                MealPlans.setVisibility(View.GONE);

                Button Locations = root_view.findViewById(R.id.LocationsButton);
                Locations.setVisibility(View.GONE);

                ScrollView DiningFacilities = root_view.findViewById(R.id.DiningFacilities);
                DiningFacilities.setVisibility(View.VISIBLE);

                Button BackButtonDining = root_view.findViewById(R.id.BackButtonDining);
                BackButtonDining.setVisibility(View.VISIBLE);

                ScrollView LyonBucksScroll = root_view.findViewById(R.id.LyonBuckScrollView);
                LyonBucksScroll.setVisibility(View.GONE);

            }
        });

        Button BackButtonDining = root_view.findViewById(R.id.BackButtonDining);
        BackButtonDining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScrollView DiningFacilities = root_view.findViewById(R.id.DiningFacilities);
                DiningFacilities.setVisibility(View.GONE);

                Button LyonBucks = root_view.findViewById(R.id.LyonBucksButton);
                LyonBucks.setVisibility(View.VISIBLE);

                Button MealPlans = root_view.findViewById(R.id.MealPlansButton);
                MealPlans.setVisibility(View.VISIBLE);

                Button Locations = root_view.findViewById(R.id.LocationsButton);
                Locations.setVisibility(View.VISIBLE);

                Button BackButtonDining = root_view.findViewById(R.id.BackButtonDining);
                BackButtonDining.setVisibility(View.GONE);

                ScrollView LyonBucksScroll = root_view.findViewById(R.id.LyonBuckScrollView);
                LyonBucksScroll.setVisibility(View.GONE);

                ScrollView MealPlanScrollView = root_view.findViewById(R.id.MealPlanScrollView);
                MealPlanScrollView.setVisibility(View.GONE);


            }
        });

        Button LyonBucksButton = root_view.findViewById(R.id.LyonBucksButton);
        LyonBucksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScrollView LyonBucksScroll = root_view.findViewById(R.id.LyonBuckScrollView);
                LyonBucksScroll.setVisibility(View.VISIBLE);

                ScrollView DiningFacilities = root_view.findViewById(R.id.DiningFacilities);
                DiningFacilities.setVisibility(View.GONE);

                LyonBucksButton.setVisibility(View.GONE);

                Button MealPlans = root_view.findViewById(R.id.MealPlansButton);
                MealPlans.setVisibility(View.GONE);

                Button Locations = root_view.findViewById(R.id.LocationsButton);
                Locations.setVisibility(View.GONE);


                Button BackButtonDining = root_view.findViewById(R.id.BackButtonDining);
                BackButtonDining.setVisibility(View.VISIBLE);



            }
        });

        Button MealPlanButton = root_view.findViewById(R.id.MealPlansButton);
        MealPlanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ScrollView MealPlanScrollView = root_view.findViewById(R.id.MealPlanScrollView);
                MealPlanScrollView.setVisibility(View.VISIBLE);

                ScrollView LyonBucksScroll = root_view.findViewById(R.id.LyonBuckScrollView);
                LyonBucksScroll.setVisibility(View.GONE);

                ScrollView DiningFacilities = root_view.findViewById(R.id.DiningFacilities);
                DiningFacilities.setVisibility(View.GONE);

                LyonBucksButton.setVisibility(View.GONE);

                Button MealPlans = root_view.findViewById(R.id.MealPlansButton);
                MealPlans.setVisibility(View.GONE);

                Button Locations = root_view.findViewById(R.id.LocationsButton);
                Locations.setVisibility(View.GONE);


                Button BackButtonDining = root_view.findViewById(R.id.BackButtonDining);
                BackButtonDining.setVisibility(View.VISIBLE);



            }
        });



        return root_view;
    }

}
