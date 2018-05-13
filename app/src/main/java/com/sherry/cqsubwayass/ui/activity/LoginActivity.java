package com.sherry.cqsubwayass.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.app.BaseActivty;
import com.sherry.cqsubwayass.model.bmob.User;
import com.sherry.cqsubwayass.model.callback.DialogDataCallBack;
import com.sherry.cqsubwayass.model.callback.LoadFindInfoCallBack;
import com.sherry.cqsubwayass.utils.DialogUtils;
import com.sherry.cqsubwayass.utils.UserUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;

public class LoginActivity extends BaseActivty implements View.OnClickListener{

    @BindView(R.id.guide_back)
    ImageView back;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.login_email_edit)
    EditText loginEmailEdit;
    @BindView(R.id.login_password_edit)
    EditText loginPasswordEdit;
    @BindView(R.id.login_btn)
    Button loginBtn;
    @BindView(R.id.login_forget_password)
    TextView loginForgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        back.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        loginForgetPassword.setOnClickListener(this);
        toolbarTitle.setText("邮箱登录");

    }

    private void initData() {
        Log.d("LOGIN---->","执行initData");

        BmobUser.loginByAccount(loginEmailEdit.getText().toString(), loginPasswordEdit.getText().toString(), new LogInListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if(e==null){
                    DialogUtils.dissmissProcess();
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    UserUtils.putName(LoginActivity.this,(String) BmobUser.getObjectByKey("username"));
                    UserUtils.putEmail(LoginActivity.this,(String) BmobUser.getObjectByKey("email"));
                    UserUtils.putHeardImage(LoginActivity.this,(String) BmobUser.getObjectByKey("headImage"));
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);

                }else {
                    Log.d("LOGIN---->","user 等于空" +e.toString());
                    Toast.makeText(LoginActivity.this,"账号或密码填写错误",Toast.LENGTH_SHORT).show();
                    DialogUtils.dissmissProcess();

                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.guide_back:
                finish();
                break;
            case R.id.login_forget_password:
                DialogUtils.oneEditDialog(LoginActivity.this, "忘记密码", 1, new DialogDataCallBack() {
                    @Override
                    public void onPositive(String message) {

                    }

                    @Override
                    public void onNeigitive() {

                    }
                });
                break;
            case R.id.login_btn:
                DialogUtils.onProcess(LoginActivity.this,"提示","登陆中,请稍等...");
                initData();
                break;
        }
    }
}
