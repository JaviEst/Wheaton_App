package com.example.wheaton.events;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.wheaton.R;

import org.apache.commons.text.StringEscapeUtils;

import java.util.ArrayList;
import java.util.List;

public class event_fragment_filter extends AppCompatActivity {

    // ********************** Variables ***************************

    // Global values for the filter elements
    private String filters = "";
    private ArrayList<String> filters2;

    // ********************** Processes ***************************

    // Listener that is accessed once a filter button is clicked
    private View.OnClickListener onListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Integer id = view.getId();
            ToggleButton button = findViewById(id);
            String name = button.getTextOn().toString();
            name = StringEscapeUtils.unescapeHtml4(name);
            buttonClicked(name,button);
        }
    };

    // Listener for the back Button
    private View.OnClickListener backListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            onBackPressed();
        }
    };

    // main onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_fragment_filter);

        // Get the values from the main fragment
        filters = getIntent().getStringExtra("filters");
        filters2 = getIntent().getStringArrayListExtra("filters2");

        // Set each filter button to the onListener
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

        // If the filter is not empty check if it contains each filter word
        if(!filters.equals("")){
            // If it matches, then call the buttonClickedJustButton function
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

        // If the resetButton is clicked clear both variables and set each filter button to normal.
        Button resetB = findViewById(R.id.resetFilterButton);
        View.OnClickListener resetListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!filters.equals("")){
                    filters = "";
                    filters2.clear();
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


            }
        };
        resetB.setOnClickListener(resetListener);

        // Back button set to the backListener
        Button backB = findViewById(R.id.backButton);
        backB.setOnClickListener(backListener);

    }

    // onBackPressed gives back the values to the main fragment
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent i = new Intent();
        i.putExtra("filters",filters);
        i.putExtra("filters2", filters2);
        setResult(RESULT_OK, i);
        finish();
    }

    // Reset the button to its default state
    private void buttonDefault(ToggleButton button){
        button.setBackgroundColor(Color.parseColor("#FFFFFF"));
        button.setTextColor(Color.parseColor("#1072BA"));
        button.setChecked(false);
        button.setEnabled(true);
    }

    // when a button is clicked this function is called
    private void buttonClicked(String name, ToggleButton button){
        // if the button is checked
        if(button.isChecked()){
            // set the background color to blue
            button.setBackgroundColor(Color.parseColor("#1072BA"));
            // set the text color to white
            button.setTextColor(Color.parseColor("#FFFFFF"));
            // make the button unable to be pressed
            button.setEnabled(false);
            // if the filter is empty when pressed just add the name given
            if(filters.equals("")){
                filters = name;
                filters2 = new ArrayList<String>();
                filters2.add(name);
            }
            // if it is not the first value, add the name normally
            else{
                filters = filters + ", " + name;
                filters2.add(name);
            }
        }
    }

    // If the filter is already listed in the filter variables then make sure the button is changed
    private void buttonClickedJustButton(ToggleButton button){
            button.setBackgroundColor(Color.parseColor("#1072BA"));
            button.setTextColor(Color.parseColor("#FFFFFF"));
            button.setEnabled(false);
    }




}