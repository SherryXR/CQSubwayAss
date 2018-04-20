package com.sherry.cqsubwayass.utils;

import android.content.Context;

/**
 * Created by Kevin Liu on 2018/4/16.
 */

public class UserUtils {

    public static void putName(Context context,String str){

        SPUtils.put(context, "name", str);
    }
    public static void putEmail(Context context,String str){
        SPUtils.put(context, "email", str);
    }

    public static void putHeardImage(Context context,String str){
        SPUtils.put(context, "headImage", str);
    }
    public static void putCollect(Context context,String str){
        SPUtils.put(context, "collect", str);
    }

    public static String getCollect(Context context){
        return (String) SPUtils.get(context, "collect", "");
    }
    public static String getName(Context context){
        return (String) SPUtils.get(context, "name", "");
    }
    public static String getEmail(Context context){
        return (String) SPUtils.get(context, "email", "");
    }
    public static String getHeadImage(Context context){
        return (String) SPUtils.get(context, "headImage", "");
    }
}
