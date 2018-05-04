package com.sherry.cqsubwayass.ui.view;

import com.sherry.cqsubwayass.model.bmob.User;
import com.sherry.cqsubwayass.model.callback.RegisterCallBack;

/**
 * Created by Sherry on 2018/4/15.
 */

public interface IRegisterActivityView {

    void loadEditTestData(RegisterCallBack registerCallBack);
    void showRegisterErro(String message);

    void compileRegister(User user);

    void testEmail();
}
