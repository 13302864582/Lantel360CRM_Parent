package com.lantel.setting.bindfile.bindstudent.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class BindStudentListModel extends BaseModel{
    private String name;
    private String age;
    private String class_room;
    private String class_area;
    private boolean isBind;
    private boolean sex;
    private Object heaImg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClass_room() {
        return class_room;
    }

    public void setClass_room(String class_room) {
        this.class_room = class_room;
    }

    public String getClass_area() {
        return class_area;
    }

    public void setClass_area(String class_area) {
        this.class_area = class_area;
    }

    public boolean isBind() {
        return isBind;
    }

    public void setBind(boolean bind) {
        isBind = bind;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public Object getHeaImg() {
        return heaImg;
    }

    public void setHeaImg(Object heaImg) {
        this.heaImg = heaImg;
    }
}
