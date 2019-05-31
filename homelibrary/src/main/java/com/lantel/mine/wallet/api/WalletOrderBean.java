package com.lantel.mine.wallet.api;

public class WalletOrderBean {
    //金额
    private String amount;
    //操作前余额
    private String before_amount;
    //操作后余额
    private String after_amount;
    //创建时间
    private String create_time;
    //业务类型:(1:结转,2:退费,3:充值, 4:下单, 5:订单续费 ,10 导入,11:用户手动增加， 12手动减少)
    private int business_type;
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getBefore_amount() {
        return before_amount;
    }

    public void setBefore_amount(String before_amount) {
        this.before_amount = before_amount;
    }

    public String getAfter_amount() {
        return after_amount;
    }

    public void setAfter_amount(String after_amount) {
        this.after_amount = after_amount;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public int getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(int business_type) {
        this.business_type = business_type;
    }
}
