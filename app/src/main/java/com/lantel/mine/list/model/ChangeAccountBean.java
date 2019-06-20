package com.lantel.mine.list.model;

public class ChangeAccountBean {
    /**
     * birth_time : 2019-05-02
     * card_no : 001002
     * credit : 0.00
     * nick_name :
     * photo_url : http://s10.xiao360.com/qms/student_avatar/1/19/05/18/ef14abe724b4fd874d9986158d70774e.png
     * sid : 21
     * sno : No123456
     * student_lesson_hours : 122.00
     * student_lesson_remain_hours : 118.00
     * student_name : test02
     */
    private String photo_url;
    private String sid;
    private String student_name;

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
}
