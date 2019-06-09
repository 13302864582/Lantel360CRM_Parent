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
        List<PublicSchoolsBean> public_schools;

        public List<PublicSchoolsBean> getPublic_schools() {
            return public_schools;
        }

        public void setPublic_schools(List<PublicSchoolsBean> public_schools) {
            this.public_schools = public_schools;
        }

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

        public static class PublicSchoolsBean{
            private int bid;
            private String school_name;

            public int getBid() {
                return bid;
            }

            public void setBid(int bid) {
                this.bid = bid;
            }

            public String getSchool_name() {
                return school_name;
            }

            public void setSchool_name(String school_name) {
                this.school_name = school_name;
            }
        }
    }
}
