package com.lantel.studylibrary.preview.preview.list.model;

import java.util.List;

public class PreviewDetailModel {
    private String CourseName;
    private String date;
    private String time;
    private String classes;
    private String teacher;
    private String short_desc;
    private String course_content;
    private List<AttachFile> attachFiles;

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getCourse_content() {
        return course_content;
    }

    public void setCourse_content(String course_content) {
        this.course_content = course_content;
    }

    public List<AttachFile> getAttachFiles() {
        return attachFiles;
    }

    public void setAttachFiles(List<AttachFile> attachFiles) {
        this.attachFiles = attachFiles;
    }
}
