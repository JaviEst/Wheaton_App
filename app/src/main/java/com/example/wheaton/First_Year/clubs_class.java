package com.example.wheaton.First_Year;

import android.view.View;
import android.widget.ImageView;

public class clubs_class {

    private String club_pic;
    private String club_name;
    private String club_desc;
    private int layout_vis;

    public clubs_class(String picture, String name, String description){
        this.club_pic = picture;
        this.club_name = name;
        this.club_desc = description;
        this.layout_vis = View.GONE;
    }

    public String getClub_pic(){
        return this.club_pic;
    }

    public String getClub_name(){
        return this.club_name;
    }

    public String getClub_desc(){
        return this.club_desc;
    }

    public int getLayout_vis(){
        return this.layout_vis;
    }

    public void setLayout_vis(int layout_vis){
        this.layout_vis = layout_vis;
    }
}
