package com.lantel.homelibrary.output.api;

import com.lantel.studylibrary.preview.preview.api.PreviewDetailBean;

import java.util.List;

public class OutputBean {
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
             * sart_id : 2
             * og_id : 0
             * bid : 1
             * eid : 10003
             * cid : 0
             * sid : 21
             * art_name : fz
             * art_desc : fzfzfz
             * create_time : 2019-06-04 10:10:35
             * student_artwork_attachment : [{"sarta_id":3,"og_id":0,"sart_id":2,"file_id":135,"file_url":"http://s10.xiao360.com/qms/student_avatar/1/19/05/18/66e97e6dcad5f137bd22b531a1e8aa76.png","file_type":"png","file_size":504365,"file_name":"648a44cdddcd1a5aabfecb72ff760a54.jpg","media_type":"image","duration":"","create_uid":1},{"sarta_id":4,"og_id":0,"sart_id":2,"file_id":138,"file_url":"http://s10.xiao360.com/qms//base/wechat_media/Gz9xoUydk6DR97DMt_srgz4K4pQxFUdmcXqvlDYwhKAasN4m7IlZ_zJaE9vgWPDP.mp4","file_type":"mp4","file_size":1764596,"file_name":"","media_type":"video","duration":"10.833333","create_uid":1},{"sarta_id":5,"og_id":0,"sart_id":2,"file_id":133,"file_url":"http://s10.xiao360.com/qms/1/0/WJ31KrqPSga5yWF44epLQpgH6SAc3jQq.jpg","file_type":"jpg","file_size":37065,"file_name":"tusaJDAxJDIzL1RCMW1HMjVMcCQ2YzNYRiQ1JDM.jpg","media_type":"image","duration":"","create_uid":1},{"sarta_id":6,"og_id":0,"sart_id":2,"file_id":136,"file_url":"http://s10.xiao360.com/qms/student_avatar/1/19/05/18/ef14abe724b4fd874d9986158d70774e.png","file_type":"png","file_size":946084,"file_name":"yz2.png","media_type":"image","duration":"","create_uid":1},{"sarta_id":7,"og_id":0,"sart_id":2,"file_id":142,"file_url":"http://s10.xiao360.com/qms/1/0/U1CXOeTMl9iCdnzwGfh13xyhdOnXARxk.pptx","file_type":"pptx","file_size":15007901,"file_name":"lesson1.pptx","media_type":"file","duration":"","create_uid":1},{"sarta_id":8,"og_id":0,"sart_id":2,"file_id":140,"file_url":"http://s10.xiao360.com/qms/1/0/n2etB1wWU5dhr3OxrNiSxmkQx0kHiNNt.m4a","file_type":"m4a","file_size":208738,"file_name":"1111.m4a","media_type":"file","duration":"","create_uid":1},{"sarta_id":9,"og_id":0,"sart_id":2,"file_id":145,"file_url":"http://s10.xiao360.com/qms//1/19/05/29/14c8cf0abe84a1c919c60e90bbc225f7.png","file_type":"png","file_size":315465,"file_name":"2078449371978d85fbb9e5524e038fef.png","media_type":"image","duration":"","create_uid":1},{"sarta_id":10,"og_id":0,"sart_id":2,"file_id":144,"file_url":"http://s10.xiao360.com/qms//1/19/05/28/6cfaf0d3a344ed6267b10afb28a87da5.png","file_type":"png","file_size":244377,"file_name":"90528175449.png","media_type":"image","duration":"","create_uid":1},{"sarta_id":11,"og_id":0,"sart_id":2,"file_id":143,"file_url":"http://s10.xiao360.com/qms//1/19/05/28/31ba523bfc66f2b4eae4b97497a2c366.jpg","file_type":"jpg","file_size":37330,"file_name":"11.jpg","media_type":"image","duration":"","create_uid":1},{"sarta_id":12,"og_id":0,"sart_id":2,"file_id":137,"file_url":"http://s10.xiao360.com/qms/1/0/yEVAY6iyE65vvB5xVW8FxmxMcSUEmdHZ.png","file_type":"png","file_size":52389,"file_name":"屏幕快照 2019-05-18 下午5.34.28.png","media_type":"image","duration":"","create_uid":1},{"sarta_id":13,"og_id":0,"sart_id":2,"file_id":131,"file_url":"http://s10.xiao360.com/qms/1/0/TYbL8je04GGIMJIECa8YBxQDHzBof1Sj.jpg","file_type":"jpg","file_size":37065,"file_name":"tusaJDAxJDIzL1RCMW1HMjVMcCQ2YzNYRiQ1JDM.jpg","media_type":"image","duration":"","create_uid":1},{"sarta_id":14,"og_id":0,"sart_id":2,"file_id":130,"file_url":"http://s10.xiao360.com/qms/1/0/nsp5FxjwQ6TeYonhuOlOg6TjFdO8XUeX.jpg","file_type":"jpg","file_size":26945,"file_name":"1480344881-1_w_1.jpg","media_type":"image","duration":"","create_uid":1},{"sarta_id":15,"og_id":0,"sart_id":2,"file_id":129,"file_url":"http://s10.xiao360.com/qms//1/19/05/13/8660e12aec8798d218f3650cd09b3799.png","file_type":"png","file_size":902,"file_name":"ketang.png","media_type":"image","duration":"","create_uid":1},{"sarta_id":16,"og_id":0,"sart_id":2,"file_id":117,"file_url":"http://s10.xiao360.com/qms//1/19/05/08/0b33ced8ab6d07453c32a75e36deac9e.jpg","file_type":"jpg","file_size":83305,"file_name":"648a44cdddcd1a5aabfecb72ff760a54.jpg","media_type":"image","duration":"","create_uid":1}]
             */
            private int sid;
            private String art_name;
            private String art_desc;
            private String create_time;

            private List<StudentArtworkAttachmentBean> student_artwork_attachment;

            public int getSid() {
                return sid;
            }

            public void setSid(int sid) {
                this.sid = sid;
            }

            public String getArt_name() {
                return art_name;
            }

            public void setArt_name(String art_name) {
                this.art_name = art_name;
            }

            public String getArt_desc() {
                return art_desc;
            }

            public void setArt_desc(String art_desc) {
                this.art_desc = art_desc;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public List<StudentArtworkAttachmentBean> getStudent_artwork_attachment() {
                return student_artwork_attachment;
            }

            public void setStudent_artwork_attachment(List<StudentArtworkAttachmentBean> student_artwork_attachment) {
                this.student_artwork_attachment = student_artwork_attachment;
            }

            public static class StudentArtworkAttachmentBean {
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
        }
    }
}
