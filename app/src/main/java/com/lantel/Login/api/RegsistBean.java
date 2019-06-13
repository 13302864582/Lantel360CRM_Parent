package com.lantel.Login.api;

public class RegsistBean {
    private int code;
    private String message;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private int app_client_id;
        private String account;
        private String mobile;
        private String email;
        private String name;
        private String avatar;
        private String wx_openid;
        private int is_mobile_bind;
        private int is_email_bind;
        private int is_weixin_bind;
        private String last_login_time;
        private String last_login_ip;
        private int login_times;
        private int status;
        private String create_time;
        private String update_time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getApp_client_id() {
            return app_client_id;
        }

        public void setApp_client_id(int app_client_id) {
            this.app_client_id = app_client_id;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getWx_openid() {
            return wx_openid;
        }

        public void setWx_openid(String wx_openid) {
            this.wx_openid = wx_openid;
        }

        public int getIs_mobile_bind() {
            return is_mobile_bind;
        }

        public void setIs_mobile_bind(int is_mobile_bind) {
            this.is_mobile_bind = is_mobile_bind;
        }

        public int getIs_email_bind() {
            return is_email_bind;
        }

        public void setIs_email_bind(int is_email_bind) {
            this.is_email_bind = is_email_bind;
        }

        public int getIs_weixin_bind() {
            return is_weixin_bind;
        }

        public void setIs_weixin_bind(int is_weixin_bind) {
            this.is_weixin_bind = is_weixin_bind;
        }

        public String getLast_login_time() {
            return last_login_time;
        }

        public void setLast_login_time(String last_login_time) {
            this.last_login_time = last_login_time;
        }

        public String getLast_login_ip() {
            return last_login_ip;
        }

        public void setLast_login_ip(String last_login_ip) {
            this.last_login_ip = last_login_ip;
        }

        public int getLogin_times() {
            return login_times;
        }

        public void setLogin_times(int login_times) {
            this.login_times = login_times;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(String update_time) {
            this.update_time = update_time;
        }
    }
}
