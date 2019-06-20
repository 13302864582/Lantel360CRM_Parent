package com.lantel.homelibrary.homework.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class HomeWorkItemModel extends BaseModel {
    private String teacher;
    private String classes;
    private boolean isFinish;
    private String imgUrl;
    private String startTime;
    private String endTime;
    private int ht_id;

    public int getHt_id() {
        return ht_id;
    }

    public void setHt_id(int ht_id) {
        this.ht_id = ht_id;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
