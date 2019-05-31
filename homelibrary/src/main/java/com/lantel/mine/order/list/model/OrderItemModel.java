package com.lantel.mine.order.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class OrderItemModel extends BaseModel {
   private String count;
   private String order_state;
    private String totalMoney;
   private String date_time;
   private Object img;
   private String orderItemJson;

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOrderItemJson() {
        return orderItemJson;
    }

    public void setOrderItemJson(String orderItemJson) {
        this.orderItemJson = orderItemJson;
    }

    public String getOrder_state() {
        return order_state;
    }

    public void setOrder_state(String order_state) {
        this.order_state = order_state;
    }

    public String getMoney_record() {
        return totalMoney;
    }

    public void setMoney_record(String money_record) {
        this.totalMoney = money_record;
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