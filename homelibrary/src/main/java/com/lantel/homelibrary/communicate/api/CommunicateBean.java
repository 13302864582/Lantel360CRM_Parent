package com.lantel.homelibrary.communicate.api;

import com.lantel.common.HttpResBean;

import java.util.List;

public class CommunicateBean  extends HttpResBean {

    /**
     * error : 0
     * message : success
     * data : {"total":1,"list":[{"ac_id":1,"og_id":0,"sid":0,"eid":0,"message":null,"send_type":0,"app_client_id":0,"message_type":0,"app_module_id":0,"is_read":0,"read_time":"-","create_time":"2019-06-21 10:59:51","create_uid":10028}],"page":1,"pagesize":20,"sql":"SELECT * FROM `x360p_im_chat` WHERE (  `x360p_im_chat`.`og_id` = 0 ) AND `x360p_im_chat`.`delete_time` IS NULL ORDER BY `x360p_im_chat`.`create_time`  desc LIMIT 0,20"}
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
         * list : [{"ac_id":1,"og_id":0,"sid":0,"eid":0,"message":null,"send_type":0,"app_client_id":0,"message_type":0,"app_module_id":0,"is_read":0,"read_time":"-","create_time":"2019-06-21 10:59:51","create_uid":10028}]
         * page : 1
         * pagesize : 20
         * sql : SELECT * FROM `x360p_im_chat` WHERE (  `x360p_im_chat`.`og_id` = 0 ) AND `x360p_im_chat`.`delete_time` IS NULL ORDER BY `x360p_im_chat`.`create_time`  desc LIMIT 0,20
         */

        private int total;
        private int page;
        private int pagesize;
        private String sql;
        private List<ListBean> list;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * ac_id : 1
             * og_id : 0
             * sid : 0
             * eid : 0
             * message : null
             * send_type : 0
             * app_client_id : 0
             * message_type : 0
             * app_module_id : 0
             * is_read : 0
             * read_time : -
             * create_time : 2019-06-21 10:59:51
             * create_uid : 10028
             */

            private int ac_id;
            private int og_id;
            private int sid;
            private int eid;
            private String message;
            private int send_type;
            private int app_client_id;
            private int message_type;
            private int app_module_id;
            private int is_read;
            private String read_time;
            private String create_time;
            private int create_uid;
            private StudentBean student;
            private EmployeeBean employee;

            public EmployeeBean getEmployee() {
                return employee;
            }

            public void setEmployee(EmployeeBean employee) {
                this.employee = employee;
            }

            public StudentBean getStudent() {
                return student;
            }

            public void setStudent(StudentBean student) {
                this.student = student;
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

            public static class StudentBean {
                private int sid;
                private String student_name;
                private String photo_url;

                public int getSid() {
                    return sid;
                }

                public void setSid(int sid) {
                    this.sid = sid;
                }

                public String getStudent_name() {
                    return student_name;
                }

                public void setStudent_name(String student_name) {
                    this.student_name = student_name;
                }

                public String getPhoto_url() {
                    return photo_url;
                }

                public void setPhoto_url(String photo_url) {
                    this.photo_url = photo_url;
                }
            }

            public int getAc_id() {
                return ac_id;
            }

            public void setAc_id(int ac_id) {
                this.ac_id = ac_id;
            }

            public int getOg_id() {
                return og_id;
            }

            public void setOg_id(int og_id) {
                this.og_id = og_id;
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

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public int getSend_type() {
                return send_type;
            }

            public void setSend_type(int send_type) {
                this.send_type = send_type;
            }

            public int getApp_client_id() {
                return app_client_id;
            }

            public void setApp_client_id(int app_client_id) {
                this.app_client_id = app_client_id;
            }

            public int getMessage_type() {
                return message_type;
            }

            public void setMessage_type(int message_type) {
                this.message_type = message_type;
            }

            public int getApp_module_id() {
                return app_module_id;
            }

            public void setApp_module_id(int app_module_id) {
                this.app_module_id = app_module_id;
            }

            public int getIs_read() {
                return is_read;
            }

            public void setIs_read(int is_read) {
                this.is_read = is_read;
            }

            public String getRead_time() {
                return read_time;
            }

            public void setRead_time(String read_time) {
                this.read_time = read_time;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
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
