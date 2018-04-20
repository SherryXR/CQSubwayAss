package com.sherry.cqsubwayass.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.app.BaseActivty;
import com.sherry.cqsubwayass.model.bean.StationBean;
import com.sherry.cqsubwayass.model.callback.OnItemClickListener;
import com.sherry.cqsubwayass.ui.adapter.StationInfoAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StationInfoActivity extends BaseActivty implements OnItemClickListener{

    @BindView(R.id.guide_back)
    ImageView back;
    @BindView(R.id.toolbar_title)
    TextView title;
    @BindView(R.id.station_info_name)
    TextView name;
    @BindView(R.id.station_info_time)
    TextView time;
    @BindView(R.id.station_info_rv)
    RecyclerView rv;
    private StationInfoAdapter adapter;

    private StationBean stationBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_info);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        stationBean = (StationBean) intent.getSerializableExtra("stationInfo");
        rv.setLayoutManager(new LinearLayoutManager(this));
        name.setText(stationBean.getName());
        title.setText("站点信息");
        time.setText(stationBean.getBegin_time()+"-------"+stationBean.getLast_time());
        adapter = new StationInfoAdapter(stationBean);
        rv.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (view.getId()){
            case R.id.guide_back:
                finish();
                break;

        }
    }
}
