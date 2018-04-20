package com.sherry.cqsubwayass.model.callback;

import com.sherry.cqsubwayass.model.bmob.User;

/**
 * Created by Kevin Liu on 2018/4/15.
 */

public interface RegisterCallBack {

    void onSuccess(User user);

    void onErro(String message);
}
