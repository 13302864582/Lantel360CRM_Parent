package com.lantel.homelibrary.course.list.model;

import com.lantel.homelibrary.course.api.CourseBean;

import java.util.List;

public class CourseAllBean {
    List<Integer> SchmeDays;

    List<CourseBean.DataBean.ListBean> listBeans;

    int SchmeError;
    String SchmeMess;

    int CourseError;
    String CourseMess;

    public int getSchmeError() {
        return SchmeError;
    }

    public void setSchmeError(int schmeError) {
        SchmeError = schmeError;
    }

    public String getSchmeMess() {
        return SchmeMess;
    }

    public void setSchmeMess(String schmeMess) {
        SchmeMess = schmeMess;
    }

    public int getCourseError() {
        return CourseError;
    }

    public void setCourseError(int courseError) {
        CourseError = courseError;
    }

    public String getCourseMess() {
        return CourseMess;
    }

    public void setCourseMess(String courseMess) {
        CourseMess = courseMess;
    }

    public List<Integer> getSchmeDays() {
        return SchmeDays;
    }

    public void setSchmeDays(List<Integer> schmeDays) {
        SchmeDays = schmeDays;
    }

    public List<CourseBean.DataBean.ListBean> getListBeans() {
        return listBeans;
    }

    public void setListBeans(List<CourseBean.DataBean.ListBean> listBeans) {
        this.listBeans = listBeans;
    }
}
