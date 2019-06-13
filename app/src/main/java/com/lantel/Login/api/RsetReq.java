package com.lantel.Login.api;

public class RsetReq {
    //账号，也就是手机号
    private String account;
    //手机验证码
    private String vcode;
    //新密码
    private String new_pwd;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

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
