package com.sherry.cqsubwayass.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/13.
 */

public class ExitInfo implements Serializable{

    private List<String> exit_number = new ArrayList<>();
    private List<String> exitInfoLists = new ArrayList<>();

    public List<String> getExit_number() {
        return exit_number;
    }

    public void setExit_number(List<String> exit_number) {
        this.exit_number = exit_number;
    }

    public void addExitNumber(String name){
        exit_number.add(name);
    }

    public List<String> getExitInfoLists() {
        return exitInfoLists;
    }

    public void setExitInfoLists(List<String> exitInfoLists) {
        this.exitInfoLists = exitInfoLists;
    }

    public void addExitInfoLists(String exitTo){
        exitInfoLists.add(exitTo);
    }
}
