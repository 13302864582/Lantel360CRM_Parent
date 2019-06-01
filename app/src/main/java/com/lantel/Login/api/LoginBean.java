package com.lantel.Login.api;

import java.util.List;

public class LoginBean {


    /**
     * error : 0
     * message : login success
     * data : {"uid":10028,"og_id":0,"account":"13434798799","mobile":"13434798799","email":"","name":"JK","sex":"0","user_type":2,"salt":"IStV2E","password":"ac63bf842f0e4fabc4558ccdf111e3d0","avatar":"","openid":"","default_sid":23,"is_mobile_bind":0,"is_email_bind":0,"is_weixin_bind":0,"last_login_time":"2019-06-01 15:40:44","last_login_ip":"113.102.167.205","login_times":123,"status":1,"is_main":0,"is_admin":0,"is_ext":0,"ext_password":null,"create_uid":1,"reset_time":null,"reset_token":null,"students":[{"sid":21,"og_id":0,"bid":1,"student_name":"test02","pinyin":"","pinyin_abbr":"","nick_name":"","sex":"1","photo_url":"http://s10.xiao360.com/qms/student_avatar/1/19/05/18/ef14abe724b4fd874d9986158d70774e.png","birth_time":"2019-05-02","birth_year":0,"birth_month":0,"birth_day":0,"school_grade":3,"grade_update_int_ym":0,"school_class":"3","school_id":2,"first_tel":"13434798799","first_family_name":"JK","first_family_rel":4,"first_uid":10028,"second_family_name":"","second_family_rel":0,"second_tel":"","second_uid":0,"eid":0,"sno":"No123456","card_no":"001002","money":"0.000000","credit":"0.00","credit2":"0.00","vip_level":-1,"service_level":0,"last_attendance_time":"2019-05-28 15:59:03","is_lost":0,"status":1,"mc_id":0,"quit_reason":"","student_type":1,"option_fields":"[]","student_lesson_times":0,"student_lesson_remain_times":0,"student_lesson_hours":"243.00","student_lesson_remain_hours":"237.00","is_demo":0,"is_demo_transfered":1,"is_face_input":0,"face_id":"","referer_sid":0,"in_time":1558022400,"create_time":"2019-05-17 12:32:34","ext_id":"","from_did":0,"school_id_text":"0"},{"sid":23,"og_id":0,"bid":1,"student_name":"test01","pinyin":"test01","pinyin_abbr":"t","nick_name":"","sex":"1","photo_url":"","birth_time":"2012-05-09","birth_year":2012,"birth_month":5,"birth_day":9,"school_grade":0,"grade_update_int_ym":0,"school_class":"0","school_id":0,"first_tel":"13434798799","first_family_name":"","first_family_rel":4,"first_uid":10028,"second_family_name":"","second_family_rel":0,"second_tel":"","second_uid":0,"eid":0,"sno":"999999","card_no":"888888","money":"220.000000","credit":"0.00","credit2":"0.00","vip_level":-1,"service_level":0,"last_attendance_time":"1970-01-01 08:00:00","is_lost":0,"status":1,"mc_id":0,"quit_reason":"","student_type":1,"option_fields":"[]","student_lesson_times":0,"student_lesson_remain_times":0,"student_lesson_hours":"0.00","student_lesson_remain_hours":"0.00","is_demo":0,"is_demo_transfered":0,"is_face_input":0,"face_id":"","referer_sid":0,"in_time":0,"create_time":"2019-05-17 12:35:23","ext_id":"","from_did":0,"school_id_text":""}],"token":"79340798e54f49138cef440ae0f20f2d","bid":0,"pers":[],"navs":[],"login_server_time":1559375814,"expired":7200,"client":{"cid":1,"parent_cid":0,"og_id":0,"client_type":0,"client_name":"开发账号","contact":"开发","address":"深圳","tel":"18316777868","email":"","host":"base","bind_domain":"","auth":"2,3,4,5,1","expire_day":20200901,"init_account_num_limit":1000000,"init_student_num_limit":1000000,"init_branch_num_limit":1000000,"account_num_limit":1000000,"student_num_limit":1000000,"branch_num_limit":1000000,"is_student_limit":0,"is_account_limit":0,"is_branch_limit":0,"current_version":"0.5.1","is_frozen":0,"is_db_install":0,"sign_contract_time":0,"init_amount":"0.00","init_renew_amount":"0.00","init_month_num":0,"init_present_month_num":0,"add_renew_amount":"0.00","edu_amount":"0.00","account_price":"0.00","student_price":"0.00","branch_price":"0.00","is_init_pay":1,"is_org_open":1,"allow_sub_org_type":0,"head_support_open":0,"sub_limit_field":"","sub_renew_amount":"0.00","sub_student_price":"0.00","sub_branch_price":"0.00","sub_account_price":"0.00","eid":0,"service_eid":0,"remark":"","params":{"pc":{"theme":"default","url":"","system_name":"校360管理软件","copyright":"Copyright  2006-2017 浪腾软件 版权所有","login_img":"http://s10.xiao360.com/qms//1/18/09/07/b324b37f74b4e6b4991656125bbd5411.jpg","big_logo":"http://s10.xiao360.com/qms//1/18/09/07/b4acdf16aa13ddbfbbbd2e43cd57e0b7.jpg","small_logo":"http://s10.xiao360.com/qms//1/18/09/07/a1dd86ed052579ef4ab5e80a9ede14ad.jpg","loading_img":"http://sp1.xiao360.com/static/ui/pc/boot-loading.gif"},"mobile":{"url":"","system_name":"学习管家","copyright":"","logo":"http://s10.xiao360.com/qms//1/18/09/07/28807d8854611979d25456404e867726.png"},"fc":{"system_name":"校360","copyright":"Copyright © 2006-2019 浪腾软件 版权所有","login_img":"http://sp1.xiao360.com/fms/login-bg.c197ea48.png","big_logo":"http://s10.xiao360.com/qms//1/19/05/13/9e3904d590ecb464c5ea8c16d3551e79.png","small_logo":"http://s10.xiao360.com/qms//1/19/05/13/8660e12aec8798d218f3650cd09b3799.png"},"cppt":{"login_bg":"http://sp1.xiao360.com/cppt/login-banner.png","ppt_logo_small":"http://sp1.xiao360.com/cppt/logo-small.png","top_logo":"http://sp1.xiao360.com/cppt/index-logo.png","ppt_bg":"http://sp1.xiao360.com/cppt/bg.jpg","ppt_logo":"http://sp1.xiao360.com/cppt/logo.png","man_avatar":"http://sp1.xiao360.com/cppt/default-head-1.png","woman_avatar":"http://sp1.xiao360.com/cppt/default-head-2.png","company_name":"","short_name":"","email":"","host":"","address":""}},"func_sdb_open":1,"last_login_time":1559210765,"last_login_account":"admin","last_login_ip":"183.11.68.15","login_times":191,"create_time":null,"create_uid":null,"update_time":null,"delete_time":null,"is_delete":0,"delete_uid":null,"frozen_int_day":0,"is_expire":false,"is_warn":false,"expire_message":"","domain":"base","subdomain":""},"x_sub_host":"base","base_url":"http://dev.xiao360.com","product_url":"http://dev.xiao360.com"}
     */

