package com.lantel.home.api;

public class HomeMessageBean {

    /**
     * error : 0
     * message : success
     * data : {"today_news_num":0,"today_schedules_num":0,"today_attendances_num":0,"today_reviews_num":0,"today_msg_num":0}
     * authed : true
     */

    private int error;
    private String message;
    private DataBean data;

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
        /**
         * today_news_num : 0
         * today_schedules_num : 0
         * today_attendances_num : 0
         * today_reviews_num : 0
         * today_msg_num : 0
         */

        private int today_news_num;
        private int today_schedules_num;
        private int today_attendances_num;
        private int today_reviews_num;
        private int today_msg_num;

        public int getToday_news_num() {
            return today_news_num;
        }

        public void setToday_news_num(int today_news_num) {
            this.today_news_num = today_news_num;
        }

        public int getToday_schedules_num() {
            return today_schedules_num;
        }

        public void setToday_schedules_num(int today_schedules_num) {
            this.today_schedules_num = today_schedules_num;
        }

        public int getToday_attendances_num() {
            return today_attendances_num;
        }

        public void setToday_attendances_num(int today_attendances_num) {
            this.today_attendances_num = today_attendances_num;
        }

        public int getToday_reviews_num() {
            return today_reviews_num;
        }

        public void setToday_reviews_num(int today_reviews_num) {
            this.today_reviews_num = today_reviews_num;
        }

        public int getToday_msg_num() {
            return today_msg_num;
        }

        public void setToday_msg_num(int today_msg_num) {
            this.today_msg_num = today_msg_num;
        }
    }
}
