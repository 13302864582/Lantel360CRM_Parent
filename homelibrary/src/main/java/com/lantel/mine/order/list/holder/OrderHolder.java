package com.lantel.mine.order.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class OrderHolder extends BaseViewHolder {
    public TextView order_date_time;
    public TextView order_state;
    public ImageView order_img;
    public TextView order_title;
    public TextView order_course_count;
    public TextView money_record;

    public OrderHolder(View view) {
        super(view);
        order_date_time = getView(R.id.order_date_time);
        money_record = getView(R.id.money_record);
        order_state = getView(R.id.order_state);
        order_course_count = getView(R.id.order_course_count);
        order_title = getView(R.id.order_title);
        order_img = getView(R.id.order_img);
    }
}
