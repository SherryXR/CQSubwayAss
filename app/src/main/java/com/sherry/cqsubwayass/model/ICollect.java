package com.sherry.cqsubwayass.model;

import com.sherry.cqsubwayass.model.bean.FindBean;
import com.sherry.cqsubwayass.model.callback.BaseCallBack;

import java.util.List;

/**
 * Created by Aaron Liu on 2018/5/4
 * <p>
 * Function:
 */
public interface ICollect {

    void postCollect(String id, final BaseCallBack<String> callBack);

    void cancelCollect(String id, final BaseCallBack<String> callBack);

    void getColelct(final BaseCallBack<List<FindBean>>  callBack);
}
