package com.lantel.setting.bindfile.bindstudent.api;

public class BindFileReqBean {
    private String domain;
    private String account; //学习管家账号，可以不填，不填默认用当前用户的账号
    private String password;
    private String user_type;  //用户类型1：机构用户，2：学习管家用户

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
}
