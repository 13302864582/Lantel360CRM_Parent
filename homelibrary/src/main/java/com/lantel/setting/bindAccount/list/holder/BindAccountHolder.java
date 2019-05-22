package com.lantel.setting.bindAccount.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class BindAccountHolder extends BaseViewHolder {
    public ImageView icon;
    public TextView title;
    public TextView value;
    public TextView state_btn;
    public BindAccountHolder(View view) {
        super(view);
        icon = getView(R.id.icon);
        title = getView(R.id.title);
        value = getView(R.id.value);
        state_btn = getView(R.id.state_btn);
    }
}
