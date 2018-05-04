package com.sherry.cqsubwayass.model.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sherry on 2018/4/15.
 */

public class FindBean implements Serializable{

    private boolean collrcted;
    private String url;
    private String message;
    private String title;
    private List<Integer> imageLists = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addImage(int image){
        imageLists.add(image);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Integer> getImageLists() {
        return imageLists;
    }

    public void setImageLists(List<Integer> imageLists) {
        this.imageLists = imageLists;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isCollrcted() {
        return collrcted;
    }

    public void setCollrcted(boolean collrcted) {
        this.collrcted = collrcted;
    }
}
