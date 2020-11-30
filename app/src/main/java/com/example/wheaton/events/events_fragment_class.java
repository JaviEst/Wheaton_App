package com.example.wheaton.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;


public class events_fragment_class {

    

    public final String title,date,image,location,largeimage,cost,filter,organName,organPhone,organEmail,link;

    private int buttonVisibility;

    private int originalPosition;


    @Override
    public String toString() {
        return title;
    }




    public void setButtonVisibility(int buttonVisibility) {
        this.buttonVisibility = buttonVisibility;
    }
    public void setOriginalPosition(int originalPosition){
        this.originalPosition = originalPosition;
    }


    public events_fragment_class(String eventTitle, String eventDate, String eventThumbnailPic,
                                 String eventLocation, String eventLargerPic, String eventCost, String eventFilter,
                                 String eventOrganizerName, String eventOrganizerPhone, String eventOrganizerEmail,
                                 String eventLink) {
        title = eventTitle;
        date = eventDate;
        image = eventThumbnailPic;
        location = eventLocation;

        largeimage = eventLargerPic;
        cost = eventCost;
        filter = eventFilter;
        organName = eventOrganizerName;
        organPhone = eventOrganizerPhone;
        organEmail = eventOrganizerEmail;
        link = eventLink;


        this.buttonVisibility = View.GONE;
    }




    public int getButtonVisibility() {
        return buttonVisibility;
    }

    public String getTitle(){
        return title;
    }

    public String getDate(){
        return date;
    }

    public String getImage(){
        return image;
    }

    public String getLocation(){
        return location;
    }

    public String getLargeimage(){
        return largeimage;
    }

    public String getCost(){
        return cost;
    }

    public String getFilter(){
        return filter;
    }

    public String getOrganName(){
        return organName;
    }

    public String getOrganPhone(){
        return organPhone;
    }

    public String getOrganEmail(){
        return organEmail;
    }

    public String getLink(){
        return link;
    }

    public int getOriginalPosition(){
        return originalPosition;
    }




}