package com.example.wheaton;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wheaton.athletics.athletics_calendar;
import com.example.wheaton.athletics.onlineLinks;

public class athletics_fragment extends Fragment implements View.OnClickListener{
    athletics_fragment context = this;


    // Declare view
    View root_view;

    public athletics_fragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.athletics, container, false);
        Button dButton = root_view.findViewById(R.id.dButton);
        dButton.setOnClickListener((View.OnClickListener) this);
        Button intButton = root_view.findViewById(R.id.intButton);
        intButton.setOnClickListener((View.OnClickListener) this);
        Button clubButton = root_view.findViewById(R.id.clubButton);
        clubButton.setOnClickListener((View.OnClickListener) this);
        Button linkButton = root_view.findViewById(R.id.linksButton);
        linkButton.setOnClickListener((View.OnClickListener) this);
        Button exerciseButton = root_view.findViewById(R.id.exerciseButton);
        exerciseButton.setOnClickListener((View.OnClickListener) this);
        Button calendarButton = root_view.findViewById(R.id.calendarButton);
        calendarButton.setOnClickListener((View.OnClickListener) this);
        Button hoursButton = root_view.findViewById(R.id.hoursButton);
        hoursButton.setOnClickListener((View.OnClickListener) this);
        return root_view;
    }
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.dButton) {
            directoryButton();
        }
        if (view.getId() == R.id.intButton) {
            intraButton();

        }
        if (view.getId() == R.id.clubButton) {
            clubButton();

        }
        if (view.getId() == R.id.linksButton) {
            linkButton();
        }

        if(view.getId() == R.id.exerciseButton){
            exerciseButton();
        }
        if(view.getId() == R.id.calendarButton){
            calendarButton();
        }
        if(view.getId() == R.id.hoursButton){
            hoursButton();
        }
    }

    public void directoryButton() {
        Intent urlIntent = new Intent(Intent.ACTION_VIEW);
        urlIntent.setData(Uri.parse("https://wheatoncollegelyons.com/information/directory/index"));
        startActivity(urlIntent);


    }


    public void intraButton() {
        Intent intraIntent = new Intent(Intent.ACTION_VIEW);
        intraIntent.setData(Uri.parse("https://engage.wheatoncollege.edu/organization/recfit"));

        startActivity(intraIntent);


    }

    public void clubButton() {
        Intent clubIntent = new Intent(Intent.ACTION_VIEW);
        clubIntent.setData(Uri.parse("https://wheatoncollegelyons.com/clubs/club_sports"));

        startActivity(clubIntent);


    }

    public void linkButton() {
        Intent linkIntent = new Intent(getContext(), onlineLinks.class);
        startActivity(linkIntent);


    }

    public void exerciseButton() {
        Intent exerciseIntent = new Intent(Intent.ACTION_VIEW);
        exerciseIntent.setData(Uri.parse("https://wheatoncollegelyons.com/clubs/rec_clubs/Group_Exercise"));

        startActivity(exerciseIntent);


    }


    public void calendarButton() {

        Intent calendarIntent = new Intent(getContext(), athletics_calendar.class);
        startActivity(calendarIntent);

    }



    public void hoursButton() {
        Intent hoursIntent = new Intent(Intent.ACTION_VIEW);
        hoursIntent.setData(Uri.parse("https://wheatoncollegelyons.com/information/facilities/hours"));

        startActivity(hoursIntent);

    }


}



