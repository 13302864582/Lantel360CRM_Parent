package com.lantel.homelibrary.course.api;


import java.util.List;

public class CourseBean {

    /**
     * error : 0
     * message : success
     * data : {"total":1,"list":[{"ca_id":91,"og_id":0,"bid":1,"lesson_type":1,"is_trial":0,"is_makeup":0,"is_demo":0,"is_online":0,"is_bk_open":1,"csd_id":0,"csm_id":0,"name":"","cid":0,"teach_eid":10002,"second_eid":1,"second_eids":"1","lid":2,"sj_id":1,"grade":0,"sg_id":0,"cr_id":1,"chapter_index":0,"season":"A","int_day":20190523,"is_attendance":2,"is_prepare":0,"prepare_file_nums":0,"int_start_hour":1400,"int_end_hour":1500,"consume_source_type":1,"consume_lesson_hour":"2.00","consume_lesson_amount":"0.00","create_type":1,"listen_apply_nums":0,"listen_approve_nums":0,"listen_arrive_nums":0,"prepare_message":"","is_before_push":0,"is_after_push":0,"before_push_time":0,"after_push_time":0,"is_cancel":0,"reason":null,"tb_id":2,"tbs_id":12,"create_uid":1,"lesson":{"lid":2,"og_id":0,"bids":[],"year":0,"season":"","sj_id":1,"sj_ids":[1],"lesson_name":"一对一数学","lesson_no":"","product_level_did":0,"fit_age_start":0,"fit_age_end":0,"fit_grade_start":0,"fit_grade_end":0,"short_desc":"张慧，国家二级心理咨询师，国际情商机构6 Seconds情商领导力认证讲师。长期为世界500强企业提供压力管理，情商，上午沟通和表达的培训","public_content":"<ol class=\" list-paddingleft-2\" style=\"width: 505.391px; white-space: normal;\"><li><p>这堂课告诉你，应对焦虑不只是内向的情绪管理。也是向外的生活管理和关系管理。<\/p><\/li><li><p>这堂课会教给你焦虑发生时，有效的缓解和疏导方法，也会告诉你，如何策略性地为自己打造稳定感和秩序感的生活场域。<\/p><\/li><li><p>讲师张慧是经验丰富的心理教练，这里有她精心筛选出的近10中应对焦虑的自我教练方法，她会通过极富启发性的引导，帮助你掌握他们<\/p><\/li><\/ol><p><br/><\/p>","lesson_cover_picture":"http://s10.xiao360.com/qms/1/0/r23F2zL5w8XsI433KG5xpJxcaP3nF3fb.jpg","chapter_nums":1,"lesson_type":1,"is_multi_class":0,"ac_class_nums":1,"price_type":2,"is_term":1,"lesson_nums":"120.00","unit_price":"16.666667","unit_lesson_hours":"1.00","unit_lesson_minutes":60,"sale_price":"2000.00","per_lesson_hour_minutes":0,"ext_lid":"","version":"","status":1,"is_package":0,"is_default":1,"is_publish":0,"is_standard":0,"ability_did":0,"is_demo":0,"is_public":1,"expire_month":0,"leave_nums_limit":-1,"teacher_level":-1,"bk_limit_status":0,"bk_space_days":0,"create_uid":1,"attachments":[],"fit_age":[0,0],"fit_grade":[0,0]},"teacher":{"eid":10002,"og_id":0,"bid":1,"ename":"刘杰克","pinyin":"","pinyin_abbr":"","nick_name":"杰克","rids":[10,1,3],"bids":[1,2,3],"com_ids":"","lids":[1,2,3],"sj_ids":[],"grades":"","uid":10011,"account":"liuzy","sex":"1","mobile":"18814514845","email":"","id_card_no":"","bank_card_no":"","photo_url":"http://s10.xiao360.com/qms/user_avatar/10011/18/01/29/3697a7b62158d6744298c53b53fdb408.jpeg","birth_time":0,"birth_year":0,"birth_month":0,"birth_day":0,"is_part_job":0,"is_on_job":1,"join_int_day":0,"official_int_day":0,"remark":"","option_fields":null,"user_status":1,"is_fsys":0,"teacher_level":-1,"college_did":0,"major_did":0,"degree_did":0,"have_cert":0,"ext_id":0},"course_prepare":null,"one_class":null,"textbook":{"tb_id":2,"og_id":0,"is_public":1,"suit_bids":"","tb_name":"高级英语第3版","tb_org_name":"中国人民出版社","create_uid":1},"textbook_section":{"tbs_id":12,"og_id":0,"tb_id":2,"section_title":"第二章","sort":2,"create_uid":1},"course_name":"一对一数学","leave_times":0,"allow_leave":1,"student_leave":null}],"page":1,"pagesize":20,"sql":"SELECT * FROM `x360p_textbook_section` WHERE (  `tbs_id` IN (12)  AND `x360p_textbook_section`.`og_id` = 0 ) AND `x360p_textbook_section`.`delete_time` IS NULL","slvs":[]}
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
         * list : [{"ca_id":91,"og_id":0,"bid":1,"lesson_type":1,"is_trial":0,"is_makeup":0,"is_demo":0,"is_online":0,"is_bk_open":1,"csd_id":0,"csm_id":0,"name":"","cid":0,"teach_eid":10002,"second_eid":1,"second_eids":"1","lid":2,"sj_id":1,"grade":0,"sg_id":0,"cr_id":1,"chapter_index":0,"season":"A","int_day":20190523,"is_attendance":2,"is_prepare":0,"prepare_file_nums":0,"int_start_hour":1400,"int_end_hour":1500,"consume_source_type":1,"consume_lesson_hour":"2.00","consume_lesson_amount":"0.00","create_type":1,"listen_apply_nums":0,"listen_approve_nums":0,"listen_arrive_nums":0,"prepare_message":"","is_before_push":0,"is_after_push":0,"before_push_time":0,"after_push_time":0,"is_cancel":0,"reason":null,"tb_id":2,"tbs_id":12,"create_uid":1,"lesson":{"lid":2,"og_id":0,"bids":[],"year":0,"season":"","sj_id":1,"sj_ids":[1],"lesson_name":"一对一数学","lesson_no":"","product_level_did":0,"fit_age_start":0,"fit_age_end":0,"fit_grade_start":0,"fit_grade_end":0,"short_desc":"张慧，国家二级心理咨询师，国际情商机构6 Seconds情商领导力认证讲师。长期为世界500强企业提供压力管理，情商，上午沟通和表达的培训","public_content":"<ol class=\" list-paddingleft-2\" style=\"width: 505.391px; white-space: normal;\"><li><p>这堂课告诉你，应对焦虑不只是内向的情绪管理。也是向外的生活管理和关系管理。<\/p><\/li><li><p>这堂课会教给你焦虑发生时，有效的缓解和疏导方法，也会告诉你，如何策略性地为自己打造稳定感和秩序感的生活场域。<\/p><\/li><li><p>讲师张慧是经验丰富的心理教练，这里有她精心筛选出的近10中应对焦虑的自我教练方法，她会通过极富启发性的引导，帮助你掌握他们<\/p><\/li><\/ol><p><br/><\/p>","lesson_cover_picture":"http://s10.xiao360.com/qms/1/0/r23F2zL5w8XsI433KG5xpJxcaP3nF3fb.jpg","chapter_nums":1,"lesson_type":1,"is_multi_class":0,"ac_class_nums":1,"price_type":2,"is_term":1,"lesson_nums":"120.00","unit_price":"16.666667","unit_lesson_hours":"1.00","unit_lesson_minutes":60,"sale_price":"2000.00","per_lesson_hour_minutes":0,"ext_lid":"","version":"","status":1,"is_package":0,"is_default":1,"is_publish":0,"is_standard":0,"ability_did":0,"is_demo":0,"is_public":1,"expire_month":0,"leave_nums_limit":-1,"teacher_level":-1,"bk_limit_status":0,"bk_space_days":0,"create_uid":1,"attachments":[],"fit_age":[0,0],"fit_grade":[0,0]},"teacher":{"eid":10002,"og_id":0,"bid":1,"ename":"刘杰克","pinyin":"","pinyin_abbr":"","nick_name":"杰克","rids":[10,1,3],"bids":[1,2,3],"com_ids":"","lids":[1,2,3],"sj_ids":[],"grades":"","uid":10011,"account":"liuzy","sex":"1","mobile":"18814514845","email":"","id_card_no":"","bank_card_no":"","photo_url":"http://s10.xiao360.com/qms/user_avatar/10011/18/01/29/3697a7b62158d6744298c53b53fdb408.jpeg","birth_time":0,"birth_year":0,"birth_month":0,"birth_day":0,"is_part_job":0,"is_on_job":1,"join_int_day":0,"official_int_day":0,"remark":"","option_fields":null,"user_status":1,"is_fsys":0,"teacher_level":-1,"college_did":0,"major_did":0,"degree_did":0,"have_cert":0,"ext_id":0},"course_prepare":null,"one_class":null,"textbook":{"tb_id":2,"og_id":0,"is_public":1,"suit_bids":"","tb_name":"高级英语第3版","tb_org_name":"中国人民出版社","create_uid":1},"textbook_section":{"tbs_id":12,"og_id":0,"tb_id":2,"section_title":"第二章","sort":2,"create_uid":1},"course_name":"一对一数学","leave_times":0,"allow_leave":1,"student_leave":null}]
         * page : 1
         * pagesize : 20
         * sql : SELECT * FROM `x360p_textbook_section` WHERE (  `tbs_id` IN (12)  AND `x360p_textbook_section`.`og_id` = 0 ) AND `x360p_textbook_section`.`delete_time` IS NULL
         * slvs : []
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
             * ca_id : 91
             * og_id : 0
             * bid : 1
             * lesson_type : 1
             * is_trial : 0
             * is_makeup : 0
             * is_demo : 0
             * is_online : 0
             * is_bk_open : 1
             * csd_id : 0
             * csm_id : 0
             * name :
             * cid : 0
             * teach_eid : 10002
             * second_eid : 1
             * second_eids : 1
             * lid : 2
             * sj_id : 1
             * grade : 0
             * sg_id : 0
             * cr_id : 1
             * chapter_index : 0
             * season : A
             * int_day : 20190523
             * is_attendance : 2
             * is_prepare : 0
             * prepare_file_nums : 0
             * int_start_hour : 1400
             * int_end_hour : 1500
             * consume_source_type : 1
             * consume_lesson_hour : 2.00
             * consume_lesson_amount : 0.00
             * create_type : 1
             * listen_apply_nums : 0
             * listen_approve_nums : 0
             * listen_arrive_nums : 0
             * prepare_message :
             * is_before_push : 0
             * is_after_push : 0
             * before_push_time : 0
             * after_push_time : 0
             * is_cancel : 0
             * reason : null
             * tb_id : 2
             * tbs_id : 12
             * create_uid : 1
             * lesson : {"lid":2,"og_id":0,"bids":[],"year":0,"season":"","sj_id":1,"sj_ids":[1],"lesson_name":"一对一数学","lesson_no":"","product_level_did":0,"fit_age_start":0,"fit_age_end":0,"fit_grade_start":0,"fit_grade_end":0,"short_desc":"张慧，国家二级心理咨询师，国际情商机构6 Seconds情商领导力认证讲师。长期为世界500强企业提供压力管理，情商，上午沟通和表达的培训","public_content":"<ol class=\" list-paddingleft-2\" style=\"width: 505.391px; white-space: normal;\"><li><p>这堂课告诉你，应对焦虑不只是内向的情绪管理。也是向外的生活管理和关系管理。<\/p><\/li><li><p>这堂课会教给你焦虑发生时，有效的缓解和疏导方法，也会告诉你，如何策略性地为自己打造稳定感和秩序感的生活场域。<\/p><\/li><li><p>讲师张慧是经验丰富的心理教练，这里有她精心筛选出的近10中应对焦虑的自我教练方法，她会通过极富启发性的引导，帮助你掌握他们<\/p><\/li><\/ol><p><br/><\/p>","lesson_cover_picture":"http://s10.xiao360.com/qms/1/0/r23F2zL5w8XsI433KG5xpJxcaP3nF3fb.jpg","chapter_nums":1,"lesson_type":1,"is_multi_class":0,"ac_class_nums":1,"price_type":2,"is_term":1,"lesson_nums":"120.00","unit_price":"16.666667","unit_lesson_hours":"1.00","unit_lesson_minutes":60,"sale_price":"2000.00","per_lesson_hour_minutes":0,"ext_lid":"","version":"","status":1,"is_package":0,"is_default":1,"is_publish":0,"is_standard":0,"ability_did":0,"is_demo":0,"is_public":1,"expire_month":0,"leave_nums_limit":-1,"teacher_level":-1,"bk_limit_status":0,"bk_space_days":0,"create_uid":1,"attachments":[],"fit_age":[0,0],"fit_grade":[0,0]}
             * teacher : {"eid":10002,"og_id":0,"bid":1,"ename":"刘杰克","pinyin":"","pinyin_abbr":"","nick_name":"杰克","rids":[10,1,3],"bids":[1,2,3],"com_ids":"","lids":[1,2,3],"sj_ids":[],"grades":"","uid":10011,"account":"liuzy","sex":"1","mobile":"18814514845","email":"","id_card_no":"","bank_card_no":"","photo_url":"http://s10.xiao360.com/qms/user_avatar/10011/18/01/29/3697a7b62158d6744298c53b53fdb408.jpeg","birth_time":0,"birth_year":0,"birth_month":0,"birth_day":0,"is_part_job":0,"is_on_job":1,"join_int_day":0,"official_int_day":0,"remark":"","option_fields":null,"user_status":1,"is_fsys":0,"teacher_level":-1,"college_did":0,"major_did":0,"degree_did":0,"have_cert":0,"ext_id":0}
             * course_prepare : null
             * one_class : null
             * textbook : {"tb_id":2,"og_id":0,"is_public":1,"suit_bids":"","tb_name":"高级英语第3版","tb_org_name":"中国人民出版社","create_uid":1}
             * textbook_section : {"tbs_id":12,"og_id":0,"tb_id":2,"section_title":"第二章","sort":2,"create_uid":1}
             * course_name : 一对一数学
             * leave_times : 0
             * allow_leave : 1
             * student_leave : null
             */

