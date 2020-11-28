package com.example.wheaton.athletics;

import java.time.Instant;
import java.util.Date;

public class calendarEvent {
    private String title;
    private String description;
    String dateStr;
    private int year;
    private int month;
    private int day;
    private int startHour;
    private int startMinute;
    private int endHour;
    private int endMinute;
    private String location;

    public calendarEvent(String title, String desc, int mm, int dd, int yyyy, int shour, int sminute, int ehour, int eminute) {
        this.title = title;
        this.description = desc;
        this.year = yyyy;
        this.month = mm;
        this.day = dd;
        this.startHour = shour;
        this.startMinute = sminute;
        this.endHour = ehour;
        this.endMinute = eminute;
    }

    public calendarEvent(String title, String desc, int mm, int dd, int yyyy, int shour, int sminute, int ehour, int eminute, String loc) {
        this.title = title;
        this.description = desc;
        this.year = yyyy;
        this.month = mm;
        this.day = dd;
        this.startHour = shour;
        this.startMinute = sminute;
        this.endHour = ehour;
        this.endMinute = eminute;
        this.location = loc;
    }

    public calendarEvent() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
}
