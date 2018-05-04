package com.sherry.cqsubwayass.model.impl;

import android.content.Context;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.ICollect;
import com.sherry.cqsubwayass.model.bean.FindBean;
import com.sherry.cqsubwayass.model.bmob.Collect;
import com.sherry.cqsubwayass.model.bmob.User;
import com.sherry.cqsubwayass.model.bmob._Article;
import com.sherry.cqsubwayass.model.callback.BaseCallBack;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Aaron Liu on 2018/5/4
 * <p>
 * Function:
 */
public class CollectModel implements ICollect {

    private Context context;
    private List<FindBean> findBeanList = new ArrayList<>();
    public CollectModel(Context context){
        this.context = context;
    }


    @Override
    public void postCollect(String id, final BaseCallBack<String> callBack) {
        User user = BmobUser.getCurrentUser(User.class);
        _Article article = new _Article();
        article.setObjectId(id);
        final Collect collect = new Collect();
        collect.setAuthor(user);
        collect.setFind(article);
        collect.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    callBack.onSuccess("收藏成功");
                }else{
                    callBack.onFailure("失败："+e.getMessage());
                }
            }

        });
    }

    @Override
    public void cancelCollect(String id, final BaseCallBack<String> callBack) {
        Collect collect = new Collect();
        collect.setObjectId(id);
        collect.delete(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    callBack.onSuccess("取消收藏成功");
                }else{
                    callBack.onFailure("失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }

    @Override
    public void getColelct(final BaseCallBack<List<FindBean>>  callBack) {
        User user = BmobUser.getCurrentUser(User.class);
        BmobQuery<Collect> query = new BmobQuery<Collect>();
        query.addWhereEqualTo("author", user);
        query.include("author,find");
        query.findObjects(new FindListener<Collect>() {

            @Override
            public void done(List<Collect> object, BmobException e) {
                if(e==null){

                    for (int i=0;i<object.size();i++) {
                        if (object.get(i).getFind().getTitle().equals("洪崖洞")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.hyd1);
                            findBean.addImage(R.mipmap.hyd2);
                            findBean.addImage(R.mipmap.hyd3);
                            findBean.addImage(R.mipmap.hyd4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setMessage(context.getResources().getString(R.string.hyd));
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setCollectID(object.get(i).getObjectId());
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("磁器口")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.cqk1);
                            findBean.addImage(R.mipmap.cqk2);
                            findBean.addImage(R.mipmap.cqk3);
                            findBean.addImage(R.mipmap.cqk4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setCollectID(object.get(i).getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.cqk));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("长江索道")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.cjsd1);
                            findBean.addImage(R.mipmap.cjsd2);
                            findBean.addImage(R.mipmap.cjsd3);
                            findBean.addImage(R.mipmap.cjsd4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setCollectID(object.get(i).getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.cjsd));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("解放碑")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.jfb1);
                            findBean.addImage(R.mipmap.jfb2);
                            findBean.addImage(R.mipmap.jfb3);
                            findBean.addImage(R.mipmap.jfb4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setCollectID(object.get(i).getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.jfb));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("南山一棵树")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.yks1);
                            findBean.addImage(R.mipmap.yks2);
                            findBean.addImage(R.mipmap.yks3);
                            findBean.addImage(R.mipmap.yks4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setCollectID(object.get(i).getObjectId());

                            findBean.setMessage(context.getResources().getString(R.string.nsyks));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("山城第三步道")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.scbd1);
                            findBean.addImage(R.mipmap.scbd2);
                            findBean.addImage(R.mipmap.scbd3);
                            findBean.addImage(R.mipmap.scbd4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setCollectID(object.get(i).getObjectId());

                            findBean.setMessage(context.getResources().getString(R.string.scdsbd));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("四川美术学院")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.cm1);
                            findBean.addImage(R.mipmap.cm2);
                            findBean.addImage(R.mipmap.cm3);
                            findBean.addImage(R.mipmap.cm4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setCollectID(object.get(i).getObjectId());

                            findBean.setMessage(context.getResources().getString(R.string.cm));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("朝天门")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.ctm1);
                            findBean.addImage(R.mipmap.ctm1);
                            findBean.addImage(R.mipmap.ctm3);
                            findBean.addImage(R.mipmap.ctm4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setCollectID(object.get(i).getObjectId());

                            findBean.setMessage(context.getResources().getString(R.string.ctm));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("李子坝站")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.lzb1);
                            findBean.addImage(R.mipmap.lzb2);
                            findBean.addImage(R.mipmap.lzb3);
                            findBean.addImage(R.mipmap.lzb4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setCollectID(object.get(i).getObjectId());

                            findBean.setMessage(context.getResources().getString(R.string.lzb));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("皇冠大扶梯")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.dft1);
                            findBean.addImage(R.mipmap.dft2);
                            findBean.addImage(R.mipmap.dft3);
                            findBean.addImage(R.mipmap.dft4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setCollectID(object.get(i).getObjectId());

                            findBean.setMessage(context.getResources().getString(R.string.dft));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("美心洋人街公园")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.yrj1);
                            findBean.addImage(R.mipmap.yrj2);
                            findBean.addImage(R.mipmap.yrj3);
                            findBean.addImage(R.mipmap.yrj4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setCollectID(object.get(i).getObjectId());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setMessage(context.getResources().getString(R.string.yrj));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("下浩老街")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.xhlj1);
                            findBean.addImage(R.mipmap.xhlj2);
                            findBean.addImage(R.mipmap.xhlj3);
                            findBean.addImage(R.mipmap.xhlj4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setId(object.get(i).getFind().getObjectId());

                            findBean.setCollectID(object.get(i).getObjectId());

                            findBean.setMessage(context.getResources().getString(R.string.xhlj));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("南山植物园")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.zwy1);
                            findBean.addImage(R.mipmap.zwy2);
                            findBean.addImage(R.mipmap.zwy3);
                            findBean.addImage(R.mipmap.zwy4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setCollectID(object.get(i).getObjectId());
                            findBean.setMessage(context.getResources().getString(R.string.zwy));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("重庆动物园")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.dwy1);
                            findBean.addImage(R.mipmap.dwy2);
                            findBean.addImage(R.mipmap.dwy3);
                            findBean.addImage(R.mipmap.dwy4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setCollectID(object.get(i).getObjectId());

                            findBean.setMessage(context.getResources().getString(R.string.dwy));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("重庆园博园")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.yby1);
                            findBean.addImage(R.mipmap.yby2);
                            findBean.addImage(R.mipmap.yby3);
                            findBean.addImage(R.mipmap.yby4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setCollectID(object.get(i).getObjectId());

                            findBean.setMessage(context.getResources().getString(R.string.yby));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("南滨路")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.nbl1);
                            findBean.addImage(R.mipmap.nbl2);
                            findBean.addImage(R.mipmap.nbl3);
                            findBean.addImage(R.mipmap.nbl4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setCollectID(object.get(i).getObjectId());

                            findBean.setMessage(context.getResources().getString(R.string.nbl));
                            findBeanList.add(findBean);
                            continue;
                        }
                        if (object.get(i).getFind().getTitle().equals("三峡博物馆")){
                            FindBean findBean = new FindBean();
                            findBean.addImage(R.mipmap.sxbwg1);
                            findBean.addImage(R.mipmap.sxbwg2);
                            findBean.addImage(R.mipmap.sxbwg3);
                            findBean.addImage(R.mipmap.sxbwg4);
                            findBean.setUrl(object.get(i).getFind().getUrl());
                            findBean.setId(object.get(i).getFind().getObjectId());
                            findBean.setTitle(object.get(i).getFind().getTitle());
                            findBean.setCollectID(object.get(i).getObjectId());

                            findBean.setMessage(context.getResources().getString(R.string.bwg));
                            findBeanList.add(findBean);
                            continue;
                        }
                    }

                    callBack.onSuccess(findBeanList);

                }else{
                    callBack.onFailure("收藏加载失败");
                }
            }

        });
    }
}
