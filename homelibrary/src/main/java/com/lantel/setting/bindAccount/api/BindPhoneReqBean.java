package com.lantel.setting.bindAccount.api;

public class BindPhoneReqBean {
    private String action;
    private String mobile;
    private String vcode;

    public BindPhoneReqBean() {
        this.action = "edit_mobile";
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }
}
