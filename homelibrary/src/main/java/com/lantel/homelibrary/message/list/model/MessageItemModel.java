package com.lantel.homelibrary.message.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class MessageItemModel extends BaseModel {
    private String content;
    private String business_type;
    private int business_id;

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(int business_id) {
        this.business_id = business_id;
    }
}
