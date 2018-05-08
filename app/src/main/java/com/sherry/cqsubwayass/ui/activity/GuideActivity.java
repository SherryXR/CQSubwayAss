package com.sherry.cqsubwayass.ui.activity;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.app.BaseActivty;
import com.sherry.cqsubwayass.model.callback.OnItemClickListener;
import com.sherry.cqsubwayass.model.db.History;
import com.sherry.cqsubwayass.ui.adapter.GuideHistoryAdapter;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GuideActivity extends BaseActivty {

    @BindView(R.id.guide_back)
    ImageView guideBack;
    @BindView(R.id.guide_ok)
    ImageView guideOk;
    @BindView(R.id.guide_from_edt)
    AppCompatEditText guideFromEdt;
    @BindView(R.id.guide_drop)
    LinearLayout guideDrop;
    @BindView(R.id.guide_icon_divider)
    ImageView guideIconDivider;
    @BindView(R.id.guide_to)
    TextView guideTo;
    @BindView(R.id.guide_to_edt)
    AppCompatEditText guideToEdt;
    @BindView(R.id.guide_rv)
    RecyclerView guideRv;
    @BindView(R.id.guide_clear_data)
    RelativeLayout guideClearData;
    @BindView(R.id.activity_guide)
    LinearLayout activityGuide;
    private GuideHistoryAdapter guideHistoryAdapter;
    private List<History> historyList = new ArrayList<>();
    private String toStation = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);
        ButterKnife.bind(this);
        Intent intent =getIntent();
        toStation = intent.getStringExtra("screen");
        if (toStation.equals("")){

        }else {
            guideToEdt.setText(toStation);
        }
        initView();
        historyList.clear();
    }

    @OnClick({R.id.guide_back, R.id.guide_ok,R.id.guide_from_edt,R.id.guide_to_edt,R.id.guide_clear_data})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.guide_back:
                finish();
                break;
            case R.id.guide_ok:
                if (TextUtils.isEmpty(guideFromEdt.getText())){
                    Snackbar.make(view, "起点不能为空", Snackbar.LENGTH_SHORT)
                            .setAction("确定", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            }).show();
                }else if (TextUtils.isEmpty(guideToEdt.getText())){
                    Snackbar.make(view, "终点点不能为空", Snackbar.LENGTH_SHORT)
                            .setAction("确定", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                }
                            }).show();
                }else {
                    new History(guideFromEdt.getText().toString(),guideToEdt.getText().toString()).save();
                    Intent toResult = new Intent(GuideActivity.this,GuideShowAvitivty.class);
                    toResult.putExtra("from",guideFromEdt.getText().toString());
                    toResult.putExtra("to",guideToEdt.getText().toString());
                    startActivity(toResult);
                }

                break;
            case R.id.guide_clear_data:
                DataSupport.deleteAll(History.class);historyList.clear();
                historyList= DataSupport.findAll(History.class);
                if (historyList.size() != 0){
                    guideClearData.setVisibility(View.VISIBLE);
                }else {
                    guideClearData.setVisibility(View.GONE);
                }
                guideHistoryAdapter = new GuideHistoryAdapter(GuideActivity.this,historyList);
                guideRv.setAdapter(guideHistoryAdapter);

                break;
            case R.id.guide_from_edt:
                Intent fromDataIntent = new Intent(GuideActivity.this, EditStationActivity.class);
                fromDataIntent.putExtra("isFrom",true);
                startActivityForResult(fromDataIntent, 1000);
                break;
            case R.id.guide_to_edt:
                Intent toDataIntent = new Intent(GuideActivity.this, EditStationActivity.class);
                toDataIntent.putExtra("isFrom",false);
                startActivityForResult(toDataIntent, 1000);
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        historyList.clear();
        historyList= DataSupport.findAll(History.class);
        if (historyList.size() != 0){
            guideClearData.setVisibility(View.VISIBLE);


        }else {
            guideClearData.setVisibility(View.GONE);
        }
        guideHistoryAdapter = new GuideHistoryAdapter(GuideActivity.this,historyList);
        guideHistoryAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent toResult = new Intent(GuideActivity.this,GuideShowAvitivty.class);
                toResult.putExtra("from",historyList.get(position).getFrom());
                toResult.putExtra("to",historyList.get(position).getTo());
                startActivity(toResult);
            }
        });
        guideRv.setAdapter(guideHistoryAdapter);
    }

    private void initView(){
        guideRv.setLayoutManager(new LinearLayoutManager(GuideActivity.this));
        guideRv.setItemAnimator(new DefaultItemAnimator());
        guideFromEdt.setFocusable(false);
        guideToEdt.setFocusable(false);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000 && resultCode == 1003) {
            guideFromEdt.setText(data.getStringExtra("stationFrom"));
        } else if (requestCode == 1000 && resultCode == 1004){
            guideToEdt.setText(data.getStringExtra("stationTo"));
        }
    }
}


