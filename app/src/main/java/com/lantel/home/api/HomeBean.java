package com.lantel.home.api;

public class HomeBean {

    /**
     * error : 0
     * message : success
     * data : {"org_name":"","branch_name":"财富中心道场","branch_address":"虹桥路1438号古北国际财富中心二期19楼（高岛屋百货大楼旁边的办公楼）","branch_tel":"13681810678","recommend_cover":"http://sp1.xiao360.com/static/img/recommend-cover.png"}
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
         * org_name :
         * branch_name : 财富中心道场
         * branch_address : 虹桥路1438号古北国际财富中心二期19楼（高岛屋百货大楼旁边的办公楼）
         * branch_tel : 13681810678
         * recommend_cover : http://sp1.xiao360.com/static/img/recommend-cover.png
         */

        private String org_name;
        private String branch_name;
        private String branch_address;
        private String branch_tel;
        private String recommend_cover;

        public String getOrg_name() {
            return org_name;
        }

        public void setOrg_name(String org_name) {
            this.org_name = org_name;
        }

        public String getBranch_name() {
            return branch_name;
        }

        public void setBranch_name(String branch_name) {
            this.branch_name = branch_name;
        }

        public String getBranch_address() {
            return branch_address;
        }

        public void setBranch_address(String branch_address) {
            this.branch_address = branch_address;
        }

        public String getBranch_tel() {
            return branch_tel;
        }

        public void setBranch_tel(String branch_tel) {
            this.branch_tel = branch_tel;
        }

        public String getRecommend_cover() {
            return recommend_cover;
        }

        public void setRecommend_cover(String recommend_cover) {
            this.recommend_cover = recommend_cover;
        }
    }
}
