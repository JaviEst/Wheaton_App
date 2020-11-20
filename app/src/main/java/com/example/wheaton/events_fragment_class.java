package com.example.wheaton;

import android.view.View;

/**
 * {@Event} represents an earthquake event.
 */
public class events_fragment_class {

    /** Title of the earthquake event */
    public final String title;

    /** Number of people who felt the earthquake and reported how strong it was */
    public final String date;

    public final String image;

    /** Perceived strength of the earthquake from the people's responses */
    public final String location;

    private int buttonVisibility;



    public void setButtonVisibility(int buttonVisibility) {
        this.buttonVisibility = buttonVisibility;
    }

    public events_fragment_class(String eventTitle, String eventDate, String eventImage, String eventLocation) {
        title = eventTitle;
        date = eventDate;
        image = eventImage;
        location = eventLocation;
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

}