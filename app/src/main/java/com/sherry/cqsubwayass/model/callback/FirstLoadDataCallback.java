package com.sherry.cqsubwayass.model.callback;

/**
 * Created by Kevin Liu on 2018/4/13.
 */

public interface FirstLoadDataCallback {

    void onSuccess(String message);
    void onFailure(String erro);
}
