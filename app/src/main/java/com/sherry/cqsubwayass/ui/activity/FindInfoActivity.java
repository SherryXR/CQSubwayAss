package com.sherry.cqsubwayass.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.app.BaseActivty;
import com.sherry.cqsubwayass.model.ICollect;
import com.sherry.cqsubwayass.model.bean.FindBean;
import com.sherry.cqsubwayass.model.bmob.User;
import com.sherry.cqsubwayass.model.callback.BaseCallBack;
import com.sherry.cqsubwayass.model.impl.CollectModel;
import com.sherry.cqsubwayass.utils.StringSplit;
import com.sherry.cqsubwayass.utils.UserUtils;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class FindInfoActivity extends BaseActivty {

    @BindView(R.id.guide_back_left)
    ImageView guideBackLeft;
    @BindView(R.id.toolbar_title_left)
    TextView toolbarTitleLeft;
    @BindView(R.id.find_info_banner)
    Banner banner;
    @BindView(R.id.find_info_web)
    WebView findInfoWeb;
    @BindView(R.id.find_info_collect)
    FloatingActionButton findInfoCollect;

    private WebSettings webSettings;

    private boolean isCollected = false;
    private FindBean findBean;
    private ICollect iCollect;
    private String collectID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_info);
        ButterKnife.bind(this);
        iCollect = new CollectModel(FindInfoActivity.this);
        Intent intent = getIntent();
        findBean = (FindBean)intent.getSerializableExtra("findScreen");
        toolbarTitleLeft.setText(findBean.getTitle());
        loadCollect();
        findInfoCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCollected){
                    iCollect.cancelCollect(collectID, new BaseCallBack<String>() {
                        @Override
                        public void onSuccess(String bean) {
                            findInfoCollect.setImageResource(R.mipmap.ic_collected_unselect);
                            Toast.makeText(FindInfoActivity.this,"取消收藏成功",Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(String error) {
                            Toast.makeText(FindInfoActivity.this,"取消收藏失败",Toast.LENGTH_SHORT).show();

                        }
                    });
                }else {
                    iCollect.postCollect(findBean.getId(), new BaseCallBack<String>() {
                        @Override
                        public void onSuccess(String bean) {
                            findInfoCollect.setImageResource(R.mipmap.ic_collected);
                            Toast.makeText(FindInfoActivity.this,"收藏成功",Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onFailure(String error) {
                            Toast.makeText(FindInfoActivity.this,error,Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        });
        initBanner();
        initAWeb();

    }

    private void initBanner() {
        List<String> titleList = new ArrayList<>();
      //  Integer[] images={findBean.getImageLists().get(0),findBean.getImageLists().get(1),findBean.getImageLists().get(2),findBean.getImageLists().get(3)};
        titleList.add(findBean.getTitle());
        titleList.add(findBean.getTitle());
        titleList.add(findBean.getTitle());
        titleList.add(findBean.getTitle());
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器，图片加载器在下方
        banner.setImageLoader(new MyLoader());
        //设置图片网址或地址的集合
        banner.setImages(findBean.getImageLists());
        //设置轮播的动画效果，内含多种特效，可点入方法内查找后内逐一体验
        banner.setBannerAnimation(Transformer.Default);
        //设置轮播图的标题集合
        banner.setBannerTitles(titleList);
        //设置轮播间隔时间
        banner.setDelayTime(3000);
        //设置是否为自动轮播，默认是“是”。
        banner.isAutoPlay(true);
        //设置指示器的位置，小点点，左中右。
        banner.setIndicatorGravity(BannerConfig.RIGHT)
                //以上内容都可写成链式布局，这是轮播图的监听。比较重要。方法在下面。
                //必须最后调用的方法，启动轮播图。
                .start();
    }

    private void initAWeb() {
        webSettings = findInfoWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("utf-8");
        webSettings.setDomStorageEnabled(true);
        findInfoWeb.loadUrl(findBean.getUrl());
        findInfoWeb.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }

    @OnClick(R.id.guide_back_left)
    public void onViewClicked() {
        finish();
    }

    private void loadCollect(){
        iCollect.getColelct(new BaseCallBack<List<FindBean>>() {
            @Override
            public void onSuccess(List<FindBean> bean) {
                for (int i=0;i<bean.size();i++){
                    if (findBean.getId().equals(bean.get(i).getId())){
                        isCollected = true;
                        collectID = bean.get(i).getCollectID();
                        findInfoCollect.setImageResource(R.mipmap.ic_collected);
                    }
                }
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.with(context).load((Integer) path).into(imageView);
        }
    }
}
