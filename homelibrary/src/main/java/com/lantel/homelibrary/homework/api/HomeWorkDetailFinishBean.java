package com.lantel.homelibrary.homework.api;

import java.util.List;

public class HomeWorkDetailFinishBean {

    /**
     * error : 0
     * message : success
     * data : {"ht_id":64,"og_id":0,"bid":1,"lid":2,"ca_id":91,"lesson_type":1,"cid":0,"sid":21,"sids":[""],"eid":10007,"htts_id":0,"content":"<p>fzfzfz<\/p>","remark":"","deadline":20190530,"push_status":1,"create_time":"2019-06-21 09:13:12","homework_complete":{"hc_id":25,"og_id":0,"bid":1,"cid":0,"ca_id":91,"lid":2,"ht_id":64,"sid":21,"star":0,"content":"qwertyu","is_check":0,"is_publish":0,"check_time":0,"check_uid":0,"check_level":0,"check_content":null,"result_level":0,"sart_id":0,"is_rejected":0,"rejected_reason":"","rejected_time":0,"create_time":"2019-06-21 09:17:41","complete_attachment":{"ha_id":65,"og_id":0,"ht_id":0,"hc_id":25,"hr_id":0,"att_type":1,"file_id":196,"file_url":"http://s10.xiao360.com/qms/com.lantel.lh01/homework/26054319-4eed-4302-8ead-655ff99ef24d.png","file_type":"png","file_size":1918517,"file_name":"26054319-4eed-4302-8ead-655ff99ef24d.png","duration":"","media_type":"image","create_uid":10028},"homework_reply":null},"student":{"sid":21,"bid":1,"student_name":"test02","sex":"2","photo_url":"http://s10.xiao360.com//Users/mac/Library/Developer/CoreSimulator/Devices/A5F463A1-8F5E-4BD5-A404-EEE1454B889F/data/Containers/Data/Application/C7772289-5FBA-42F0-AAD0-E91F7143388C/Documents/1560491879193.png","school_id_text":""},"one_class":null,"homework_attachment":[{"ha_id":62,"og_id":0,"ht_id":64,"hc_id":0,"hr_id":0,"att_type":0,"file_id":182,"file_url":"http://s10.xiao360.com/qms/1/0/RfjNpbtqK9XbzUEj4r7YLcNoGjQoigKc.png","file_type":"png","file_size":248222,"file_name":"屏幕快照 2019-06-20 上午11.01.18.png","duration":"","media_type":"image","create_uid":1},{"ha_id":63,"og_id":0,"ht_id":64,"hc_id":0,"hr_id":0,"att_type":0,"file_id":146,"file_url":"http://s10.xiao360.com/qms/student_avatar/1/19/06/06/d73d000343f5b813e02e5aeb83f2c478.png","file_type":"png","file_size":336829,"file_name":"648a44cdddcd1a5aabfecb72ff760a54.jpg","duration":"","media_type":"image","create_uid":1},{"ha_id":64,"og_id":0,"ht_id":64,"hc_id":0,"hr_id":0,"att_type":0,"file_id":132,"file_url":"http://s10.xiao360.com/qms/1/0/r23F2zL5w8XsI433KG5xpJxcaP3nF3fb.jpg","file_type":"jpg","file_size":42411,"file_name":"u=2791487048,1056707858&fm=214&gp=0.jpg","duration":"","media_type":"image","create_uid":1}],"employee":{"eid":10007,"ename":"吴喆聪","uid":10031,"mobile":"13800013800","photo_url":""}}
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
         * ht_id : 64
         * og_id : 0
         * bid : 1
         * lid : 2
         * ca_id : 91
         * lesson_type : 1
         * cid : 0
         * sid : 21
         * sids : [""]
         * eid : 10007
         * htts_id : 0
         * content : <p>fzfzfz</p>
         * remark :
         * deadline : 20190530
         * push_status : 1
         * create_time : 2019-06-21 09:13:12
         * homework_complete : {"hc_id":25,"og_id":0,"bid":1,"cid":0,"ca_id":91,"lid":2,"ht_id":64,"sid":21,"star":0,"content":"qwertyu","is_check":0,"is_publish":0,"check_time":0,"check_uid":0,"check_level":0,"check_content":null,"result_level":0,"sart_id":0,"is_rejected":0,"rejected_reason":"","rejected_time":0,"create_time":"2019-06-21 09:17:41","complete_attachment":{"ha_id":65,"og_id":0,"ht_id":0,"hc_id":25,"hr_id":0,"att_type":1,"file_id":196,"file_url":"http://s10.xiao360.com/qms/com.lantel.lh01/homework/26054319-4eed-4302-8ead-655ff99ef24d.png","file_type":"png","file_size":1918517,"file_name":"26054319-4eed-4302-8ead-655ff99ef24d.png","duration":"","media_type":"image","create_uid":10028},"homework_reply":null}
         * student : {"sid":21,"bid":1,"student_name":"test02","sex":"2","photo_url":"http://s10.xiao360.com//Users/mac/Library/Developer/CoreSimulator/Devices/A5F463A1-8F5E-4BD5-A404-EEE1454B889F/data/Containers/Data/Application/C7772289-5FBA-42F0-AAD0-E91F7143388C/Documents/1560491879193.png","school_id_text":""}
         * one_class : null
         * homework_attachment : [{"ha_id":62,"og_id":0,"ht_id":64,"hc_id":0,"hr_id":0,"att_type":0,"file_id":182,"file_url":"http://s10.xiao360.com/qms/1/0/RfjNpbtqK9XbzUEj4r7YLcNoGjQoigKc.png","file_type":"png","file_size":248222,"file_name":"屏幕快照 2019-06-20 上午11.01.18.png","duration":"","media_type":"image","create_uid":1},{"ha_id":63,"og_id":0,"ht_id":64,"hc_id":0,"hr_id":0,"att_type":0,"file_id":146,"file_url":"http://s10.xiao360.com/qms/student_avatar/1/19/06/06/d73d000343f5b813e02e5aeb83f2c478.png","file_type":"png","file_size":336829,"file_name":"648a44cdddcd1a5aabfecb72ff760a54.jpg","duration":"","media_type":"image","create_uid":1},{"ha_id":64,"og_id":0,"ht_id":64,"hc_id":0,"hr_id":0,"att_type":0,"file_id":132,"file_url":"http://s10.xiao360.com/qms/1/0/r23F2zL5w8XsI433KG5xpJxcaP3nF3fb.jpg","file_type":"jpg","file_size":42411,"file_name":"u=2791487048,1056707858&fm=214&gp=0.jpg","duration":"","media_type":"image","create_uid":1}]
         * employee : {"eid":10007,"ename":"吴喆聪","uid":10031,"mobile":"13800013800","photo_url":""}
         */

