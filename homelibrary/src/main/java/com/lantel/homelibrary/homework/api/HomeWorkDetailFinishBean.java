package com.lantel.homelibrary.homework.api;

import java.util.List;

public class HomeWorkDetailFinishBean {
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
         * hc_id : 6
         * og_id : 0
         * bid : 1
         * cid : 0
         * ca_id : 92
         * lid : 2
         * ht_id : 6
         * sid : 21
         * star : 0
         * content : SSSSS
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
         * create_time : 2019-06-15 11:26:16
         * homework_attachment : []
         * homework_task : {"ht_id":6,"og_id":0,"bid":1,"lid":2,"ca_id":92,"lesson_type":1,"cid":0,"sid":21,"sids":[""],"eid":10003,"htts_id":0,"content":"<p>AAA<\/p>","remark":"","deadline":20190603,"push_status":1,"create_time":"2019-06-15 11:25:59","employee":{"eid":10003,"ename":"徐老师","uid":10014,"mobile":"17799999999","photo_url":"http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg"},"homework_attachment":[{"ha_id":5,"og_id":0,"ht_id":6,"hc_id":0,"hr_id":0,"att_type":0,"file_id":146,"file_url":"http://s10.xiao360.com/qms/student_avatar/1/19/06/06/d73d000343f5b813e02e5aeb83f2c478.png","file_type":"png","file_size":336829,"file_name":"648a44cdddcd1a5aabfecb72ff760a54.jpg","duration":"","media_type":"image","create_uid":1},{"ha_id":6,"og_id":0,"ht_id":6,"hc_id":0,"hr_id":0,"att_type":0,"file_id":144,"file_url":"http://s10.xiao360.com/qms//1/19/05/28/6cfaf0d3a344ed6267b10afb28a87da5.png","file_type":"png","file_size":244377,"file_name":"90528175449.png","duration":"","media_type":"image","create_uid":1},{"ha_id":7,"og_id":0,"ht_id":6,"hc_id":0,"hr_id":0,"att_type":0,"file_id":136,"file_url":"http://s10.xiao360.com/qms/student_avatar/1/19/05/18/ef14abe724b4fd874d9986158d70774e.png","file_type":"png","file_size":946084,"file_name":"yz2.png","duration":"","media_type":"image","create_uid":1},{"ha_id":8,"og_id":0,"ht_id":6,"hc_id":0,"hr_id":0,"att_type":0,"file_id":139,"file_url":"http://s10.xiao360.com/qms/1/0/cNHSyBUlcwYAW8vKLGEvjtNfHoELTnIC.pptx","file_type":"pptx","file_size":72267303,"file_name":"4.氧气的制取.pptx","duration":"","media_type":"file","create_uid":1},{"ha_id":9,"og_id":0,"ht_id":6,"hc_id":0,"hr_id":0,"att_type":0,"file_id":152,"file_url":"http://s10.xiao360.com/qms/1/0/BaPkLg6ceJBEqPHrJR92Fdhu95okdHRC.xlsx","file_type":"xlsx","file_size":109078,"file_name":"产品捉虫行动-产品部.xlsx","duration":"","media_type":"file","create_uid":1}]}
         * student : {"sid":21,"og_id":0,"bid":1,"student_name":"test02","pinyin":"test02","pinyin_abbr":"t","nick_name":"","sex":"2","photo_url":"http://s10.xiao360.com//Users/mac/Library/Developer/CoreSimulator/Devices/A5F463A1-8F5E-4BD5-A404-EEE1454B889F/data/Containers/Data/Application/C7772289-5FBA-42F0-AAD0-E91F7143388C/Documents/1560491879193.png","birth_time":"2019-12-02","birth_year":2019,"birth_month":12,"birth_day":2,"school_grade":3,"grade_update_int_ym":201906,"school_class":"3","school_id":2,"first_tel":"","first_family_name":"","first_family_rel":4,"first_uid":10028,"second_family_name":"","second_family_rel":0,"second_tel":"","second_uid":0,"eid":0,"sno":"No123456","card_no":"001002","money":"0.000000","credit":"0.00","credit2":"0.00","vip_level":-1,"service_level":0,"last_attendance_time":"2019-05-28 15:59:03","is_lost":0,"status":1,"mc_id":0,"quit_reason":"","student_type":1,"option_fields":"[]","student_lesson_times":0,"student_lesson_remain_times":0,"student_lesson_hours":"243.00","student_lesson_remain_hours":"237.00","is_demo":0,"is_demo_transfered":1,"is_face_input":0,"face_id":"","referer_sid":0,"in_time":1558022400,"create_time":"2019-05-17 12:32:34","ext_id":"","from_did":0,"school_id_text":"0"}
         * one_class : null
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
        private Object check_content;
        private int result_level;
        private int sart_id;
        private int is_rejected;
        private String rejected_reason;
        private int rejected_time;
        private String create_time;
        private HomeworkTaskBean homework_task;
        private StudentBean student;

