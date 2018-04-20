package com.sherry.cqsubwayass.model.bmob;

import cn.bmob.v3.BmobObject;

/**
 * Created by Kevin Liu on 2018/4/13.
 */

public class SubwayFive extends BmobObject {

    private String station_name;
    private Integer station_id;
    private String station_begin;
    private String station_last;
    private String station_exit;




    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public Integer getStation_id() {
        return station_id;
    }

    public void setStation_id(Integer station_id) {
        this.station_id = station_id;
    }

    public String getStation_begin() {
        return station_begin;
    }

    public void setStation_begin(String station_begin) {
        this.station_begin = station_begin;
    }

    public String getStation_last() {
        return station_last;
    }

    public void setStation_last(String station_last) {
        this.station_last = station_last;
    }

    public String getStation_exit() {
        return station_exit;
    }

    public void setStation_exit(String station_exit) {
        this.station_exit = station_exit;
    }
}
