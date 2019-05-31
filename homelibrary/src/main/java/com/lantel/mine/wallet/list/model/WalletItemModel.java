package com.lantel.mine.wallet.list.model;

import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.DisplayUtil;
import java.util.Date;

public class WalletItemModel extends BaseModel {
   private String money_record;
   private int business_type;
   private String remark;
   private Date date;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMoney_record() {
        return money_record;
    }

    public void setMoney_record(String money_record) {
        this.money_record = money_record;
    }

    public int getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(int business_type) {
        this.business_type = business_type;
    }

    public String getDateMonth() {
        return getFormat("yyyy-MM");
    }

    public String getDateTime() {
        return getFormat("MM-dd  HH:mm");
    }

    public String getFormat(String format) {
        if (date == null)
            return "";
        return DisplayUtil.praseformatIntDay(format, date);
    }
}