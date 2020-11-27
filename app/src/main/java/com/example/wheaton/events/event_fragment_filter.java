package com.example.wheaton.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.wheaton.R;

import org.apache.commons.text.StringEscapeUtils;

import java.util.ArrayList;

public class event_fragment_filter extends AppCompatActivity {

    private String filters = "";



    private View.OnClickListener onListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer id = view.getId();
            ToggleButton button = findViewById(id);
            String name = button.getTextOn().toString();
            name = StringEscapeUtils.unescapeHtml4(name);
            buttonClicked(name,button);
//            Toast.makeText(event_fragment_filter.this, filters, Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_fragment_filter);

//        ArrayList<events_fragment_class> events = getIntent().getParcelableExtra("events");
        filters = getIntent().getStringExtra("filters");


        ToggleButton Academic = findViewById(R.id.AcademicB);
        Academic.setOnClickListener(onListener);

        ToggleButton Admission = findViewById(R.id.AdmissionB);
        Admission.setOnClickListener(onListener);

        ToggleButton Alumni = findViewById(R.id.AlumniB);
        Alumni.setOnClickListener(onListener);

        ToggleButton Arts = findViewById(R.id.ArtsB);
        Arts.setOnClickListener(onListener);

        ToggleButton Athletics = findViewById(R.id.AthleticsB);
        Athletics.setOnClickListener(onListener);

        ToggleButton Career = findViewById(R.id.CareerB);
        Career.setOnClickListener(onListener);

        ToggleButton Diversity = findViewById(R.id.DiversityB);
        Diversity.setOnClickListener(onListener);

        ToggleButton FacultyStaff = findViewById(R.id.FacultyStaffB);
        FacultyStaff.setOnClickListener(onListener);

        ToggleButton Global = findViewById(R.id.GlobalB);
        Global.setOnClickListener(onListener);

        ToggleButton HealthWellness = findViewById(R.id.HealthWellnessB);
        HealthWellness.setOnClickListener(onListener);

        ToggleButton LGBTQ = findViewById(R.id.LGBTQB);
        LGBTQ.setOnClickListener(onListener);

        ToggleButton Library = findViewById(R.id.LibraryB);
        Library.setOnClickListener(onListener);

        ToggleButton Music = findViewById(R.id.MusicB);
        Music.setOnClickListener(onListener);

        ToggleButton STEM = findViewById(R.id.STEMB);
        STEM.setOnClickListener(onListener);

        ToggleButton Students = findViewById(R.id.StudentsB);
        Students.setOnClickListener(onListener);

        if(!filters.equals("")){
            if(filters.contains("Academic")){
                buttonClickedJustButton(Academic);
            }
            if(filters.contains("Admission")){
                buttonClickedJustButton(Admission);
            }
            if(filters.contains("Alumni")){
                buttonClickedJustButton(Alumni);
            }
            if(filters.contains("Arts")){
                buttonClickedJustButton(Arts);
            }
            if(filters.contains("Athletics")){
                buttonClickedJustButton(Athletics);
            }
            if(filters.contains("Career")){
                buttonClickedJustButton(Career);
            }
            if(filters.contains("Diversity")){
                buttonClickedJustButton(Diversity);
            }
            if(filters.contains("Faculty & Staff")){
                buttonClickedJustButton(FacultyStaff);
            }
            if(filters.contains("Global")){
                buttonClickedJustButton(Global);
            }
            if(filters.contains("Health & Wellness")){
                buttonClickedJustButton(HealthWellness);
            }
            if(filters.contains("LGBTQ+")){
                buttonClickedJustButton(LGBTQ);
            }
            if(filters.contains("Library")){
                buttonClickedJustButton(Library);
            }
            if(filters.contains("Music")){
                buttonClickedJustButton(Music);
            }
            if(filters.contains("STEM")){
                buttonClickedJustButton(STEM);
            }
            if(filters.contains("Students")){
                buttonClickedJustButton(Students);
            }

        }

        Button resetB = findViewById(R.id.resetFilterButton);
        View.OnClickListener resetListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filters = "";
                buttonDefault(Academic);
                buttonDefault(Admission);
                buttonDefault(Alumni);
                buttonDefault(Arts);
                buttonDefault(Athletics);
                buttonDefault(Career);
                buttonDefault(Diversity);
                buttonDefault(FacultyStaff);
                buttonDefault(Global);
                buttonDefault(HealthWellness);
                buttonDefault(LGBTQ);
                buttonDefault(Library);
                buttonDefault(Music);
                buttonDefault(STEM);
                buttonDefault(Students);

            }
        };
        resetB.setOnClickListener(resetListener);



    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent i = new Intent();
        i.putExtra("filters",filters);
        setResult(RESULT_OK, i);
        finish();
    }

    private void buttonDefault(ToggleButton button){
        button.setBackgroundColor(Color.parseColor("#FFFFFF"));
        button.setTextColor(Color.parseColor("#1072BA"));
        button.setChecked(false);
        button.setEnabled(true);
    }


    private void buttonClicked(String name, ToggleButton button){
        if(button.isChecked()){
            button.setBackgroundColor(Color.parseColor("#1072BA"));
            button.setTextColor(Color.parseColor("#FFFFFF"));
            button.setEnabled(false);
            if(filters.equals("")){
                filters = name;
            }
            else{
                filters = filters + "," + name;
            }
        }
    }


    private void buttonClickedJustButton(ToggleButton button){
            button.setBackgroundColor(Color.parseColor("#1072BA"));
            button.setTextColor(Color.parseColor("#FFFFFF"));
            button.setEnabled(false);
    }




}