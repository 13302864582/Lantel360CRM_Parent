package com.lantel.Login.api;

public class UserRsetReq {
    //手机验证码
    private String vcode ;
    //新密码
    private String new_pwd ;

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getNew_pwd() {
        return new_pwd;
    }

    public void setNew_pwd(String new_pwd) {
        this.new_pwd = new_pwd;
    }
}
