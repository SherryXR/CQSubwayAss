package com.sherry.cqsubwayass.app;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.sherry.cqsubwayass.config.Contants;
import com.sherry.cqsubwayass.model.bmob.SubwayFive;
import com.sherry.cqsubwayass.model.bmob.SubwayOne;
import com.sherry.cqsubwayass.model.bmob.SubwaySix;
import com.sherry.cqsubwayass.model.bmob.SubwaySixOther;
import com.sherry.cqsubwayass.model.bmob.SubwayTen;
import com.sherry.cqsubwayass.model.bmob.SubwayThree;
import com.sherry.cqsubwayass.model.bmob.SubwayThreeOther;
import com.sherry.cqsubwayass.model.bmob.SubwayTwo;
import com.sherry.cqsubwayass.model.callback.FirstLoadDataCallback;
import com.sherry.cqsubwayass.model.db.DBSubwayFive;
import com.sherry.cqsubwayass.model.db.DBSubwayOne;
import com.sherry.cqsubwayass.model.db.DBSubwaySix;
import com.sherry.cqsubwayass.model.db.DBSubwaySixOther;
import com.sherry.cqsubwayass.model.db.DBSubwayTen;
import com.sherry.cqsubwayass.model.db.DBSubwayThree;
import com.sherry.cqsubwayass.model.db.DBSubwayThreeOther;
import com.sherry.cqsubwayass.model.db.DBSubwayTwo;
import com.sherry.cqsubwayass.utils.FileUtil;
import com.sherry.cqsubwayass.utils.SPUtils;

import org.litepal.LitePalApplication;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

import static android.support.v4.app.ActivityCompat.requestPermissions;


/**
 * Created by Sherry on 2018/4/9.
 */

public class BaseApplication extends LitePalApplication {

    boolean isComplie =true;
    @Override
    public void onCreate() {
        FileUtil.setMapCustomFile(this, Contants.CUSTOM_CONFIG_MAP_PATH);
        super.onCreate();
        SDKInitializer.initialize(getApplicationContext());
        Bmob.initialize(this, "f3ecb71a10353c2f309ca1d54c820ac4");
        if ((boolean) SPUtils.get(this,"isFirstOpen",true)){
            Log.d("FirstLoadBmobData-->","是第一次！！！！！");
            loadData(this);
        }
    }

