package com.lantel.Login.api;

public class SignUpReq {
    //手机号
    private String mobile;
    //短信验证码
    private String vcode;
    //密码
    private String password;
    //APPID ,教育助手为1,学习管家为2
    private int app_client_id;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getApp_client_id() {
        return app_client_id;
    }

    public void setApp_client_id(int app_client_id) {
        this.app_client_id = app_client_id;
    }
}
