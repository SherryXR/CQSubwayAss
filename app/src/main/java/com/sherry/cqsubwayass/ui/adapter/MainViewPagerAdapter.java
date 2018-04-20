package com.sherry.cqsubwayass.ui.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/8.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> list = new ArrayList<>();

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {

        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public void addFragment(Fragment fragment) {
        list.add(fragment);
        Log.d("MainViewPagerAdapert","list的大小"+list.size());
    }
}
