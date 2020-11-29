package com.example.wheaton.First_Year;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    AutoCompleteTextView searchbar;

    private final ArrayList<Major> searchResults = new ArrayList<>();
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
        String[] majorTitles = MajorsInitList.allMajorTitles(allMajorsList);
        searchResults.addAll(allMajorsList);

        ArrayAdapter<String> titleAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, majorTitles);
        searchbar.setAdapter(titleAdapter);


        searchbar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateListFromSearchbar();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        searchbar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                searchbar.dismissDropDown();
                findViewById(R.id.list).requestFocus();
                hideKeyboardFrom(view.getContext(), searchbar);
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

        ArrayList<Major> newResults = new ArrayList<>();
        String searchQuery = searchbar.getText().toString();
        if (searchQuery.equals(""))
            newResults = allMajorsList;
        else {
            for (int i = 0; i < allMajorsList.size(); i++) {
                if (allMajorsList.get(i).getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
                    newResults.add(allMajorsList.get(i));
                }
            }
        }
        if (focus != -1 && focus < searchResults.size()) {
            searchResults.get(focus).setExpandedVisibility(View.GONE);
        }
        searchResults.clear();
        searchResults.addAll(newResults);
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

    public void gotoReqSheet(View view) {
        if (focus == -1)
            return;

        String reqSheetLink = searchResults.get(focus).getSheetURL();
        Uri pageURL = Uri.parse(reqSheetLink);
        Intent reqSheetPage = new Intent(Intent.ACTION_VIEW, pageURL);
        //  if (reqSheetPage.resolveActivity(getPackageManager()) != null) {
        startActivity(reqSheetPage);
        //}
    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void clearText(View view) {
        searchbar.setText("");
        searchbar.dismissDropDown();
        findViewById(R.id.list).requestFocus();
        hideKeyboardFrom(view.getContext(), searchbar);
    }
}