package com.sherry.cqsubwayass.model.impl;

import android.support.v4.app.Fragment;

import com.sherry.cqsubwayass.model.IMainTag;
import com.sherry.cqsubwayass.model.bean.MainTag;
import com.sherry.cqsubwayass.ui.fragment.FindFragment;
import com.sherry.cqsubwayass.ui.fragment.GoOutFragment;
import com.sherry.cqsubwayass.ui.fragment.MineFragment;
import com.sherry.cqsubwayass.ui.fragment.StationFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/11.
 */

public class MainTagModel implements IMainTag {
    private List<Fragment> lists= new ArrayList<>();
    private MainTag mainTag = new MainTag();

    @Override
    public MainTag loadFragment() {
        lists.add(new GoOutFragment());
        lists.add(new StationFragment());
        lists.add(new FindFragment());
        lists.add(new MineFragment());
        mainTag.setLists(lists);


        return mainTag;
    }
}
