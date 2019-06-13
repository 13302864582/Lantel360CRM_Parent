package com.lantel.mine.api;


import java.util.List;

public class MineCardBean {
    private int error;
    private String message;
    private DataBean data;
    private boolean authed;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
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

    public boolean isAuthed() {
        return authed;
    }

    public void setAuthed(boolean authed) {
        this.authed = authed;
    }

    public static class DataBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            private String sid;
            private String student_name;
            private String nick_name;
            private String photo_url;
            private String birth_time;
            private String sno;
            private String sex;
            private String card_no;
            private String credit;
            private String student_lesson_hours;
            private String student_lesson_remain_hours;
            private String money;

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
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

            public String getNick_name() {
                return nick_name;
            }

            public void setNick_name(String nick_name) {
                this.nick_name = nick_name;
            }

            public String getPhoto_url() {
                return photo_url;
            }

            public void setPhoto_url(String photo_url) {
                this.photo_url = photo_url;
            }

            public String getBirth_time() {
                return birth_time;
            }

            public void setBirth_time(String birth_time) {
                this.birth_time = birth_time;
            }

            public String getSno() {
                return sno;
            }

            public void setSno(String sno) {
                this.sno = sno;
            }

            public String getCard_no() {
                return card_no;
            }

            public void setCard_no(String card_no) {
                this.card_no = card_no;
            }

            public String getCredit() {
                return credit;
            }

            public void setCredit(String credit) {
                this.credit = credit;
            }

            public String getStudent_lesson_hours() {
                return student_lesson_hours;
            }

            public void setStudent_lesson_hours(String student_lesson_hours) {
                this.student_lesson_hours = student_lesson_hours;
            }

            public String getStudent_lesson_remain_hours() {
                return student_lesson_remain_hours;
            }

            public void setStudent_lesson_remain_hours(String student_lesson_remain_hours) {
                this.student_lesson_remain_hours = student_lesson_remain_hours;
            }
        }
    }
}
