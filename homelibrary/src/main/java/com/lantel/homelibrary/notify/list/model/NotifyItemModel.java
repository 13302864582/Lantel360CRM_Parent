package com.lantel.homelibrary.notify.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class NotifyItemModel extends BaseModel {
    private String time;
    private String content;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}