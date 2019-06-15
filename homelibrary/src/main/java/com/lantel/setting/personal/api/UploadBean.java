package com.lantel.setting.personal.api;

public class UploadBean {
    private String domain;
    private String prefix;
    private String uptoken;

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getUptoken() {
        return uptoken;
    }

    public void setUptoken(String uptoken) {
        this.uptoken = uptoken;
    }
}
