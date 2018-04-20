package com.sherry.cqsubwayass.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.app.BaseActivty;
import com.sherry.cqsubwayass.model.bean.StationBean;
import com.sherry.cqsubwayass.model.callback.OnItemClickListener;
import com.sherry.cqsubwayass.presenter.SubwayLineActivityPresenter;
import com.sherry.cqsubwayass.ui.adapter.SubwayLineAdapter;
import com.sherry.cqsubwayass.ui.view.ISubwayLineActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubwayLineActivity extends BaseActivty implements ISubwayLineActivity{

    @BindView(R.id.subway_line_name)
    TextView subway_line_name;
    @BindView(R.id.subway_line_rv)
    RecyclerView  subway_line_rv;
    private int num;

    private SubwayLineActivityPresenter subwayLineActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway_line);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        num = intent.getIntExtra("subwayLine",500);
        subwayLineActivityPresenter = new SubwayLineActivityPresenter(this,this,num);
        subwayLineActivityPresenter.loadStation(subway_line_rv);
    }

    @Override
    public void showRv() {
        subway_line_rv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void setType() {
        switch (num){
            case 0:
                subway_line_name.setText(getResources().getText(R.string.subway_one));
                break;
            case 1:
                subway_line_name.setText(getResources().getText(R.string.subway_two));
                break;
            case 2:
                subway_line_name.setText(getResources().getText(R.string.subway_three));
                break;
            case 3:
                subway_line_name.setText(getResources().getText(R.string.subway_five));
                break;
            case 4:
                subway_line_name.setText(getResources().getText(R.string.subway_six));
                break;
            case 5:
                subway_line_name.setText(getResources().getText(R.string.subway_ten));
                break;
            case 6:
                subway_line_name.setText(getResources().getText(R.string.subway_three_other));
                break;
            case 7:
                subway_line_name.setText(getResources().getText(R.string.subway_six_other));
                break;
            case 500:
                break;
        }
    }

    @Override
    public void tendToAStationInfoActivity(SubwayLineAdapter adapter, final List<StationBean> list) {
        adapter.setOnItemClickLitener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent =  new Intent(SubwayLineActivity.this, StationInfoActivity.class);
                intent.putExtra("stationInfo",list.get(position));
                startActivity(intent);
            }
        });
    }


}
