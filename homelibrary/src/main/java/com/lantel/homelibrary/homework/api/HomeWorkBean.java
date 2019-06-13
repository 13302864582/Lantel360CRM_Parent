package com.lantel.homelibrary.homework.api;

import com.lantel.studylibrary.preview.preview.api.PreviewDetailBean;

import java.util.List;

public class HomeWorkBean {

    /**
     * error : 0
     * message : success
     * data : {"total":1,"list":[{"ht_id":2,"og_id":0,"bid":1,"lid":2,"ca_id":0,"lesson_type":1,"cid":0,"sid":21,"sids":[""],"eid":1,"htts_id":0,"content":"<p>sasaxsasx<\/p>","remark":"","deadline":20190525,"push_status":1,"create_time":"2019-05-18 17:43:07","employee":{"eid":1,"ename":"管理员","uid":1,"mobile":"17620398800","photo_url":""},"one_class":null}],"page":1,"pagesize":40,"sql":"SELECT `cid`,`bid`,`class_name`,`lid` FROM `x360p_class` WHERE (  `cid` IN (0)  AND `x360p_class`.`og_id` = 0 ) AND `x360p_class`.`delete_time` IS NULL"}
     * authed : true
     */

    private int error;
    private String message;
    private DataBean data;
    private boolean authed;

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

    public boolean isAuthed() {
        return authed;
    }

    public void setAuthed(boolean authed) {
        this.authed = authed;
    }

    public static class DataBean {
        /**
         * total : 1
         * list : [{"ht_id":2,"og_id":0,"bid":1,"lid":2,"ca_id":0,"lesson_type":1,"cid":0,"sid":21,"sids":[""],"eid":1,"htts_id":0,"content":"<p>sasaxsasx<\/p>","remark":"","deadline":20190525,"push_status":1,"create_time":"2019-05-18 17:43:07","employee":{"eid":1,"ename":"管理员","uid":1,"mobile":"17620398800","photo_url":""},"one_class":null}]
         * page : 1
         * pagesize : 40
         * sql : SELECT `cid`,`bid`,`class_name`,`lid` FROM `x360p_class` WHERE (  `cid` IN (0)  AND `x360p_class`.`og_id` = 0 ) AND `x360p_class`.`delete_time` IS NULL
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
             * ht_id : 2
             * og_id : 0
             * bid : 1
             * lid : 2
             * ca_id : 0
             * lesson_type : 1
             * cid : 0
             * sid : 21
             * sids : [""]
             * eid : 1
             * htts_id : 0
             * content : <p>sasaxsasx</p>
             * remark :
             * deadline : 20190525
             * push_status : 1
             * create_time : 2019-05-18 17:43:07
             * employee : {"eid":1,"ename":"管理员","uid":1,"mobile":"17620398800","photo_url":""}
             * one_class : null
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

            public static class EmployeeBean {
                /**
                 * eid : 1
                 * ename : 管理员
                 * uid : 1
                 * mobile : 17620398800
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
        }
    }
}
