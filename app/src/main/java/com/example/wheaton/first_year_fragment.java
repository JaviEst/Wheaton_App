package com.example.wheaton;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.wheaton.First_Year.admissions_office;
import com.example.wheaton.First_Year.financial_aid_office;
import com.example.wheaton.First_Year.imp_phone_num;
import com.example.wheaton.First_Year.registrar_office;

public class first_year_fragment extends Fragment {

    // Declare view
    View root_view;

    public first_year_fragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.first_year, container, false);

        // Move to majors and minors intent
        ImageButton education = root_view.findViewById(R.id.edu_button);
        education.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent edu = new Intent(getContext(), com.example.wheaton.First_Year.education.class);

                try {
                    startActivity(edu);
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast toast = Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
                    toast.show();
                }
            }
        });

        // Move to clubs/organizations intent
        ImageButton clubs = root_view.findViewById(R.id.clubs_button);
        clubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clubs = new Intent(getContext(), com.example.wheaton.First_Year.clubs.class);

                try {
                    startActivity(clubs);
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast toast = Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
                    toast.show();
                }
            }
        });

        // Move to academic calendar intent
        ImageButton academic_calendar = root_view.findViewById(R.id.academic_calendar_button);
        academic_calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent academic = new Intent(getContext(), com.example.wheaton.First_Year.academic_calendar.class);

                try {
                    startActivity(academic);
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast toast = Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
                    toast.show();
                }
            }
        });

        // Move to registrar intent
        ImageButton reg_office = root_view.findViewById(R.id.reg_office_button);
        reg_office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrar = new Intent(getContext(), registrar_office.class);

                try {
                    startActivity(registrar);
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast toast = Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
                    toast.show();
                }
            }
        });

        // Move to admissions intent
        ImageButton adm_office = root_view.findViewById(R.id.adm_office_button);
        adm_office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent admissions = new Intent(getContext(), admissions_office.class);

                try {
                    startActivity(admissions);
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast toast = Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
                    toast.show();
                }
            }
        });

        // Move to financial intent
        ImageButton fin_aid_office = root_view.findViewById(R.id.fin_aid_office_button);
        fin_aid_office.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent financial = new Intent(getContext(), financial_aid_office.class);

                try {
                    startActivity(financial);
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast toast = Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
                    toast.show();
                }
            }
        });

        // Move to important phone numbers intent
        ImageButton important_num = root_view.findViewById(R.id.important_num_button);
        important_num.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phone_numbers = new Intent(getContext(), imp_phone_num.class);

                try {
                    startActivity(phone_numbers);
                }
                catch (android.content.ActivityNotFoundException ex){
                    Toast toast = Toast.makeText(getContext(), "Error", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_HORIZONTAL|Gravity.BOTTOM, 0, 0);
                    toast.show();
                }
            }
        });

        return root_view;
    }
}
