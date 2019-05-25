package com.lantel.studylibrary.classes.api;

import java.util.List;

public class ClassBean {

    /**
     * error : 0
     * message : success
     * data : {"total":1,"list":[{"cid":4,"og_id":0,"bid":1,"parent_cid":0,"class_name":"徐老师1班","class_no":"","class_type":0,"lid":0,"sj_id":2,"grade":0,"sg_id":0,"unit_price":"0.00","per_lesson_hour_minutes":0,"consume_source_type":1,"consume_lesson_hour":"1.00","subject_grade":0,"teach_eid":10003,"second_eid":0,"second_eids":"","edu_eid":0,"cr_id":1,"plan_student_nums":16,"student_nums":13,"nums_rate":"0.81","lesson_times":14,"lesson_index":0,"arrange_times":10,"attendance_times":2,"year":2019,"season":"C","start_lesson_time":"2019-05-08","end_lesson_time":"2019-05-20","status":1,"ext_id":"","is_demo":0,"is_online":0,"create_uid":1,"int_start_hour":"0","int_end_hour":"0","student_artwork_count":0,"lesson":null,"classroom":{"cr_id":1,"og_id":0,"bid":1,"room_name":"MR001","seat_nums":16,"max_seat_nums":0,"listen_nums_limit":4,"seat_config":null,"area":"0.00"},"teacher":{"eid":10003,"og_id":0,"bid":1,"ename":"徐老师","pinyin":"xulaoshi","pinyin_abbr":"xls","nick_name":"","rids":[1],"bids":[1,2,3,4],"com_ids":"","lids":[],"sj_ids":[],"grades":"","uid":10014,"account":"17799999999","sex":"1","mobile":"17799999999","email":"","id_card_no":"","bank_card_no":"","photo_url":"http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg","birth_time":0,"birth_year":0,"birth_month":0,"birth_day":0,"is_part_job":0,"is_on_job":1,"join_int_day":0,"official_int_day":0,"remark":"","option_fields":"[]","user_status":1,"is_fsys":0,"teacher_level":-1,"college_did":0,"major_did":0,"degree_did":0,"have_cert":1,"ext_id":0},"assistant":null}],"page":1,"pagesize":10,"sql":"SELECT * FROM `x360p_class_student` WHERE (  `sid` = 21  AND `x360p_class_student`.`og_id` = 0 ) AND `x360p_class_student`.`delete_time` IS NULL ORDER BY `x360p_class_student`.`create_time`  desc LIMIT 0,10"}
     * authed : true
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
        /**
         * total : 1
         * list : [{"cid":4,"og_id":0,"bid":1,"parent_cid":0,"class_name":"徐老师1班","class_no":"","class_type":0,"lid":0,"sj_id":2,"grade":0,"sg_id":0,"unit_price":"0.00","per_lesson_hour_minutes":0,"consume_source_type":1,"consume_lesson_hour":"1.00","subject_grade":0,"teach_eid":10003,"second_eid":0,"second_eids":"","edu_eid":0,"cr_id":1,"plan_student_nums":16,"student_nums":13,"nums_rate":"0.81","lesson_times":14,"lesson_index":0,"arrange_times":10,"attendance_times":2,"year":2019,"season":"C","start_lesson_time":"2019-05-08","end_lesson_time":"2019-05-20","status":1,"ext_id":"","is_demo":0,"is_online":0,"create_uid":1,"int_start_hour":"0","int_end_hour":"0","student_artwork_count":0,"lesson":null,"classroom":{"cr_id":1,"og_id":0,"bid":1,"room_name":"MR001","seat_nums":16,"max_seat_nums":0,"listen_nums_limit":4,"seat_config":null,"area":"0.00"},"teacher":{"eid":10003,"og_id":0,"bid":1,"ename":"徐老师","pinyin":"xulaoshi","pinyin_abbr":"xls","nick_name":"","rids":[1],"bids":[1,2,3,4],"com_ids":"","lids":[],"sj_ids":[],"grades":"","uid":10014,"account":"17799999999","sex":"1","mobile":"17799999999","email":"","id_card_no":"","bank_card_no":"","photo_url":"http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg","birth_time":0,"birth_year":0,"birth_month":0,"birth_day":0,"is_part_job":0,"is_on_job":1,"join_int_day":0,"official_int_day":0,"remark":"","option_fields":"[]","user_status":1,"is_fsys":0,"teacher_level":-1,"college_did":0,"major_did":0,"degree_did":0,"have_cert":1,"ext_id":0},"assistant":null}]
         * page : 1
         * pagesize : 10
         * sql : SELECT * FROM `x360p_class_student` WHERE (  `sid` = 21  AND `x360p_class_student`.`og_id` = 0 ) AND `x360p_class_student`.`delete_time` IS NULL ORDER BY `x360p_class_student`.`create_time`  desc LIMIT 0,10
         */

        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * cid : 4
             * og_id : 0
             * bid : 1
             * parent_cid : 0
             * class_name : 徐老师1班
             * class_no :
             * class_type : 0
             * lid : 0
             * sj_id : 2
             * grade : 0
             * sg_id : 0
             * unit_price : 0.00
             * per_lesson_hour_minutes : 0
             * consume_source_type : 1
             * consume_lesson_hour : 1.00
             * subject_grade : 0
             * teach_eid : 10003
             * second_eid : 0
             * second_eids :
             * edu_eid : 0
             * cr_id : 1
             * plan_student_nums : 16
             * student_nums : 13
             * nums_rate : 0.81
             * lesson_times : 14
             * lesson_index : 0
             * arrange_times : 10
             * attendance_times : 2
             * year : 2019
             * season : C
             * start_lesson_time : 2019-05-08
             * end_lesson_time : 2019-05-20
             * status : 1
             * ext_id :
             * is_demo : 0
             * is_online : 0
             * create_uid : 1
             * int_start_hour : 0
             * int_end_hour : 0
             * student_artwork_count : 0
             * lesson : null
             * classroom : {"cr_id":1,"og_id":0,"bid":1,"room_name":"MR001","seat_nums":16,"max_seat_nums":0,"listen_nums_limit":4,"seat_config":null,"area":"0.00"}
             * teacher : {"eid":10003,"og_id":0,"bid":1,"ename":"徐老师","pinyin":"xulaoshi","pinyin_abbr":"xls","nick_name":"","rids":[1],"bids":[1,2,3,4],"com_ids":"","lids":[],"sj_ids":[],"grades":"","uid":10014,"account":"17799999999","sex":"1","mobile":"17799999999","email":"","id_card_no":"","bank_card_no":"","photo_url":"http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg","birth_time":0,"birth_year":0,"birth_month":0,"birth_day":0,"is_part_job":0,"is_on_job":1,"join_int_day":0,"official_int_day":0,"remark":"","option_fields":"[]","user_status":1,"is_fsys":0,"teacher_level":-1,"college_did":0,"major_did":0,"degree_did":0,"have_cert":1,"ext_id":0}
             * assistant : null
             */

