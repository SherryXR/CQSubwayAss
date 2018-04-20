package com.sherry.cqsubwayass.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import com.sherry.cqsubwayass.model.bean.FindBean;
import com.sherry.cqsubwayass.model.bmob.User;
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
    ImageView findInfoCollect;

    private boolean isCollect =false;
    private WebSettings webSettings;
    private List<String> collects = new ArrayList<>();


    private FindBean findBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_info);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        findBean = (FindBean)intent.getSerializableExtra("findScreen");
        toolbarTitleLeft.setText(findBean.getTitle());
        collects= StringSplit.PraseCollect(UserUtils.getCollect(FindInfoActivity.this));
        for (int i =0;i<collects.size();i++){
            if (collects.get(i).equals(findBean.getTitle())){
                isCollect =true;
                break;
            }
        }

        if (isCollect){
            findInfoCollect.setImageResource(R.mipmap.ic_collected);
        }

        findInfoCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCollect){
                    findInfoCollect.setImageResource(R.mipmap.ic_collected_unselect);
                    String str = "";
                    for (int i =0;i<collects.size();i++){
                        if(collects.get(i).equals(findBean.getTitle())){

                        }else {
                            str = str+","+collects.get(i);
                        }
                    }
                    UserUtils.putCollect(FindInfoActivity.this,str);
                    User newUser = new User();
                    newUser.setCollect(str);
                    BmobUser bmobUser = BmobUser.getCurrentUser(User.class);
                    newUser.update(bmobUser.getObjectId(),new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if(e==null){
                                Toast.makeText(FindInfoActivity.this,"已取消收藏",Toast.LENGTH_SHORT).show();
                            }else{
                            }
                        }
                    });
                }else {
                    findInfoCollect.setImageResource(R.mipmap.ic_collected);
                    String str = UserUtils.getCollect(FindInfoActivity.this)+","+findBean.getTitle();

                    UserUtils.putCollect(FindInfoActivity.this,str);
                    User newUser = new User();
                    newUser.setCollect(str);
                    BmobUser bmobUser = BmobUser.getCurrentUser(User.class);
                    newUser.update(bmobUser.getObjectId(),new UpdateListener() {
                        @Override
                        public void done(BmobException e) {
                            if(e==null){
                                Toast.makeText(FindInfoActivity.this,"已收藏",Toast.LENGTH_SHORT).show();
                            }else{
                            }
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


    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.with(context).load((Integer) path).into(imageView);
        }
    }
}
