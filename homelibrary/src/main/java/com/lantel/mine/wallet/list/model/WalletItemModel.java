package com.lantel.mine.wallet.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class WalletItemModel extends BaseModel {
   private String money_record;
   private String detail;
   private String date_time;

    public String getMoney_record() {
        return money_record;
    }

    public void setMoney_record(String money_record) {
        this.money_record = money_record;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
}