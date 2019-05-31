package com.lantel.mine.order.list.holder;

import android.view.View;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class DetailTopHolder extends BaseViewHolder {
    public TextView order_id;
    public TextView join_time;
    public TextView order_time;

    public DetailTopHolder(View view) {
        super(view);
        order_id = getView(R.id.order_id);
        join_time = getView(R.id.join_time);
        order_time = getView(R.id.order_time);
    }
}
