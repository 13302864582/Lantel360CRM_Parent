package com.lantel.studylibrary.preview.preview.list.holder;

import android.view.View;
import android.widget.CheckBox;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class LeaveHolder extends BaseViewHolder {
    public CheckBox checkBox;

    public LeaveHolder(View view) {
        super(view);
        checkBox = getView(R.id.checkBox);
    }
}
