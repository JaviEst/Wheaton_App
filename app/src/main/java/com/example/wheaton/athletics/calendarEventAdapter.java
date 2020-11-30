package com.example.wheaton.athletics;

import android.app.Activity;
import android.bluetooth.BluetoothClass;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.wheaton.R;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.time.Instant;
import java.time.MonthDay;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.ArrayList;

import static java.time.temporal.ChronoField.*;

public class calendarEventAdapter extends ArrayAdapter<calendarEvent> {
    public calendarEventAdapter(Activity context, ArrayList<calendarEvent> list) {
        super(context, 0, list);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.athletics_event_layout, parent, false);
        }


        calendarEvent current = getItem(position);
        assert current != null;

        // entry title
        TextView titleText = listItemView.findViewById(R.id.eventTitle);
        titleText.setText(current.getTitle());

        //start date
        TextView dateText = listItemView.findViewById(R.id.date);
        String dateStr = MessageFormat.format("{0}/{1}/{2,number,#}", current.getMonth(), current.getDay(), current.getYear());
        dateText.setText(dateStr);

        // times
        String startTimeSTR = "";
        String endTimeSTR = "";

        int startHour = current.getStartHour();
        if (startHour == 0) {
            startTimeSTR += "12";
        } else if (startHour < 12) {
            startTimeSTR += String.valueOf(startHour);
        } else if (startHour == 12) {
            startTimeSTR += 12;
        } else {
            startTimeSTR += String.valueOf(startHour - 12);
        }
        int startMinute = current.getStartMinute();
        if (startMinute == 0) {
            startTimeSTR += "";
        } else {
            startTimeSTR += ":".concat(String.valueOf(startMinute));
        }
        if (startHour < 12) {
            startTimeSTR += " AM";
        } else {
            startTimeSTR += " PM";
        }

        int endHour = current.getEndHour();
        if (endHour == 0) {
            endTimeSTR += "12";
        } else if (endHour < 12) {
            endTimeSTR += String.valueOf(endHour);
        } else if (endHour == 12) {
            endTimeSTR += 12;
        } else {
            endTimeSTR += String.valueOf(endHour - 12);
        }
        int endMinute = current.getEndMinute();
        if (endMinute == 0) {
            endTimeSTR += "";
        } else {
            endTimeSTR += ":".concat(String.valueOf(endMinute));
        }
        if (endHour < 12) {
            endTimeSTR += " AM";
        } else {
            endTimeSTR += " PM";
        }

        TextView timesText = listItemView.findViewById(R.id.times);
        timesText.setText(MessageFormat.format("{0} - {1}", startTimeSTR, endTimeSTR));

        TextView locationText = listItemView.findViewById(R.id.location);
        if (current.getLocation() != null) {
            locationText.setText(current.getLocation());
        } else {
            locationText.setVisibility(View.GONE);
        }


        return listItemView;
    }


}