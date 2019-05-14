package com.lantel.mine.list.model;

import com.xiao360.baselibrary.base.BaseModel;

public class CardModel extends BaseModel {
    private String value;

    public CardModel(String title, String value) {
        super(-1, title);
        this.value = value;
    }

    public CardModel(String value) {
        super(-1,"");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
