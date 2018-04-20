package com.sherry.cqsubwayass.model.bmob;

import cn.bmob.v3.BmobUser;

/**
 * Created by Kevin Liu on 2018/4/11.
 */

public class User extends BmobUser{

    private String collect;
    private String headImage;

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }
}
