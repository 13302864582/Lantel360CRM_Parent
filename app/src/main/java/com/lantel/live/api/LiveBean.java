package com.lantel.live.api;

import com.lantel.common.HttpResBean;

import java.util.List;

public class LiveBean  extends HttpResBean {


    /**
     * error : 0
     * message : success
     * data : {"total":1,"list":[{"sl_id":16,"og_id":0,"bid":2,"sid":12,"lid":92,"sj_ids":[6],"fit_grade_start":0,"fit_grade_end":0,"lesson_type":1,"price_type":2,"is_package":0,"origin_lesson_times":"1.00","present_lesson_times":"0.00","lesson_times":"1.00","origin_lesson_hours":"1.00","present_lesson_hours":"0.00","lesson_hours":"1.00","lesson_amount":"85.000000","import_lesson_hours":"0.00","refund_lesson_hours":"0.00","transfer_lesson_hours":"0.00","trans_out_lesson_hours":"0.00","trans_in_lesson_hours":"0.00","extra_lesson_hours":"0.00","expire_time":0,"cid":0,"eid":10012,"ac_status":0,"need_ac_nums":0,"ac_nums":0,"lesson_status":0,"is_stop":0,"use_times":0,"remain_times":0,"use_lesson_hours":"0.00","remain_lesson_hours":"1.00","remain_lesson_amount":"85.000000","last_attendance_time":0,"remain_arrange_times":-99999,"remain_arrange_hours":"1.00","start_int_day":20190529,"end_int_day":0,"is_demo":0,"is_online":1,"leave_nums_limit":-1,"teacher_level":-1,"create_uid":10001,"lesson":{"lid":92,"price_type":2,"lesson_name":"SAT 中级考前班(1-1)","unit_lesson_hours":"1.00","lesson_cover_picture":"","fit_age":[0,0],"fit_grade":[0,0]},"one_class":null,"room_client_uri":"https://stu.forbestacademy.com?roomID=10001&account=13928211122","roomID":10001,"account":"13928211122"}],"page":1,"pagesize":10,"sql":"SELECT * FROM `x360p_class` WHERE (  `cid` IN (0)  AND `x360p_class`.`og_id` = 0 ) AND `x360p_class`.`delete_time` IS NULL"}
     * authed : true
     */
    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * total : 1
         * list : [{"sl_id":16,"og_id":0,"bid":2,"sid":12,"lid":92,"sj_ids":[6],"fit_grade_start":0,"fit_grade_end":0,"lesson_type":1,"price_type":2,"is_package":0,"origin_lesson_times":"1.00","present_lesson_times":"0.00","lesson_times":"1.00","origin_lesson_hours":"1.00","present_lesson_hours":"0.00","lesson_hours":"1.00","lesson_amount":"85.000000","import_lesson_hours":"0.00","refund_lesson_hours":"0.00","transfer_lesson_hours":"0.00","trans_out_lesson_hours":"0.00","trans_in_lesson_hours":"0.00","extra_lesson_hours":"0.00","expire_time":0,"cid":0,"eid":10012,"ac_status":0,"need_ac_nums":0,"ac_nums":0,"lesson_status":0,"is_stop":0,"use_times":0,"remain_times":0,"use_lesson_hours":"0.00","remain_lesson_hours":"1.00","remain_lesson_amount":"85.000000","last_attendance_time":0,"remain_arrange_times":-99999,"remain_arrange_hours":"1.00","start_int_day":20190529,"end_int_day":0,"is_demo":0,"is_online":1,"leave_nums_limit":-1,"teacher_level":-1,"create_uid":10001,"lesson":{"lid":92,"price_type":2,"lesson_name":"SAT 中级考前班(1-1)","unit_lesson_hours":"1.00","lesson_cover_picture":"","fit_age":[0,0],"fit_grade":[0,0]},"one_class":null,"room_client_uri":"https://stu.forbestacademy.com?roomID=10001&account=13928211122","roomID":10001,"account":"13928211122"}]
         * page : 1
         * pagesize : 10
         * sql : SELECT * FROM `x360p_class` WHERE (  `cid` IN (0)  AND `x360p_class`.`og_id` = 0 ) AND `x360p_class`.`delete_time` IS NULL
         */
        private int total;

        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * sl_id : 16
             * og_id : 0
             * bid : 2
             * sid : 12
             * lid : 92
             * sj_ids : [6]
             * fit_grade_start : 0
             * fit_grade_end : 0
             * lesson_type : 1
             * price_type : 2
             * is_package : 0
             * origin_lesson_times : 1.00
             * present_lesson_times : 0.00
             * lesson_times : 1.00
             * origin_lesson_hours : 1.00
             * present_lesson_hours : 0.00
             * lesson_hours : 1.00
             * lesson_amount : 85.000000
             * import_lesson_hours : 0.00
             * refund_lesson_hours : 0.00
             * transfer_lesson_hours : 0.00
             * trans_out_lesson_hours : 0.00
             * trans_in_lesson_hours : 0.00
             * extra_lesson_hours : 0.00
             * expire_time : 0
             * cid : 0
             * eid : 10012
             * ac_status : 0
             * need_ac_nums : 0
             * ac_nums : 0
             * lesson_status : 0
             * is_stop : 0
             * use_times : 0
             * remain_times : 0
             * use_lesson_hours : 0.00
             * remain_lesson_hours : 1.00
             * remain_lesson_amount : 85.000000
             * last_attendance_time : 0
             * remain_arrange_times : -99999
             * remain_arrange_hours : 1.00
             * start_int_day : 20190529
             * end_int_day : 0
             * is_demo : 0
             * is_online : 1
             * leave_nums_limit : -1
             * teacher_level : -1
             * create_uid : 10001
             * lesson : {"lid":92,"price_type":2,"lesson_name":"SAT 中级考前班(1-1)","unit_lesson_hours":"1.00","lesson_cover_picture":"","fit_age":[0,0],"fit_grade":[0,0]}
             * one_class : null
             * room_client_uri : https://stu.forbestacademy.com?roomID=10001&account=13928211122
             * roomID : 10001
             * account : 13928211122
             */

