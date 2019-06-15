package com.lantel.setting.personal.api;

public class UploadReq {
    private String birth_time;
    private String photo_url;
    private String sex;
    private int sid;
    private String student_name;

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getBirth_time() {
        return birth_time;
    }

    public void setBirth_time(String birth_time) {
        this.birth_time = birth_time;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    /*birth_time: "2019-12-02"
    photo_url: "http://s10.xiao360.com/qms/student_avatar/1/19/06/06/d73d000343f5b813e02e5aeb83f2c478.png"
    sex: "2"*/
}