    private int error;
    private String message;
    private DataBean data;

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

    public static class DataBean {
        private String account;
        private String password;
        private String token;
        private String x_sub_host;
        private int uid;
        private int bid;
        private String base_url;
        private List<StudentsBean> students;

        public int getBid() {
            return bid;
        }

        public void setBid(int bid) {
            this.bid = bid;
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

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getX_sub_host() {
            return x_sub_host;
        }

        public void setX_sub_host(String x_sub_host) {
            this.x_sub_host = x_sub_host;
        }

        public String getBase_url() {
            return base_url;
        }

        public void setBase_url(String base_url) {
            this.base_url = base_url;
        }

        public List<StudentsBean> getStudents() {
            return students;
        }

        public void setStudents(List<StudentsBean> students) {
            this.students = students;
        }

        public static class StudentsBean {
            private int sid;
            private int og_id;
            private int bid;
            private String student_name;
            private String pinyin;
            private String pinyin_abbr;
            private String nick_name;
            private String sex;
            private String photo_url;
            private String birth_time;
            private int birth_year;
            private int birth_month;
            private int birth_day;
            private int school_grade;
            private int grade_update_int_ym;
            private String school_class;
            private int school_id;
            private String first_tel;
            private String first_family_name;
            private int first_family_rel;
            private int first_uid;
            private String second_family_name;
            private int second_family_rel;
            private String second_tel;
            private int second_uid;
            private int eid;
            private String sno;
            private String card_no;
            private String money;
            private String credit;
            private String credit2;
            private int vip_level;
            private int service_level;
            private String last_attendance_time;
            private int is_lost;
            private int status;
            private int mc_id;
            private String quit_reason;
            private int student_type;
            private String option_fields;
            private int student_lesson_times;
            private int student_lesson_remain_times;
            private String student_lesson_hours;
            private String student_lesson_remain_hours;
            private int is_demo;
            private int is_demo_transfered;
            private int is_face_input;
            private String face_id;
            private int referer_sid;
            private int in_time;
            private String create_time;
            private String ext_id;
            private int from_did;
            private String school_id_text;

            public int getSid() {
                return sid;
            }

            public void setSid(int sid) {
                this.sid = sid;
            }

            public int getOg_id() {
                return og_id;
            }

            public void setOg_id(int og_id) {
                this.og_id = og_id;
            }

            public int getBid() {
                return bid;
            }

            public void setBid(int bid) {
                this.bid = bid;
            }

            public String getStudent_name() {
                return student_name;
            }

            public void setStudent_name(String student_name) {
                this.student_name = student_name;
            }

            public String getPinyin() {
                return pinyin;
            }

            public void setPinyin(String pinyin) {
                this.pinyin = pinyin;
            }

            public String getPinyin_abbr() {
                return pinyin_abbr;
            }

            public void setPinyin_abbr(String pinyin_abbr) {
                this.pinyin_abbr = pinyin_abbr;
            }

            public String getNick_name() {
                return nick_name;
            }

            public void setNick_name(String nick_name) {
                this.nick_name = nick_name;
            }

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
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

            public int getBirth_year() {
                return birth_year;
            }

            public void setBirth_year(int birth_year) {
                this.birth_year = birth_year;
            }

            public int getBirth_month() {
                return birth_month;
            }

            public void setBirth_month(int birth_month) {
                this.birth_month = birth_month;
            }

            public int getBirth_day() {
                return birth_day;
            }

            public void setBirth_day(int birth_day) {
                this.birth_day = birth_day;
            }

            public int getSchool_grade() {
                return school_grade;
            }

            public void setSchool_grade(int school_grade) {
                this.school_grade = school_grade;
            }

            public int getGrade_update_int_ym() {
                return grade_update_int_ym;
            }

            public void setGrade_update_int_ym(int grade_update_int_ym) {
                this.grade_update_int_ym = grade_update_int_ym;
            }

            public String getSchool_class() {
                return school_class;
            }

            public void setSchool_class(String school_class) {
                this.school_class = school_class;
            }

            public int getSchool_id() {
                return school_id;
            }

            public void setSchool_id(int school_id) {
                this.school_id = school_id;
            }

            public String getFirst_tel() {
                return first_tel;
            }

            public void setFirst_tel(String first_tel) {
                this.first_tel = first_tel;
            }

            public String getFirst_family_name() {
                return first_family_name;
            }

            public void setFirst_family_name(String first_family_name) {
                this.first_family_name = first_family_name;
            }

            public int getFirst_family_rel() {
                return first_family_rel;
            }

            public void setFirst_family_rel(int first_family_rel) {
                this.first_family_rel = first_family_rel;
            }

            public int getFirst_uid() {
                return first_uid;
            }

            public void setFirst_uid(int first_uid) {
                this.first_uid = first_uid;
            }

            public String getSecond_family_name() {
                return second_family_name;
            }

            public void setSecond_family_name(String second_family_name) {
                this.second_family_name = second_family_name;
            }

            public int getSecond_family_rel() {
                return second_family_rel;
            }

            public void setSecond_family_rel(int second_family_rel) {
                this.second_family_rel = second_family_rel;
            }

            public String getSecond_tel() {
                return second_tel;
            }

            public void setSecond_tel(String second_tel) {
                this.second_tel = second_tel;
            }

            public int getSecond_uid() {
                return second_uid;
            }

            public void setSecond_uid(int second_uid) {
                this.second_uid = second_uid;
            }

            public int getEid() {
                return eid;
            }

            public void setEid(int eid) {
                this.eid = eid;
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

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getCredit() {
                return credit;
            }

            public void setCredit(String credit) {
                this.credit = credit;
            }

            public String getCredit2() {
                return credit2;
            }

            public void setCredit2(String credit2) {
                this.credit2 = credit2;
            }

            public int getVip_level() {
                return vip_level;
            }

            public void setVip_level(int vip_level) {
                this.vip_level = vip_level;
            }

            public int getService_level() {
                return service_level;
            }

            public void setService_level(int service_level) {
                this.service_level = service_level;
            }

            public String getLast_attendance_time() {
                return last_attendance_time;
            }

            public void setLast_attendance_time(String last_attendance_time) {
                this.last_attendance_time = last_attendance_time;
            }

            public int getIs_lost() {
                return is_lost;
            }

            public void setIs_lost(int is_lost) {
                this.is_lost = is_lost;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getMc_id() {
                return mc_id;
            }

            public void setMc_id(int mc_id) {
                this.mc_id = mc_id;
            }

            public String getQuit_reason() {
                return quit_reason;
            }

            public void setQuit_reason(String quit_reason) {
                this.quit_reason = quit_reason;
            }

            public int getStudent_type() {
                return student_type;
            }

            public void setStudent_type(int student_type) {
                this.student_type = student_type;
            }

            public String getOption_fields() {
                return option_fields;
            }

            public void setOption_fields(String option_fields) {
                this.option_fields = option_fields;
            }

            public int getStudent_lesson_times() {
                return student_lesson_times;
            }

            public void setStudent_lesson_times(int student_lesson_times) {
                this.student_lesson_times = student_lesson_times;
            }

            public int getStudent_lesson_remain_times() {
                return student_lesson_remain_times;
            }

            public void setStudent_lesson_remain_times(int student_lesson_remain_times) {
                this.student_lesson_remain_times = student_lesson_remain_times;
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

            public int getIs_demo() {
                return is_demo;
            }

            public void setIs_demo(int is_demo) {
                this.is_demo = is_demo;
            }

            public int getIs_demo_transfered() {
                return is_demo_transfered;
            }

            public void setIs_demo_transfered(int is_demo_transfered) {
                this.is_demo_transfered = is_demo_transfered;
            }

            public int getIs_face_input() {
                return is_face_input;
            }

            public void setIs_face_input(int is_face_input) {
                this.is_face_input = is_face_input;
            }

            public String getFace_id() {
                return face_id;
            }

            public void setFace_id(String face_id) {
                this.face_id = face_id;
            }

            public int getReferer_sid() {
                return referer_sid;
            }

            public void setReferer_sid(int referer_sid) {
                this.referer_sid = referer_sid;
            }

            public int getIn_time() {
                return in_time;
            }

            public void setIn_time(int in_time) {
                this.in_time = in_time;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getExt_id() {
                return ext_id;
            }

            public void setExt_id(String ext_id) {
                this.ext_id = ext_id;
            }

            public int getFrom_did() {
                return from_did;
            }

            public void setFrom_did(int from_did) {
                this.from_did = from_did;
            }

            public String getSchool_id_text() {
                return school_id_text;
            }

            public void setSchool_id_text(String school_id_text) {
                this.school_id_text = school_id_text;
            }
        }
    }
}
