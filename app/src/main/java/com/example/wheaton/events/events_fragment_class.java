package com.example.wheaton.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;


public class events_fragment_class implements Parcelable {

    public final String title,date,image,location,largeimage,cost,filter,organName,organPhone,organEmail,link;

    private int buttonVisibility;


    protected events_fragment_class(Parcel in) {
        title = in.readString();
        date = in.readString();
        image = in.readString();
        location = in.readString();
        largeimage = in.readString();
        cost = in.readString();
        filter = in.readString();
        organName = in.readString();
        organPhone = in.readString();
        organEmail = in.readString();
        link = in.readString();
        buttonVisibility = in.readInt();
    }

    public static final Creator<events_fragment_class> CREATOR = new Creator<events_fragment_class>() {
        @Override
        public events_fragment_class createFromParcel(Parcel in) {
            return new events_fragment_class(in);
        }

        @Override
        public events_fragment_class[] newArray(int size) {
            return new events_fragment_class[size];
        }
    };

    public void setButtonVisibility(int buttonVisibility) {
        this.buttonVisibility = buttonVisibility;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(date);
        parcel.writeString(image);
        parcel.writeString(location);
        parcel.writeString(largeimage);
        parcel.writeString(cost);
        parcel.writeString(filter);
        parcel.writeString(organName);
        parcel.writeString(organPhone);
        parcel.writeString(organEmail);
        parcel.writeString(link);
        parcel.writeInt(buttonVisibility);
    }
}