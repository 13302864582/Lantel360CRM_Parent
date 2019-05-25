package com.lantel.mine.order.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class OrderItemModel extends BaseModel {
   private String unit_count;
   private String order_state;
    private String money_record;
   private String date_time;
   private Object img;

    public String getUnit_count() {
        return unit_count;
    }

    public void setUnit_count(String unit_count) {
        this.unit_count = unit_count;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public String getMoney_record() {
        return money_record;
    }

    public void setMoney_record(String money_record) {
        this.money_record = money_record;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

    public Object getImg() {
        return img;
    }

    public void setImg(Object img) {
        this.img = img;
    }
}