package com.sherry.cqsubwayass.model.bmob;

import cn.bmob.v3.BmobObject;

/**
 * Created by Kevin Liu on 2018/4/15.
 */

public class _Article extends BmobObject {

    private String url;
    private String title;



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
