package com.lantel.homelibrary.homework.api;

import com.lantel.common.HttpResBean;

import java.util.List;

public class HomeWorkBean  extends HttpResBean {


    /**
     * error : 0
     * message : success
     * data : {"complete":{"total":1,"list":[{"ht_id":10,"og_id":0,"bid":8,"lid":0,"ca_id":265,"lesson_type":0,"cid":6,"sid":0,"sids":[""],"eid":10016,"htts_id":0,"content":"新接口第一次发布作业测试","remark":"第一次发布作业","deadline":20190626,"push_status":1,"create_time":"2019-06-19 16:30:36","employee":{"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""},"class_name":"演示6-1班"}],"page":1,"pagesize":20,"sql":"SELECT `eid`,`ename`,`uid`,`mobile`,`photo_url` FROM `x360p_employee` WHERE (  `eid` IN (10016)  AND `x360p_employee`.`og_id` = 0 ) AND `x360p_employee`.`delete_time` IS NULL"},"incomplete":{"total":3,"list":[{"ht_id":10,"og_id":0,"bid":8,"lid":0,"ca_id":265,"lesson_type":0,"cid":6,"sid":0,"sids":[""],"eid":10016,"htts_id":0,"content":"新接口第一次发布作业测试","remark":"第一次发布作业","deadline":20190626,"push_status":1,"create_time":"2019-06-19 16:30:36","employee":{"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""},"class_name":"演示6-1班"},{"ht_id":25,"og_id":0,"bid":8,"lid":0,"ca_id":265,"lesson_type":0,"cid":6,"sid":0,"sids":[""],"eid":10016,"htts_id":0,"content":"第n次吃啥布置作业","remark":"第那次","deadline":20190626,"push_status":1,"create_time":"2019-06-19 19:06:21","employee":{"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""},"class_name":"演示6-1班"},{"ht_id":43,"og_id":0,"bid":8,"lid":0,"ca_id":265,"lesson_type":0,"cid":6,"sid":0,"sids":[""],"eid":10016,"htts_id":0,"content":"布置作业啦","remark":"布置作业啦","deadline":20190627,"push_status":1,"create_time":"2019-06-20 10:16:18","employee":{"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""},"class_name":"演示6-1班"}],"page":1,"pagesize":20,"sql":"SELECT `eid`,`ename`,`uid`,`mobile`,`photo_url` FROM `x360p_employee` WHERE (  `eid` IN (10016)  AND `x360p_employee`.`og_id` = 0 ) AND `x360p_employee`.`delete_time` IS NULL"}}
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
         * complete : {"total":1,"list":[{"ht_id":10,"og_id":0,"bid":8,"lid":0,"ca_id":265,"lesson_type":0,"cid":6,"sid":0,"sids":[""],"eid":10016,"htts_id":0,"content":"新接口第一次发布作业测试","remark":"第一次发布作业","deadline":20190626,"push_status":1,"create_time":"2019-06-19 16:30:36","employee":{"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""},"class_name":"演示6-1班"}],"page":1,"pagesize":20,"sql":"SELECT `eid`,`ename`,`uid`,`mobile`,`photo_url` FROM `x360p_employee` WHERE (  `eid` IN (10016)  AND `x360p_employee`.`og_id` = 0 ) AND `x360p_employee`.`delete_time` IS NULL"}
         * incomplete : {"total":3,"list":[{"ht_id":10,"og_id":0,"bid":8,"lid":0,"ca_id":265,"lesson_type":0,"cid":6,"sid":0,"sids":[""],"eid":10016,"htts_id":0,"content":"新接口第一次发布作业测试","remark":"第一次发布作业","deadline":20190626,"push_status":1,"create_time":"2019-06-19 16:30:36","employee":{"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""},"class_name":"演示6-1班"},{"ht_id":25,"og_id":0,"bid":8,"lid":0,"ca_id":265,"lesson_type":0,"cid":6,"sid":0,"sids":[""],"eid":10016,"htts_id":0,"content":"第n次吃啥布置作业","remark":"第那次","deadline":20190626,"push_status":1,"create_time":"2019-06-19 19:06:21","employee":{"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""},"class_name":"演示6-1班"},{"ht_id":43,"og_id":0,"bid":8,"lid":0,"ca_id":265,"lesson_type":0,"cid":6,"sid":0,"sids":[""],"eid":10016,"htts_id":0,"content":"布置作业啦","remark":"布置作业啦","deadline":20190627,"push_status":1,"create_time":"2019-06-20 10:16:18","employee":{"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""},"class_name":"演示6-1班"}],"page":1,"pagesize":20,"sql":"SELECT `eid`,`ename`,`uid`,`mobile`,`photo_url` FROM `x360p_employee` WHERE (  `eid` IN (10016)  AND `x360p_employee`.`og_id` = 0 ) AND `x360p_employee`.`delete_time` IS NULL"}
         */
        private int total;
        private CompleteBean complete;
        private IncompleteBean incomplete;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public CompleteBean getComplete() {
            return complete;
        }

        public void setComplete(CompleteBean complete) {
            this.complete = complete;
        }

