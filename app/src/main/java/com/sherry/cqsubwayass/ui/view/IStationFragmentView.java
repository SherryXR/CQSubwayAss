package com.sherry.cqsubwayass.ui.view;

import com.sherry.cqsubwayass.ui.adapter.StationRvAdapter;

/**
 * Created by Sherry on 2018/4/13.
 */

public interface IStationFragmentView {

    void showRv();

    void toSubwayLine(StationRvAdapter adapter);
}
