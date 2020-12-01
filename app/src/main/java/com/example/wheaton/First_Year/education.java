package com.example.wheaton.First_Year;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;

import java.io.IOException;
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
        String[] majorTitles = MajorsInitList.getAllMajorTitles(allMajorsList);
        searchResults.addAll(allMajorsList);

        ArrayAdapter<String> titleAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, majorTitles);
        searchbar.setAdapter(titleAdapter);

        //*
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

        // *
        //on click, hides dropdown, clears focus and hides keyboard
        searchbar.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                searchbar.dismissDropDown();
                findViewById(R.id.list).requestFocus();
                hideKeyboardFrom(view.getContext(), searchbar);
            }
        });

        // the listView and adapter are set to the search results array that is constantly changing when updating
        itemAdapter = new MajorAdapter(this, searchResults);
        final ListView majorsListView = findViewById(R.id.list);
        majorsListView.setAdapter(itemAdapter);

        majorsListView.setClickable(true);
        majorsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Object current = majorsListView.getItemAtPosition(position);

                // hides previously expanded element and expands clicked element
                // shifts focus to the newly clicked element
                if (focus != -1 && focus < searchResults.size()) {
                    searchResults.get(focus).setExpandedVisibility(View.GONE);
                }
                searchResults.get(position).setExpandedVisibility(View.VISIBLE);
                focus = position;

                itemAdapter.notifyDataSetChanged();
            }
        });
    }

    // *
    public void updateListFromSearchbar() {
        // newResults is the ArrayList that searchResults will have its contents replaced with
        ArrayList<Major> newResults = new ArrayList<>();

        //gets AutoComplete text string
        String searchQuery = searchbar.getText().toString();

        // if empty, set search
        if (searchQuery.equals(""))
            newResults = allMajorsList;
        else {
            for (int i = 0; i < allMajorsList.size(); i++) {
                // if the title matches the searchQuery (toLowercase makes condition not case sensitive)
                if (allMajorsList.get(i).getTitle().toLowerCase().contains(searchQuery.toLowerCase())) {
                    newResults.add(allMajorsList.get(i));
                }
            }
        }
        // hides the expanded view if there was one
        if (focus != -1 && focus < searchResults.size()) {
            searchResults.get(focus).setExpandedVisibility(View.GONE);
        }
        //empties searchResults and replaces contents with newResults
        searchResults.clear();
        searchResults.addAll(newResults);
        itemAdapter.notifyDataSetChanged();
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