            private int sl_id;
            private int og_id;
            private int bid;
            private int sid;
            private int lid;
            private int fit_grade_start;
            private int fit_grade_end;
            private int lesson_type;
            private int price_type;
            private int is_package;
            private String origin_lesson_times;
            private String present_lesson_times;
            private int lesson_times;
            private String origin_lesson_hours;
            private String present_lesson_hours;
            private String lesson_hours;
            private String lesson_amount;
            private String import_lesson_hours;
            private String refund_lesson_hours;
            private String transfer_lesson_hours;
            private String trans_out_lesson_hours;
            private String trans_in_lesson_hours;
            private String extra_lesson_hours;
            private int expire_time;
            private int cid;
            private int eid;
            private int ac_status;
            private int need_ac_nums;
            private int ac_nums;
            private int lesson_status;
            private int is_stop;
            private int use_times;
            private int remain_times;
            private String use_lesson_hours;
            private String remain_lesson_hours;
            private String remain_lesson_amount;
            private int last_attendance_time;
            private int remain_arrange_times;
            private String remain_arrange_hours;
            private int start_int_day;
            private int end_int_day;
            private int is_demo;
            private int is_online;
            private int leave_nums_limit;
            private int teacher_level;
            private int create_uid;
            private LessonBean lesson;
            private OneClassBean one_class;
            private String room_client_uri;
            private int roomID;
            private String account;
            private List<Integer> sj_ids;

            public static class OneClassBean {
                /**
                 * cid : 2
                 * og_id : 0
                 * bid : 1
                 * parent_cid : 0
                 * class_name : 数学001班
                 * class_no : SX001
                 * class_type : 0
                 * lid : 1
                 * sj_id : 1
                 * grade : 0
                 * sg_id : 0
                 * unit_price : 0.00
                 * per_lesson_hour_minutes : 0
                 * consume_source_type : 1
                 * consume_lesson_hour : 0.00
                 * subject_grade : 0
                 * teach_eid : 10002
                 * second_eid : 0
                 * second_eids :
                 * edu_eid : 0
                 * cr_id : 1
                 * plan_student_nums : 20
                 * student_nums : 4
                 * nums_rate : 0.20
                 * lesson_times : 200
                 * lesson_index : 0
                 * arrange_times : 38
                 * attendance_times : 2
                 * year : 2018
                 * season : A
                 * start_lesson_time : 2018-01-01
                 * end_lesson_time : 2019-05-27
                 * status : 1
                 * ext_id :
                 * is_demo : 0
                 * is_online : 0
                 * create_uid : 1
                 * int_start_hour : 0
                 * int_end_hour : 0
                 */

