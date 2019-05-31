package com.lantel.mine.order.api;

import java.util.List;

public class OrderDetailBean {
    private String create_time;
    private String order_amount;
    private String order_no;
    private String paid_amount;
    private String paid_time;
    private int pay_status;
    private List<OrderItemsBean> order_items;



    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(String order_amount) {
        this.order_amount = order_amount;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(String paid_amount) {
        this.paid_amount = paid_amount;
    }

    public String getPaid_time() {
        return paid_time;
    }

    public void setPaid_time(String paid_time) {
        this.paid_time = paid_time;
    }

    public int getPay_status() {
        return pay_status;
    }

    public void setPay_status(int pay_status) {
        this.pay_status = pay_status;
    }

    public List<OrderItemsBean> getOrder_items() {
        return order_items;
    }

    public void setOrder_items(List<OrderItemsBean> order_items) {
        this.order_items = order_items;
    }

    public static class OrderItemsBean {
        /**
         * discount_amount : 0.00
         * item_name : 高级英语
         * lesson : {"lesson_cover_picture":"http://s10.xiao360.com/qms/1/0/nsp5FxjwQ6TeYonhuOlOg6TjFdO8XUeX.jpg"}
         * nums : 1.00
         * origin_price : 0.010000
         * present_lesson_hours : 0.00
         * price : 0.010000
         * reduced_amount : 0.00
         * subtotal : 0.01
         */

        private String discount_amount;
        private String item_name;
        private LessonBean lesson;
        private String nums;
        private String origin_price;
        private String present_lesson_hours;
        private String price;
        private String reduced_amount;
        private String subtotal;
        private String expire_time;

        public String getExpire_time() {
            return expire_time;
        }

        public void setExpire_time(String expire_time) {
            this.expire_time = expire_time;
        }


        public String getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(String discount_amount) {
            this.discount_amount = discount_amount;
        }

        public String getItem_name() {
            return item_name;
        }

        public void setItem_name(String item_name) {
            this.item_name = item_name;
        }

        public LessonBean getLesson() {
            return lesson;
        }

        public void setLesson(LessonBean lesson) {
            this.lesson = lesson;
        }

        public String getNums() {
            return nums;
        }

        public void setNums(String nums) {
            this.nums = nums;
        }

        public String getOrigin_price() {
            return origin_price;
        }

        public void setOrigin_price(String origin_price) {
            this.origin_price = origin_price;
        }

        public String getPresent_lesson_hours() {
            return present_lesson_hours;
        }

        public void setPresent_lesson_hours(String present_lesson_hours) {
            this.present_lesson_hours = present_lesson_hours;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getReduced_amount() {
            return reduced_amount;
        }

        public void setReduced_amount(String reduced_amount) {
            this.reduced_amount = reduced_amount;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public static class LessonBean {
            /**
             * lesson_cover_picture : http://s10.xiao360.com/qms/1/0/nsp5FxjwQ6TeYonhuOlOg6TjFdO8XUeX.jpg
             */

            private String lesson_cover_picture;

            public String getLesson_cover_picture() {
                return lesson_cover_picture;
            }

            public void setLesson_cover_picture(String lesson_cover_picture) {
                this.lesson_cover_picture = lesson_cover_picture;
            }
        }
    }
}
