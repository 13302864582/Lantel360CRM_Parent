package com.lantel.homelibrary.course.calendar;

import com.lantel.common.HttpResBean;

import java.util.List;

public class CalenderSchemBean  extends HttpResBean {
    private DataBean data;
    private boolean authed;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<Integer> list;

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }
    }
}
