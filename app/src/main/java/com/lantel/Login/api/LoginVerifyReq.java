package com.lantel.Login.api;

public class LoginVerifyReq {
    //手机号
    private String mobile;
    //业务类型，目前三种 signup(注册),resetpwd(忘记密码重设),user_resetpwd(用户修改密码),
    private String business_type;
    //app客户端id,2为学习管家1为教育助手 可以不填，默认学习管家
    private int app_client_id;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }

    public int getApp_client_id() {
        return app_client_id;
    }

    public void setApp_client_id(int app_client_id) {
        this.app_client_id = app_client_id;
    }
}
