package com.sherry.cqsubwayass.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sherry.cqsubwayass.model.ISubwayInfo;
import com.sherry.cqsubwayass.model.callback.OnItemClickListener;
import com.sherry.cqsubwayass.model.impl.SubwayInfoModel;
import com.sherry.cqsubwayass.ui.activity.SubwayLineActivity;
import com.sherry.cqsubwayass.ui.adapter.StationRvAdapter;
import com.sherry.cqsubwayass.ui.view.IStationFragmentView;

/**
 * Created by Kevin Liu on 2018/4/13.
 */

public class StationFragmentPresenter {

    private Context context;
    private IStationFragmentView iStationFragmentView;
    private ISubwayInfo iSubwayInfo;
    private StationRvAdapter adapter;

    public StationFragmentPresenter(Context context, IStationFragmentView iStationFragmentView) {
        this.context = context;
        this.iStationFragmentView = iStationFragmentView;
        iSubwayInfo = new SubwayInfoModel(this.context);
    }



    public void loadSubway(RecyclerView rv){
        iStationFragmentView.showRv();
        adapter =new StationRvAdapter(iSubwayInfo.loadData());
        iStationFragmentView.toSubwayLine(adapter);
        rv.setAdapter(adapter);
    }
}
