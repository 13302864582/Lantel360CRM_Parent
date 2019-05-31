package com.lantel.mine.order.list.model;

import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseModel;

public class DetailTopModel extends BaseModel {
    private String order_id;
    private String join_time;
    private String order_time;

    public DetailTopModel() {
        super(Config.TYPE_ORDER_TOP, "");
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getJoin_time() {
        return join_time;
    }

    public void setJoin_time(String join_time) {
        this.join_time = join_time;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }
}
