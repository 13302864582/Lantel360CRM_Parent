package com.lantel.mine.order.list.model;

import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseModel;

public class DetailEndModel extends BaseModel {
    private String money;

    public DetailEndModel() {
        super(Config.TYPE_ORDER_END, "");
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
