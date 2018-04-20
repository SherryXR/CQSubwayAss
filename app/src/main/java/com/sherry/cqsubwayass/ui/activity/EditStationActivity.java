package com.sherry.cqsubwayass.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;


import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.app.BaseActivty;
import com.sherry.cqsubwayass.model.bean.StationBean;
import com.sherry.cqsubwayass.model.db.DBSubwayFive;
import com.sherry.cqsubwayass.model.db.DBSubwayOne;
import com.sherry.cqsubwayass.model.db.DBSubwaySix;
import com.sherry.cqsubwayass.model.db.DBSubwaySixOther;
import com.sherry.cqsubwayass.model.db.DBSubwayTen;
import com.sherry.cqsubwayass.model.db.DBSubwayThree;
import com.sherry.cqsubwayass.model.db.DBSubwayThreeOther;
import com.sherry.cqsubwayass.model.db.DBSubwayTwo;
import com.sherry.cqsubwayass.ui.adapter.GuidePopupAdpter;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EditStationActivity extends BaseActivty {

    @BindView(R.id.guide_station_back)
    ImageView guideStationBack;
    @BindView(R.id.guide_station_edit)
    EditText guideStationEdit;
    @BindView(R.id.guide_station_lv)
    ListView guideStationLv;
    @BindView(R.id.guide_station_refresh)
    SwipeRefreshLayout refreshLayout;
    private GuidePopupAdpter dataAdapter;
    private boolean isFrom ;

    private List<StationBean> stationList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_station);
        ButterKnife.bind(this);
        initRefreshLayout();
        guideStationLv.setDividerHeight(0);
        isFrom = getIntent().getBooleanExtra("isFrom",true);
        dataAdapter = new GuidePopupAdpter(stationList,this.getLayoutInflater());
        guideStationLv.setAdapter(dataAdapter);
        guideStationEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(final CharSequence charSequence, int i, int i1, int i2) {
                if (!charSequence.toString().equals("")){
                    refreshLayout.setRefreshing(true);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            QueryData(charSequence.toString());
                        }
                    }, 2000);
                    //QueryData(charSequence.toString());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
            guideStationLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                if (isFrom){
                    intent.putExtra("stationFrom", stationList.get(i).getName());
                    setResult(1003, intent);
                    finish();
                }else {
                    intent.putExtra("stationTo", stationList.get(i).getName());
                    setResult(1004, intent);
                    finish();
                }
            }
        });
    }

    @OnClick(R.id.guide_station_back)
    public void onClick() {
        finish();
    }

    private void QueryData(final String keyword){
        stationList.clear();
        stationList.clear();
        for (DBSubwayOne bean : DataSupport.findAll(DBSubwayOne.class)) {
            if (bean.getStation_name().contains(keyword) || bean.getStation_name().contains(keyword.toUpperCase())) {
                stationList.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),1000));
            }
        }
        for (DBSubwayTwo bean : DataSupport.findAll(DBSubwayTwo.class)) {
            if (bean.getStation_name().contains(keyword) || bean.getStation_name().contains(keyword.toUpperCase())) {
                stationList.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),1000));
            }
        }
        for (DBSubwayThree bean : DataSupport.findAll(DBSubwayThree.class)) {
            if (bean.getStation_name().contains(keyword) || bean.getStation_name().contains(keyword.toUpperCase())) {
                stationList.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),1000));
            }
        }
        for (DBSubwayFive bean : DataSupport.findAll(DBSubwayFive.class)) {
            if (bean.getStation_name().contains(keyword) || bean.getStation_name().contains(keyword.toUpperCase())) {
                stationList.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),1000));
            }
        }
        for (DBSubwaySix bean : DataSupport.findAll(DBSubwaySix.class)) {
            if (bean.getStation_name().contains(keyword) || bean.getStation_name().contains(keyword.toUpperCase())) {
                stationList.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),1000));
            }
        }
        for (DBSubwayTen bean : DataSupport.findAll(DBSubwayTen.class)) {
            if (bean.getStation_name().contains(keyword) || bean.getStation_name().contains(keyword.toUpperCase())) {
                stationList.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),1000));
            }
        }
        for (DBSubwaySixOther bean : DataSupport.findAll(DBSubwaySixOther.class)) {
            if (bean.getStation_name().contains(keyword) || bean.getStation_name().contains(keyword.toUpperCase())) {
                stationList.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),1000));
            }
        }
        for (DBSubwayThreeOther bean : DataSupport.findAll(DBSubwayThreeOther.class)) {
            if (bean.getStation_name().contains(keyword) || bean.getStation_name().contains(keyword.toUpperCase())) {
                stationList.add(new StationBean(bean.getStation_name(),bean.getStation_id(),bean.getStation_exit(),1000));
            }
        }
        dataAdapter.notifyDataSetChanged();
        refreshLayout.setRefreshing(false);

    }

    private void initRefreshLayout() {
        //设置刷新的颜色
        refreshLayout.setColorSchemeResources(
                R.color.colorPrimary,
                R.color.colorPrimary,
                R.color.colorPrimary,
                R.color.colorPrimary);
        //拖动多长的时候开始刷新
        refreshLayout.setDistanceToTriggerSync(100);

        refreshLayout.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.white));

        //设置大小
        refreshLayout.setSize(SwipeRefreshLayout.DEFAULT);
        //刷新监听器
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                QueryData(guideStationEdit.getText().toString());
            }
        });
    }

}

