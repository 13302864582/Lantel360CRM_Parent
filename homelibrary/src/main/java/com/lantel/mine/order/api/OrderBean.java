package com.lantel.mine.order.api;

import java.util.List;

public class OrderBean {
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
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            //订单编号
            private String order_no;
            //报名日期
            private String paid_time;
            //下单时间
            private String create_time;
            //订单金额
            private String order_amount;
            //实付款
            private String paid_amount;

            //付款状态(0:未付款,1:部分付款,2:全部付款)
            private int pay_status;

            private List<OrderItemsBean> order_items;

            public String getOrder_no() {
                return order_no;
            }

            public void setOrder_no(String order_no) {
                this.order_no = order_no;
            }

            public String getOrder_amount() {
                return order_amount;
            }

            public void setOrder_amount(String order_amount) {
                this.order_amount = order_amount;
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

            public String getPaid_amount() {
                return paid_amount;
            }

            public void setPaid_amount(String paid_amount) {
                this.paid_amount = paid_amount;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public List<OrderItemsBean> getOrder_items() {
                return order_items;
            }

            public void setOrder_items(List<OrderItemsBean> order_items) {
                this.order_items = order_items;
            }

            public static class OrderItemsBean {
                private String item_name;

                private String origin_price;
                private String price;

                //小计金额
                private String subtotal;

                private String nums;
                private String discount_amount;
                private String reduced_amount;

                private String present_lesson_times;
                private String present_lesson_hours;

                private LessonBean lesson;

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

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getSubtotal() {
                    return subtotal;
                }

                public void setSubtotal(String subtotal) {
                    this.subtotal = subtotal;
                }

                public String getDiscount_amount() {
                    return discount_amount;
                }

                public void setDiscount_amount(String discount_amount) {
                    this.discount_amount = discount_amount;
                }

                public String getReduced_amount() {
                    return reduced_amount;
                }

                public void setReduced_amount(String reduced_amount) {
                    this.reduced_amount = reduced_amount;
                }

                public String getPresent_lesson_times() {
                    return present_lesson_times;
                }

                public void setPresent_lesson_times(String present_lesson_times) {
                    this.present_lesson_times = present_lesson_times;
                }

                public String getPresent_lesson_hours() {
                    return present_lesson_hours;
                }

                public void setPresent_lesson_hours(String present_lesson_hours) {
                    this.present_lesson_hours = present_lesson_hours;
                }

                public String getItem_name() {
                    return item_name;
                }

                public void setItem_name(String item_name) {
                    this.item_name = item_name;
                }

                public static class LessonBean {
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
    }
}
