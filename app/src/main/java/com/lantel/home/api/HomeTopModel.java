package com.lantel.home.api;

import com.xiao360.baselibrary.base.BaseModel;

public class HomeTopModel extends BaseModel {
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