                private int cid;
                private int og_id;
                private int bid;
                private int parent_cid;
                private String class_name;
                private String class_no;
                private int class_type;
                private int lid;
                private int sj_id;
                private int grade;
                private int sg_id;
                private String unit_price;
                private int per_lesson_hour_minutes;
                private int consume_source_type;
                private String consume_lesson_hour;
                private int subject_grade;
                private int teach_eid;
                private int second_eid;
                private String second_eids;
                private int edu_eid;
                private int cr_id;
                private int plan_student_nums;
                private int student_nums;
                private String nums_rate;
                private int lesson_times;
                private int lesson_index;
                private int arrange_times;
                private int attendance_times;
                private int year;
                private String season;
                private String start_lesson_time;
                private String end_lesson_time;
                private int status;
                private String ext_id;
                private int is_demo;
                private int is_online;
                private int create_uid;
                private String int_start_hour;
                private String int_end_hour;

                public int getCid() {
                    return cid;
                }

                public void setCid(int cid) {
                    this.cid = cid;
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

                public int getParent_cid() {
                    return parent_cid;
                }

                public void setParent_cid(int parent_cid) {
                    this.parent_cid = parent_cid;
                }

                public String getClass_name() {
                    return class_name;
                }

                public void setClass_name(String class_name) {
                    this.class_name = class_name;
                }

                public String getClass_no() {
                    return class_no;
                }

                public void setClass_no(String class_no) {
                    this.class_no = class_no;
                }

                public int getClass_type() {
                    return class_type;
                }

                public void setClass_type(int class_type) {
                    this.class_type = class_type;
                }

                public int getLid() {
                    return lid;
                }

                public void setLid(int lid) {
                    this.lid = lid;
                }

                public int getSj_id() {
                    return sj_id;
                }

                public void setSj_id(int sj_id) {
                    this.sj_id = sj_id;
                }

                public int getGrade() {
                    return grade;
                }

                public void setGrade(int grade) {
                    this.grade = grade;
                }

                public int getSg_id() {
                    return sg_id;
                }

                public void setSg_id(int sg_id) {
                    this.sg_id = sg_id;
                }

                public String getUnit_price() {
                    return unit_price;
                }

                public void setUnit_price(String unit_price) {
                    this.unit_price = unit_price;
                }

                public int getPer_lesson_hour_minutes() {
                    return per_lesson_hour_minutes;
                }

                public void setPer_lesson_hour_minutes(int per_lesson_hour_minutes) {
                    this.per_lesson_hour_minutes = per_lesson_hour_minutes;
                }

                public int getConsume_source_type() {
                    return consume_source_type;
                }

                public void setConsume_source_type(int consume_source_type) {
                    this.consume_source_type = consume_source_type;
                }

                public String getConsume_lesson_hour() {
                    return consume_lesson_hour;
                }

                public void setConsume_lesson_hour(String consume_lesson_hour) {
                    this.consume_lesson_hour = consume_lesson_hour;
                }

                public int getSubject_grade() {
                    return subject_grade;
                }

                public void setSubject_grade(int subject_grade) {
                    this.subject_grade = subject_grade;
                }

                public int getTeach_eid() {
                    return teach_eid;
                }

                public void setTeach_eid(int teach_eid) {
                    this.teach_eid = teach_eid;
                }

                public int getSecond_eid() {
                    return second_eid;
                }

                public void setSecond_eid(int second_eid) {
                    this.second_eid = second_eid;
                }

                public String getSecond_eids() {
                    return second_eids;
                }

                public void setSecond_eids(String second_eids) {
                    this.second_eids = second_eids;
                }

                public int getEdu_eid() {
                    return edu_eid;
                }

                public void setEdu_eid(int edu_eid) {
                    this.edu_eid = edu_eid;
                }

                public int getCr_id() {
                    return cr_id;
                }

                public void setCr_id(int cr_id) {
                    this.cr_id = cr_id;
                }

                public int getPlan_student_nums() {
                    return plan_student_nums;
                }

                public void setPlan_student_nums(int plan_student_nums) {
                    this.plan_student_nums = plan_student_nums;
                }

                public int getStudent_nums() {
                    return student_nums;
                }

                public void setStudent_nums(int student_nums) {
                    this.student_nums = student_nums;
                }

                public String getNums_rate() {
                    return nums_rate;
                }

                public void setNums_rate(String nums_rate) {
                    this.nums_rate = nums_rate;
                }

                public int getLesson_times() {
                    return lesson_times;
                }

                public void setLesson_times(int lesson_times) {
                    this.lesson_times = lesson_times;
                }

                public int getLesson_index() {
                    return lesson_index;
                }

                public void setLesson_index(int lesson_index) {
                    this.lesson_index = lesson_index;
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

                public int getYear() {
                    return year;
                }

                public void setYear(int year) {
                    this.year = year;
                }

                public String getSeason() {
                    return season;
                }

                public void setSeason(String season) {
                    this.season = season;
                }

                public String getStart_lesson_time() {
                    return start_lesson_time;
                }

                public void setStart_lesson_time(String start_lesson_time) {
                    this.start_lesson_time = start_lesson_time;
                }

                public String getEnd_lesson_time() {
                    return end_lesson_time;
                }

                public void setEnd_lesson_time(String end_lesson_time) {
                    this.end_lesson_time = end_lesson_time;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public String getExt_id() {
                    return ext_id;
                }

                public void setExt_id(String ext_id) {
                    this.ext_id = ext_id;
                }

                public int getIs_demo() {
                    return is_demo;
                }

                public void setIs_demo(int is_demo) {
                    this.is_demo = is_demo;
                }

                public int getIs_online() {
                    return is_online;
                }

                public void setIs_online(int is_online) {
                    this.is_online = is_online;
                }

                public int getCreate_uid() {
                    return create_uid;
                }

                public void setCreate_uid(int create_uid) {
                    this.create_uid = create_uid;
                }

                public String getInt_start_hour() {
                    return int_start_hour;
                }

                public void setInt_start_hour(String int_start_hour) {
                    this.int_start_hour = int_start_hour;
                }

                public String getInt_end_hour() {
                    return int_end_hour;
                }

                public void setInt_end_hour(String int_end_hour) {
                    this.int_end_hour = int_end_hour;
                }
            }

            public int getSl_id() {
                return sl_id;
            }

            public void setSl_id(int sl_id) {
                this.sl_id = sl_id;
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

            public int getSid() {
                return sid;
            }

            public void setSid(int sid) {
                this.sid = sid;
            }

            public int getLid() {
                return lid;
            }

            public void setLid(int lid) {
                this.lid = lid;
            }

            public int getFit_grade_start() {
                return fit_grade_start;
            }

            public void setFit_grade_start(int fit_grade_start) {
                this.fit_grade_start = fit_grade_start;
            }

            public int getFit_grade_end() {
                return fit_grade_end;
            }

            public void setFit_grade_end(int fit_grade_end) {
                this.fit_grade_end = fit_grade_end;
            }

            public int getLesson_type() {
                return lesson_type;
            }

            public void setLesson_type(int lesson_type) {
                this.lesson_type = lesson_type;
            }

            public int getPrice_type() {
                return price_type;
            }

            public void setPrice_type(int price_type) {
                this.price_type = price_type;
            }

            public int getIs_package() {
                return is_package;
            }

            public void setIs_package(int is_package) {
                this.is_package = is_package;
            }

            public String getOrigin_lesson_times() {
                return origin_lesson_times;
            }

            public void setOrigin_lesson_times(String origin_lesson_times) {
                this.origin_lesson_times = origin_lesson_times;
            }

            public String getPresent_lesson_times() {
                return present_lesson_times;
            }

            public void setPresent_lesson_times(String present_lesson_times) {
                this.present_lesson_times = present_lesson_times;
            }

            public int getLesson_times() {
                return lesson_times;
            }

            public void setLesson_times(int lesson_times) {
                this.lesson_times = lesson_times;
            }

            public String getOrigin_lesson_hours() {
                return origin_lesson_hours;
            }

            public void setOrigin_lesson_hours(String origin_lesson_hours) {
                this.origin_lesson_hours = origin_lesson_hours;
            }

            public String getPresent_lesson_hours() {
                return present_lesson_hours;
            }

            public void setPresent_lesson_hours(String present_lesson_hours) {
                this.present_lesson_hours = present_lesson_hours;
            }

            public String getLesson_hours() {
                return lesson_hours;
            }

            public void setLesson_hours(String lesson_hours) {
                this.lesson_hours = lesson_hours;
            }

            public String getLesson_amount() {
                return lesson_amount;
            }

            public void setLesson_amount(String lesson_amount) {
                this.lesson_amount = lesson_amount;
            }

            public String getImport_lesson_hours() {
                return import_lesson_hours;
            }

            public void setImport_lesson_hours(String import_lesson_hours) {
                this.import_lesson_hours = import_lesson_hours;
            }

            public String getRefund_lesson_hours() {
                return refund_lesson_hours;
            }

            public void setRefund_lesson_hours(String refund_lesson_hours) {
                this.refund_lesson_hours = refund_lesson_hours;
            }

            public String getTransfer_lesson_hours() {
                return transfer_lesson_hours;
            }

            public void setTransfer_lesson_hours(String transfer_lesson_hours) {
                this.transfer_lesson_hours = transfer_lesson_hours;
            }

            public String getTrans_out_lesson_hours() {
                return trans_out_lesson_hours;
            }

            public void setTrans_out_lesson_hours(String trans_out_lesson_hours) {
                this.trans_out_lesson_hours = trans_out_lesson_hours;
            }

            public String getTrans_in_lesson_hours() {
                return trans_in_lesson_hours;
            }

            public void setTrans_in_lesson_hours(String trans_in_lesson_hours) {
                this.trans_in_lesson_hours = trans_in_lesson_hours;
            }

            public String getExtra_lesson_hours() {
                return extra_lesson_hours;
            }

            public void setExtra_lesson_hours(String extra_lesson_hours) {
                this.extra_lesson_hours = extra_lesson_hours;
            }

            public int getExpire_time() {
                return expire_time;
            }

            public void setExpire_time(int expire_time) {
                this.expire_time = expire_time;
            }

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public int getEid() {
                return eid;
            }

            public void setEid(int eid) {
                this.eid = eid;
            }

            public int getAc_status() {
                return ac_status;
            }

            public void setAc_status(int ac_status) {
                this.ac_status = ac_status;
            }

            public int getNeed_ac_nums() {
                return need_ac_nums;
            }

            public void setNeed_ac_nums(int need_ac_nums) {
                this.need_ac_nums = need_ac_nums;
            }

            public int getAc_nums() {
                return ac_nums;
            }

            public void setAc_nums(int ac_nums) {
                this.ac_nums = ac_nums;
            }

            public int getLesson_status() {
                return lesson_status;
            }

            public void setLesson_status(int lesson_status) {
                this.lesson_status = lesson_status;
            }

            public int getIs_stop() {
                return is_stop;
            }

            public void setIs_stop(int is_stop) {
                this.is_stop = is_stop;
            }

            public int getUse_times() {
                return use_times;
            }

            public void setUse_times(int use_times) {
                this.use_times = use_times;
            }

            public int getRemain_times() {
                return remain_times;
            }

            public void setRemain_times(int remain_times) {
                this.remain_times = remain_times;
            }

            public String getUse_lesson_hours() {
                return use_lesson_hours;
            }

            public void setUse_lesson_hours(String use_lesson_hours) {
                this.use_lesson_hours = use_lesson_hours;
            }

            public String getRemain_lesson_hours() {
                return remain_lesson_hours;
            }

            public void setRemain_lesson_hours(String remain_lesson_hours) {
                this.remain_lesson_hours = remain_lesson_hours;
            }

            public String getRemain_lesson_amount() {
                return remain_lesson_amount;
            }

            public void setRemain_lesson_amount(String remain_lesson_amount) {
                this.remain_lesson_amount = remain_lesson_amount;
            }

            public int getLast_attendance_time() {
                return last_attendance_time;
            }

            public void setLast_attendance_time(int last_attendance_time) {
                this.last_attendance_time = last_attendance_time;
            }

            public int getRemain_arrange_times() {
                return remain_arrange_times;
            }

            public void setRemain_arrange_times(int remain_arrange_times) {
                this.remain_arrange_times = remain_arrange_times;
            }

            public String getRemain_arrange_hours() {
                return remain_arrange_hours;
            }

            public void setRemain_arrange_hours(String remain_arrange_hours) {
                this.remain_arrange_hours = remain_arrange_hours;
            }

            public int getStart_int_day() {
                return start_int_day;
            }

            public void setStart_int_day(int start_int_day) {
                this.start_int_day = start_int_day;
            }

            public int getEnd_int_day() {
                return end_int_day;
            }

            public void setEnd_int_day(int end_int_day) {
                this.end_int_day = end_int_day;
            }

            public int getIs_demo() {
                return is_demo;
            }

            public void setIs_demo(int is_demo) {
                this.is_demo = is_demo;
            }

            public int getIs_online() {
                return is_online;
            }

            public void setIs_online(int is_online) {
                this.is_online = is_online;
            }

            public int getLeave_nums_limit() {
                return leave_nums_limit;
            }

            public void setLeave_nums_limit(int leave_nums_limit) {
                this.leave_nums_limit = leave_nums_limit;
            }

            public int getTeacher_level() {
                return teacher_level;
            }

            public void setTeacher_level(int teacher_level) {
                this.teacher_level = teacher_level;
            }

            public int getCreate_uid() {
                return create_uid;
            }

            public void setCreate_uid(int create_uid) {
                this.create_uid = create_uid;
            }

            public LessonBean getLesson() {
                return lesson;
            }

            public void setLesson(LessonBean lesson) {
                this.lesson = lesson;
            }

            public OneClassBean getOne_class() {
                return one_class;
            }

            public void setOne_class(OneClassBean one_class) {
                this.one_class = one_class;
            }

            public String getRoom_client_uri() {
                return room_client_uri;
            }

            public void setRoom_client_uri(String room_client_uri) {
                this.room_client_uri = room_client_uri;
            }

            public int getRoomID() {
                return roomID;
            }

            public void setRoomID(int roomID) {
                this.roomID = roomID;
            }

            public String getAccount() {
                return account;
            }

            public void setAccount(String account) {
                this.account = account;
            }

            public List<Integer> getSj_ids() {
                return sj_ids;
            }

            public void setSj_ids(List<Integer> sj_ids) {
                this.sj_ids = sj_ids;
            }

            public static class LessonBean {
                /**
                 * lid : 92
                 * price_type : 2
                 * lesson_name : SAT 中级考前班(1-1)
                 * unit_lesson_hours : 1.00
                 * lesson_cover_picture :
                 * fit_age : [0,0]
                 * fit_grade : [0,0]
                 */

                private int lid;
                private int price_type;
                private String lesson_name;
                private String unit_lesson_hours;
                private String lesson_cover_picture;
                private List<Integer> fit_age;
                private List<Integer> fit_grade;

                public int getLid() {
                    return lid;
                }

                public void setLid(int lid) {
                    this.lid = lid;
                }

                public int getPrice_type() {
                    return price_type;
                }

                public void setPrice_type(int price_type) {
                    this.price_type = price_type;
                }

                public String getLesson_name() {
                    return lesson_name;
                }

                public void setLesson_name(String lesson_name) {
                    this.lesson_name = lesson_name;
                }

                public String getUnit_lesson_hours() {
                    return unit_lesson_hours;
                }

                public void setUnit_lesson_hours(String unit_lesson_hours) {
                    this.unit_lesson_hours = unit_lesson_hours;
                }

                public String getLesson_cover_picture() {
                    return lesson_cover_picture;
                }

                public void setLesson_cover_picture(String lesson_cover_picture) {
                    this.lesson_cover_picture = lesson_cover_picture;
                }

                public List<Integer> getFit_age() {
                    return fit_age;
                }

                public void setFit_age(List<Integer> fit_age) {
                    this.fit_age = fit_age;
                }

                public List<Integer> getFit_grade() {
                    return fit_grade;
                }

                public void setFit_grade(List<Integer> fit_grade) {
                    this.fit_grade = fit_grade;
                }
            }
        }
    }
}
