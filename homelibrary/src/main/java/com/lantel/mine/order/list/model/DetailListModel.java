package com.lantel.mine.order.list.model;

import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseModel;

public class DetailListModel extends BaseModel {
    private Object list_img;
    private String list_title;
    private String course_time;
    private String useful_date;
    private String paid_money;
    private String origin_price;
    private String price;
    private String discount_amount;
    private String reduced_amount;
    private String present_times;

    public DetailListModel() {
        super(Config.TYPE_ORDER_LIST, "");
    }

    public Object getList_img() {
        return list_img;
    }

    public void setList_img(Object list_img) {
        this.list_img = list_img;
    }

    public String getList_title() {
        return list_title;
    }

    public void setList_title(String list_title) {
        this.list_title = list_title;
    }

    public String getCourse_time() {
        return course_time;
    }

    public void setCourse_time(String course_time) {
        this.course_time = course_time;
    }

    public String getUseful_date() {
        return useful_date;
    }

    public void setUseful_date(String useful_date) {
        this.useful_date = useful_date;
    }

    public String getPaid_money() {
        return paid_money;
    }

    public void setPaid_money(String paid_money) {
        this.paid_money = paid_money;
    }

    public String getOrigin_price() {
        return origin_price;
    }

    public void setOrigin_price(String origin_price) {
        this.origin_price = origin_price;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount_amount() {
        return discount_amount;
    }

    public void setDiscount_amount(String discount_amount) {
        this.discount_amount = discount_amount;
    }

    public String getReduced_amount() {
        return reduced_amount;
    }

    public void setReduced_amount(String reduced_amount) {
        this.reduced_amount = reduced_amount;
    }

    public String getPresent_times() {
        return present_times;
    }

    public void setPresent_times(String present_times) {
        this.present_times = present_times;
    }
}
