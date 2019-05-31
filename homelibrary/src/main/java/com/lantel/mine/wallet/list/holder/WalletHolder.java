package com.lantel.mine.wallet.list.holder;

import android.view.View;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

import androidx.constraintlayout.widget.ConstraintLayout;

public class WalletHolder extends BaseViewHolder {
    public TextView title;
    public TextView money_record;
    public TextView detail;
    public TextView date_time;
    public TextView date_title;

    public WalletHolder(View view) {
        super(view);
        title = getView(R.id.title);
        money_record = getView(R.id.money_record);
        detail = getView(R.id.detail);
        date_time = getView(R.id.date_time);
        date_title = getView(R.id.date_title);
    }
}
