package com.lantel.app.api;

import com.lantel.common.HttpResBean;

import java.util.List;

public class AllBean  extends HttpResBean {

    private AllBean.DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ClassroomsBean> classrooms;
        private DictsBean dicts;
        private List<PublicSchoolsBean> public_schools;
        private List<LessonsBean> lessons;

        public List<LessonsBean> getLessons() {
            return lessons;
        }

        public void setLessons(List<LessonsBean> lessons) {
            this.lessons = lessons;
        }

        public DictsBean getDicts() {
            return dicts;
        }

        public void setDicts(DictsBean dicts) {
            this.dicts = dicts;
        }

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

        public static class DictsBean {
            private List<LeaveReasonBean> leave_reason;

            public List<LeaveReasonBean> getLeave_reason() {
                return leave_reason;
            }

            public void setLeave_reason(List<LeaveReasonBean> leave_reason) {
                this.leave_reason = leave_reason;
            }

            public static class LeaveReasonBean {
                private int did;
                private String title;

                public int getDid() {
                    return did;
                }

                public void setDid(int did) {
                    this.did = did;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }

        public static class LessonsBean{
            private int lid;
            private String lesson_name;

            public int getLid() {
                return lid;
            }

            public void setLid(int lid) {
                this.lid = lid;
            }

            public String getLesson_name() {
                return lesson_name;
            }

            public void setLesson_name(String lesson_name) {
                this.lesson_name = lesson_name;
            }
        }
    }
}
