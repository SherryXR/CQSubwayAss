package com.sherry.cqsubwayass.utils;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.sherry.cqsubwayass.R;
import com.sherry.cqsubwayass.model.bmob.User;
import com.sherry.cqsubwayass.model.callback.DialogDataCallBack;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Sherry on 2018/4/16.
 */

public class DialogUtils {

    private static MaterialDialog dialog;

    /**
     * 正在加载的动画效果
     * @param context
     * @param title
     * @param content
     */

    public static void onProcess(Context context,String title,String content){
        dialog= new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .titleColor(context.getResources().getColor(R.color.colorPrimary))
                .backgroundColor(context.getResources().getColor(R.color.white))
                .theme(Theme.LIGHT)
                .progress(true, 100)
                .cancelable(true)
                .show();
    }

    /***
     * 所有的取消
     */
    public static void dissmissProcess(){
        dialog.dismiss();
    }

    /**
     * 清除所有缓存
     * @param context
     */
    public static void ClearDataDialog(final Context context){
        dialog =new MaterialDialog.Builder(context)
                .title("温馨提示")
                .content("清除缓存后没网的状态下就看不到消息了哦~")
                .positiveText("没事")
                .negativeText("算了")
                .titleColor(context.getResources().getColor(R.color.colorPrimary))
                .backgroundColor(context.getResources().getColor(R.color.white))
                .positiveColor(context.getResources().getColor(R.color.colorPrimary))
                .negativeColor(context.getResources().getColor(R.color.grey_light))
                .cancelable(false)
                .theme(Theme.LIGHT)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {

                        Toast.makeText(context,"已经成功清除缓存", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {

                    }
                })
                .show();
    }


    /**
     * 重制密码
     * @param context
     */
    public static void UpdatePasswordDialog(final Context context, final DialogDataCallBack dialogDataCallBack){
        View UpdatePasswordView = LayoutInflater.from(context).inflate(R.layout.view_update_password, null);
        final AppCompatEditText oldPassword_edt = (AppCompatEditText) UpdatePasswordView.findViewById(R.id.update_password_old_password);
        final  AppCompatEditText newPassword_edt = (AppCompatEditText) UpdatePasswordView.findViewById(R.id.update_password_new_password);
        final  AppCompatEditText twoPassword_edt = (AppCompatEditText) UpdatePasswordView.findViewById(R.id.update_password_new_password_twice);
        new MaterialDialog.Builder(context)
                .title("修改密码")
                .customView(UpdatePasswordView, false)
                .positiveText("好了，我确定了~")
                .negativeText("算了，我不改了~")
                .titleColor(context.getResources().getColor(R.color.colorPrimary))
                .backgroundColor(context.getResources().getColor(R.color.white))
                .positiveColor(context.getResources().getColor(R.color.colorPrimary))
                .negativeColor(context.getResources().getColor(R.color.grey_light))
                .cancelable(false)
                .theme(Theme.LIGHT)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        String oldPassword = oldPassword_edt.getText().toString();
                        String newPassword = newPassword_edt.getText().toString();
                        String twoPassword = twoPassword_edt.getText().toString();
                        if (newPassword.equals(twoPassword)) {
                            BmobUser.updateCurrentUserPassword("旧密码", "新密码", new UpdateListener() {

                                @Override
                                public void done(BmobException e) {
                                    if(e==null){
                                        dialogDataCallBack.onPositive("");
                                        Toast.makeText(context,"密码修改成功，可以用新密码进行登录啦",Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(context,"密码修改失败",Toast.LENGTH_SHORT).show();
                                        dialogDataCallBack.onNeigitive();

                                    }
                                }

                            });
                        } else {
                            Toast.makeText(context,"两次的密码不正确",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public static void oneEditDialog(final Context context, String title, final int type, final DialogDataCallBack dialogDataCallBack){
        View dialog_one_edit = LayoutInflater.from(context).inflate(R.layout.diag_one_edit, null);
        final AppCompatEditText editText = (AppCompatEditText) dialog_one_edit.findViewById(R.id.diag_one_edit);
        new MaterialDialog.Builder(context)
                .title(title)
                .customView(dialog_one_edit, false)
                .positiveText("确定")
                .negativeText("取消")
                .titleColor(context.getResources().getColor(R.color.colorPrimary))
                .backgroundColor(context.getResources().getColor(R.color.white))
                .positiveColor(context.getResources().getColor(R.color.colorPrimary))
                .negativeColor(context.getResources().getColor(R.color.grey_light))
                .cancelable(false)
                .theme(Theme.LIGHT)
                .callback(new MaterialDialog.ButtonCallback() {
                    @Override
                    public void onPositive(MaterialDialog dialog) {
                        final String str = editText.getText().toString();
                        switch (type){
                            case 1:
                                //邮箱忘记密码
                                BmobUser.resetPasswordByEmail(str, new UpdateListener() {
                                    @Override
                                    public void done(BmobException e) {
                                        if(e==null){
                                            Toast.makeText(context,"重置密码请求成功，请到" + str + "邮箱进行密码重置操作",Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(context,"重置密码失败！！",Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                break;
                            case 2:
                                //修改邮箱
                                BmobUser emailUser = new BmobUser();
                                emailUser.setEmail(str);
                                BmobUser bmobUser = BmobUser.getCurrentUser(User.class);
                                emailUser.update(bmobUser.getObjectId(),new UpdateListener() {
                                    @Override
                                    public void done(BmobException e) {
                                        if(e==null){
                                            dialogDataCallBack.onPositive(str);
                                            Toast.makeText(context,"邮箱更新成功",Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(context,"邮箱更新失败",Toast.LENGTH_SHORT).show();
                                            dialogDataCallBack.onNeigitive();

                                        }
                                    }
                                });
                                break;
                            case 3:
                                BmobUser nameUser = new BmobUser();
                                nameUser.setUsername(str);
                                BmobUser bmobUser2 = BmobUser.getCurrentUser(User.class);
                                nameUser.update(bmobUser2.getObjectId(),new UpdateListener() {
                                    @Override
                                    public void done(BmobException e) {
                                        if(e==null){
                                            dialogDataCallBack.onPositive(str);

                                            Toast.makeText(context,"昵称更新成功",Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(context,"昵称更新失败",Toast.LENGTH_SHORT).show();
                                            dialogDataCallBack.onNeigitive();

                                        }
                                    }
                                });
                                break;
                            case 4:
                                dialogDataCallBack.onPositive("OK");
                                break;
                        }
                    }

                    @Override
                    public void onNegative(MaterialDialog dialog) {
                        dialog.dismiss();
                    }
                })
                .show();
    }


}