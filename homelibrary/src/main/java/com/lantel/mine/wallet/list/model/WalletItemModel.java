package com.lantel.mine.wallet.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class WalletItemModel extends BaseModel {
    private long id;
    private Object head_img;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Object getHead_img() {
        return head_img;
    }

    public void setHead_img(Object head_img) {
        this.head_img = head_img;
    }
}