            private String class_name;
            private int arrange_times;
            private int attendance_times;
            private ClassroomBean classroom;
            private TeacherBean teacher;

            public String getClass_name() {
                return class_name;
            }

            public void setClass_name(String class_name) {
                this.class_name = class_name;
            }

            public int getArrange_times() {
                return arrange_times;
            }

            public void setArrange_times(int arrange_times) {
                this.arrange_times = arrange_times;
            }

            public int getAttendance_times() {
                return attendance_times;
            }

            public void setAttendance_times(int attendance_times) {
                this.attendance_times = attendance_times;
            }

            public ClassroomBean getClassroom() {
                return classroom;
            }

            public void setClassroom(ClassroomBean classroom) {
                this.classroom = classroom;
            }

            public TeacherBean getTeacher() {
                return teacher;
            }

            public void setTeacher(TeacherBean teacher) {
                this.teacher = teacher;
            }

            public static class ClassroomBean {
                /**
                 * cr_id : 1
                 * og_id : 0
                 * bid : 1
                 * room_name : MR001
                 * seat_nums : 16
                 * max_seat_nums : 0
                 * listen_nums_limit : 4
                 * seat_config : null
                 * area : 0.00
                 */

                private String room_name;

                public String getRoom_name() {
                    return room_name;
                }

                public void setRoom_name(String room_name) {
                    this.room_name = room_name;
                }
            }

            public static class TeacherBean {
                /**
                 * eid : 10003
                 * og_id : 0
                 * bid : 1
                 * ename : 徐老师
                 * pinyin : xulaoshi
                 * pinyin_abbr : xls
                 * nick_name :
                 * rids : [1]
                 * bids : [1,2,3,4]
                 * com_ids :
                 * lids : []
                 * sj_ids : []
                 * grades :
                 * uid : 10014
                 * account : 17799999999
                 * sex : 1
                 * mobile : 17799999999
                 * email :
                 * id_card_no :
                 * bank_card_no :
                 * photo_url : http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg
                 * birth_time : 0
                 * birth_year : 0
                 * birth_month : 0
                 * birth_day : 0
                 * is_part_job : 0
                 * is_on_job : 1
                 * join_int_day : 0
                 * official_int_day : 0
                 * remark :
                 * option_fields : []
                 * user_status : 1
                 * is_fsys : 0
                 * teacher_level : -1
                 * college_did : 0
                 * major_did : 0
                 * degree_did : 0
                 * have_cert : 1
                 * ext_id : 0
                 */

                private String ename;
                private String photo_url;

                public String getEname() {
                    return ename;
                }

                public void setEname(String ename) {
                    this.ename = ename;
                }

                public String getPhoto_url() {
                    return photo_url;
                }

                public void setPhoto_url(String photo_url) {
                    this.photo_url = photo_url;
                }
            }
        }
    }
}
