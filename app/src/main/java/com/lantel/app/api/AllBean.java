package com.lantel.app.api;

import java.util.List;

public class AllBean {
    private int error;
    private String message;
    private AllBean.DataBean data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        List<ClassroomsBean> classrooms;

        public List<ClassroomsBean> getClassrooms() {
            return classrooms;
        }

        public void setClassrooms(List<ClassroomsBean> classrooms) {
            this.classrooms = classrooms;
        }

        public static class ClassroomsBean {
            private int cr_id;
            private String room_name;

            public int getCr_id() {
                return cr_id;
            }

            public void setCr_id(int cr_id) {
                this.cr_id = cr_id;
            }

            public String getRoom_name() {
                return room_name;
            }

            public void setRoom_name(String room_name) {
                this.room_name = room_name;
            }
        }
    }
}
