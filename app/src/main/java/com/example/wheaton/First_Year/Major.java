package com.example.wheaton.First_Year;

import android.view.View;

public class Major {
    protected String title;
    protected String author;
    protected String publisher;
    protected int year;
    protected String category;
    protected String summary;
    protected int expandedVisibility;

    public String getSheetURL() {
        return sheetURL;
    }

    public void setSheetURL(String sheetURL) {
        this.sheetURL = sheetURL;
    }

    protected String sheetURL;

    public int getExpandedVisibility() {
        return expandedVisibility;
    }

    public void setExpandedVisibility(int expandedVisibility) {
        this.expandedVisibility = expandedVisibility;
    }

    public Major() {
        expandedVisibility = View.GONE;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
