package com.lantel.homelibrary.output.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class RemarkModel extends BaseModel {
    private String imgUrl;
    private String time;
    private String content;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

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
