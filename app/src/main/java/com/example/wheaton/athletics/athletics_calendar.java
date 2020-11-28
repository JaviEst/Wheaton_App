package com.example.wheaton.athletics;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.wheaton.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.example.wheaton.athletics.ICS_sample_str;

public class athletics_calendar extends AppCompatActivity {

    ArrayList<calendarEvent> listviewArray = new ArrayList<>();
    calendarEventAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athletics_calendar);
        ListView eventsListview = findViewById(R.id.calendarListview);

        try {
            generateCalendar();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        adapter = new calendarEventAdapter(this, listviewArray);
        eventsListview.setAdapter(adapter);


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void generateCalendar() throws IOException, ParseException {
//        calendarEvent newItem = new calendarEvent("testing","123",11,10,2020,15,30,19,0);
//        listviewArray.add(newItem);
//
//        newItem = new calendarEvent("two","123",11,10,2020,12,0,19,30,"Haas");
//        listviewArray.add(newItem);
//
//        newItem = new calendarEvent("testfing","waf3",11,10,2020,15,30,19,0,"place");
//        listviewArray.add(newItem);

        String filename = "sample.ics";
        FileOutputStream fOut = openFileOutput(filename, Context.MODE_PRIVATE);
        fOut.write(ICS_sample_str.sampleSTR.getBytes());
        fOut.close();

        File calenderICS = getBaseContext().getFileStreamPath(filename);

        if (calenderICS.exists()) {
            FileReader fileReader = new FileReader(calenderICS);
            BufferedReader bf = new BufferedReader(fileReader);
            generateCalendarFromBR(bf);

        }
    }

    private void generateCalendarFromBR(BufferedReader bf) throws IOException, ParseException {
        //skip first four lines
        for (int i = 0; i < 4; i++) {
            bf.readLine();
        }
        String currentAttribute;
        String currentLine;
        //
        currentLine = bf.readLine();
        currentAttribute = getLineAttribute(currentLine);

        while (!currentAttribute.contains("END")) {
            if (currentAttribute.contains("BEGIN")) {
                readEvent(bf);
                currentLine = bf.readLine();
                currentAttribute = getLineAttribute(currentLine);
                //Toast.makeText(this, currentAttribute, Toast.LENGTH_SHORT).show();
            }
        }

    }

    private void readEvent(BufferedReader bf) throws IOException, ParseException {
        calendarEvent newEvent = new calendarEvent();
        String currentAttribute;
        String currentLine;
        String lineData;

        currentLine = bf.readLine();
        currentAttribute = getLineAttribute(currentLine);
        lineData = removeLineAttribute(currentLine);


        while (!currentAttribute.contains("END")) {
            switch (currentAttribute) {
                case "DTSTART":
                    newEvent.setYear(Integer.parseInt(lineData.substring(0, 4)));
                    newEvent.setMonth(Integer.parseInt(lineData.substring(4, 6)));
                    newEvent.setDay(Integer.parseInt(lineData.substring(6, 8)));
                    newEvent.setStartHour(Integer.parseInt(lineData.substring(9, 11)));
                    newEvent.setStartMinute(Integer.parseInt(lineData.substring(11, 13)));
                    break;

                case "DURATION":
                    newEvent.setEndHour(newEvent.getStartHour() + Integer.parseInt(lineData.substring(2, 3)));
                    break;

                case "SUMMARY":
                    newEvent.setTitle(lineData);
                    break;

                default:
                    break;
            }

            currentLine = bf.readLine();
            currentAttribute = getLineAttribute(currentLine);
            lineData = removeLineAttribute(currentLine);
        }
        listviewArray.add(newEvent);
    }

    private String getLineAttribute(String currentLine) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < currentLine.length() && currentLine.charAt(i) != ':'; i++) {
            output.append(currentLine.charAt(i));
        }
        return output.toString();
    }

    private String removeLineAttribute(String currentLine) {
        boolean start = false;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < currentLine.length() && currentLine.charAt(i) != '\n'; i++) {
            if (start)
                output.append(currentLine.charAt(i));
            if (currentLine.charAt(i) == ':')
                start = true;
        }
        return output.toString();
    }

}
