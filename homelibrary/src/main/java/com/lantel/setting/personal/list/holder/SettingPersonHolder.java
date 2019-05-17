package com.lantel.setting.personal.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class SettingPersonHolder extends BaseViewHolder {
    public TextView title;
    public TextView value;

    public SettingPersonHolder(View view) {
        super(view);
        title = getView(R.id.title);
        value = getView(R.id.value);
    }
}
