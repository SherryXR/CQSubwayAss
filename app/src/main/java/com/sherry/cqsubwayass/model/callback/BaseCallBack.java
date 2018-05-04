package com.sherry.cqsubwayass.model.callback;



public interface BaseCallBack<T> {
    void onSuccess(T bean);

    void onFailure(String error);
}
