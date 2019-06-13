package com.lantel.homelibrary.homework.list.model;

import com.lantel.studylibrary.preview.preview.list.model.AttachFile;
import com.xiao360.baselibrary.base.BaseModel;

import java.util.List;

public class HomeWorkItemModel extends BaseModel {
    private String teacher;
    private String classes;
    private boolean isFinish;
    private String imgUrl;
    private String startTime;
    private String endTime;
    private List<AttachFile> attachFiles;

    public List<AttachFile> getAttachFiles() {
        return attachFiles;
    }

    public void setAttachFiles(List<AttachFile> attachFiles) {
        this.attachFiles = attachFiles;
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

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
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
