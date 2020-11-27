package com.example.wheaton.First_Year;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.example.wheaton.R;

public class education extends AppCompatActivity {

    private ArrayList<Major> allMajorsList = new ArrayList<>();
    private String[] majorTitles;
    AutoCompleteTextView searchbar;

    private ArrayList<Major> searchResults;
    private MajorAdapter itemAdapter;
    public int focus = -1;

    public education() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        Intent call_intent = getIntent();

        searchbar = findViewById(R.id.searchBar);


        allMajorsList = MajorsInitList.generateAllMajorsList();
        majorTitles = MajorsInitList.allMajorTitles(allMajorsList);
        searchResults = allMajorsList;

        ArrayAdapter<String> titleAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, majorTitles);
        searchbar.setAdapter(titleAdapter);

        searchbar.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View arg1, int pos,
                                    long id) {
                updateListFromSearchbar();

            }
        });


        itemAdapter = new MajorAdapter(this, searchResults);
        final ListView majorsListView = findViewById(R.id.list);
        majorsListView.setAdapter(itemAdapter);

        majorsListView.setClickable(true);
        majorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Object current = majorsListView.getItemAtPosition(position);

                // hides previously selected element and selects clicked element
                // shifts focus to the newly clicked element
                if (focus != -1 && focus < searchResults.size()) {
                    searchResults.get(focus).setExpandedVisibility(View.GONE);
                }
//                if(position == focus) {
//                    searchResults.get(position).setExpandedVisibility(View.GONE);
//                    focus = -1;
//                }else {
                searchResults.get(position).setExpandedVisibility(View.VISIBLE);
                focus = position;
                //}


                itemAdapter.notifyDataSetChanged();
            }
        });

    }


    public void updateListFromSearchbar() {
        //searchResults.clear();
        //Toast.makeText(this,searchbar.getText().toString(),Toast.LENGTH_SHORT).show();
        for (int i = 0; i < allMajorsList.size(); i++) {
            if (allMajorsList.get(i).getTitle().contains(searchbar.getText().toString())) {
                searchResults.add(allMajorsList.get(i));
                Toast.makeText(this, "adding", Toast.LENGTH_SHORT).show();
            }
        }
        itemAdapter.notifyDataSetChanged();
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ArrayList<Major> generateAllMajorsFromFile() throws IOException {
        ArrayList<Major> output = new ArrayList<>();
        Major newItem;

        String filename = "majors.txt";
        InputStreamReader inputStreamReader = new InputStreamReader(getAssets().open("majors.txt"), StandardCharsets.UTF_8);
        BufferedReader bf = new BufferedReader(inputStreamReader);

        // read lines and put them in arrayList
        String currentName, currentCategory, currentSheetLink, currentDescription;
        String line = bf.readLine();

        while (line != null) {
            currentName = bf.readLine();
            currentCategory = bf.readLine();
            currentSheetLink = bf.readLine();
            currentDescription = bf.readLine();


            newItem = new Major();
            newItem.setTitle(currentName);
            newItem.setCategory(currentCategory);
            newItem.setSheetURL(currentSheetLink);
            newItem.setSummary(currentDescription);

            output.add(newItem);

            line = bf.readLine();
        }


        return output;
    }
}