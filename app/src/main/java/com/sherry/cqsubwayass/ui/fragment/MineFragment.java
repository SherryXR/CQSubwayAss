package com.sherry.cqsubwayass.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.bmob.User;
import com.sherry.cqsubwayass.model.callback.DialogDataCallBack;
import com.sherry.cqsubwayass.ui.activity.AboutActivity;
import com.sherry.cqsubwayass.ui.activity.CollectActivity;
import com.sherry.cqsubwayass.ui.activity.MineActivity;
import com.sherry.cqsubwayass.utils.DialogUtils;
import com.sherry.cqsubwayass.utils.UserUtils;
import com.sherry.cqsubwayass.widget.CircleImageView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.bmob.v3.BmobUser;

/**
 * Created by Kevin Liu on 2018/4/8.
 */

public class MineFragment extends Fragment implements View.OnClickListener{

    private CircleImageView circleImageView;
    private TextView name;
    private TextView email;
    private RelativeLayout mine_info;
    private RelativeLayout mine_collect;
    private RelativeLayout mine_share;
    private RelativeLayout mine_clear;
    private RelativeLayout mine_about;
    private RelativeLayout mine_suggest;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null);
        initView(view);

        return view;
    }

    private void initView(View view) {
        circleImageView = view.findViewById(R.id.mine_heart_image);
        name = view.findViewById(R.id.mine_name);
        email = view.findViewById(R.id.mine_email);
        mine_info = view.findViewById(R.id.mine_info);
        mine_about= view.findViewById(R.id.mine_about);
        mine_clear = view.findViewById(R.id.mine_clear);
        mine_collect= view.findViewById(R.id.mine_collect);
        mine_share = view.findViewById(R.id.mine_share);
        mine_suggest = view.findViewById(R.id.mine_suggest);
        mine_info.setOnClickListener(this);
        mine_collect.setOnClickListener(this);

        mine_share.setOnClickListener(this);

        mine_clear.setOnClickListener(this);

        mine_about.setOnClickListener(this);
        mine_suggest.setOnClickListener(this);


    }

    @Override
    public void onResume() {
        super.onResume();
        name.setText(UserUtils.getName(getActivity()));
        email.setText(UserUtils.getEmail(getActivity()));
        //  Glide.with(getActivity()).load((String)BmobUser.getObjectByKey("headImage")).into(circleImageView);
        Picasso.with(getActivity()).load(UserUtils.getHeadImage(getActivity())).placeholder(R.mipmap.ic_boy).into(circleImageView);
        Log.d("FragmentMine---->","图片地址："+UserUtils.getHeadImage(getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mine_info:
                startActivity(new Intent(getActivity(), MineActivity.class));
                break;
            case R.id.mine_about:
                startActivity(new Intent(getActivity(), AboutActivity.class));

                break;
            case R.id.mine_clear:
                Toast.makeText(getActivity(),"清空垃圾啦~~",Toast.LENGTH_SHORT).show();
                break;
            case R.id.mine_collect:
                //Toast.makeText(getActivity(),"开发人员努力加工中..........",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), CollectActivity.class));
                break;
            case R.id.mine_share:
                Intent sendIntent = new Intent();
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
// 指定发送内容的类型
                sendIntent.setType("text/plain");
                sendIntent.setAction(Intent.ACTION_SEND);
                startActivity(sendIntent);
                break;
            case R.id.mine_suggest:
                DialogUtils.oneEditDialog(getActivity(), "意见反馈", 4, new DialogDataCallBack() {
                    @Override
                    public void onPositive(String message) {
                        Toast.makeText(getActivity(),"谢谢您的反馈,我会努力做的更好~",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onNeigitive() {

                    }
                });
                break;
        }
    }
}
