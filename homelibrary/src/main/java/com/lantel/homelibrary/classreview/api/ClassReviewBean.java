package com.lantel.homelibrary.classreview.api;

import com.lantel.common.HttpResBean;

import java.util.List;

public class ClassReviewBean  extends HttpResBean {
    /**
     * error : 0
     * message : success
     * data : {"total":3,"list":[{"rs_id":6,"og_id":0,"bid":1,"rvw_id":4,"sid":21,"lesson_type":0,"review_style":0,"cid":4,"lid":0,"int_day":0,"int_start_hour":0,"int_end_hour":0,"eid":10003,"is_read":0,"read_time":0,"score":5,"score1":0,"score2":0,"score3":0,"score4":0,"score5":0,"score6":0,"score7":0,"score8":0,"score9":0,"detail":"hjjjjjjjjj","view_times":2,"share_times":0,"create_time":"2019-05-24 12:33:59","employee":{"eid":10003,"ename":"徐老师","photo_url":"http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg"},"lesson":null},{"rs_id":5,"og_id":0,"bid":1,"rvw_id":3,"sid":21,"lesson_type":1,"review_style":0,"cid":0,"lid":2,"int_day":20190523,"int_start_hour":1400,"int_end_hour":1500,"eid":10002,"is_read":0,"read_time":0,"score":5,"score1":0,"score2":0,"score3":0,"score4":0,"score5":0,"score6":0,"score7":0,"score8":0,"score9":0,"detail":"上课认真，回答问题非常积极！","view_times":6,"share_times":0,"create_time":"2019-05-24 10:12:23","employee":{"eid":10002,"ename":"刘杰克","photo_url":"http://s10.xiao360.com/qms/user_avatar/10011/18/01/29/3697a7b62158d6744298c53b53fdb408.jpeg"},"lesson":{"lid":2,"lesson_name":"一对一数学","short_desc":"张慧，国家二级心理咨询师，国际情商机构6 Seconds情商领导力认证讲师。长期为世界500强企业提供压力管理，情商，上午沟通和表达的培训","fit_age":[0,0],"fit_grade":[0,0]}},{"rs_id":4,"og_id":0,"bid":1,"rvw_id":2,"sid":21,"lesson_type":1,"review_style":0,"cid":0,"lid":2,"int_day":20190518,"int_start_hour":800,"int_end_hour":1000,"eid":10003,"is_read":0,"read_time":0,"score":5,"score1":0,"score2":0,"score3":0,"score4":0,"score5":0,"score6":0,"score7":0,"score8":0,"score9":0,"detail":"少时诵诗书","view_times":2,"share_times":0,"create_time":"2019-05-18 17:35:00","employee":{"eid":10003,"ename":"徐老师","photo_url":"http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg"},"lesson":{"lid":2,"lesson_name":"一对一数学","short_desc":"张慧，国家二级心理咨询师，国际情商机构6 Seconds情商领导力认证讲师。长期为世界500强企业提供压力管理，情商，上午沟通和表达的培训","fit_age":[0,0],"fit_grade":[0,0]}}],"page":1,"pagesize":10,"sql":"SELECT `lid`,`lesson_name`,`short_desc` FROM `x360p_lesson` WHERE (  `lid` IN (0,2)  AND `x360p_lesson`.`og_id` = 0 ) AND `x360p_lesson`.`delete_time` IS NULL"}
     * authed : true
     */
    private DataBean data;
    private boolean authed;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isAuthed() {
        return authed;
    }

    public void setAuthed(boolean authed) {
        this.authed = authed;
    }

