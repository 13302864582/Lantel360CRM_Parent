package com.lantel.studylibrary.preview.preview;

import com.xiao360.baselibrary.base.BaseModel;

import java.util.List;

public class LeaveDialogBean {
    private String teacher;
    private String time;
    private List<BaseModel> leaveType ;

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<BaseModel> getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(List<BaseModel> leaveType) {
        this.leaveType = leaveType;
    }
}
