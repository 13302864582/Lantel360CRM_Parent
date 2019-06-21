package com.lantel.homelibrary.communicate.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class ItemModel extends BaseModel {
    private String headImg;
    private String content;
    private String time;
    private int sid;

    public int getId() {
        return sid;
    }

    public void setId(int id) {
        this.sid = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
