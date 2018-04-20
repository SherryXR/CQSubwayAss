package com.sherry.cqsubwayass.model.impl;

import com.sherry.cqsubwayass.model.IStationBean;
import com.sherry.cqsubwayass.model.bean.Station;
import com.sherry.cqsubwayass.model.bean.StationBean;
import com.sherry.cqsubwayass.model.db.DBSubwayFive;
import com.sherry.cqsubwayass.model.db.DBSubwayOne;
import com.sherry.cqsubwayass.model.db.DBSubwaySix;
import com.sherry.cqsubwayass.model.db.DBSubwaySixOther;
import com.sherry.cqsubwayass.model.db.DBSubwayTen;
import com.sherry.cqsubwayass.model.db.DBSubwayThree;
import com.sherry.cqsubwayass.model.db.DBSubwayThreeOther;
import com.sherry.cqsubwayass.model.db.DBSubwayTwo;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/13.
 */

public class StationBeanModel implements IStationBean{

    private List<StationBean> lists = new ArrayList<>();


    @Override
    public List<StationBean> loadDataFromDB(int num) {
        lists.clear();
        switch (num){
            case 0:
                for (DBSubwayOne bean : DataSupport.findAll(DBSubwayOne.class)) {
                    lists.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),bean.getStation_begin(),bean.getStation_last() ));
                }
                break;
            case 1:
                for (DBSubwayTwo bean : DataSupport.findAll(DBSubwayTwo.class)) {
                    lists.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),bean.getStation_begin(),bean.getStation_last() ));
                }
                break;
            case 2:
                for (DBSubwayThree bean : DataSupport.findAll(DBSubwayThree.class)) {
                    lists.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),bean.getStation_begin(),bean.getStation_last() ));
                }
                break;
            case 3:
                for (DBSubwayFive bean : DataSupport.findAll(DBSubwayFive.class)) {
                    lists.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),bean.getStation_begin(),bean.getStation_last() ));
                }
                break;
            case 4:
                for (DBSubwaySix bean : DataSupport.findAll(DBSubwaySix.class)) {
                    lists.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),bean.getStation_begin(),bean.getStation_last() ));
                }
                break;
            case 5:
                for (DBSubwayTen bean : DataSupport.findAll(DBSubwayTen.class)) {
                    lists.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),bean.getStation_begin(),bean.getStation_last() ));
                }
                break;
            case 6:
                for (DBSubwayThreeOther bean : DataSupport.findAll(DBSubwayThreeOther.class)) {
                    lists.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),bean.getStation_begin(),bean.getStation_last() ));
                }
                break;
            case 7:
                for (DBSubwaySixOther bean : DataSupport.findAll(DBSubwaySixOther.class)) {
                    lists.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),bean.getStation_begin(),bean.getStation_last() ));
                }
                break;
        }
        return lists;
    }
}
