package com.example.wheaton.map;

public class Building {
    private String name;
    private Double Lat;
    private Double Long;

    public Building(String n, Double la, Double lo){
        this.name = n;
        this.Lat = la;
        this.Long = lo;
    }

    public String getName(){
        return this.name;
    }

    public Double getLat(){
        return this.Lat;
    }

    public Double getLong(){
        return this.Long;
    }
}
