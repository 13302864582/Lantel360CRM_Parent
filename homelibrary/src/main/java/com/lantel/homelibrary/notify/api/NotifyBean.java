package com.lantel.homelibrary.notify.api;

import java.util.List;

public class NotifyBean {

    /**
     * error : 0
     * message : success
     * data : {"total":6,"list":[{"bc_id":7,"og_id":0,"type":2,"is_global":1,"dpt_ids":[],"lids":"4,3,2,1","cids":"","sids":"","title":"2222","desc":"<p><span style=\"color:#92d050\">放假德生科技<\/span><\/p>","create_time":"2019-05-22 18:42:01","create_uid":1},{"bc_id":6,"og_id":0,"type":2,"is_global":1,"dpt_ids":[],"lids":"4,3,2,1","cids":"","sids":"","title":"333333","desc":"<p>33333333<img class=\"img-responsive\" src=\"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521579192923.png\" _src=\"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521579192923.png\"/>33333333784积分给大家首付款厚大司考返回看多少坑和客户客户发打瞌睡<img class=\"img-responsive\" src=\"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521603875538.png\" _src=\"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521603875538.png\"/>副科级点击分类就废了看到结束六块腹肌打开链接开发来得及杀戮空间反倒是<\/p>","create_time":"2019-05-22 18:40:24","create_uid":1},{"bc_id":5,"og_id":0,"type":2,"is_global":1,"dpt_ids":[],"lids":"4,3,2,1","cids":"","sids":"","title":"33333","desc":"<p>33333<\/p>","create_time":"2019-05-22 18:16:57","create_uid":1},{"bc_id":4,"og_id":0,"type":2,"is_global":1,"dpt_ids":[],"lids":"4,3,2,1","cids":"","sids":"","title":"带图片的","desc":"<p>特殊事所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所<span style=\"white-space: normal;\">特殊事所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所<\/span><img class=\"img-responsive\" src=\"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558519933150199.png\" _src=\"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558519933150199.png\"/><\/p>","create_time":"2019-05-22 18:16:04","create_uid":1},{"bc_id":3,"og_id":0,"type":2,"is_global":1,"dpt_ids":[],"lids":"4,3,2,1","cids":"","sids":"","title":"test","desc":"<p><span style=\"color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 13px; white-space: normal; background-color: rgb(245, 245, 245);\">秋意越来越重了，明天就是处暑，也出了末伏，表示夏天已经完全的结束了，无论节气还是天气。归来也一周多了，归来后，总是浑身懒散的感觉，什么也不想干，只想能懒散散的躺在一个地方，静静的发呆。<\/span><\/p>","create_time":"2019-05-22 17:32:30","create_uid":1},{"bc_id":2,"og_id":0,"type":2,"is_global":1,"dpt_ids":[1,3,4],"lids":"4,3,2,1","cids":"","sids":"","title":"回教室上课！！！","desc":"<p>附近的垃圾分类吉林省了开发就算啦就废了看到结束<\/p>","create_time":"2019-05-22 17:30:54","create_uid":1}],"page":1,"pagesize":10,"sql":"SELECT * FROM `x360p_broadcast` WHERE (  `type` = 2  AND (  (  find_in_set(21, sids) ) OR (  find_in_set(4,cids) )  OR (  find_in_set(4,lids) )  OR (  find_in_set(1,lids) )  OR (  find_in_set(2,lids) ) )  AND `x360p_broadcast`.`og_id` = 0 ) AND `x360p_broadcast`.`delete_time` IS NULL ORDER BY `x360p_broadcast`.`create_time`  desc LIMIT 0,10"}
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
         * total : 6
         * list : [{"bc_id":7,"og_id":0,"type":2,"is_global":1,"dpt_ids":[],"lids":"4,3,2,1","cids":"","sids":"","title":"2222","desc":"<p><span style=\"color:#92d050\">放假德生科技<\/span><\/p>","create_time":"2019-05-22 18:42:01","create_uid":1},{"bc_id":6,"og_id":0,"type":2,"is_global":1,"dpt_ids":[],"lids":"4,3,2,1","cids":"","sids":"","title":"333333","desc":"<p>33333333<img class=\"img-responsive\" src=\"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521579192923.png\" _src=\"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521579192923.png\"/>33333333784积分给大家首付款厚大司考返回看多少坑和客户客户发打瞌睡<img class=\"img-responsive\" src=\"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521603875538.png\" _src=\"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558521603875538.png\"/>副科级点击分类就废了看到结束六块腹肌打开链接开发来得及杀戮空间反倒是<\/p>","create_time":"2019-05-22 18:40:24","create_uid":1},{"bc_id":5,"og_id":0,"type":2,"is_global":1,"dpt_ids":[],"lids":"4,3,2,1","cids":"","sids":"","title":"33333","desc":"<p>33333<\/p>","create_time":"2019-05-22 18:16:57","create_uid":1},{"bc_id":4,"og_id":0,"type":2,"is_global":1,"dpt_ids":[],"lids":"4,3,2,1","cids":"","sids":"","title":"带图片的","desc":"<p>特殊事所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所<span style=\"white-space: normal;\">特殊事所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所所<\/span><img class=\"img-responsive\" src=\"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558519933150199.png\" _src=\"http://s10.xiao360.com/qms/data/uploads/file/20190522/1558519933150199.png\"/><\/p>","create_time":"2019-05-22 18:16:04","create_uid":1},{"bc_id":3,"og_id":0,"type":2,"is_global":1,"dpt_ids":[],"lids":"4,3,2,1","cids":"","sids":"","title":"test","desc":"<p><span style=\"color: rgb(51, 51, 51); font-family: -apple-system, &quot;SF UI Text&quot;, Arial, &quot;PingFang SC&quot;, &quot;Hiragino Sans GB&quot;, &quot;Microsoft YaHei&quot;, &quot;WenQuanYi Micro Hei&quot;, sans-serif; font-size: 13px; white-space: normal; background-color: rgb(245, 245, 245);\">秋意越来越重了，明天就是处暑，也出了末伏，表示夏天已经完全的结束了，无论节气还是天气。归来也一周多了，归来后，总是浑身懒散的感觉，什么也不想干，只想能懒散散的躺在一个地方，静静的发呆。<\/span><\/p>","create_time":"2019-05-22 17:32:30","create_uid":1},{"bc_id":2,"og_id":0,"type":2,"is_global":1,"dpt_ids":[1,3,4],"lids":"4,3,2,1","cids":"","sids":"","title":"回教室上课！！！","desc":"<p>附近的垃圾分类吉林省了开发就算啦就废了看到结束<\/p>","create_time":"2019-05-22 17:30:54","create_uid":1}]
         * page : 1
         * pagesize : 10
         * sql : SELECT * FROM `x360p_broadcast` WHERE (  `type` = 2  AND (  (  find_in_set(21, sids) ) OR (  find_in_set(4,cids) )  OR (  find_in_set(4,lids) )  OR (  find_in_set(1,lids) )  OR (  find_in_set(2,lids) ) )  AND `x360p_broadcast`.`og_id` = 0 ) AND `x360p_broadcast`.`delete_time` IS NULL ORDER BY `x360p_broadcast`.`create_time`  desc LIMIT 0,10
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
             * bc_id : 7
             * og_id : 0
             * type : 2
             * is_global : 1
             * dpt_ids : []
             * lids : 4,3,2,1
             * cids :
             * sids :
             * title : 2222
             * desc : <p><span style="color:#92d050">放假德生科技</span></p>
             * create_time : 2019-05-22 18:42:01
             * create_uid : 1
             */

            private String title;
            private String desc;
            private String create_time;
            private BroadcastPushBean broadcast_push;

            public BroadcastPushBean getBroadcast_push() {
                return broadcast_push;
            }

            public void setBroadcast_push(BroadcastPushBean broadcast_push) {
                this.broadcast_push = broadcast_push;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public static class BroadcastPushBean {
                private int bcp_id;
                private int og_id;
                private int bc_id;
                private int eid;
                private int sid;
                private String read_time;
                private String create_time;
                private int create_uid;

                public int getBcp_id() {
                    return bcp_id;
                }

                public void setBcp_id(int bcp_id) {
                    this.bcp_id = bcp_id;
                }

                public int getOg_id() {
                    return og_id;
                }

                public void setOg_id(int og_id) {
                    this.og_id = og_id;
                }

                public int getBc_id() {
                    return bc_id;
                }

                public void setBc_id(int bc_id) {
                    this.bc_id = bc_id;
                }

                public int getEid() {
                    return eid;
                }

                public void setEid(int eid) {
                    this.eid = eid;
                }

                public int getSid() {
                    return sid;
                }

                public void setSid(int sid) {
                    this.sid = sid;
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
}