        private int ht_id;
        private int og_id;
        private int bid;
        private int lid;
        private int ca_id;
        private int lesson_type;
        private int cid;
        private int sid;
        private int eid;
        private int htts_id;
        private String content;
        private String remark;
        private int deadline;
        private int push_status;
        private String create_time;
        private HomeworkCompleteBean homework_complete;
        private StudentBean student;
        private OneClassBean one_class;
        private EmployeeBean employee;
        private List<String> sids;
        private List<HomeworkAttachmentBean> homework_attachment;

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

        public int getHt_id() {
            return ht_id;
        }

        public void setHt_id(int ht_id) {
            this.ht_id = ht_id;
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

        public int getLid() {
            return lid;
        }

        public void setLid(int lid) {
            this.lid = lid;
        }

        public int getCa_id() {
            return ca_id;
        }

        public void setCa_id(int ca_id) {
            this.ca_id = ca_id;
        }

        public int getLesson_type() {
            return lesson_type;
        }

        public void setLesson_type(int lesson_type) {
            this.lesson_type = lesson_type;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public int getSid() {
            return sid;
        }

        public void setSid(int sid) {
            this.sid = sid;
        }

        public int getEid() {
            return eid;
        }

        public void setEid(int eid) {
            this.eid = eid;
        }

        public int getHtts_id() {
            return htts_id;
        }

        public void setHtts_id(int htts_id) {
            this.htts_id = htts_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getDeadline() {
            return deadline;
        }

        public void setDeadline(int deadline) {
            this.deadline = deadline;
        }

        public int getPush_status() {
            return push_status;
        }

        public void setPush_status(int push_status) {
            this.push_status = push_status;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public HomeworkCompleteBean getHomework_complete() {
            return homework_complete;
        }

        public void setHomework_complete(HomeworkCompleteBean homework_complete) {
            this.homework_complete = homework_complete;
        }

        public StudentBean getStudent() {
            return student;
        }

        public void setStudent(StudentBean student) {
            this.student = student;
        }

        public OneClassBean getOne_class() {
            return one_class;
        }

        public void setOne_class(OneClassBean one_class) {
            this.one_class = one_class;
        }

        public EmployeeBean getEmployee() {
            return employee;
        }

        public void setEmployee(EmployeeBean employee) {
            this.employee = employee;
        }

        public List<String> getSids() {
            return sids;
        }

        public void setSids(List<String> sids) {
            this.sids = sids;
        }

        public List<HomeworkAttachmentBean> getHomework_attachment() {
            return homework_attachment;
        }

        public void setHomework_attachment(List<HomeworkAttachmentBean> homework_attachment) {
            this.homework_attachment = homework_attachment;
        }

        public static class HomeworkCompleteBean {
            /**
             * hc_id : 25
             * og_id : 0
             * bid : 1
             * cid : 0
             * ca_id : 91
             * lid : 2
             * ht_id : 64
             * sid : 21
             * star : 0
             * content : qwertyu
             * is_check : 0
             * is_publish : 0
             * check_time : 0
             * check_uid : 0
             * check_level : 0
             * check_content : null
             * result_level : 0
             * sart_id : 0
             * is_rejected : 0
             * rejected_reason :
             * rejected_time : 0
             * create_time : 2019-06-21 09:17:41
             * complete_attachment : {"ha_id":65,"og_id":0,"ht_id":0,"hc_id":25,"hr_id":0,"att_type":1,"file_id":196,"file_url":"http://s10.xiao360.com/qms/com.lantel.lh01/homework/26054319-4eed-4302-8ead-655ff99ef24d.png","file_type":"png","file_size":1918517,"file_name":"26054319-4eed-4302-8ead-655ff99ef24d.png","duration":"","media_type":"image","create_uid":10028}
             * homework_reply : null
             */

            private int hc_id;
            private int og_id;
            private int bid;
            private int cid;
            private int ca_id;
            private int lid;
            private int ht_id;
            private int sid;
            private int star;
            private String content;
            private int is_check;
            private int is_publish;
            private int check_time;
            private int check_uid;
            private int check_level;
            private int result_level;
            private int sart_id;
            private int is_rejected;
            private String rejected_reason;
            private int rejected_time;
            private String create_time;
            private List<CompleteAttachmentBean> complete_attachment;
            private Object homework_reply;

            public int getHc_id() {
                return hc_id;
            }

            public void setHc_id(int hc_id) {
                this.hc_id = hc_id;
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

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
            }

            public int getCa_id() {
                return ca_id;
            }

            public void setCa_id(int ca_id) {
                this.ca_id = ca_id;
            }

            public int getLid() {
                return lid;
            }

            public void setLid(int lid) {
                this.lid = lid;
            }

            public int getHt_id() {
                return ht_id;
            }

            public void setHt_id(int ht_id) {
                this.ht_id = ht_id;
            }

            public int getSid() {
                return sid;
            }

            public void setSid(int sid) {
                this.sid = sid;
            }

            public int getStar() {
                return star;
            }

            public void setStar(int star) {
                this.star = star;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getIs_check() {
                return is_check;
            }

            public void setIs_check(int is_check) {
                this.is_check = is_check;
            }

            public int getIs_publish() {
                return is_publish;
            }

            public void setIs_publish(int is_publish) {
                this.is_publish = is_publish;
            }

            public int getCheck_time() {
                return check_time;
            }

            public void setCheck_time(int check_time) {
                this.check_time = check_time;
            }

            public int getCheck_uid() {
                return check_uid;
            }

            public void setCheck_uid(int check_uid) {
                this.check_uid = check_uid;
            }

            public int getCheck_level() {
                return check_level;
            }

            public void setCheck_level(int check_level) {
                this.check_level = check_level;
            }

            public int getResult_level() {
                return result_level;
            }

            public void setResult_level(int result_level) {
                this.result_level = result_level;
            }

            public int getSart_id() {
                return sart_id;
            }

            public void setSart_id(int sart_id) {
                this.sart_id = sart_id;
            }

            public int getIs_rejected() {
                return is_rejected;
            }

            public void setIs_rejected(int is_rejected) {
                this.is_rejected = is_rejected;
            }

            public String getRejected_reason() {
                return rejected_reason;
            }

            public void setRejected_reason(String rejected_reason) {
                this.rejected_reason = rejected_reason;
            }

            public int getRejected_time() {
                return rejected_time;
            }

            public void setRejected_time(int rejected_time) {
                this.rejected_time = rejected_time;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public List<CompleteAttachmentBean> getComplete_attachment() {
                return complete_attachment;
            }

            public void setComplete_attachment(List<CompleteAttachmentBean> complete_attachment) {
                this.complete_attachment = complete_attachment;
            }

            public Object getHomework_reply() {
                return homework_reply;
            }

            public void setHomework_reply(Object homework_reply) {
                this.homework_reply = homework_reply;
            }

            public static class CompleteAttachmentBean {
                /**
                 * ha_id : 65
                 * og_id : 0
                 * ht_id : 0
                 * hc_id : 25
                 * hr_id : 0
                 * att_type : 1
                 * file_id : 196
                 * file_url : http://s10.xiao360.com/qms/com.lantel.lh01/homework/26054319-4eed-4302-8ead-655ff99ef24d.png
                 * file_type : png
                 * file_size : 1918517
                 * file_name : 26054319-4eed-4302-8ead-655ff99ef24d.png
                 * duration :
                 * media_type : image
                 * create_uid : 10028
                 */

                private int ha_id;
                private int og_id;
                private int ht_id;
                private int hc_id;
                private int hr_id;
                private int att_type;
                private int file_id;
                private String file_url;
                private String file_type;
                private int file_size;
                private String file_name;
                private String duration;
                private String media_type;
                private int create_uid;

                public int getHa_id() {
                    return ha_id;
                }

                public void setHa_id(int ha_id) {
                    this.ha_id = ha_id;
                }

                public int getOg_id() {
                    return og_id;
                }

                public void setOg_id(int og_id) {
                    this.og_id = og_id;
                }

                public int getHt_id() {
                    return ht_id;
                }

                public void setHt_id(int ht_id) {
                    this.ht_id = ht_id;
                }

                public int getHc_id() {
                    return hc_id;
                }

                public void setHc_id(int hc_id) {
                    this.hc_id = hc_id;
                }

                public int getHr_id() {
                    return hr_id;
                }

                public void setHr_id(int hr_id) {
                    this.hr_id = hr_id;
                }

                public int getAtt_type() {
                    return att_type;
                }

                public void setAtt_type(int att_type) {
                    this.att_type = att_type;
                }

                public int getFile_id() {
                    return file_id;
                }

                public void setFile_id(int file_id) {
                    this.file_id = file_id;
                }

                public String getFile_url() {
                    return file_url;
                }

                public void setFile_url(String file_url) {
                    this.file_url = file_url;
                }

                public String getFile_type() {
                    return file_type;
                }

                public void setFile_type(String file_type) {
                    this.file_type = file_type;
                }

                public int getFile_size() {
                    return file_size;
                }

                public void setFile_size(int file_size) {
                    this.file_size = file_size;
                }

                public String getFile_name() {
                    return file_name;
                }

                public void setFile_name(String file_name) {
                    this.file_name = file_name;
                }

                public String getDuration() {
                    return duration;
                }

                public void setDuration(String duration) {
                    this.duration = duration;
                }

                public String getMedia_type() {
                    return media_type;
                }

                public void setMedia_type(String media_type) {
                    this.media_type = media_type;
                }

                public int getCreate_uid() {
                    return create_uid;
                }

                public void setCreate_uid(int create_uid) {
                    this.create_uid = create_uid;
                }
            }
        }

        public static class StudentBean {
            /**
             * sid : 21
             * bid : 1
             * student_name : test02
             * sex : 2
             * photo_url : http://s10.xiao360.com//Users/mac/Library/Developer/CoreSimulator/Devices/A5F463A1-8F5E-4BD5-A404-EEE1454B889F/data/Containers/Data/Application/C7772289-5FBA-42F0-AAD0-E91F7143388C/Documents/1560491879193.png
             * school_id_text :
             */

            private int sid;
            private int bid;
            private String student_name;
            private String sex;
            private String photo_url;
            private String school_id_text;

            public int getSid() {
                return sid;
            }

            public void setSid(int sid) {
                this.sid = sid;
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

            public String getSchool_id_text() {
                return school_id_text;
            }

            public void setSchool_id_text(String school_id_text) {
                this.school_id_text = school_id_text;
            }
        }

        public static class EmployeeBean {
            /**
             * eid : 10007
             * ename : 吴喆聪
             * uid : 10031
             * mobile : 13800013800
             * photo_url :
             */

            private int eid;
            private String ename;
            private int uid;
            private String mobile;
            private String photo_url;

            public int getEid() {
                return eid;
            }

            public void setEid(int eid) {
                this.eid = eid;
            }

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getPhoto_url() {
                return photo_url;
            }

            public void setPhoto_url(String photo_url) {
                this.photo_url = photo_url;
            }
        }

        public static class HomeworkAttachmentBean {
            /**
             * ha_id : 62
             * og_id : 0
             * ht_id : 64
             * hc_id : 0
             * hr_id : 0
             * att_type : 0
             * file_id : 182
             * file_url : http://s10.xiao360.com/qms/1/0/RfjNpbtqK9XbzUEj4r7YLcNoGjQoigKc.png
             * file_type : png
             * file_size : 248222
             * file_name : 屏幕快照 2019-06-20 上午11.01.18.png
             * duration :
             * media_type : image
             * create_uid : 1
             */

            private int ha_id;
            private int og_id;
            private int ht_id;
            private int hc_id;
            private int hr_id;
            private int att_type;
            private int file_id;
            private String file_url;
            private String file_type;
            private int file_size;
            private String file_name;
            private String duration;
            private String media_type;
            private int create_uid;

            public int getHa_id() {
                return ha_id;
            }

            public void setHa_id(int ha_id) {
                this.ha_id = ha_id;
            }

            public int getOg_id() {
                return og_id;
            }

            public void setOg_id(int og_id) {
                this.og_id = og_id;
            }

            public int getHt_id() {
                return ht_id;
            }

            public void setHt_id(int ht_id) {
                this.ht_id = ht_id;
            }

            public int getHc_id() {
                return hc_id;
            }

            public void setHc_id(int hc_id) {
                this.hc_id = hc_id;
            }

            public int getHr_id() {
                return hr_id;
            }

            public void setHr_id(int hr_id) {
                this.hr_id = hr_id;
            }

            public int getAtt_type() {
                return att_type;
            }

            public void setAtt_type(int att_type) {
                this.att_type = att_type;
            }

            public int getFile_id() {
                return file_id;
            }

            public void setFile_id(int file_id) {
                this.file_id = file_id;
            }

            public String getFile_url() {
                return file_url;
            }

            public void setFile_url(String file_url) {
                this.file_url = file_url;
            }

            public String getFile_type() {
                return file_type;
            }

            public void setFile_type(String file_type) {
                this.file_type = file_type;
            }

            public int getFile_size() {
                return file_size;
            }

            public void setFile_size(int file_size) {
                this.file_size = file_size;
            }

            public String getFile_name() {
                return file_name;
            }

            public void setFile_name(String file_name) {
                this.file_name = file_name;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getMedia_type() {
                return media_type;
            }

            public void setMedia_type(String media_type) {
                this.media_type = media_type;
            }

            public int getCreate_uid() {
                return create_uid;
            }

            public void setCreate_uid(int create_uid) {
                this.create_uid = create_uid;
            }
        }
    }
}
