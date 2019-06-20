package com.lantel.homelibrary.classreview.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class ClassReviewCardModel extends BaseModel {
    private String teacherName;
    private String className;
    private String date;
    private String content;
    private Object headImg;
    private int rvw_id;

    public int getRvw_id() {
        return rvw_id;
    }

    public void setRvw_id(int rvw_id) {
        this.rvw_id = rvw_id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getHeadImg() {
        return headImg;
    }

    public void setHeadImg(Object headImg) {
        this.headImg = headImg;
    }
}