        public IncompleteBean getIncomplete() {
            return incomplete;
        }

        public void setIncomplete(IncompleteBean incomplete) {
            this.incomplete = incomplete;
        }

        public static class CompleteBean {
            /**
             * total : 1
             * list : [{"ht_id":10,"og_id":0,"bid":8,"lid":0,"ca_id":265,"lesson_type":0,"cid":6,"sid":0,"sids":[""],"eid":10016,"htts_id":0,"content":"新接口第一次发布作业测试","remark":"第一次发布作业","deadline":20190626,"push_status":1,"create_time":"2019-06-19 16:30:36","employee":{"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""},"class_name":"演示6-1班"}]
             * page : 1
             * pagesize : 20
             * sql : SELECT `eid`,`ename`,`uid`,`mobile`,`photo_url` FROM `x360p_employee` WHERE (  `eid` IN (10016)  AND `x360p_employee`.`og_id` = 0 ) AND `x360p_employee`.`delete_time` IS NULL
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
                 * ht_id : 10
                 * og_id : 0
                 * bid : 8
                 * lid : 0
                 * ca_id : 265
                 * lesson_type : 0
                 * cid : 6
                 * sid : 0
                 * sids : [""]
                 * eid : 10016
                 * htts_id : 0
                 * content : 新接口第一次发布作业测试
                 * remark : 第一次发布作业
                 * deadline : 20190626
                 * push_status : 1
                 * create_time : 2019-06-19 16:30:36
                 * employee : {"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""}
                 * class_name : 演示6-1班
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
                private String class_name;
                private List<String> sids;

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

                public String getClass_name() {
                    return class_name;
                }

                public void setClass_name(String class_name) {
                    this.class_name = class_name;
                }

                public List<String> getSids() {
                    return sids;
                }

                public void setSids(List<String> sids) {
                    this.sids = sids;
                }

                public static class EmployeeBean {
                    /**
                     * eid : 10016
                     * ename : 老师6号-1
                     * uid : 10040
                     * mobile : 17712345678
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

        public static class IncompleteBean {
            /**
             * total : 3
             * list : [{"ht_id":10,"og_id":0,"bid":8,"lid":0,"ca_id":265,"lesson_type":0,"cid":6,"sid":0,"sids":[""],"eid":10016,"htts_id":0,"content":"新接口第一次发布作业测试","remark":"第一次发布作业","deadline":20190626,"push_status":1,"create_time":"2019-06-19 16:30:36","employee":{"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""},"class_name":"演示6-1班"},{"ht_id":25,"og_id":0,"bid":8,"lid":0,"ca_id":265,"lesson_type":0,"cid":6,"sid":0,"sids":[""],"eid":10016,"htts_id":0,"content":"第n次吃啥布置作业","remark":"第那次","deadline":20190626,"push_status":1,"create_time":"2019-06-19 19:06:21","employee":{"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""},"class_name":"演示6-1班"},{"ht_id":43,"og_id":0,"bid":8,"lid":0,"ca_id":265,"lesson_type":0,"cid":6,"sid":0,"sids":[""],"eid":10016,"htts_id":0,"content":"布置作业啦","remark":"布置作业啦","deadline":20190627,"push_status":1,"create_time":"2019-06-20 10:16:18","employee":{"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""},"class_name":"演示6-1班"}]
             * page : 1
             * pagesize : 20
             * sql : SELECT `eid`,`ename`,`uid`,`mobile`,`photo_url` FROM `x360p_employee` WHERE (  `eid` IN (10016)  AND `x360p_employee`.`og_id` = 0 ) AND `x360p_employee`.`delete_time` IS NULL
             */

            private int total;
            private int page;
            private int pagesize;
            private String sql;
            private List<ListBeanX> list;

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

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class ListBeanX {
                /**
                 * ht_id : 10
                 * og_id : 0
                 * bid : 8
                 * lid : 0
                 * ca_id : 265
                 * lesson_type : 0
                 * cid : 6
                 * sid : 0
                 * sids : [""]
                 * eid : 10016
                 * htts_id : 0
                 * content : 新接口第一次发布作业测试
                 * remark : 第一次发布作业
                 * deadline : 20190626
                 * push_status : 1
                 * create_time : 2019-06-19 16:30:36
                 * employee : {"eid":10016,"ename":"老师6号-1","uid":10040,"mobile":"17712345678","photo_url":""}
                 * class_name : 演示6-1班
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
                private EmployeeBeanX employee;
                private String class_name;
                private List<String> sids;

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

                public EmployeeBeanX getEmployee() {
                    return employee;
                }

                public void setEmployee(EmployeeBeanX employee) {
                    this.employee = employee;
                }

                public String getClass_name() {
                    return class_name;
                }

                public void setClass_name(String class_name) {
                    this.class_name = class_name;
                }

                public List<String> getSids() {
                    return sids;
                }

                public void setSids(List<String> sids) {
                    this.sids = sids;
                }

                public static class EmployeeBeanX {
                    /**
                     * eid : 10016
                     * ename : 老师6号-1
                     * uid : 10040
                     * mobile : 17712345678
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
}
