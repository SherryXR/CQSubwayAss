package com.sherry.cqsubwayass.presenter;

import android.content.Context;

import com.sherry.cqsubwayass.model.bmob.User;
import com.sherry.cqsubwayass.model.callback.RegisterCallBack;
import com.sherry.cqsubwayass.ui.view.IRegisterActivityView;

/**
 * Created by Sherry on 2018/4/15.
 */

public class RegisterActivityPresenter {

    private IRegisterActivityView iRegisterActivityView;
    private Context context;

    public RegisterActivityPresenter(IRegisterActivityView iRegisterActivityView, Context context) {
        this.iRegisterActivityView = iRegisterActivityView;
        this.context = context;
    }

    public void registerAccount(){
        iRegisterActivityView.loadEditTestData(new RegisterCallBack() {
            @Override
            public void onSuccess(User user) {
                iRegisterActivityView.compileRegister(user);
            }

            @Override
            public void onErro(String message) {
                iRegisterActivityView.showRegisterErro(message);
            }
        });
    }

    public void EmailTest(){
        iRegisterActivityView.testEmail();
    }
}