    void initSubwayOne(final FirstLoadDataCallback firstLoadDataCallback){
        BmobQuery<SubwayOne> query = new BmobQuery<SubwayOne>();
        query.setLimit(50);
        query.findObjects(new FindListener<SubwayOne>() {
            @Override
            public void done(List<SubwayOne> object, BmobException e) {
                if(e==null){
                    for (SubwayOne subwayOne : object) {
                       new DBSubwayOne(subwayOne.getStation_name(),subwayOne.getStation_id(),subwayOne.getStation_begin(),subwayOne.getStation_last(),subwayOne.getStation_exit()).save();
                    }
                    firstLoadDataCallback.onSuccess("一号线成功");
                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                    firstLoadDataCallback.onFailure("失败："+e.getMessage()+","+e.getErrorCode());

                }
            }
        });

    }
    void initSubwayTwo(final FirstLoadDataCallback firstLoadDataCallback){
        BmobQuery<SubwayTwo> query = new BmobQuery<SubwayTwo>();
        query.setLimit(50);
        query.findObjects(new FindListener<SubwayTwo>() {
            @Override
            public void done(List<SubwayTwo> object, BmobException e) {
                if(e==null){
                    for (SubwayTwo subway : object) {
                        new DBSubwayTwo(subway.getStation_name(),subway.getStation_id(),subway.getStation_begin(),subway.getStation_last(),subway.getStation_exit()).save();
                    }
                    firstLoadDataCallback.onSuccess("二号线成功");
                }else{
                    firstLoadDataCallback.onFailure("失败："+e.getMessage()+","+e.getErrorCode());

                }
            }
        });
    }
    void initSubwayThree(final FirstLoadDataCallback firstLoadDataCallback){
        BmobQuery<SubwayThree> query = new BmobQuery<SubwayThree>();
        query.setLimit(50);
        query.findObjects(new FindListener<SubwayThree>() {
            @Override
            public void done(List<SubwayThree> object, BmobException e) {
                if(e==null){
                    for (SubwayThree subway : object) {
                        new DBSubwayThree(subway.getStation_name(),subway.getStation_id(),subway.getStation_begin(),subway.getStation_last(),subway.getStation_exit()).save();
                    }
                    firstLoadDataCallback.onSuccess("三号线成功");

                }else{
                    firstLoadDataCallback.onFailure("失败："+e.getMessage()+","+e.getErrorCode());

                }
            }
        });
    }
    void initSubwayFive(final FirstLoadDataCallback firstLoadDataCallback){
        BmobQuery<SubwayFive> query = new BmobQuery<SubwayFive>();
        query.setLimit(50);
        query.findObjects(new FindListener<SubwayFive>() {
            @Override
            public void done(List<SubwayFive> object, BmobException e) {
                if(e==null){
                    for (SubwayFive subway : object) {
                        new DBSubwayFive(subway.getStation_name(),subway.getStation_id(),subway.getStation_begin(),subway.getStation_last(),subway.getStation_exit()).save();
                    }
                    firstLoadDataCallback.onSuccess("五号线成功");

                }else{
                    firstLoadDataCallback.onFailure("失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }
    void initSubwaySix(final FirstLoadDataCallback firstLoadDataCallback){
        BmobQuery<SubwaySix> query = new BmobQuery<SubwaySix>();
        query.setLimit(50);
        query.findObjects(new FindListener<SubwaySix>() {
            @Override
            public void done(List<SubwaySix> object, BmobException e) {
                if(e==null){
                    for (SubwaySix subway : object) {
                        new DBSubwaySix(subway.getStation_name(),subway.getStation_id(),subway.getStation_begin(),subway.getStation_last(),subway.getStation_exit()).save();
                    }
                    firstLoadDataCallback.onSuccess("六号线成功");

                }else{
                    firstLoadDataCallback.onFailure("失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }
    void initSubwaySixOther(final FirstLoadDataCallback firstLoadDataCallback){
        BmobQuery<SubwaySixOther> query = new BmobQuery<SubwaySixOther>();
        query.setLimit(50);
        query.findObjects(new FindListener<SubwaySixOther>() {
            @Override
            public void done(List<SubwaySixOther> object, BmobException e) {
                if(e==null){
                    for (SubwaySixOther subway : object) {
                        new DBSubwaySixOther(subway.getStation_name(),subway.getStation_id(),subway.getStation_begin(),subway.getStation_last(),subway.getStation_exit()).save();
                    }
                    firstLoadDataCallback.onSuccess("六号线国博线成功");

                }else{
                    firstLoadDataCallback.onFailure("失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }
    void initSubwayTen(final FirstLoadDataCallback firstLoadDataCallback){
        BmobQuery<SubwayTen> query = new BmobQuery<SubwayTen>();
        query.setLimit(50);
        query.findObjects(new FindListener<SubwayTen>() {
            @Override
            public void done(List<SubwayTen> object, BmobException e) {
                if(e==null){
                    for (SubwayTen subway : object) {
                        new DBSubwayTen(subway.getStation_name(),subway.getStation_id(),subway.getStation_begin(),subway.getStation_last(),subway.getStation_exit()).save();
                    }
                    firstLoadDataCallback.onSuccess("十号线号线成功");

                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }
    void initSubwayThreeOther(final FirstLoadDataCallback firstLoadDataCallback){
        BmobQuery<SubwayThreeOther> query = new BmobQuery<SubwayThreeOther>();
        query.setLimit(50);
        query.findObjects(new FindListener<SubwayThreeOther>() {
            @Override
            public void done(List<SubwayThreeOther> object, BmobException e) {
                if(e==null){
                    for (SubwayThreeOther subway : object) {
                        new DBSubwayThreeOther(subway.getStation_name(),subway.getStation_id(),subway.getStation_begin(),subway.getStation_last(),subway.getStation_exit()).save();
                    }
                    firstLoadDataCallback.onSuccess("三号线北沿线成功");

                }else{
                    Log.i("bmob","失败："+e.getMessage()+","+e.getErrorCode());
                }
            }
        });
    }

    void loadData(final Context context){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("FirstLoadBmobData-->","开始执行数据任务！！！！！");
                initSubwayOne(new FirstLoadDataCallback() {
                    @Override
                    public void onSuccess(String message) {
                        Log.d("FirstLoadBmobData-->",message);
                    }

                    @Override
                    public void onFailure(String erro) {
                        Log.d("FirstLoadBmobData-->",erro);

                        isComplie = false;
                    }
                });
                initSubwayTwo(new FirstLoadDataCallback() {
                    @Override
                    public void onSuccess(String message) {
                        Log.d("FirstLoadBmobData-->",message);

                    }

                    @Override
                    public void onFailure(String erro) {
                        Log.d("FirstLoadBmobData-->",erro);

                        isComplie = false;
                    }
                });
                initSubwayThree(new FirstLoadDataCallback() {
                    @Override
                    public void onSuccess(String message) {
                        Log.d("FirstLoadBmobData-->",message);

                    }

                    @Override
                    public void onFailure(String erro) {
                        Log.d("FirstLoadBmobData-->",erro);
                        isComplie = false;

                    }
                });
                initSubwayFive(new FirstLoadDataCallback() {
                    @Override
                    public void onSuccess(String message) {
                        Log.d("FirstLoadBmobData-->",message);

                    }

                    @Override
                    public void onFailure(String erro) {
                        Log.d("FirstLoadBmobData-->",erro);

                        isComplie = false;
                    }
                });
                initSubwaySix(new FirstLoadDataCallback() {
                    @Override
                    public void onSuccess(String message) {
                        Log.d("FirstLoadBmobData-->",message);

                    }

                    @Override
                    public void onFailure(String erro) {
                        Log.d("FirstLoadBmobData-->",erro);

                        isComplie = false;
                    }
                });
                initSubwayTen(new FirstLoadDataCallback() {
                    @Override
                    public void onSuccess(String message) {
                        Log.d("FirstLoadBmobData-->",message);

                    }

                    @Override
                    public void onFailure(String erro) {
                        Log.d("FirstLoadBmobData-->",erro);

                        isComplie = false;
                    }
                });
                initSubwaySixOther(new FirstLoadDataCallback() {
                    @Override
                    public void onSuccess(String message) {
                        Log.d("FirstLoadBmobData-->",message);

                    }

                    @Override
                    public void onFailure(String erro) {
                        Log.d("FirstLoadBmobData-->",erro);

                        isComplie = false;
                    }
                });
                initSubwayThreeOther(new FirstLoadDataCallback() {
                    @Override
                    public void onSuccess(String message) {
                        Log.d("FirstLoadBmobData-->",message);

                    }

                    @Override
                    public void onFailure(String erro) {
                        Log.d("FirstLoadBmobData-->",erro);

                        isComplie = false;
                    }
                });

                if (isComplie){
                    SPUtils.put(context,"isFirstOpen",false);
                }
            }
        }).start();


    }

}
