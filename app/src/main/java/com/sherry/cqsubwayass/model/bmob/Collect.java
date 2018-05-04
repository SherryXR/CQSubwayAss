package com.sherry.cqsubwayass.model.bmob;

import cn.bmob.v3.BmobObject;

/**
 * Created by Sherry on 2018/5/4
 * <p>
 * Function:
 */
public class Collect extends BmobObject {

    private User author;
    private _Article find;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public _Article getFind() {
        return find;
    }

    public void setFind(_Article find) {
        this.find = find;
    }
}
