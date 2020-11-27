package com.example.wheaton.First_Year;

import android.view.View;

public class phone_nums {

    private String location;
    private String phone_num;
    private int layout_vis;

    public phone_nums(String place, String phone){
        this.location = place;
        this.phone_num = phone;
        this.layout_vis = View.GONE;
    }

    public String getLocation(){
        return this.location;
    }

    public String getPhone_num(){ return this.phone_num; }

    public int getLayout_vis(){ return this.layout_vis; }

    public void setLayout_vis(int layout_vis) {
        this.layout_vis = layout_vis;
    }
}
