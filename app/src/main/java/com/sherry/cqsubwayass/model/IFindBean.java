package com.sherry.cqsubwayass.model;

import com.sherry.cqsubwayass.model.bean.FindBean;
import com.sherry.cqsubwayass.model.callback.FirstLoadDataCallback;
import com.sherry.cqsubwayass.model.callback.LoadFindInfoCallBack;

import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/15.
 */

public interface IFindBean {

    void loadAllData(LoadFindInfoCallBack loadFindInfoCallBack);
}
