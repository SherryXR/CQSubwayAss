package com.sherry.cqsubwayass.model.bean;

/**
 * Created by Sherry on 2018/4/13.
 */

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;


/**
 * desc：地铁站对象
 */
public class Station {

    private String name; //地铁站名称，假设具备唯一性

    public Station prev; //本站在lineNo线上面的前一个站

    public Station next; //本站在lineNo线上面的后一个站

    private String whichLine ="";//本站属于几号线

    private boolean isHuan = false;

    //本站到某一个目标站(key)所经过的所有站集合(value)，保持前后顺序
    private Map<Station,LinkedHashSet<Station>> orderSetMap =
            new HashMap<Station,LinkedHashSet<Station>>();

    public Station (String name ,String whichLine){
        this.name = name;
        this.whichLine = whichLine;
    }

    public Station(String name){
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLine(String line){
        this.whichLine = line;
    }

    public String getLine(){
        return whichLine;
    }

    public LinkedHashSet<Station> getAllPassedStations(Station station) {
        if(orderSetMap.get(station) == null){
            LinkedHashSet<Station> set = new LinkedHashSet<Station>();
            set.add(this);
            orderSetMap.put(station, set);
        }
        return orderSetMap.get(station);
    }

    public Map<Station, LinkedHashSet<Station>> getOrderSetMap() {
        return orderSetMap;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        } else if(obj instanceof Station){
            Station s = (Station) obj;
            if(s.getName().equals(this.getName())){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.getName().hashCode();
    }

    @Override
    public String toString(){
        return this.name;
    }

    public String getWhichLine() {
        return whichLine;
    }

    public void setWhichLine(String whichLine) {
        this.whichLine = whichLine;
    }

    public Station getNext() {
        return next;
    }

    public void setNext(Station next) {
        this.next = next;
    }

    public Station getPrev() {
        return prev;
    }

    public void setPrev(Station prev) {
        this.prev = prev;
    }

    public boolean isHuan() {
        return isHuan;
    }

    public void setHuan(boolean huan) {
        isHuan = huan;
    }




}



