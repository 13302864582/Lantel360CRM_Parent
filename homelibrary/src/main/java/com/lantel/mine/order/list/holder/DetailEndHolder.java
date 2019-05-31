package com.lantel.mine.order.list.holder;

import android.view.View;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class DetailEndHolder extends BaseViewHolder {
    public TextView order_end_money;

    public DetailEndHolder(View view) {
        super(view);
        order_end_money = getView(R.id.order_end_money);
    }
}