            private int int_start_hour;
            private int int_end_hour;
            private LessonBean lesson;
            private TeacherBean teacher;
            private TextbookBean textbook;
            private TextbookSectionBean textbook_section;
            private StudentLeaveBean student_leave;

            public int getInt_start_hour() {
                return int_start_hour;
            }

            public void setInt_start_hour(int int_start_hour) {
                this.int_start_hour = int_start_hour;
            }

            public StudentLeaveBean getStudent_leave() {
                return student_leave;
            }

            public void setStudent_leave(StudentLeaveBean student_leave) {
                this.student_leave = student_leave;
            }

            public int getInt_end_hour() {
                return int_end_hour;
            }

            public void setInt_end_hour(int int_end_hour) {
                this.int_end_hour = int_end_hour;
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

            public TextbookBean getTextbook() {
                return textbook;
            }

            public void setTextbook(TextbookBean textbook) {
                this.textbook = textbook;
            }

            public TextbookSectionBean getTextbook_section() {
                return textbook_section;
            }

            public void setTextbook_section(TextbookSectionBean textbook_section) {
                this.textbook_section = textbook_section;
            }

            public static class LessonBean {
                /**
                 * lid : 2
                 * og_id : 0
                 * bids : []
                 * year : 0
                 * season :
                 * sj_id : 1
                 * sj_ids : [1]
                 * lesson_name : 一对一数学
                 * lesson_no :
                 * product_level_did : 0
                 * fit_age_start : 0
                 * fit_age_end : 0
                 * fit_grade_start : 0
                 * fit_grade_end : 0
                 * short_desc : 张慧，国家二级心理咨询师，国际情商机构6 Seconds情商领导力认证讲师。长期为世界500强企业提供压力管理，情商，上午沟通和表达的培训
                 * public_content : <ol class=" list-paddingleft-2" style="width: 505.391px; white-space: normal;"><li><p>这堂课告诉你，应对焦虑不只是内向的情绪管理。也是向外的生活管理和关系管理。</p></li><li><p>这堂课会教给你焦虑发生时，有效的缓解和疏导方法，也会告诉你，如何策略性地为自己打造稳定感和秩序感的生活场域。</p></li><li><p>讲师张慧是经验丰富的心理教练，这里有她精心筛选出的近10中应对焦虑的自我教练方法，她会通过极富启发性的引导，帮助你掌握他们</p></li></ol><p><br/></p>
                 * lesson_cover_picture : http://s10.xiao360.com/qms/1/0/r23F2zL5w8XsI433KG5xpJxcaP3nF3fb.jpg
                 * chapter_nums : 1
                 * lesson_type : 1
                 * is_multi_class : 0
                 * ac_class_nums : 1
                 * price_type : 2
                 * is_term : 1
                 * lesson_nums : 120.00
                 * unit_price : 16.666667
                 * unit_lesson_hours : 1.00
                 * unit_lesson_minutes : 60
                 * sale_price : 2000.00
                 * per_lesson_hour_minutes : 0
                 * ext_lid :
                 * version :
                 * status : 1
                 * is_package : 0
                 * is_default : 1
                 * is_publish : 0
                 * is_standard : 0
                 * ability_did : 0
                 * is_demo : 0
                 * is_public : 1
                 * expire_month : 0
                 * leave_nums_limit : -1
                 * teacher_level : -1
                 * bk_limit_status : 0
                 * bk_space_days : 0
                 * create_uid : 1
                 * attachments : []
                 * fit_age : [0,0]
                 * fit_grade : [0,0]
                 */

                private String lesson_name;

                public String getLesson_name() {
                    return lesson_name;
                }

                public void setLesson_name(String lesson_name) {
                    this.lesson_name = lesson_name;
                }
            }

            public static class TeacherBean {
                /**
                 * eid : 10002
                 * og_id : 0
                 * bid : 1
                 * ename : 刘杰克
                 * pinyin :
                 * pinyin_abbr :
                 * nick_name : 杰克
                 * rids : [10,1,3]
                 * bids : [1,2,3]
                 * com_ids :
                 * lids : [1,2,3]
                 * sj_ids : []
                 * grades :
                 * uid : 10011
                 * account : liuzy
                 * sex : 1
                 * mobile : 18814514845
                 * email :
                 * id_card_no :
                 * bank_card_no :
                 * photo_url : http://s10.xiao360.com/qms/user_avatar/10011/18/01/29/3697a7b62158d6744298c53b53fdb408.jpeg
                 * birth_time : 0
                 * birth_year : 0
                 * birth_month : 0
                 * birth_day : 0
                 * is_part_job : 0
                 * is_on_job : 1
                 * join_int_day : 0
                 * official_int_day : 0
                 * remark :
                 * option_fields : null
                 * user_status : 1
                 * is_fsys : 0
                 * teacher_level : -1
                 * college_did : 0
                 * major_did : 0
                 * degree_did : 0
                 * have_cert : 0
                 * ext_id : 0
                 */

                private String ename;
                private String nick_name;

                public String getEname() {
                    return ename;
                }

                public void setEname(String ename) {
                    this.ename = ename;
                }

                public String getNick_name() {
                    return nick_name;
                }

                public void setNick_name(String nick_name) {
                    this.nick_name = nick_name;
                }
            }

            public static class TextbookBean {
                /**
                 * tb_id : 2
                 * og_id : 0
                 * is_public : 1
                 * suit_bids :
                 * tb_name : 高级英语第3版
                 * tb_org_name : 中国人民出版社
                 * create_uid : 1
                 */

                private String tb_name;

                public String getTb_name() {
                    return tb_name;
                }

                public void setTb_name(String tb_name) {
                    this.tb_name = tb_name;
                }
            }

            public static class TextbookSectionBean {
                /**
                 * tbs_id : 12
                 * og_id : 0
                 * tb_id : 2
                 * section_title : 第二章
                 * sort : 2
                 * create_uid : 1
                 */

                private String section_title;
                private int sort;

                public String getSection_title() {
                    return section_title;
                }

                public void setSection_title(String section_title) {
                    this.section_title = section_title;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }
            }

            public static class StudentLeaveBean{
                private int leave_type;
                private int leave_way;

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
            }
        }


    }
}
