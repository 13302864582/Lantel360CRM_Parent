package com.lantel.studylibrary.preview.preview.api;

import java.util.List;

public class PreviewDetailBean {
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
            private int ca_id;
            private int og_id;
            private int bid;
            private int lesson_type;
            private int is_trial;
            private int is_makeup;
            private int is_demo;
            private int is_online;
            private int is_bk_open;
            private int csd_id;
            private int csm_id;
            private String name;
            private int cid;
            private int teach_eid;
            private int second_eid;
            private String second_eids;
            private int lid;
            private int sj_id;
            private int grade;
            private int sg_id;
            private int cr_id;
            private int chapter_index;
            private String season;
            private int int_day;
            private int is_attendance;
            private int is_prepare;
            private int prepare_file_nums;
            private int int_start_hour;
            private int int_end_hour;
            private int consume_source_type;
            private String consume_lesson_hour;
            private String consume_lesson_amount;
            private int create_type;
            private int listen_apply_nums;
            private int listen_approve_nums;
            private int listen_arrive_nums;
            private String prepare_message;
            private int is_before_push;
            private int is_after_push;
            private int before_push_time;
            private int after_push_time;
            private int is_cancel;
            private Object reason;
            private int tb_id;
            private int tbs_id;
            private int create_uid;
            private LessonBean lesson;
            private TeacherBean teacher;
            private OneClassBean one_class;
            private CoursePrepareBean course_prepare;
            private String course_name;
            private int leave_times;
            private int allow_leave;
            private StudentLeaveBean student_leave;
            private int can_leave;

            public StudentLeaveBean getStudent_leave() {
                return student_leave;
            }

            public void setStudent_leave(StudentLeaveBean student_leave) {
                this.student_leave = student_leave;
            }

            public static class StudentLeaveBean {
                /**
                 * slv_id : 19
                 * og_id : 0
                 * bid : 1
                 * sid : 21
                 * lid : 2
                 * sj_id : 1
                 * grade : 0
                 * cid : 0
                 * sl_id : 47
                 * lesson_type : 1
                 * ca_id : 101
                 * int_day : 20190603
                 * int_start_hour : 800
                 * int_end_hour : 1000
                 * reason : null
                 * leave_type : 116
                 * leave_way : 1
                 * satt_id : 0
                 * ma_id : 0
                 * is_consume : 0
                 * create_time : 2019-05-30 12:08:02
                 */

                private int slv_id;
                private int og_id;
                private int bid;
                private int sid;
                private int lid;
                private int sj_id;
                private int grade;
                private int cid;
                private int sl_id;
                private int lesson_type;
                private int ca_id;
                private int int_day;
                private int int_start_hour;
                private int int_end_hour;
                private Object reason;
                private int leave_type;
                private int leave_way;
                private int satt_id;
                private int ma_id;
                private int is_consume;
                private String create_time;

                public int getSlv_id() {
                    return slv_id;
                }

                public void setSlv_id(int slv_id) {
                    this.slv_id = slv_id;
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

                public int getCid() {
                    return cid;
                }

                public void setCid(int cid) {
                    this.cid = cid;
                }

                public int getSl_id() {
                    return sl_id;
                }

                public void setSl_id(int sl_id) {
                    this.sl_id = sl_id;
                }

                public int getLesson_type() {
                    return lesson_type;
                }

                public void setLesson_type(int lesson_type) {
                    this.lesson_type = lesson_type;
                }

                public int getCa_id() {
                    return ca_id;
                }

                public void setCa_id(int ca_id) {
                    this.ca_id = ca_id;
                }

                public int getInt_day() {
                    return int_day;
                }

                public void setInt_day(int int_day) {
                    this.int_day = int_day;
                }

                public int getInt_start_hour() {
                    return int_start_hour;
                }

                public void setInt_start_hour(int int_start_hour) {
                    this.int_start_hour = int_start_hour;
                }

                public int getInt_end_hour() {
                    return int_end_hour;
                }

                public void setInt_end_hour(int int_end_hour) {
                    this.int_end_hour = int_end_hour;
                }

                public Object getReason() {
                    return reason;
                }

                public void setReason(Object reason) {
                    this.reason = reason;
                }

                public int getLeave_type() {
                    return leave_type;
                }

                public void setLeave_type(int leave_type) {
                    this.leave_type = leave_type;
                }

                public int getLeave_way() {
                    return leave_way;
                }

                public void setLeave_way(int leave_way) {
                    this.leave_way = leave_way;
                }

                public int getSatt_id() {
                    return satt_id;
                }

                public void setSatt_id(int satt_id) {
                    this.satt_id = satt_id;
                }

                public int getMa_id() {
                    return ma_id;
                }

                public void setMa_id(int ma_id) {
                    this.ma_id = ma_id;
                }

                public int getIs_consume() {
                    return is_consume;
                }

                public void setIs_consume(int is_consume) {
                    this.is_consume = is_consume;
                }

                public String getCreate_time() {
                    return create_time;
                }

                public void setCreate_time(String create_time) {
                    this.create_time = create_time;
                }
            }

