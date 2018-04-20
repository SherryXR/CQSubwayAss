package com.sherry.cqsubwayass.utils;

import com.sherry.cqsubwayass.model.bean.ExitInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/13.
 */

public class StringSplit {

    /**
     * 对每一个站点进行数据解析
     * 使用";"来区别每一个出站口
     * 使用","来却别每一个出站口的到达地点
     * 使用":"来却别每一个出站口的名称
     */
    public static ExitInfo PraseExit(String info){
        ExitInfo exitInfo = new ExitInfo();
        String[] allExitInfo = info.split("[;]");
        /**
         * 数据被分割成一个XX:SSSSS,SSSSS类型 即: 每个出口被分隔开
         */
        for (int i = 0; i < allExitInfo.length; i++) {
            /**
             * 数据被分割成一个XX与SSSS,SSSSS类型 即: 出口名和出口去向分开
             */
            String[] perExitinfo = allExitInfo[i].split("[:]");
            exitInfo.addExitNumber(perExitinfo[0]);
            if (perExitinfo.length>1) {
                /**
                 * 数据被分割成一个SSSS SSSSS类型 即: 出口去向分开
                 */
                    exitInfo.addExitInfoLists(perExitinfo[1]);

            }else {
                exitInfo.addExitInfoLists("暂无");
            }
        }
        return exitInfo;
    }

    public static List<String> PraseCollect(String str){
        String[] collect = str.split("[,]");
        List<String> collectList = new ArrayList<>();
        for (int i=0;i<collect.length;i++){
            collectList.add(collect[0]);
        }
        return collectList;
    }

}
