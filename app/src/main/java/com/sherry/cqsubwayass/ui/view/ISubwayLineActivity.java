package com.sherry.cqsubwayass.ui.view;

import com.sherry.cqsubwayass.model.bean.Station;
import com.sherry.cqsubwayass.model.bean.StationBean;
import com.sherry.cqsubwayass.ui.adapter.SubwayLineAdapter;

import java.util.List;

/**
 * Created by Sherry on 2018/4/13.
 */

public interface ISubwayLineActivity {

    void showRv();

    void setType();

    void tendToAStationInfoActivity(SubwayLineAdapter adapter, List<StationBean> lists);
}
