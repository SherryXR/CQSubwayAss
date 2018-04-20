package com.sherry.cqsubwayass.model.impl;

import android.content.Context;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.ISubwayInfo;
import com.sherry.cqsubwayass.model.bean.SubwayInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin Liu on 2018/4/13.
 */

public class SubwayInfoModel implements ISubwayInfo {

    private Context context;
    private List<SubwayInfo> lists =new ArrayList<>();
    int color_one,color_two,color_three,color_five,color_six,color_ten;

    public SubwayInfoModel(Context context){
        this.context = context;
        this.color_one = context.getResources().getColor(R.color.subway_one);
        this.color_two = context.getResources().getColor(R.color.subway_two);
        this.color_three = context.getResources().getColor(R.color.subway_three);
        this.color_five = context.getResources().getColor(R.color.subway_five);
        this.color_six = context.getResources().getColor(R.color.subway_six);
        this.color_ten = context.getResources().getColor(R.color.subway_ten);
    }

    @Override
    public List<SubwayInfo> loadData() {
        lists.add(new SubwayInfo("轻轨一号线",color_one));
        lists.add(new SubwayInfo("轻轨二号线",color_two));
        lists.add(new SubwayInfo("轻轨三号线",color_three));
        lists.add(new SubwayInfo("轻轨五号线",color_five));
        lists.add(new SubwayInfo("轻轨六号线",color_six));
        lists.add(new SubwayInfo("轻轨十号线",color_ten));
        lists.add(new SubwayInfo("轻轨三号线-其他线",color_three));
        lists.add(new SubwayInfo("轻轨六号线-国博线",color_six));
        return lists;
    }
}
