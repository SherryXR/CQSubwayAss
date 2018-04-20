package com.sherry.cqsubwayass.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.sherry.cqsubwayass.model.IMainTag;
import com.sherry.cqsubwayass.model.impl.MainTagModel;
import com.sherry.cqsubwayass.ui.view.IMainActivityView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/11.
 */

public class MainActivityPresenter {

    private Context context;
    private IMainTag iMainTag;
    private IMainActivityView iMainActivityView;
    private List<Fragment> listFragment =new ArrayList<>();

    public MainActivityPresenter(Context context, IMainActivityView iMainActivityView) {
        this.context = context;
        this.iMainActivityView = iMainActivityView;
        iMainTag = new MainTagModel();
    }


    public void loadFragment(){
        listFragment =iMainTag.loadFragment().getLists();
        iMainActivityView.setupViewPager(listFragment);

    }
}
