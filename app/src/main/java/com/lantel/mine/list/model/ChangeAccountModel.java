package com.lantel.mine.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class ChangeAccountModel extends BaseModel {
    private String sid;
    private Object head_img;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Object getHead_img() {
        return head_img;
    }

    public void setHead_img(Object head_img) {
        this.head_img = head_img;
    }
}
