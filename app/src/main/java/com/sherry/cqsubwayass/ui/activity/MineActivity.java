package com.sherry.cqsubwayass.ui.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.app.BaseActivty;
import com.sherry.cqsubwayass.model.bmob.User;
import com.sherry.cqsubwayass.model.callback.DialogDataCallBack;
import com.sherry.cqsubwayass.utils.ActivityCollector;
import com.sherry.cqsubwayass.utils.DialogUtils;
import com.sherry.cqsubwayass.utils.SPUtils;
import com.sherry.cqsubwayass.utils.UserUtils;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;
import cn.bmob.v3.listener.UploadFileListener;

import static android.support.v4.app.ActivityCompat.requestPermissions;

public class MineActivity extends BaseActivty {

    @BindView(R.id.guide_back_left)
    ImageView guideBackLeft;
    @BindView(R.id.toolbar_title_left)
    TextView toolbarTitleLeft;
    @BindView(R.id.mine_change_heard_iamge)
    ImageView mineChangeHeardIamge;
    @BindView(R.id.mine_change_heard)
    RelativeLayout mineChangeHeard;
    @BindView(R.id.mine_change_name_text)
    TextView mineChangeNameText;
    @BindView(R.id.mine_change_name)
    RelativeLayout mineChangeName;
    @BindView(R.id.mine_change_email_text)
    TextView mineChangeEmailText;
    @BindView(R.id.mine_change_email)
    RelativeLayout mineChangeEmail;
    @BindView(R.id.mine_change_password)
    RelativeLayout mineChangePassword;
    @BindView(R.id.mine_sign_out)
    Button mineSignOut;

    private Bitmap head;// 头像Bitmap
    private static String path = "/sdcard/myHead/";// sd路径
    private String imagePath= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        toolbarTitleLeft.setText("个人信息");
        Picasso.with(MineActivity.this).load((String) BmobUser.getObjectByKey("headImage")).into(mineChangeHeardIamge);
        mineChangeNameText.setText((String) BmobUser.getObjectByKey("username"));
        mineChangeEmailText.setText((String) BmobUser.getObjectByKey("email"));
    }

    @OnClick({R.id.guide_back_left, R.id.mine_change_heard, R.id.mine_change_name, R.id.mine_change_email, R.id.mine_change_password, R.id.mine_sign_out})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.guide_back_left:
                finish();
                break;
            case R.id.mine_change_heard:
                if (Build.VERSION.SDK_INT >= 23) {
                    int REQUEST_CODE_CONTACT = 101;
                    String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                    //验证是否许可权限
                    for (String str : permissions) {
                        if (this.checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                            //申请权限
                            requestPermissions(permissions, REQUEST_CODE_CONTACT);
                            return;
                        }
                    }
                }
                showTypeDialog();
                break;
            case R.id.mine_change_name:
                DialogUtils.oneEditDialog(MineActivity.this, "重置昵称", 3, new DialogDataCallBack() {
                    @Override
                    public void onPositive(String message) {
                        UserUtils.putName(MineActivity.this,message);
                        mineChangeNameText.setText((String) BmobUser.getObjectByKey("username"));

                    }

                    @Override
                    public void onNeigitive() {

                    }
                });
                break;
            case R.id.mine_change_email:
                DialogUtils.oneEditDialog(MineActivity.this, "重置邮箱", 2, new DialogDataCallBack() {
                    @Override
                    public void onPositive(String message) {
                        UserUtils.putEmail(MineActivity.this,message);
                        mineChangeEmailText.setText((String) BmobUser.getObjectByKey("email"));
                    }

                    @Override
                    public void onNeigitive() {

                    }
                });

                break;
            case R.id.mine_change_password:
                setMineChangePassword();

                break;
            case R.id.mine_sign_out:
                showSignOutDialog();
                break;
        }
    }

    private void showTypeDialog() {

     Intent intent1 = new Intent(Intent.ACTION_PICK, null);
     //打开文件
     intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
     startActivityForResult(intent1, 1);

    }


    private void showSignOutDialog(){
        new MaterialDialog.Builder(MineActivity.this)
                .title("温馨提示")
                .content("是否要退出登录")
                .positiveText("确定")
                .negativeText("取消")
                .titleColor(getResources().getColor(R.color.colorPrimary))
                .backgroundColor(getResources().getColor(R.color.white))
                .positiveColor(getResources().getColor(R.color.colorPrimary))
                .negativeColor(getResources().getColor(R.color.grey_light))
                .cancelable(false)
                .theme(Theme.LIGHT)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        BmobUser.logOut();   //清除缓存用户对象
                        startActivity(new Intent(MineActivity.this,PrepareActivity.class));
                        ActivityCollector.finishAll();
                        SPUtils.clear(MineActivity.this);

                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {
                        super.onNegative(dialog);
                    }
                })
                .show();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {

                    cropPhoto(data.getData());// 裁剪图片
                }

                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    File temp = new File(Environment.getExternalStorageDirectory() + "/head.jpg");
                    cropPhoto(Uri.fromFile(temp));// 裁剪图片
                }

                break;
            case 3:
                DialogUtils.onProcess(MineActivity.this,"提示","正在上传图片");
                if (data != null) {
                    Bundle extras = data.getExtras();
                    head = extras.getParcelable("data");
                    if (head != null) {
                        /**
                         * 上传服务器代码
                         */
                        final BmobFile bmobFile = new BmobFile(new File(imagePath));
                        bmobFile.uploadblock(new UploadFileListener() {

                            @Override
                            public void done(BmobException e) {
                                if(e==null){
                                    //bmobFile.getFileUrl()--返回的上传文件的完整地址
                                    User newUser = new User();
                                    newUser.setHeadImage(bmobFile.getFileUrl());
                                    BmobUser bmobUser = BmobUser.getCurrentUser(User.class);
                                    newUser.update(bmobUser.getObjectId(),new UpdateListener() {
                                        @Override
                                        public void done(BmobException e) {
                                            if(e==null){
                                                DialogUtils.dissmissProcess();
                                                Toast.makeText(MineActivity.this,"更新用户信息成功",Toast.LENGTH_SHORT).show();
                                                UserUtils.putHeardImage(MineActivity.this,bmobFile.getFileUrl());

                                            }else{
                                                DialogUtils.dissmissProcess();
                                                Toast.makeText(MineActivity.this,"更新用户信息失败",Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }else{
                                    DialogUtils.dissmissProcess();
                                    Toast.makeText(MineActivity.this,"更新用户头像失败",Toast.LENGTH_SHORT).show();
                                }

                            }

                            @Override
                            public void onProgress(Integer value) {
                                // 返回的上传进度（百分比）
                            }
                        });
                        //setPicToView(head);// 保存在SD卡中
                        mineChangeHeardIamge.setImageBitmap(head);// 用ImageButton显示出来
                    }
                }
                break;
            default:
                break;

        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 调用系统的裁剪功能
     *
     * @param uri
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 250);
        intent.putExtra("outputY", 250);
        intent.putExtra("return-data", true);
        imagePath = getImagePath(uri,null);
        startActivityForResult(intent, 3);
    }

    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName = path + "head.jpg";// 图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getImagePath(Uri uri, String seletion) {
        String path = null;
        Cursor cursor = getContentResolver().query(uri, null, seletion, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            }
            cursor.close();

        }
        return path;
    }


    private void setMineChangePassword(){
        DialogUtils.UpdatePasswordDialog(MineActivity.this, new DialogDataCallBack() {
            @Override
            public void onPositive(String message) {

            }

            @Override
            public void onNeigitive() {

            }
        });
    }

}
