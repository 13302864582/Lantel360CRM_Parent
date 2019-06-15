package com.lantel.setting.personal.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class SettingPersonItemModel extends BaseModel{
    private String value;
    private String[] strs;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String[] getStrs() {
        return strs;
    }

    public void setStrs(String[] strs) {
        this.strs = strs;
    }
}
