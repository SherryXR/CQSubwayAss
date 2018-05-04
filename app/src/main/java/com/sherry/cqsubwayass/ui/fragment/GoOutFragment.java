package com.sherry.cqsubwayass.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.presenter.GoOutFragmentPresenter;
import com.sherry.cqsubwayass.ui.activity.GuideActivity;
import com.sherry.cqsubwayass.ui.view.IGoOutFragmentView;


/**
 * Created by Sherry on 2018/4/8.
 */

public class GoOutFragment extends Fragment implements IGoOutFragmentView{
    //private MapView mapView;
    private CardView search;
    //static BaiduMap mBaiduMap;
    private GoOutFragmentPresenter goOutFragmentPresenter;

    private WebView webView;
    private WebSettings webSettings;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_go_out,null);
        //MapView.setMapCustomEnable(true);
        initView(view);
        goOutFragmentPresenter = new GoOutFragmentPresenter(getActivity(),this);
        goOutFragmentPresenter.configMap();
        return view;
    }

    private void initView(View view){
        //mapView = view.findViewById(R.id.bmapView);
        webView =view.findViewById(R.id.bmapView);
        search = view.findViewById(R.id.search_cd);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goOutFragmentPresenter.tendToLineActivity();
            }
        });


    }

    @Override
    public void toLineActivity() {
        Intent toLineActivity =new Intent(getActivity(), GuideActivity.class);
        startActivity(toLineActivity);
    }

    @Override
    public void showMap() {
//        LatLng cenpt = new LatLng(29.57,106.55 );
//        mBaiduMap = mapView.getMap();
//        MapStatus mMapStatus = new MapStatus.Builder()//定义地图状态
//                .target(cenpt)
//                .zoom(15)
//                .build();  //定义MapStatusUpdate对象，以便描述地图状态将要发生的变化
//        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
//        mBaiduMap.setMapStatus(mMapStatusUpdate);
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setDomStorageEnabled(true);
        webView.loadUrl("file:///android_asset/cq_map.html");
//        webView.loadUrl("http://www.baidu.com");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setSupportZoom(true);
//        webView.getSettings().setUseWideViewPort(true);
//        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        webView.getSettings().setLoadWithOverviewMode(true);
    }
}
