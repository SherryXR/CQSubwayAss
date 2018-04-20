package com.sherry.cqsubwayass.model.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Kevin Liu on 2018/4/11.
 */

public class History extends DataSupport{
    private String from;

    private String to;

    public History(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
