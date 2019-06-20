package com.lantel.homelibrary.homework.api;

import java.util.List;

public class HomeWorkDetailFinishBean {

    /**
     * error : 0
     * message : success
     * data : {"ht_id":42,"og_id":0,"bid":1,"lid":2,"ca_id":92,"lesson_type":1,"cid":0,"sid":21,"sids":[""],"eid":10002,"htts_id":0,"content":"<p>555wdqd<\/p>","remark":"","deadline":20190603,"push_status":1,"create_time":"2019-06-20 09:56:43","homework_complete":{"hc_id":12,"og_id":0,"bid":1,"cid":0,"ca_id":92,"lid":2,"ht_id":42,"sid":21,"star":0,"content":"hhfhfgdbgf","is_check":0,"is_publish":0,"check_time":0,"check_uid":0,"check_level":0,"check_content":null,"result_level":0,"sart_id":0,"is_rejected":0,"rejected_reason":"","rejected_time":0,"create_time":"2019-06-20 10:04:53"},"student":{"sid":21,"bid":1,"student_name":"test02","sex":"2","photo_url":"http://s10.xiao360.com//Users/mac/Library/Developer/CoreSimulator/Devices/A5F463A1-8F5E-4BD5-A404-EEE1454B889F/data/Containers/Data/Application/C7772289-5FBA-42F0-AAD0-E91F7143388C/Documents/1560491879193.png","school_id_text":""},"one_class":null,"homework_attachment":[],"employee":{"eid":10002,"ename":"刘杰克","uid":10011,"mobile":"18814514845","photo_url":"http://s10.xiao360.com/qms/user_avatar/10011/18/01/29/3697a7b62158d6744298c53b53fdb408.jpeg"}}
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
         * ht_id : 42
         * og_id : 0
         * bid : 1
         * lid : 2
         * ca_id : 92
         * lesson_type : 1
         * cid : 0
         * sid : 21
         * sids : [""]
         * eid : 10002
         * htts_id : 0
         * content : <p>555wdqd</p>
         * remark :
         * deadline : 20190603
         * push_status : 1
         * create_time : 2019-06-20 09:56:43
         * homework_complete : {"hc_id":12,"og_id":0,"bid":1,"cid":0,"ca_id":92,"lid":2,"ht_id":42,"sid":21,"star":0,"content":"hhfhfgdbgf","is_check":0,"is_publish":0,"check_time":0,"check_uid":0,"check_level":0,"check_content":null,"result_level":0,"sart_id":0,"is_rejected":0,"rejected_reason":"","rejected_time":0,"create_time":"2019-06-20 10:04:53"}
         * student : {"sid":21,"bid":1,"student_name":"test02","sex":"2","photo_url":"http://s10.xiao360.com//Users/mac/Library/Developer/CoreSimulator/Devices/A5F463A1-8F5E-4BD5-A404-EEE1454B889F/data/Containers/Data/Application/C7772289-5FBA-42F0-AAD0-E91F7143388C/Documents/1560491879193.png","school_id_text":""}
         * one_class : null
         * homework_attachment : []
         * employee : {"eid":10002,"ename":"刘杰克","uid":10011,"mobile":"18814514845","photo_url":"http://s10.xiao360.com/qms/user_avatar/10011/18/01/29/3697a7b62158d6744298c53b53fdb408.jpeg"}
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

        private EmployeeBean employee;

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

        public EmployeeBean getEmployee() {
            return employee;
        }

        public void setEmployee(EmployeeBean employee) {
            this.employee = employee;
        }

        public List<HomeworkAttachmentBean> getHomework_attachment() {
            return homework_attachment;
        }

        public void setHomework_attachment(List<HomeworkAttachmentBean> homework_attachment) {
            this.homework_attachment = homework_attachment;
        }

        public static class HomeworkAttachmentBean {
            /**
             * ha_id : 14
             * og_id : 0
             * ht_id : 7
             * hc_id : 0
             * hr_id : 0
             * att_type : 0
             * file_id : 145
             * file_url : http://s10.xiao360.com/qms//1/19/05/29/14c8cf0abe84a1c919c60e90bbc225f7.png
             * file_type : png
             * file_size : 315465
             * file_name : 2078449371978d85fbb9e5524e038fef.png
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

        public static class HomeworkCompleteBean {
            /**
             * hc_id : 12
             * og_id : 0
             * bid : 1
             * cid : 0
             * ca_id : 92
             * lid : 2
             * ht_id : 42
             * sid : 21
             * star : 0
             * content : hhfhfgdbgf
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
             * create_time : 2019-06-20 10:04:53
             */
            private List<DataBean.HomeworkCompleteBean.HomeworkAttachmentBean> homework_attachment;
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

            public List<DataBean.HomeworkCompleteBean.HomeworkAttachmentBean> getHomework_attachment() {
                return homework_attachment;
            }

            public void setHomework_attachment(List<DataBean.HomeworkCompleteBean.HomeworkAttachmentBean> homework_attachment) {
                this.homework_attachment = homework_attachment;
            }

            public static class HomeworkAttachmentBean {
                /**
                 * ha_id : 14
                 * og_id : 0
                 * ht_id : 7
                 * hc_id : 0
                 * hr_id : 0
                 * att_type : 0
                 * file_id : 145
                 * file_url : http://s10.xiao360.com/qms//1/19/05/29/14c8cf0abe84a1c919c60e90bbc225f7.png
                 * file_type : png
                 * file_size : 315465
                 * file_name : 2078449371978d85fbb9e5524e038fef.png
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
             * eid : 10002
             * ename : 刘杰克
             * uid : 10011
             * mobile : 18814514845
             * photo_url : http://s10.xiao360.com/qms/user_avatar/10011/18/01/29/3697a7b62158d6744298c53b53fdb408.jpeg
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
    }
}
