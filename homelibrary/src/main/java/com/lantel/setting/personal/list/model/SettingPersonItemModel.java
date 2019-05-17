package com.lantel.setting.personal.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class SettingPersonItemModel extends BaseModel{
    private String value;
    private String[] strs;

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
