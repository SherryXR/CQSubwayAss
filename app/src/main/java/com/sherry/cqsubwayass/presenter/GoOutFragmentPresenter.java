package com.sherry.cqsubwayass.presenter;

import android.content.Context;

import com.sherry.cqsubwayass.model.ISubwayInfo;
import com.sherry.cqsubwayass.model.impl.SubwayInfoModel;
import com.sherry.cqsubwayass.ui.view.IGoOutFragmentView;

/**
 * Created by Sherry on 2018/4/11.
 */

public class GoOutFragmentPresenter {
    private Context context;

    private IGoOutFragmentView iGoOutFragmentView;

    public GoOutFragmentPresenter(Context context, IGoOutFragmentView iGoOutFragmentView) {
        this.context = context;
        this.iGoOutFragmentView = iGoOutFragmentView;
    }


    public void configMap(){
        iGoOutFragmentView.showMap();
    }

    public void tendToLineActivity(){
        iGoOutFragmentView.toLineActivity();
    }
}
