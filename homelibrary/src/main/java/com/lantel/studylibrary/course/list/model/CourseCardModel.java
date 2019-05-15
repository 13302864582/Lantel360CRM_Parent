package com.lantel.studylibrary.course.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class CourseCardModel extends BaseModel{
    private String course_name;
    private String course_start_date;
    private String course_end_date;
    private int percent;
    private int total;

    public CourseCardModel(String name, String start_date, String end_date, int usecount, int totalcount) {
        this.course_name = name;
        this.course_start_date = start_date;
        this.course_end_date = end_date;
        this.percent = percent;
        this.percent = usecount;
        this.total = totalcount;
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
