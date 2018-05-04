package com.sherry.cqsubwayass.model.bean;

/**
 * Created by Sherry on 2018/4/13.
 */

public class SubwayInfo {

    private String Subway_name;

    private int Subway_color;

    public SubwayInfo(String subway_name, int subway_color) {
        Subway_name = subway_name;
        Subway_color = subway_color;
    }

    public String getSubway_name() {
        return Subway_name;
    }

    public void setSubway_name(String subway_name) {
        Subway_name = subway_name;
    }

    public int getSubway_color() {
        return Subway_color;
    }

    public void setSubway_color(int subway_color) {
        Subway_color = subway_color;
    }
}
