package com.sherry.cqsubwayass.model.callback;

import com.sherry.cqsubwayass.model.bean.FindBean;

import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/16.
 */

public interface LoadFindInfoCallBack {
    void onSuccess(List<FindBean> list);
    void onFailure(String erro);
}
