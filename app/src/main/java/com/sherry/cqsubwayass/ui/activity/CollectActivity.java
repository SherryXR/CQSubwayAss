package com.sherry.cqsubwayass.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.ICollect;
import com.sherry.cqsubwayass.model.IFindBean;
import com.sherry.cqsubwayass.model.bean.FindBean;
import com.sherry.cqsubwayass.model.bmob.Collect;
import com.sherry.cqsubwayass.model.bmob.User;
import com.sherry.cqsubwayass.model.callback.BaseCallBack;
import com.sherry.cqsubwayass.model.callback.LoadFindInfoCallBack;
import com.sherry.cqsubwayass.model.callback.OnItemClickListener;
import com.sherry.cqsubwayass.model.impl.CollectModel;
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
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class CollectActivity extends AppCompatActivity {

    @BindView(R.id.guide_back_left)
    ImageView guideBackLeft;
    @BindView(R.id.toolbar_title_left)
    TextView toolbarTitleLeft;
    @BindView(R.id.collect)
    RecyclerView collect;
    private FindShowAdapter adapter;
    private ICollect iCollect;
    private List<FindBean> lists = new ArrayList<>();
    private List<String> collectList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        ButterKnife.bind(this);
        iCollect = new CollectModel(CollectActivity.this);
        toolbarTitleLeft.setText("个人收藏");
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL );
        //通过布局管理器控制条目排列的顺序  true:反向显示 false:正向显示
        staggeredGridLayoutManager.setReverseLayout(false);
        collect.setLayoutManager(staggeredGridLayoutManager);
        DialogUtils.onProcess(CollectActivity.this,"温馨提示","正在加载数据....");
        loadData();

     }


    @OnClick(R.id.guide_back_left)
    public void onViewClicked() {
        finish();
    }

    private void loadData(){
        iCollect.getColelct(new BaseCallBack<List<FindBean>>() {
            @Override
            public void onSuccess(final List<FindBean> bean) {
                adapter = new FindShowAdapter(bean);
                collect.setAdapter(adapter);
                adapter.setOnItemClickLitener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(CollectActivity.this, FindInfoActivity.class);
                        intent.putExtra("findScreen",bean.get(position));
                        startActivity(intent);
                    }
                });
                DialogUtils.dissmissProcess();
            }

            @Override
            public void onFailure(String error) {
                Toast.makeText(CollectActivity.this,error,Toast.LENGTH_SHORT).show();
                DialogUtils.dissmissProcess();

            }
        });

    }
}
