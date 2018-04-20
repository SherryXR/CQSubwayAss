package com.sherry.cqsubwayass.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.IFindBean;
import com.sherry.cqsubwayass.model.bean.FindBean;
import com.sherry.cqsubwayass.model.callback.LoadFindInfoCallBack;
import com.sherry.cqsubwayass.model.callback.OnItemClickListener;
import com.sherry.cqsubwayass.model.impl.FindBeanModel;
import com.sherry.cqsubwayass.ui.adapter.FindShowAdapter;
import com.sherry.cqsubwayass.utils.DialogUtils;
import com.sherry.cqsubwayass.utils.StringSplit;
import com.sherry.cqsubwayass.utils.UserUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectActivity extends AppCompatActivity {

    @BindView(R.id.guide_back_left)
    ImageView guideBackLeft;
    @BindView(R.id.toolbar_title_left)
    TextView toolbarTitleLeft;
    @BindView(R.id.collect)
    RecyclerView collect;
    private FindShowAdapter adapter;
    private IFindBean iFindBean;
    private List<FindBean> lists = new ArrayList<>();
    private List<String> collectList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        ButterKnife.bind(this);
        iFindBean = new FindBeanModel(CollectActivity.this);
        toolbarTitleLeft.setText("个人收藏");
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL );
        //通过布局管理器控制条目排列的顺序  true:反向显示 false:正向显示
        staggeredGridLayoutManager.setReverseLayout(false);
        collect.setLayoutManager(staggeredGridLayoutManager);
        DialogUtils.onProcess(CollectActivity.this,"温馨提示","正在加载数据....");
        collectList= StringSplit.PraseCollect(UserUtils.getCollect(CollectActivity.this));
        iFindBean.loadAllData(new LoadFindInfoCallBack() {
            @Override
            public void onSuccess(final List<FindBean> list) {

                for (int i= 0;i<list.size();i++){
                    for (int j =0;j<collectList.size();j++){
                        if (collectList.get(j).equals(list.get(i).getTitle())){
                            lists.add(list.get(i));
                        }
                    }
                }
                adapter = new FindShowAdapter(lists);

                adapter.setOnItemClickLitener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(CollectActivity.this, FindInfoActivity.class);
                        intent.putExtra("findScreen",lists.get(position));
                        startActivity(intent);
                    }
                });
                DialogUtils.dissmissProcess();

                collect.setAdapter(adapter);
            }

            @Override
            public void onFailure(String erro) {
                DialogUtils.dissmissProcess();

            }
        });


     }


    @OnClick(R.id.guide_back_left)
    public void onViewClicked() {
        finish();
    }
}
