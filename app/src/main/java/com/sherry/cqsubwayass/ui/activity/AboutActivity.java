package com.sherry.cqsubwayass.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.app.BaseActivty;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AboutActivity extends BaseActivty {

    @BindView(R.id.guide_back_left)
    ImageView guideBackLeft;
    @BindView(R.id.toolbar_title_left)
    TextView toolbarTitleLeft;
    @BindView(R.id.about_update)
    RelativeLayout aboutUpdate;
    @BindView(R.id.about_introduce)
    RelativeLayout aboutIntroduce;
    @BindView(R.id.about_us)
    RelativeLayout aboutUs;
    private MaterialDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ButterKnife.bind(this);
        toolbarTitleLeft.setText("关于我们");
        dialog = new MaterialDialog.Builder(this)
                .cancelable(true)
                .build();
    }

    @OnClick({R.id.guide_back_left, R.id.about_update, R.id.about_introduce, R.id.about_us})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.guide_back_left:
                finish();
                break;
            case R.id.about_update:
                Toast.makeText(AboutActivity.this,"暂无更新~",Toast.LENGTH_SHORT).show();
                break;
            case R.id.about_introduce:
                dialog.setTitle("功能说明");
                dialog.setContent("1.可随时查看各线路站点信息。\\n2.可为你定制最优出行路线。\\n3.根据输入站点,可了解该站点的详细情况");
                dialog.show();
                break;
            case R.id.about_us:
                dialog.setTitle("联系我们");
                dialog.setContent("SherryMiss@126.com");
                dialog.show();
                break;
        }
    }

}
