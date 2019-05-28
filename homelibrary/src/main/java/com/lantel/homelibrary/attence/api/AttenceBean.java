package com.lantel.homelibrary.attence.api;

public class AttenceBean {
    private int int_day;
    private int int_start_hour;

    private int is_in;
    private int is_leave;

    private CourseArrangeBean course_arrange;

    public int getInt_day() {
        return int_day;
    }

    public void setInt_day(int int_day) {
        this.int_day = int_day;
    }

    public int getInt_start_hour() {
        return int_start_hour;
    }

    public void setInt_start_hour(int int_start_hour) {
        this.int_start_hour = int_start_hour;
    }

    public int getIs_in() {
        return is_in;
    }

    public void setIs_in(int is_in) {
        this.is_in = is_in;
    }

    public int getIs_leave() {
        return is_leave;
    }

    public void setIs_leave(int is_leave) {
        this.is_leave = is_leave;
    }


    public CourseArrangeBean getCourse_arrange() {
        return course_arrange;
    }

    public void setCourse_arrange(CourseArrangeBean course_arrange) {
        this.course_arrange = course_arrange;
    }

    public static class CourseArrangeBean {
        private String course_name;

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }
    }
}
