package com.lantel.studylibrary.course.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class CourseCardModel extends BaseModel{
    private String course_name;
    private String course_start_date;
    private String course_end_date;
    private float percent;
    private float total;

    public CourseCardModel() {
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_start_date() {
        return course_start_date;
    }

    public void setCourse_start_date(String course_start_date) {
        this.course_start_date = course_start_date;
    }

    public String getCourse_end_date() {
        return course_end_date;
    }

    public void setCourse_end_date(String course_end_date) {
        this.course_end_date = course_end_date;
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
