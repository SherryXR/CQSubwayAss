package com.sherry.cqsubwayass.model;

import com.sherry.cqsubwayass.model.bean.StationBean;

import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/13.
 */

public interface IStationBean {

    List<StationBean> loadDataFromDB(int num);
}