    public static class DataBean {
        /**
         * total : 3
         * list : [{"rs_id":6,"og_id":0,"bid":1,"rvw_id":4,"sid":21,"lesson_type":0,"review_style":0,"cid":4,"lid":0,"int_day":0,"int_start_hour":0,"int_end_hour":0,"eid":10003,"is_read":0,"read_time":0,"score":5,"score1":0,"score2":0,"score3":0,"score4":0,"score5":0,"score6":0,"score7":0,"score8":0,"score9":0,"detail":"hjjjjjjjjj","view_times":2,"share_times":0,"create_time":"2019-05-24 12:33:59","employee":{"eid":10003,"ename":"徐老师","photo_url":"http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg"},"lesson":null},{"rs_id":5,"og_id":0,"bid":1,"rvw_id":3,"sid":21,"lesson_type":1,"review_style":0,"cid":0,"lid":2,"int_day":20190523,"int_start_hour":1400,"int_end_hour":1500,"eid":10002,"is_read":0,"read_time":0,"score":5,"score1":0,"score2":0,"score3":0,"score4":0,"score5":0,"score6":0,"score7":0,"score8":0,"score9":0,"detail":"上课认真，回答问题非常积极！","view_times":6,"share_times":0,"create_time":"2019-05-24 10:12:23","employee":{"eid":10002,"ename":"刘杰克","photo_url":"http://s10.xiao360.com/qms/user_avatar/10011/18/01/29/3697a7b62158d6744298c53b53fdb408.jpeg"},"lesson":{"lid":2,"lesson_name":"一对一数学","short_desc":"张慧，国家二级心理咨询师，国际情商机构6 Seconds情商领导力认证讲师。长期为世界500强企业提供压力管理，情商，上午沟通和表达的培训","fit_age":[0,0],"fit_grade":[0,0]}},{"rs_id":4,"og_id":0,"bid":1,"rvw_id":2,"sid":21,"lesson_type":1,"review_style":0,"cid":0,"lid":2,"int_day":20190518,"int_start_hour":800,"int_end_hour":1000,"eid":10003,"is_read":0,"read_time":0,"score":5,"score1":0,"score2":0,"score3":0,"score4":0,"score5":0,"score6":0,"score7":0,"score8":0,"score9":0,"detail":"少时诵诗书","view_times":2,"share_times":0,"create_time":"2019-05-18 17:35:00","employee":{"eid":10003,"ename":"徐老师","photo_url":"http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg"},"lesson":{"lid":2,"lesson_name":"一对一数学","short_desc":"张慧，国家二级心理咨询师，国际情商机构6 Seconds情商领导力认证讲师。长期为世界500强企业提供压力管理，情商，上午沟通和表达的培训","fit_age":[0,0],"fit_grade":[0,0]}}]
         * page : 1
         * pagesize : 10
         * sql : SELECT `lid`,`lesson_name`,`short_desc` FROM `x360p_lesson` WHERE (  `lid` IN (0,2)  AND `x360p_lesson`.`og_id` = 0 ) AND `x360p_lesson`.`delete_time` IS NULL
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
             * rs_id : 6
             * og_id : 0
             * bid : 1
             * rvw_id : 4
             * sid : 21
             * lesson_type : 0
             * review_style : 0
             * cid : 4
             * lid : 0
             * int_day : 0
             * int_start_hour : 0
             * int_end_hour : 0
             * eid : 10003
             * is_read : 0
             * read_time : 0
             * score : 5
             * score1 : 0
             * score2 : 0
             * score3 : 0
             * score4 : 0
             * score5 : 0
             * score6 : 0
             * score7 : 0
             * score8 : 0
             * score9 : 0
             * detail : hjjjjjjjjj
             * view_times : 2
             * share_times : 0
             * create_time : 2019-05-24 12:33:59
             * employee : {"eid":10003,"ename":"徐老师","photo_url":"http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg"}
             * lesson : null
             */

            private String detail;
            private String create_time;
            private EmployeeBean employee;
            private int rvw_id;

            public int getRvw_id() {
                return rvw_id;
            }

            public void setRvw_id(int rvw_id) {
                this.rvw_id = rvw_id;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
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

            public static class EmployeeBean {
                /**
                 * eid : 10003
                 * ename : 徐老师
                 * photo_url : http://s10.xiao360.com/qms/user_avatar/10014/19/05/08/4823c2e2a3385f2d0979ad10ecf969dd.jpeg
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
