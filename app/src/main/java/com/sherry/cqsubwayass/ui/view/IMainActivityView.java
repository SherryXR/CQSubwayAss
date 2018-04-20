package com.sherry.cqsubwayass.ui.view;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/11.
 */

public interface IMainActivityView {

    void setupViewPager(List<Fragment> lists);
}
