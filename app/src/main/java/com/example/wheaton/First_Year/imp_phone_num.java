package com.example.wheaton.First_Year;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.wheaton.R;

import java.util.ArrayList;

public class imp_phone_num extends AppCompatActivity {

    // Declare array list of phone number objects
    private ArrayList<phone_nums> phone_num_list;

    // Declare array adapter
    private phone_num_adapter adapter;

    // Declare current list view
    private View current_list_view = null;
    private int current_pos = 0;

    // Declare previous list view
    private View previous_list_view = null;
    private int previous_pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imp_phone_num);

        Intent call_intent = getIntent();

        generate_list();

        // Create and set adapter
        adapter = new phone_num_adapter(this, phone_num_list);
        ListView list_view = findViewById(R.id.list_val);
        list_view.setAdapter(adapter);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                if(previous_list_view == null){
                    // Update current list
                    current_pos = i;
                    current_list_view = view;

                    // Set element layout to visible
                    phone_num_list.get(current_pos).setLayout_vis(View. VISIBLE);
                }
                else{
                    // Set visibility of previous item in the list clicked to gone
                    phone_num_list.get(previous_pos).setLayout_vis(View.GONE);

                    // Update current list
                    current_pos = i;
                    current_list_view = view;

                    // Set element layout to visible
                    phone_num_list.get(current_pos).setLayout_vis(View.VISIBLE);
                }

                // Update old view
                previous_pos = i;
                previous_list_view = view;

                // Notify array adapter that the data has changed
                adapter.notifyDataSetChanged();
            }
        });

    }

    // Method to generate important phone number list
    private void generate_list(){
        phone_num_list = new ArrayList<phone_nums>();

        phone_num_list.add(new phone_nums(getString(R.string.crisis_line), getString(R.string.crisis_line_number)));
        phone_num_list.add(new phone_nums(getString(R.string.campus_emergency), getString(R.string.campus_emergency_number)));
        phone_num_list.add(new phone_nums(getString(R.string.medical_center), getString(R.string.medical_center_number)));
        phone_num_list.add(new phone_nums(getString(R.string.counseling_center), getString(R.string.counseling_center_number)));
        phone_num_list.add(new phone_nums(getString(R.string.public_safety), getString(R.string.public_safety_number)));
        phone_num_list.add(new phone_nums(getString(R.string.bus_service), getString(R.string.bus_service_number)));
        phone_num_list.add(new phone_nums(getString(R.string.tech_support), getString(R.string.tech_support_number)));
        phone_num_list.add(new phone_nums(getString(R.string.physical_plant), getString(R.string.physical_plant_number)));
        phone_num_list.add(new phone_nums(getString(R.string.registrar_office), getString(R.string.registrar_office_number)));
        phone_num_list.add(new phone_nums(getString(R.string.admissions_office), getString(R.string.admissions_office_number)));
        phone_num_list.add(new phone_nums(getString(R.string.financial_aid_office), getString(R.string.financial_aid_office_number)));
        phone_num_list.add(new phone_nums(getString(R.string.anonymous_line), getString(R.string.anonymous_line_number)));
        phone_num_list.add(new phone_nums(getString(R.string.main_wheaton), getString(R.string.main_wheaton_number)));
    }

}