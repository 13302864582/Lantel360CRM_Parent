package com.lantel.mine.order.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class DetailListHolder extends BaseViewHolder {
    public ImageView list_img;
    public TextView list_title;
    public TextView course_time;
    public TextView useful_date;
    public TextView paid_money;
    public TextView origin_price;
    public TextView price;
    public TextView discount_amount;
    public TextView reduced_amount;
    public TextView present_times;

    public DetailListHolder(View view) {
        super(view);
        list_img = getView(R.id.list_img);
        list_title = getView(R.id.list_title);
        course_time = getView(R.id.course_time);
        useful_date = getView(R.id.useful_date);
        paid_money = getView(R.id.paid_money);
        origin_price = getView(R.id.origin_price_value);
        price = getView(R.id.price_value);
        discount_amount = getView(R.id.discount_amount_value);
        reduced_amount = getView(R.id.reduced_amount_value);
        present_times = getView(R.id.present_times_value);
    }
}
