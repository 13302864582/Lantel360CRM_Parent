package com.lantel.homelibrary.message.api;

import java.util.List;

public class MessageBean {


    /**
     * error : 0
     * message : success
     * data : {"total":39,"list":[{"id":378,"og_id":0,"bid":1,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"after_class_push","business_id":5,"send_mode":0,"title":"课后作业通知","tpl_data":null,"content":"您有新的作业了，请查收。!班级名称:一对一数学,作业名称:刘杰克布置了作业,作业详情:2019-06-13,感谢您的查阅，请认真对待，按时完成作业。","url":"https://base.dev.xiao360.com/student/#/home/homework/5","status":0,"error":null,"mgh_id":0,"create_uid":1},{"id":377,"og_id":0,"bid":1,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"after_class_push","business_id":4,"send_mode":0,"title":"课后作业通知","tpl_data":null,"content":"您有新的作业了，请查收。!班级名称:一对一数学,作业名称:管理员布置了作业,作业详情:2019-06-12,感谢您的查阅，请认真对待，按时完成作业。","url":"https://base.dev.xiao360.com/student/#/home/homework/4","status":0,"error":null,"mgh_id":0,"create_uid":1},{"id":376,"og_id":0,"bid":1,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"after_class_push","business_id":3,"send_mode":0,"title":"课后作业通知","tpl_data":null,"content":"您有新的作业了，请查收。!班级名称:一对一数学,作业名称:徐老师布置了作业,作业详情:2019-06-12,感谢您的查阅，请认真对待，按时完成作业。","url":"https://base.dev.xiao360.com/student/#/home/homework/3","status":0,"error":null,"mgh_id":0,"create_uid":1},{"id":373,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，事假，2019-10-21 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028},{"id":371,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，病假，2019-10-14 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028},{"id":369,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，病假，2019-10-07 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028},{"id":367,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，病假，2019-09-23 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028},{"id":365,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，病假，2019-09-16 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028},{"id":363,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，病假，2019-09-09 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028},{"id":361,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，病假，2019-09-02 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028}],"page":1,"pagesize":10,"sql":"SELECT * FROM `x360p_message` WHERE (  `sid` = 21  AND `x360p_message`.`og_id` = 0 ) AND `x360p_message`.`delete_time` IS NULL ORDER BY `x360p_message`.`create_time`  desc LIMIT 0,10"}
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
         * total : 39
         * list : [{"id":378,"og_id":0,"bid":1,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"after_class_push","business_id":5,"send_mode":0,"title":"课后作业通知","tpl_data":null,"content":"您有新的作业了，请查收。!班级名称:一对一数学,作业名称:刘杰克布置了作业,作业详情:2019-06-13,感谢您的查阅，请认真对待，按时完成作业。","url":"https://base.dev.xiao360.com/student/#/home/homework/5","status":0,"error":null,"mgh_id":0,"create_uid":1},{"id":377,"og_id":0,"bid":1,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"after_class_push","business_id":4,"send_mode":0,"title":"课后作业通知","tpl_data":null,"content":"您有新的作业了，请查收。!班级名称:一对一数学,作业名称:管理员布置了作业,作业详情:2019-06-12,感谢您的查阅，请认真对待，按时完成作业。","url":"https://base.dev.xiao360.com/student/#/home/homework/4","status":0,"error":null,"mgh_id":0,"create_uid":1},{"id":376,"og_id":0,"bid":1,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"after_class_push","business_id":3,"send_mode":0,"title":"课后作业通知","tpl_data":null,"content":"您有新的作业了，请查收。!班级名称:一对一数学,作业名称:徐老师布置了作业,作业详情:2019-06-12,感谢您的查阅，请认真对待，按时完成作业。","url":"https://base.dev.xiao360.com/student/#/home/homework/3","status":0,"error":null,"mgh_id":0,"create_uid":1},{"id":373,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，事假，2019-10-21 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028},{"id":371,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，病假，2019-10-14 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028},{"id":369,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，病假，2019-10-07 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028},{"id":367,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，病假，2019-09-23 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028},{"id":365,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，病假，2019-09-16 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028},{"id":363,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，病假，2019-09-09 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028},{"id":361,"og_id":0,"bid":0,"uid":10028,"sid":21,"cu_id":0,"eid":0,"cid":0,"business_type":"leave_push_s","business_id":0,"send_mode":0,"title":"您有一条请假信息。","tpl_data":null,"content":"test02，病假，2019-09-02 08:00-10:00。","url":"{url}","status":0,"error":null,"mgh_id":0,"create_uid":10028}]
         * page : 1
         * pagesize : 10
         * sql : SELECT * FROM `x360p_message` WHERE (  `sid` = 21  AND `x360p_message`.`og_id` = 0 ) AND `x360p_message`.`delete_time` IS NULL ORDER BY `x360p_message`.`create_time`  desc LIMIT 0,10
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
             * id : 378
             * og_id : 0
             * bid : 1
             * uid : 10028
             * sid : 21
             * cu_id : 0
             * eid : 0
             * cid : 0
             * business_type : after_class_push
             * business_id : 5
             * send_mode : 0
             * title : 课后作业通知
             * tpl_data : null
             * content : 您有新的作业了，请查收。!班级名称:一对一数学,作业名称:刘杰克布置了作业,作业详情:2019-06-13,感谢您的查阅，请认真对待，按时完成作业。
             * url : https://base.dev.xiao360.com/student/#/home/homework/5
             * status : 0
             * error : null
             * mgh_id : 0
             * create_uid : 1
             */

            private String business_type;
            private int business_id;
            private String title;
            private String content;

            public String getBusiness_type() {
                return business_type;
            }

            public void setBusiness_type(String business_type) {
                this.business_type = business_type;
            }

            public int getBusiness_id() {
                return business_id;
            }

            public void setBusiness_id(int business_id) {
                this.business_id = business_id;
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
        }
    }
}
