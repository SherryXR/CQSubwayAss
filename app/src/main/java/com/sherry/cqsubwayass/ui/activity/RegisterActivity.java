package com.sherry.cqsubwayass.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.app.BaseActivty;
import com.sherry.cqsubwayass.config.Contants;
import com.sherry.cqsubwayass.model.bmob.User;
import com.sherry.cqsubwayass.model.callback.RegisterCallBack;
import com.sherry.cqsubwayass.presenter.RegisterActivityPresenter;
import com.sherry.cqsubwayass.ui.view.IRegisterActivityView;
import com.sherry.cqsubwayass.utils.DialogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

public class RegisterActivity extends BaseActivty implements IRegisterActivityView,View.OnClickListener{


    @BindView(R.id.guide_back)
    ImageView back;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.register_name_edit)
    EditText registerNameEdit;
    @BindView(R.id.register_email_edit)
    EditText registerEmailEdit;
//    @BindView(R.id.register_email_test)
//    Button registerEmailTest;
    @BindView(R.id.register_password_edit)
    EditText registerPasswordEdit;
    @BindView(R.id.register_password_image2)
    ImageView registerPasswordImage2;
    @BindView(R.id.register_password_edit2)
    EditText registerPasswordEdit2;
    @BindView(R.id.register_btn)
    Button registerBtn;

    private boolean isClickTest= false;
    private RegisterActivityPresenter registerActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        registerBtn.setOnClickListener(this);
//        registerEmailTest.setOnClickListener(this);
        toolbarTitle.setText("邮箱注册");
        registerActivityPresenter = new RegisterActivityPresenter(this,RegisterActivity.this);
    }

    @Override
    public void loadEditTestData(RegisterCallBack registerCallBack) {
        User user = new User();
        user.setUsername(registerNameEdit.getText().toString());
        if (registerPasswordEdit2.getText().toString().equals(registerPasswordEdit.getText().toString())){
            user.setPassword(registerPasswordEdit2.getText().toString());
        }else {
            registerCallBack.onErro("两次输入密码不一致！");
        }
        user.setEmail(registerEmailEdit.getText().toString());
        user.setHeadImage(Contants.head_image);
        registerCallBack.onSuccess(user);
    }

    @Override
    public void showRegisterErro(String messge) {
        Toast.makeText(RegisterActivity.this,messge,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void compileRegister(User user) {
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(User s, BmobException e) {
                if(e==null){
                    DialogUtils.dissmissProcess();
                    Toast.makeText(RegisterActivity.this,"注册成功!",Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    DialogUtils.dissmissProcess();
                    Toast.makeText(RegisterActivity.this,"注册失败"+e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void testEmail() {
        BmobUser.requestEmailVerify(registerEmailEdit.getText().toString(), new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if(e==null){
                    Toast.makeText(RegisterActivity.this,"请求验证邮件成功，请到" + registerEmailEdit.getText().toString() + "邮箱中进行激活!",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegisterActivity.this,"邮箱发送失败" ,Toast.LENGTH_SHORT).show();

                }
            }
        });
//        registerEmailTest.setBackgroundColor(getResources().getColor(R.color.grey_light));
//        registerEmailTest.setClickable(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_btn:
                DialogUtils.onProcess(RegisterActivity.this,"提示","正在注册,请稍等......");
                registerActivityPresenter.registerAccount();
                break;
//            case R.id.register_email_test:
//                isClickTest = true;
//                registerActivityPresenter.EmailTest();
//                break;
            case R.id.guide_back:
                finish();
                break;
        }
    }
}
