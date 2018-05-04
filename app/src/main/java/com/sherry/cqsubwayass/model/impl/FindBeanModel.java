package com.sherry.cqsubwayass.model.impl;

import android.content.Context;
import android.util.Log;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.IFindBean;
import com.sherry.cqsubwayass.model.bean.FindBean;
import com.sherry.cqsubwayass.model.bmob._Article;
import com.sherry.cqsubwayass.model.callback.FirstLoadDataCallback;
import com.sherry.cqsubwayass.model.callback.LoadFindInfoCallBack;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Kevin Liu on 2018/4/15.
 */

public class FindBeanModel implements IFindBean {
    private List<FindBean> list = new ArrayList<>();
    private Context context;

    public FindBeanModel(Context context){
        this.context = context;
    }

    @Override
    public void loadAllData(final LoadFindInfoCallBack loadFindInfoCallBack) {

        BmobQuery<_Article> query = new BmobQuery<_Article>();
        query.setLimit(50);
        query.findObjects(new FindListener<_Article>() {
            @Override
            public void done(List<_Article> object, BmobException e) {
                if(e==null){
                    for (_Article article : object) {
                        if (article.getTitle().equals("洪崖洞")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.hyd1);
                            findBean.addImage(R.mipmap.hyd2);
                            findBean.addImage(R.mipmap.hyd3);
                            findBean.addImage(R.mipmap.hyd4);
                            findBean.setUrl(article.getUrl());
                            findBean.setMessage(context.getResources().getString(R.string.hyd));
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("磁器口")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.cqk1);
                            findBean.addImage(R.mipmap.cqk2);
                            findBean.addImage(R.mipmap.cqk3);
                            findBean.addImage(R.mipmap.cqk4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setMessage(context.getResources().getString(R.string.cqk));
                            findBean.setId(article.getObjectId());
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("长江索道")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.cjsd1);
                            findBean.addImage(R.mipmap.cjsd2);
                            findBean.addImage(R.mipmap.cjsd3);
                            findBean.addImage(R.mipmap.cjsd4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.cjsd));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("解放碑")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.jfb1);
                            findBean.addImage(R.mipmap.jfb2);
                            findBean.addImage(R.mipmap.jfb3);
                            findBean.addImage(R.mipmap.jfb4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.jfb));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("南山一棵树")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.yks1);
                            findBean.addImage(R.mipmap.yks2);
                            findBean.addImage(R.mipmap.yks3);
                            findBean.addImage(R.mipmap.yks4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.nsyks));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("山城第三步道")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.scbd1);
                            findBean.addImage(R.mipmap.scbd2);
                            findBean.addImage(R.mipmap.scbd3);
                            findBean.addImage(R.mipmap.scbd4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.scdsbd));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("四川美术学院")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.cm1);
                            findBean.addImage(R.mipmap.cm2);
                            findBean.addImage(R.mipmap.cm3);
                            findBean.addImage(R.mipmap.cm4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.cm));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("朝天门")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.ctm1);
                            findBean.addImage(R.mipmap.ctm1);
                            findBean.addImage(R.mipmap.ctm3);
                            findBean.addImage(R.mipmap.ctm4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.ctm));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("李子坝站")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.lzb1);
                            findBean.addImage(R.mipmap.lzb2);
                            findBean.addImage(R.mipmap.lzb3);
                            findBean.addImage(R.mipmap.lzb4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.lzb));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("皇冠大扶梯")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.dft1);
                            findBean.addImage(R.mipmap.dft2);
                            findBean.addImage(R.mipmap.dft3);
                            findBean.addImage(R.mipmap.dft4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.dft));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("美心洋人街公园")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.yrj1);
                            findBean.addImage(R.mipmap.yrj2);
                            findBean.addImage(R.mipmap.yrj3);
                            findBean.addImage(R.mipmap.yrj4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.yrj));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("下浩老街")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.xhlj1);
                            findBean.addImage(R.mipmap.xhlj2);
                            findBean.addImage(R.mipmap.xhlj3);
                            findBean.addImage(R.mipmap.xhlj4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.xhlj));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("南山植物园")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.zwy1);
                            findBean.addImage(R.mipmap.zwy2);
                            findBean.addImage(R.mipmap.zwy3);
                            findBean.addImage(R.mipmap.zwy4);
                            findBean.setUrl(article.getUrl());
                            findBean.setId(article.getObjectId());
                            findBean.setTitle(article.getTitle());
                            findBean.setMessage(context.getResources().getString(R.string.zwy));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("重庆动物园")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.dwy1);
                            findBean.addImage(R.mipmap.dwy2);
                            findBean.addImage(R.mipmap.dwy3);
                            findBean.addImage(R.mipmap.dwy4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.dwy));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("重庆园博园")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.yby1);
                            findBean.addImage(R.mipmap.yby2);
                            findBean.addImage(R.mipmap.yby3);
                            findBean.addImage(R.mipmap.yby4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setId(article.getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.yby));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("南滨路")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.nbl1);
                            findBean.addImage(R.mipmap.nbl2);
                            findBean.addImage(R.mipmap.nbl3);
                            findBean.setId(article.getObjectId());
                            findBean.addImage(R.mipmap.nbl4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setMessage(context.getResources().getString(R.string.nbl));
                            list.add(findBean);
                            continue;
                        }
                        if (article.getTitle().equals("三峡博物馆")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.sxbwg1);
                            findBean.addImage(R.mipmap.sxbwg2);
                            findBean.addImage(R.mipmap.sxbwg3);
                            findBean.setId(article.getObjectId());
                            findBean.addImage(R.mipmap.sxbwg4);
                            findBean.setUrl(article.getUrl());
                            findBean.setTitle(article.getTitle());
                            findBean.setMessage(context.getResources().getString(R.string.bwg));
                            list.add(findBean);
                            continue;
                        }
                    }

                    loadFindInfoCallBack.onSuccess(list);
                }else{
                    loadFindInfoCallBack.onFailure("加载失败");

                }
            }
        });
    }
}
