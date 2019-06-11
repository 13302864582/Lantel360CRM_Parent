package com.lantel.studylibrary.preview.preview.api;

import java.util.List;

public class PreviewBean {
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
            private Object one_class;
            private List<String> sids;

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

            public Object getOne_class() {
                return one_class;
            }

            public void setOne_class(Object one_class) {
                this.one_class = one_class;
            }

            public List<String> getSids() {
                return sids;
            }

            public void setSids(List<String> sids) {
                this.sids = sids;
            }
        }
    }
}
