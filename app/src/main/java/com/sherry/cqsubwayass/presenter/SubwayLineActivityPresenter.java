package com.sherry.cqsubwayass.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.sherry.cqsubwayass.model.IStationBean;
import com.sherry.cqsubwayass.model.bean.StationBean;
import com.sherry.cqsubwayass.model.impl.StationBeanModel;
import com.sherry.cqsubwayass.ui.adapter.SubwayLineAdapter;
import com.sherry.cqsubwayass.ui.view.ISubwayLineActivity;

import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/13.
 */

public class SubwayLineActivityPresenter {

    private ISubwayLineActivity iSubwayLineActivity;
    private Context context;
    private IStationBean iStationBean;
    private SubwayLineAdapter adapter;
    private int num;


    public SubwayLineActivityPresenter(ISubwayLineActivity iSubwayLineActivity, Context context,int num) {
        this.iSubwayLineActivity = iSubwayLineActivity;
        this.context = context;
        iStationBean = new StationBeanModel();
        this.num = num;
    }

    public void loadStation(RecyclerView rv){
        iSubwayLineActivity.showRv();
        iSubwayLineActivity.setType();

        List<StationBean> stationBeans = iStationBean.loadDataFromDB(num);
        adapter = new SubwayLineAdapter(stationBeans,num,context);
        iSubwayLineActivity.tendToAStationInfoActivity(adapter,stationBeans);
        rv.setAdapter(adapter);
    }
}
