package com.sherry.cqsubwayass.utils;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/16.
 */

public class ActivityCollector {

    public static List<AppCompatActivity> appCompatActivities= new ArrayList<>();


    public static void addActivity(AppCompatActivity activity){
        appCompatActivities.add(activity);
    }
    public static void removeActivity(AppCompatActivity activity){
        appCompatActivities.remove(activity);
    }
    //测试finishAll()方法在ThirdActivity中
    public static void finishAll(){
        for (AppCompatActivity activity:appCompatActivities) {
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
