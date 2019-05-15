package com.lantel.studylibrary.classes.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class ClassesCardModel extends BaseModel{
    private String teacher;
    private String place;
    private String className;
    private int percent;
    private int total;
    private Object heaImg;

    public ClassesCardModel(Object heaImg,String teacher, String place, String className,int percent, int total) {
        this.teacher = teacher;
        this.place = place;
        this.className = className;
        this.percent = percent;
        this.total = total;
        this.heaImg = heaImg;
    }


    public Object getHeaImg() {
        return heaImg;
    }

    public void setHeaImg(Object heaImg) {
        this.heaImg = heaImg;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
