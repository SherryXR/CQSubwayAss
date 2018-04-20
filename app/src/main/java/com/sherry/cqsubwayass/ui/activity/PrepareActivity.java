package com.sherry.cqsubwayass.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.bmob.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;


public class PrepareActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.prepare_toLogin)
    Button prepareToLogin;
    @BindView(R.id.prepare_toRegister)
    Button prepareToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare);
        User bmobUser = BmobUser.getCurrentUser(User.class);
        if (bmobUser !=null){
            Intent intent = new Intent(PrepareActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            ButterKnife.bind(this);
            prepareToLogin.setOnClickListener(this);
            prepareToRegister.setOnClickListener(this);
        }



    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.prepare_toLogin:
                Intent toLogin = new Intent(PrepareActivity.this,LoginActivity.class);
                startActivity(toLogin);
                break;
            case R.id.prepare_toRegister:
                Intent toRegister = new Intent(PrepareActivity.this,RegisterActivity.class);
                startActivity(toRegister);
                break;
        }
    }
}
