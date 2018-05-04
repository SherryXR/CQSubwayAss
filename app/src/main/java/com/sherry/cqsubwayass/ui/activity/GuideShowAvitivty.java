package com.sherry.cqsubwayass.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;


import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.app.BaseActivty;
import com.sherry.cqsubwayass.model.bean.Station;
import com.sherry.cqsubwayass.model.db.DBSubwayFive;
import com.sherry.cqsubwayass.model.db.DBSubwayOne;
import com.sherry.cqsubwayass.model.db.DBSubwaySix;
import com.sherry.cqsubwayass.model.db.DBSubwaySixOther;
import com.sherry.cqsubwayass.model.db.DBSubwayTen;
import com.sherry.cqsubwayass.model.db.DBSubwayThree;
import com.sherry.cqsubwayass.model.db.DBSubwayThreeOther;
import com.sherry.cqsubwayass.model.db.DBSubwayTwo;
import com.sherry.cqsubwayass.ui.adapter.GuideShowAdapter;
import com.sherry.cqsubwayass.utils.DataBuilder;
import com.sherry.cqsubwayass.widget.MaterialProgressDrawable;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuideShowAvitivty extends BaseActivty {

    @BindView(R.id.guide_back)
    ImageView guideBack;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.guide_show_area)
    TextView guideShowArea;
    @BindView(R.id.guide_show_stationNum)
    TextView guideShowStationNum;
    @BindView(R.id.guide_show_time)
    TextView guideShowTime;
    @BindView(R.id.guide_show_rv)
    RecyclerView guideShowRv;
    private String from;
    private String to;
    private GuideShowAdapter guideShowAdapter;
    private List<Station> result = new ArrayList<>();
    private DataBuilder dataBuilder;
    MaterialProgressDrawable progress;
    private int totalStation = 0;
    private Set<List<Station>> lineSet = new HashSet<List<Station>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_show);
        ButterKnife.bind(this);
        from = getIntent().getStringExtra("from");
        to = getIntent().getStringExtra("to");
        initView();
        dataBuilder = new DataBuilder();
        initStation();
        dataBuilder.getMetroMap(lineSet, totalStation);
        Station s1 = new Station(from);
        Station s2 = new Station(to);
        result = dataBuilder.getLines(s1, s2);
        guideShowStationNum.setText(result.size()+"站");
        guideShowTime.setText("大约"+result.size()*2+"分钟");
        guideShowAdapter = new GuideShowAdapter(GuideShowAvitivty.this,result);
        guideShowRv.setAdapter(guideShowAdapter);


    }


    private void initStation() {
        List<Station> subwayOneList = new ArrayList<>();
        List<Station> subwayTwoList = new ArrayList<>();
        List<Station> subwayThreeList = new ArrayList<>();
        List<Station> subwaySixList = new ArrayList<>();
        List<Station> subwayFiveList = new ArrayList<>();
        List<Station> subwayTenList = new ArrayList<>();
        List<Station> subwaySixOtherList = new ArrayList<>();
        List<Station> subwayThreeOtherList = new ArrayList<>();

        for (DBSubwayOne bean : DataSupport.findAll(DBSubwayOne.class)) {
            subwayOneList.add(new Station(bean.getStation_name(), "1号线"));
        }
        for (DBSubwayTwo bean : DataSupport.findAll(DBSubwayTwo.class)) {
            subwayTwoList.add(new Station(bean.getStation_name(), "2号线"));
        }
        for (DBSubwayThree bean : DataSupport.findAll(DBSubwayThree.class)) {
            subwayThreeList.add(new Station(bean.getStation_name(), "3号线"));
        }
        for (DBSubwaySix bean : DataSupport.findAll(DBSubwaySix.class)) {
            subwaySixList.add(new Station(bean.getStation_name(), "6号线"));
        }
        for (DBSubwayFive bean : DataSupport.findAll(DBSubwayFive.class)) {
            subwayFiveList.add(new Station(bean.getStation_name(), "5号线"));
        }
        for (DBSubwayTen bean : DataSupport.findAll(DBSubwayTen.class)) {
            subwayTenList.add(new Station(bean.getStation_name(), "10号线"));
        }
        for (DBSubwayThreeOther bean : DataSupport.findAll(DBSubwayThreeOther.class)) {
            subwayThreeOtherList.add(new Station(bean.getStation_name(), "3号线北延线"));
        }
        for (DBSubwaySixOther bean : DataSupport.findAll(DBSubwaySixOther.class)) {
            subwaySixOtherList.add(new Station(bean.getStation_name(), "6号线国博线"));
        }

        for (int j = 0; j < subwayOneList.size(); j++) {
            if (j < subwayOneList.size() - 1) {
                subwayOneList.get(j).next = subwayOneList.get(j + 1);
                subwayOneList.get(j + 1).prev = subwayOneList.get(j);
            }
        }
        for (int j = 0; j < subwayOneList.size(); j++) {
            if (j < subwayOneList.size() - 1) {
                subwayOneList.get(j).next = subwayOneList.get(j + 1);
                subwayOneList.get(j + 1).prev = subwayOneList.get(j);
            }
        }
        for (int j = 0; j < subwayThreeList.size(); j++) {
            if (j < subwayThreeList.size() - 1) {
                subwayThreeList.get(j).next = subwayThreeList.get(j + 1);
                subwayThreeList.get(j + 1).prev = subwayThreeList.get(j);
            }
        }
        for (int j = 0; j < subwaySixList.size(); j++) {
            if (j < subwaySixList.size() - 1) {
                subwaySixList.get(j).next = subwaySixList.get(j + 1);
                subwaySixList.get(j + 1).prev = subwaySixList.get(j);
            }
        }
        for (int j = 0; j < subwayFiveList.size(); j++) {
            if (j < subwayFiveList.size() - 1) {
                subwayFiveList.get(j).next = subwayFiveList.get(j + 1);
                subwayFiveList.get(j + 1).prev = subwayFiveList.get(j);
            }
        }
        for (int j = 0; j < subwayTenList.size(); j++) {
            if (j < subwayTenList.size() - 1) {
                subwayTenList.get(j).next = subwayTenList.get(j + 1);
                subwayTenList.get(j + 1).prev = subwayTenList.get(j);
            }
        }
        for (int j = 0; j < subwayThreeOtherList.size(); j++) {
            if (j < subwayThreeOtherList.size() - 1) {
                subwayThreeOtherList.get(j).next = subwayThreeOtherList.get(j + 1);
                subwayThreeOtherList.get(j + 1).prev = subwayThreeOtherList.get(j);
            }
        }
        for (int j = 0; j < subwaySixOtherList.size(); j++) {
            if (j < subwaySixOtherList.size() - 1) {
                subwaySixOtherList.get(j).next = subwaySixOtherList.get(j + 1);
                subwaySixOtherList.get(j + 1).prev = subwaySixOtherList.get(j);
            }
        }
        totalStation = subwayOneList.size() + subwayTwoList.size() + subwayThreeList.size() + subwaySixList.size()+subwayFiveList.size()+subwayTenList.size()+subwaySixOtherList.size()+subwayThreeOtherList.size();
        lineSet.add(subwayOneList);
        lineSet.add(subwayTwoList);
        lineSet.add(subwayThreeList);
        lineSet.add(subwaySixList);
        lineSet.add(subwayFiveList);
        lineSet.add(subwayTenList);
        lineSet.add(subwaySixOtherList);
        lineSet.add(subwayThreeOtherList);
    }


    private void initView(){


        toolbarTitle.setText("查询结果");
        guideShowArea.setText(from+"  ------  "+to);
        guideShowRv.setLayoutManager(new LinearLayoutManager(this));
        guideShowRv.setItemAnimator(new DefaultItemAnimator());
    }

    @OnClick(R.id.guide_back)
    public void onClick() {
        finish();
    }
}
