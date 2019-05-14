package com.lantel.studylibrary.classes.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class ClassesCardModel extends BaseModel implements Comparable<ClassesCardModel>{
    private String date;
    private String time;
    private String className;
    private int state;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public long getTimeLong() {
        if(time.indexOf(0)==0){
            time.replaceAll("^(0+)", "").trim();
        }
        return Long.valueOf(time);
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public int compareTo(ClassesCardModel attenceModel) {
        long i = Long.valueOf(this.getDate()) - Long.valueOf(attenceModel.getDate());
        if(i == 0){
            i = getTimeLong() - attenceModel.getTimeLong();
        }
        if(i == 0)
            return 0;
        if(i>0)
            return 1;
        else
            return -1;
    }
}
