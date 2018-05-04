package com.sherry.cqsubwayass.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.sherry.cqsubwayass.model.IFindBean;
import com.sherry.cqsubwayass.model.bean.FindBean;
import com.sherry.cqsubwayass.model.callback.DialogDataCallBack;
import com.sherry.cqsubwayass.model.callback.FirstLoadDataCallback;
import com.sherry.cqsubwayass.model.callback.LoadFindInfoCallBack;
import com.sherry.cqsubwayass.model.callback.OnItemClickListener;
import com.sherry.cqsubwayass.model.impl.FindBeanModel;
import com.sherry.cqsubwayass.ui.activity.FindInfoActivity;
import com.sherry.cqsubwayass.ui.adapter.FindShowAdapter;
import com.sherry.cqsubwayass.ui.view.IFindFragmetView;
import com.sherry.cqsubwayass.utils.DialogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sherry on 2018/4/15.
 */

public class FindFragmentPresenter {

    private IFindFragmetView iFindFragmetView;
    private IFindBean iFindBean;
    private Context context;
    private FindShowAdapter adapter;
    public FindFragmentPresenter(IFindFragmetView iFindFragmetView, Context context) {
        this.iFindFragmetView = iFindFragmetView;
        this.context = context;
        iFindBean = new FindBeanModel(context);
    }

    public void showData(final RecyclerView rv){

        DialogUtils.onProcess(context,"温馨提示","正在加载数据....");
        iFindBean.loadAllData(new LoadFindInfoCallBack() {
            @Override
            public void onSuccess(final List<FindBean> lists) {
                adapter = new FindShowAdapter(lists);
                adapter.setOnItemClickLitener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(context, FindInfoActivity.class);
                        intent.putExtra("findScreen",lists.get(position));
                        context.startActivity(intent);
                    }
                });
                DialogUtils.dissmissProcess();
                iFindFragmetView.setRv();
                rv.setAdapter(adapter);
            }

            @Override
            public void onFailure(String erro) {
                DialogUtils.dissmissProcess();

            }
        });


    }
}
