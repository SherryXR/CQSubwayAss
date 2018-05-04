package com.sherry.cqsubwayass.model.bean;

import com.sherry.cqsubwayass.utils.StringSplit;

import java.io.Serializable;

/**
 * Created by Sherry on 2018/4/13.
 */

public class StationBean implements Serializable{
    private String name;

    private Integer id;

    private ExitInfo exitInfo;

    private int subwayNum;

    private String begin_time;

    private String last_time;

    public StationBean(String name, Integer id, String exitInfo, int subwayNum) {
        this.name = name;
        this.id = id;
        this.exitInfo = StringSplit.PraseExit(exitInfo);
        this.subwayNum = subwayNum;
    }

    public StationBean(String name, Integer id, String exitInfo, String begin_time, String last_time) {
        this.name = name;
        this.id = id;
        this.exitInfo = StringSplit.PraseExit(exitInfo);
        this.begin_time = begin_time;
        this.last_time = last_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ExitInfo getExitInfo() {
        return exitInfo;
    }

    public void setExitInfo(String exitInfo) {
        this.exitInfo = StringSplit.PraseExit(exitInfo);
    }

    public int getSubwayNum() {
        return subwayNum;
    }

    public void setSubwayNum(int subwayNum) {
        this.subwayNum = subwayNum;
    }

    public String getBegin_time() {
        return begin_time;
    }

    public void setBegin_time(String begin_time) {
        this.begin_time = begin_time;
    }

    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }
}