        private Object homework_reply;
        private List<HomeworkAttachmentBean> homework_attachment;
        private OneClassBean one_class;

        public OneClassBean getOne_class() {
            return one_class;
        }

        public void setOne_class(OneClassBean one_class) {
            this.one_class = one_class;
        }

        public static class OneClassBean {
            private int cid;
            private int parent_cid;
            private String class_name;
            private String class_no;
            private int class_type;

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
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
        }

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

        public Object getCheck_content() {
            return check_content;
        }

        public void setCheck_content(Object check_content) {
            this.check_content = check_content;
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

        public HomeworkTaskBean getHomework_task() {
            return homework_task;
        }

        public void setHomework_task(HomeworkTaskBean homework_task) {
            this.homework_task = homework_task;
        }

        public StudentBean getStudent() {
            return student;
        }

        public void setStudent(StudentBean student) {
            this.student = student;
        }

        public Object getHomework_reply() {
            return homework_reply;
        }

        public void setHomework_reply(Object homework_reply) {
            this.homework_reply = homework_reply;
        }

        public List<HomeworkAttachmentBean> getHomework_attachment() {
            return homework_attachment;
        }

        public void setHomework_attachment(List<HomeworkAttachmentBean> homework_attachment) {
            this.homework_attachment = homework_attachment;
        }

        public static class HomeworkTaskBean {
            /**
             * ht_id : 6
             * og_id : 0
             * bid : 1
             * lid : 2
             * ca_id : 92
             * lesson_type : 1
             * cid : 0
             * sid : 21
             * sids : [""]
             * eid : 10003
             * htts_id : 0
             * content : <p>AAA</p>
             * remark :
             * deadline : 20190603
             * push_status : 1
             * create_time : 2019-06-15 11:25:59
             * employee : {"eid":10003,"ename":"徐老师","uid":10014,"mobile":"17799999999","photo_url":"http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg"}
             * homework_attachment : [{"ha_id":5,"og_id":0,"ht_id":6,"hc_id":0,"hr_id":0,"att_type":0,"file_id":146,"file_url":"http://s10.xiao360.com/qms/student_avatar/1/19/06/06/d73d000343f5b813e02e5aeb83f2c478.png","file_type":"png","file_size":336829,"file_name":"648a44cdddcd1a5aabfecb72ff760a54.jpg","duration":"","media_type":"image","create_uid":1},{"ha_id":6,"og_id":0,"ht_id":6,"hc_id":0,"hr_id":0,"att_type":0,"file_id":144,"file_url":"http://s10.xiao360.com/qms//1/19/05/28/6cfaf0d3a344ed6267b10afb28a87da5.png","file_type":"png","file_size":244377,"file_name":"90528175449.png","duration":"","media_type":"image","create_uid":1},{"ha_id":7,"og_id":0,"ht_id":6,"hc_id":0,"hr_id":0,"att_type":0,"file_id":136,"file_url":"http://s10.xiao360.com/qms/student_avatar/1/19/05/18/ef14abe724b4fd874d9986158d70774e.png","file_type":"png","file_size":946084,"file_name":"yz2.png","duration":"","media_type":"image","create_uid":1},{"ha_id":8,"og_id":0,"ht_id":6,"hc_id":0,"hr_id":0,"att_type":0,"file_id":139,"file_url":"http://s10.xiao360.com/qms/1/0/cNHSyBUlcwYAW8vKLGEvjtNfHoELTnIC.pptx","file_type":"pptx","file_size":72267303,"file_name":"4.氧气的制取.pptx","duration":"","media_type":"file","create_uid":1},{"ha_id":9,"og_id":0,"ht_id":6,"hc_id":0,"hr_id":0,"att_type":0,"file_id":152,"file_url":"http://s10.xiao360.com/qms/1/0/BaPkLg6ceJBEqPHrJR92Fdhu95okdHRC.xlsx","file_type":"xlsx","file_size":109078,"file_name":"产品捉虫行动-产品部.xlsx","duration":"","media_type":"file","create_uid":1}]
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
            private EmployeeBean employee;
            private List<String> sids;
            private List<HomeworkAttachmentBean> homework_attachment;

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

            public static class EmployeeBean {
                /**
                 * eid : 10003
                 * ename : 徐老师
                 * uid : 10014
                 * mobile : 17799999999
                 * photo_url : http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg
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
                 * ha_id : 5
                 * og_id : 0
                 * ht_id : 6
                 * hc_id : 0
                 * hr_id : 0
                 * att_type : 0
                 * file_id : 146
                 * file_url : http://s10.xiao360.com/qms/student_avatar/1/19/06/06/d73d000343f5b813e02e5aeb83f2c478.png
                 * file_type : png
                 * file_size : 336829
                 * file_name : 648a44cdddcd1a5aabfecb72ff760a54.jpg
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

        public static class StudentBean {
            /**
             * sid : 21
             * og_id : 0
             * bid : 1
             * student_name : test02
             * pinyin : test02
             * pinyin_abbr : t
             * nick_name :
             * sex : 2
             * photo_url : http://s10.xiao360.com//Users/mac/Library/Developer/CoreSimulator/Devices/A5F463A1-8F5E-4BD5-A404-EEE1454B889F/data/Containers/Data/Application/C7772289-5FBA-42F0-AAD0-E91F7143388C/Documents/1560491879193.png
             * birth_time : 2019-12-02
             * birth_year : 2019
             * birth_month : 12
             * birth_day : 2
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
             * sno : No123456
             * card_no : 001002
             * money : 0.000000
             * credit : 0.00
             * credit2 : 0.00
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
             * is_demo : 0
             * is_demo_transfered : 1
             * is_face_input : 0
             * face_id :
             * referer_sid : 0
             * in_time : 1558022400
             * create_time : 2019-05-17 12:32:34
             * ext_id :
             * from_did : 0
             * school_id_text : 0
             */

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

        public static class HomeworkAttachmentBean {
            /**
             * file_id : 135
             * file_url : http://s10.xiao360.com/qms/student_avatar/1/19/05/18/66e97e6dcad5f137bd22b531a1e8aa76.png
             * file_type : png
             * file_size : 504365
             * file_name : 648a44cdddcd1a5aabfecb72ff760a54.jpg
             * media_type : image
             * duration :
             * create_uid : 1
             */

            private int file_id;
            private String file_url;
            private String file_type;
            private int file_size;
            private String file_name;
            private String media_type;
            private String duration;
            private int create_uid;

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

            public String getMedia_type() {
                return media_type;
            }

            public void setMedia_type(String media_type) {
                this.media_type = media_type;
            }

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
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
