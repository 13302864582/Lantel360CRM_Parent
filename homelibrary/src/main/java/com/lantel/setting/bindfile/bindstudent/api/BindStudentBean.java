package com.lantel.setting.bindfile.bindstudent.api;

import java.util.List;

public class BindStudentBean {
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * sid : 21
             * og_id : 0
             * bid : 1
             * student_name : test02
             * nick_name :
             * sex : 1
             * photo_url : http://s10.xiao360.com/qms/student_avatar/1/19/06/06/d73d000343f5b813e02e5aeb83f2c478.png
             * birth_time : 2019-12-09
             * birth_year : 2019
             * birth_month : 12
             * birth_day : 9
             * school_grade : 3
             * grade_update_int_ym : 201906
             * school_class : 3
             * school_id : 2
             * first_tel :
             * first_family_name :
             * first_family_rel : 4
             * first_uid : 10028
             * second_family_name :
             * second_family_rel : 0
             * second_tel :
             * second_uid : 0
             * eid : 0
             * vip_level : -1
             * service_level : 0
             * last_attendance_time : 2019-05-28 15:59:03
             * is_lost : 0
             * status : 1
             * mc_id : 0
             * quit_reason :
             * student_type : 1
             * option_fields : []
             * student_lesson_times : 0
             * student_lesson_remain_times : 0
             * student_lesson_hours : 243.00
             * student_lesson_remain_hours : 237.00
             * is_face_input : 0
             * face_id :
             * referer_sid : 0
             * in_time : 1558022400
             * create_time : 2019-05-17 12:32:34
             * ext_id :
             * from_did : 0
             * school_id_text : 0
             * branch : {"bid":1,"og_id":0,"branch_name":"古北财富中心道场","short_name":"财富中心道场","branch_type":"1","branch_tel":"13681810678","big_area_id":0,"province_id":9,"city_id":146,"district_id":1844,"area_id":1844,"address":"虹桥路1438号古北国际财富中心二期19楼（高岛屋百货大楼旁边的办公楼）","ms_id":0,"sort":0,"appid":"","create_uid":0,"ext_id":null}
             */

            private int sid;
            private int og_id;
            private int bid;
            private String student_name;
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
            private String last_attendance_time;
            private int status;
            private int mc_id;
            private int student_type;
            private String option_fields;
            private int student_lesson_times;
            private int student_lesson_remain_times;
            private String student_lesson_hours;
            private String student_lesson_remain_hours;
            private int is_demo;
            private int is_demo_transfered;
            private int referer_sid;
            private int in_time;
            private String create_time;
            private String ext_id;
            private int from_did;
            private String school_id_text;
            private BranchBean branch;

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


            public String getLast_attendance_time() {
                return last_attendance_time;
            }

            public void setLast_attendance_time(String last_attendance_time) {
                this.last_attendance_time = last_attendance_time;
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

            public BranchBean getBranch() {
                return branch;
            }

            public void setBranch(BranchBean branch) {
                this.branch = branch;
            }

            public static class BranchBean {
                /**
                 * bid : 1
                 * og_id : 0
                 * branch_name : 古北财富中心道场
                 * short_name : 财富中心道场
                 * branch_type : 1
                 * branch_tel : 13681810678
                 * big_area_id : 0
                 * province_id : 9
                 * city_id : 146
                 * district_id : 1844
                 * area_id : 1844
                 * address : 虹桥路1438号古北国际财富中心二期19楼（高岛屋百货大楼旁边的办公楼）
                 * ms_id : 0
                 * sort : 0
                 * appid :
                 * create_uid : 0
                 * ext_id : null
                 */

                private int bid;
                private int og_id;
                private String branch_name;
                private String short_name;
                private String branch_type;
                private String branch_tel;
                private int big_area_id;
                private int province_id;
                private int city_id;
                private int district_id;
                private int area_id;
                private String address;
                private int ms_id;
                private int sort;
                private String appid;
                private int create_uid;
                private Object ext_id;

                public int getBid() {
                    return bid;
                }

                public void setBid(int bid) {
                    this.bid = bid;
                }

                public int getOg_id() {
                    return og_id;
                }

                public void setOg_id(int og_id) {
                    this.og_id = og_id;
                }

                public String getBranch_name() {
                    return branch_name;
                }

                public void setBranch_name(String branch_name) {
                    this.branch_name = branch_name;
                }

                public String getShort_name() {
                    return short_name;
                }

                public void setShort_name(String short_name) {
                    this.short_name = short_name;
                }

                public String getBranch_type() {
                    return branch_type;
                }

                public void setBranch_type(String branch_type) {
                    this.branch_type = branch_type;
                }

                public String getBranch_tel() {
                    return branch_tel;
                }

                public void setBranch_tel(String branch_tel) {
                    this.branch_tel = branch_tel;
                }

                public int getBig_area_id() {
                    return big_area_id;
                }

                public void setBig_area_id(int big_area_id) {
                    this.big_area_id = big_area_id;
                }

                public int getProvince_id() {
                    return province_id;
                }

                public void setProvince_id(int province_id) {
                    this.province_id = province_id;
                }

                public int getCity_id() {
                    return city_id;
                }

                public void setCity_id(int city_id) {
                    this.city_id = city_id;
                }

                public int getDistrict_id() {
                    return district_id;
                }

                public void setDistrict_id(int district_id) {
                    this.district_id = district_id;
                }

                public int getArea_id() {
                    return area_id;
                }

                public void setArea_id(int area_id) {
                    this.area_id = area_id;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public int getMs_id() {
                    return ms_id;
                }

                public void setMs_id(int ms_id) {
                    this.ms_id = ms_id;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public String getAppid() {
                    return appid;
                }

                public void setAppid(String appid) {
                    this.appid = appid;
                }

                public int getCreate_uid() {
                    return create_uid;
                }

                public void setCreate_uid(int create_uid) {
                    this.create_uid = create_uid;
                }

                public Object getExt_id() {
                    return ext_id;
                }

                public void setExt_id(Object ext_id) {
                    this.ext_id = ext_id;
                }
            }
        }
    }
}