            public CoursePrepareBean getCourse_prepare() {
                return course_prepare;
            }

            public void setCourse_prepare(CoursePrepareBean course_prepare) {
                this.course_prepare = course_prepare;
            }

            public int getCa_id() {
                return ca_id;
            }

            public void setCa_id(int ca_id) {
                this.ca_id = ca_id;
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

            public int getLesson_type() {
                return lesson_type;
            }

            public void setLesson_type(int lesson_type) {
                this.lesson_type = lesson_type;
            }

            public int getIs_trial() {
                return is_trial;
            }

            public void setIs_trial(int is_trial) {
                this.is_trial = is_trial;
            }

            public int getIs_makeup() {
                return is_makeup;
            }

            public void setIs_makeup(int is_makeup) {
                this.is_makeup = is_makeup;
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

            public int getIs_bk_open() {
                return is_bk_open;
            }

            public void setIs_bk_open(int is_bk_open) {
                this.is_bk_open = is_bk_open;
            }

            public int getCsd_id() {
                return csd_id;
            }

            public void setCsd_id(int csd_id) {
                this.csd_id = csd_id;
            }

            public int getCsm_id() {
                return csm_id;
            }

            public void setCsm_id(int csm_id) {
                this.csm_id = csm_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCid() {
                return cid;
            }

            public void setCid(int cid) {
                this.cid = cid;
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

            public int getCr_id() {
                return cr_id;
            }

            public void setCr_id(int cr_id) {
                this.cr_id = cr_id;
            }

            public int getChapter_index() {
                return chapter_index;
            }

            public void setChapter_index(int chapter_index) {
                this.chapter_index = chapter_index;
            }

            public String getSeason() {
                return season;
            }

            public void setSeason(String season) {
                this.season = season;
            }

            public int getInt_day() {
                return int_day;
            }

            public void setInt_day(int int_day) {
                this.int_day = int_day;
            }

            public int getIs_attendance() {
                return is_attendance;
            }

            public void setIs_attendance(int is_attendance) {
                this.is_attendance = is_attendance;
            }

            public int getIs_prepare() {
                return is_prepare;
            }

            public void setIs_prepare(int is_prepare) {
                this.is_prepare = is_prepare;
            }

            public int getPrepare_file_nums() {
                return prepare_file_nums;
            }

            public void setPrepare_file_nums(int prepare_file_nums) {
                this.prepare_file_nums = prepare_file_nums;
            }

            public int getInt_start_hour() {
                return int_start_hour;
            }

            public void setInt_start_hour(int int_start_hour) {
                this.int_start_hour = int_start_hour;
            }

            public int getInt_end_hour() {
                return int_end_hour;
            }

            public void setInt_end_hour(int int_end_hour) {
                this.int_end_hour = int_end_hour;
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

            public String getConsume_lesson_amount() {
                return consume_lesson_amount;
            }

            public void setConsume_lesson_amount(String consume_lesson_amount) {
                this.consume_lesson_amount = consume_lesson_amount;
            }

            public int getCreate_type() {
                return create_type;
            }

            public void setCreate_type(int create_type) {
                this.create_type = create_type;
            }

            public int getListen_apply_nums() {
                return listen_apply_nums;
            }

            public void setListen_apply_nums(int listen_apply_nums) {
                this.listen_apply_nums = listen_apply_nums;
            }

            public int getListen_approve_nums() {
                return listen_approve_nums;
            }

            public void setListen_approve_nums(int listen_approve_nums) {
                this.listen_approve_nums = listen_approve_nums;
            }

            public int getListen_arrive_nums() {
                return listen_arrive_nums;
            }

            public void setListen_arrive_nums(int listen_arrive_nums) {
                this.listen_arrive_nums = listen_arrive_nums;
            }

            public String getPrepare_message() {
                return prepare_message;
            }

            public void setPrepare_message(String prepare_message) {
                this.prepare_message = prepare_message;
            }

            public int getIs_before_push() {
                return is_before_push;
            }

            public void setIs_before_push(int is_before_push) {
                this.is_before_push = is_before_push;
            }

            public int getIs_after_push() {
                return is_after_push;
            }

            public void setIs_after_push(int is_after_push) {
                this.is_after_push = is_after_push;
            }

            public int getBefore_push_time() {
                return before_push_time;
            }

            public void setBefore_push_time(int before_push_time) {
                this.before_push_time = before_push_time;
            }

            public int getAfter_push_time() {
                return after_push_time;
            }

            public void setAfter_push_time(int after_push_time) {
                this.after_push_time = after_push_time;
            }

            public int getIs_cancel() {
                return is_cancel;
            }

            public void setIs_cancel(int is_cancel) {
                this.is_cancel = is_cancel;
            }

            public Object getReason() {
                return reason;
            }

            public void setReason(Object reason) {
                this.reason = reason;
            }

            public int getTb_id() {
                return tb_id;
            }

            public void setTb_id(int tb_id) {
                this.tb_id = tb_id;
            }

            public int getTbs_id() {
                return tbs_id;
            }

            public void setTbs_id(int tbs_id) {
                this.tbs_id = tbs_id;
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

            public TeacherBean getTeacher() {
                return teacher;
            }

            public void setTeacher(TeacherBean teacher) {
                this.teacher = teacher;
            }

            public OneClassBean getOne_class() {
                return one_class;
            }

            public void setOne_class(OneClassBean one_class) {
                this.one_class = one_class;
            }

            public String getCourse_name() {
                return course_name;
            }

            public void setCourse_name(String course_name) {
                this.course_name = course_name;
            }

            public int getLeave_times() {
                return leave_times;
            }

            public void setLeave_times(int leave_times) {
                this.leave_times = leave_times;
            }

            public int getAllow_leave() {
                return allow_leave;
            }

            public void setAllow_leave(int allow_leave) {
                this.allow_leave = allow_leave;
            }

            public int getCan_leave() {
                return can_leave;
            }

            public void setCan_leave(int can_leave) {
                this.can_leave = can_leave;
            }

            public static class LessonBean {
                private int lid;
                private int og_id;
                private int year;
                private String season;
                private int sj_id;
                private String lesson_name;
                private String lesson_no;
                private int product_level_did;
                private int fit_age_start;
                private int fit_age_end;
                private int fit_grade_start;
                private int fit_grade_end;
                private String short_desc;
                private String public_content;
                private String lesson_cover_picture;
                private int chapter_nums;
                private int lesson_type;
                private int is_multi_class;
                private int ac_class_nums;
                private int price_type;
                private int is_term;
                private String lesson_nums;
                private String unit_price;
                private String unit_lesson_hours;
                private int unit_lesson_minutes;
                private String sale_price;
                private int per_lesson_hour_minutes;
                private String ext_lid;
                private String version;
                private int status;
                private int is_package;
                private int is_default;
                private int is_publish;
                private int is_standard;
                private int ability_did;
                private int is_demo;
                private int is_public;
                private int expire_month;
                private int leave_nums_limit;
                private int teacher_level;
                private int bk_limit_status;
                private int bk_space_days;
                private int create_uid;
                private List<Integer> bids;
                private List<Integer> sj_ids;
                private List<?> attachments;
                private List<Integer> fit_age;
                private List<Integer> fit_grade;

                public int getLid() {
                    return lid;
                }

                public void setLid(int lid) {
                    this.lid = lid;
                }

                public int getOg_id() {
                    return og_id;
                }

                public void setOg_id(int og_id) {
                    this.og_id = og_id;
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

                public int getSj_id() {
                    return sj_id;
                }

                public void setSj_id(int sj_id) {
                    this.sj_id = sj_id;
                }

                public String getLesson_name() {
                    return lesson_name;
                }

                public void setLesson_name(String lesson_name) {
                    this.lesson_name = lesson_name;
                }

                public String getLesson_no() {
                    return lesson_no;
                }

                public void setLesson_no(String lesson_no) {
                    this.lesson_no = lesson_no;
                }

                public int getProduct_level_did() {
                    return product_level_did;
                }

                public void setProduct_level_did(int product_level_did) {
                    this.product_level_did = product_level_did;
                }

                public int getFit_age_start() {
                    return fit_age_start;
                }

                public void setFit_age_start(int fit_age_start) {
                    this.fit_age_start = fit_age_start;
                }

                public int getFit_age_end() {
                    return fit_age_end;
                }

                public void setFit_age_end(int fit_age_end) {
                    this.fit_age_end = fit_age_end;
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

                public String getShort_desc() {
                    return short_desc;
                }

                public void setShort_desc(String short_desc) {
                    this.short_desc = short_desc;
                }

                public String getPublic_content() {
                    return public_content;
                }

                public void setPublic_content(String public_content) {
                    this.public_content = public_content;
                }

                public String getLesson_cover_picture() {
                    return lesson_cover_picture;
                }

                public void setLesson_cover_picture(String lesson_cover_picture) {
                    this.lesson_cover_picture = lesson_cover_picture;
                }

                public int getChapter_nums() {
                    return chapter_nums;
                }

                public void setChapter_nums(int chapter_nums) {
                    this.chapter_nums = chapter_nums;
                }

                public int getLesson_type() {
                    return lesson_type;
                }

                public void setLesson_type(int lesson_type) {
                    this.lesson_type = lesson_type;
                }

                public int getIs_multi_class() {
                    return is_multi_class;
                }

                public void setIs_multi_class(int is_multi_class) {
                    this.is_multi_class = is_multi_class;
                }

                public int getAc_class_nums() {
                    return ac_class_nums;
                }

                public void setAc_class_nums(int ac_class_nums) {
                    this.ac_class_nums = ac_class_nums;
                }

                public int getPrice_type() {
                    return price_type;
                }

                public void setPrice_type(int price_type) {
                    this.price_type = price_type;
                }

                public int getIs_term() {
                    return is_term;
                }

                public void setIs_term(int is_term) {
                    this.is_term = is_term;
                }

                public String getLesson_nums() {
                    return lesson_nums;
                }

                public void setLesson_nums(String lesson_nums) {
                    this.lesson_nums = lesson_nums;
                }

                public String getUnit_price() {
                    return unit_price;
                }

                public void setUnit_price(String unit_price) {
                    this.unit_price = unit_price;
                }

                public String getUnit_lesson_hours() {
                    return unit_lesson_hours;
                }

                public void setUnit_lesson_hours(String unit_lesson_hours) {
                    this.unit_lesson_hours = unit_lesson_hours;
                }

                public int getUnit_lesson_minutes() {
                    return unit_lesson_minutes;
                }

                public void setUnit_lesson_minutes(int unit_lesson_minutes) {
                    this.unit_lesson_minutes = unit_lesson_minutes;
                }

                public String getSale_price() {
                    return sale_price;
                }

                public void setSale_price(String sale_price) {
                    this.sale_price = sale_price;
                }

                public int getPer_lesson_hour_minutes() {
                    return per_lesson_hour_minutes;
                }

                public void setPer_lesson_hour_minutes(int per_lesson_hour_minutes) {
                    this.per_lesson_hour_minutes = per_lesson_hour_minutes;
                }

                public String getExt_lid() {
                    return ext_lid;
                }

                public void setExt_lid(String ext_lid) {
                    this.ext_lid = ext_lid;
                }

                public String getVersion() {
                    return version;
                }

                public void setVersion(String version) {
                    this.version = version;
                }

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public int getIs_package() {
                    return is_package;
                }

                public void setIs_package(int is_package) {
                    this.is_package = is_package;
                }

                public int getIs_default() {
                    return is_default;
                }

                public void setIs_default(int is_default) {
                    this.is_default = is_default;
                }

                public int getIs_publish() {
                    return is_publish;
                }

                public void setIs_publish(int is_publish) {
                    this.is_publish = is_publish;
                }

                public int getIs_standard() {
                    return is_standard;
                }

                public void setIs_standard(int is_standard) {
                    this.is_standard = is_standard;
                }

                public int getAbility_did() {
                    return ability_did;
                }

                public void setAbility_did(int ability_did) {
                    this.ability_did = ability_did;
                }

                public int getIs_demo() {
                    return is_demo;
                }

                public void setIs_demo(int is_demo) {
                    this.is_demo = is_demo;
                }

                public int getIs_public() {
                    return is_public;
                }

                public void setIs_public(int is_public) {
                    this.is_public = is_public;
                }

                public int getExpire_month() {
                    return expire_month;
                }

                public void setExpire_month(int expire_month) {
                    this.expire_month = expire_month;
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

                public int getBk_limit_status() {
                    return bk_limit_status;
                }

                public void setBk_limit_status(int bk_limit_status) {
                    this.bk_limit_status = bk_limit_status;
                }

                public int getBk_space_days() {
                    return bk_space_days;
                }

                public void setBk_space_days(int bk_space_days) {
                    this.bk_space_days = bk_space_days;
                }

                public int getCreate_uid() {
                    return create_uid;
                }

                public void setCreate_uid(int create_uid) {
                    this.create_uid = create_uid;
                }

                public List<Integer> getBids() {
                    return bids;
                }

                public void setBids(List<Integer> bids) {
                    this.bids = bids;
                }

                public List<Integer> getSj_ids() {
                    return sj_ids;
                }

                public void setSj_ids(List<Integer> sj_ids) {
                    this.sj_ids = sj_ids;
                }

                public List<?> getAttachments() {
                    return attachments;
                }

                public void setAttachments(List<?> attachments) {
                    this.attachments = attachments;
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

            public static class TeacherBean {
                /**
                 * eid : 10001
                 * og_id : 0
                 * bid : 1
                 * ename : yaorui001
                 * pinyin :
                 * pinyin_abbr :
                 * nick_name :
                 * rids : [1]
                 * bids : [1,2]
                 * com_ids :
                 * lids : [1,2,3]
                 * sj_ids : []
                 * grades :
                 * uid : 0
                 * account :
                 * sex : 1
                 * mobile : 17768026455
                 * email : 562247587@qq.com
                 * id_card_no :
                 * bank_card_no :
                 * photo_url :
                 * birth_time : 2010-01-08
                 * birth_year : 0
                 * birth_month : 0
                 * birth_day : 0
                 * is_part_job : 0
                 * is_on_job : 1
                 * join_int_day : 20171201
                 * official_int_day : 0
                 * remark :
                 * option_fields : null
                 * user_status : 0
                 * is_fsys : 0
                 * teacher_level : -1
                 * college_did : 0
                 * major_did : 0
                 * degree_did : 0
                 * have_cert : 0
                 * ext_id : 0
                 */

                private int eid;
                private int og_id;
                private int bid;
                private String ename;
                private String pinyin;
                private String pinyin_abbr;
                private String nick_name;
                private String com_ids;
                private String grades;
                private int uid;
                private String account;
                private String sex;
                private String mobile;
                private String email;
                private String id_card_no;
                private String bank_card_no;
                private String photo_url;
                private String birth_time;
                private int birth_year;
                private int birth_month;
                private int birth_day;
                private int is_part_job;
                private int is_on_job;
                private int join_int_day;
                private int official_int_day;
                private String remark;
                private Object option_fields;
                private int user_status;
                private int is_fsys;
                private int teacher_level;
                private int college_did;
                private int major_did;
                private int degree_did;
                private int have_cert;
                private int ext_id;
                private List<Integer> rids;
                private List<Integer> bids;
                private List<Integer> lids;
                private List<?> sj_ids;

                public int getEid() {
                    return eid;
                }

                public void setEid(int eid) {
                    this.eid = eid;
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

                public String getEname() {
                    return ename;
                }

                public void setEname(String ename) {
                    this.ename = ename;
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

                public String getCom_ids() {
                    return com_ids;
                }

                public void setCom_ids(String com_ids) {
                    this.com_ids = com_ids;
                }

                public String getGrades() {
                    return grades;
                }

                public void setGrades(String grades) {
                    this.grades = grades;
                }

                public int getUid() {
                    return uid;
                }

                public void setUid(int uid) {
                    this.uid = uid;
                }

                public String getAccount() {
                    return account;
                }

                public void setAccount(String account) {
                    this.account = account;
                }

                public String getSex() {
                    return sex;
                }

                public void setSex(String sex) {
                    this.sex = sex;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String getId_card_no() {
                    return id_card_no;
                }

                public void setId_card_no(String id_card_no) {
                    this.id_card_no = id_card_no;
                }

                public String getBank_card_no() {
                    return bank_card_no;
                }

                public void setBank_card_no(String bank_card_no) {
                    this.bank_card_no = bank_card_no;
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

                public int getIs_part_job() {
                    return is_part_job;
                }

                public void setIs_part_job(int is_part_job) {
                    this.is_part_job = is_part_job;
                }

                public int getIs_on_job() {
                    return is_on_job;
                }

                public void setIs_on_job(int is_on_job) {
                    this.is_on_job = is_on_job;
                }

                public int getJoin_int_day() {
                    return join_int_day;
                }

                public void setJoin_int_day(int join_int_day) {
                    this.join_int_day = join_int_day;
                }

                public int getOfficial_int_day() {
                    return official_int_day;
                }

                public void setOfficial_int_day(int official_int_day) {
                    this.official_int_day = official_int_day;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public Object getOption_fields() {
                    return option_fields;
                }

                public void setOption_fields(Object option_fields) {
                    this.option_fields = option_fields;
                }

                public int getUser_status() {
                    return user_status;
                }

                public void setUser_status(int user_status) {
                    this.user_status = user_status;
                }

                public int getIs_fsys() {
                    return is_fsys;
                }

                public void setIs_fsys(int is_fsys) {
                    this.is_fsys = is_fsys;
                }

                public int getTeacher_level() {
                    return teacher_level;
                }

                public void setTeacher_level(int teacher_level) {
                    this.teacher_level = teacher_level;
                }

                public int getCollege_did() {
                    return college_did;
                }

                public void setCollege_did(int college_did) {
                    this.college_did = college_did;
                }

                public int getMajor_did() {
                    return major_did;
                }

                public void setMajor_did(int major_did) {
                    this.major_did = major_did;
                }

                public int getDegree_did() {
                    return degree_did;
                }

                public void setDegree_did(int degree_did) {
                    this.degree_did = degree_did;
                }

                public int getHave_cert() {
                    return have_cert;
                }

                public void setHave_cert(int have_cert) {
                    this.have_cert = have_cert;
                }

                public int getExt_id() {
                    return ext_id;
                }

                public void setExt_id(int ext_id) {
                    this.ext_id = ext_id;
                }

                public List<Integer> getRids() {
                    return rids;
                }

                public void setRids(List<Integer> rids) {
                    this.rids = rids;
                }

                public List<Integer> getBids() {
                    return bids;
                }

                public void setBids(List<Integer> bids) {
                    this.bids = bids;
                }

                public List<Integer> getLids() {
                    return lids;
                }

                public void setLids(List<Integer> lids) {
                    this.lids = lids;
                }

                public List<?> getSj_ids() {
                    return sj_ids;
                }

                public void setSj_ids(List<?> sj_ids) {
                    this.sj_ids = sj_ids;
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

            public static class CoursePrepareBean {
                private int cp_id;
                private int og_id;
                private int bid;
                private int int_day;
                private int int_start_hour;
                private int int_end_hour;
                private int teach_eid;
                private int lesson_type;
                private int cid;
                private int sid;
                private String title;
                private String content;
                private int lid;
                private int sj_id;
                private int ca_id;
                private int is_push;
                private int push_time;
                private int create_uid;
                private List<String> sids;
                private List<CoursePrepareAttachmentBean> course_prepare_attachment;
                public static class CoursePrepareAttachmentBean {
                    /**
                     * cpa_id : 5
                     * og_id : 0
                     * cp_id : 1
                     * file_id : 134
                     * file_url : http://s10.xiao360.com/qms/student_avatar/1/19/05/18/c30992c88c86283db31c2428bb438e0a.png
                     * file_type : png
                     * file_size : 1075380
                     * file_name : 648a44cdddcd1a5aabfecb72ff760a54.jpg
                     * media_type : image
                     * duration :
                     * create_uid : 1
                     */

                    private int cpa_id;
                    private int og_id;
                    private int cp_id;
                    private int file_id;
                    private String file_url;
                    private String file_type;
                    private int file_size;
                    private String file_name;
                    private String media_type;
                    private String duration;
                    private int create_uid;

                    public int getCpa_id() {
                        return cpa_id;
                    }

                    public void setCpa_id(int cpa_id) {
                        this.cpa_id = cpa_id;
                    }

                    public int getOg_id() {
                        return og_id;
                    }

                    public void setOg_id(int og_id) {
                        this.og_id = og_id;
                    }

                    public int getCp_id() {
                        return cp_id;
                    }

                    public void setCp_id(int cp_id) {
                        this.cp_id = cp_id;
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
                public int getCp_id() {
                    return cp_id;
                }

                public void setCp_id(int cp_id) {
                    this.cp_id = cp_id;
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

                public int getInt_day() {
                    return int_day;
                }

                public void setInt_day(int int_day) {
                    this.int_day = int_day;
                }

                public int getInt_start_hour() {
                    return int_start_hour;
                }

                public void setInt_start_hour(int int_start_hour) {
                    this.int_start_hour = int_start_hour;
                }

                public int getInt_end_hour() {
                    return int_end_hour;
                }

                public void setInt_end_hour(int int_end_hour) {
                    this.int_end_hour = int_end_hour;
                }

                public int getTeach_eid() {
                    return teach_eid;
                }

                public void setTeach_eid(int teach_eid) {
                    this.teach_eid = teach_eid;
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

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
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

                public int getCa_id() {
                    return ca_id;
                }

                public void setCa_id(int ca_id) {
                    this.ca_id = ca_id;
                }

                public int getIs_push() {
                    return is_push;
                }

                public void setIs_push(int is_push) {
                    this.is_push = is_push;
                }

                public int getPush_time() {
                    return push_time;
                }

                public void setPush_time(int push_time) {
                    this.push_time = push_time;
                }

                public int getCreate_uid() {
                    return create_uid;
                }

                public void setCreate_uid(int create_uid) {
                    this.create_uid = create_uid;
                }

                public List<String> getSids() {
                    return sids;
                }

                public void setSids(List<String> sids) {
                    this.sids = sids;
                }

                public List<CoursePrepareAttachmentBean> getCourse_prepare_attachment() {
                    return course_prepare_attachment;
                }

                public void setCourse_prepare_attachment(List<CoursePrepareAttachmentBean> course_prepare_attachment) {
                    this.course_prepare_attachment = course_prepare_attachment;
                }


            }
        }
    }
}
