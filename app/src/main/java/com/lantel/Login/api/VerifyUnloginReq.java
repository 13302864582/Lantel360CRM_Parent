package com.lantel.Login.api;

public class VerifyUnloginReq {
    private String mobile;
    private String type;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
