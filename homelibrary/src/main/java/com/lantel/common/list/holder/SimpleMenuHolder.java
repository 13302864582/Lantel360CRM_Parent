package com.lantel.common.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class SimpleMenuHolder extends BaseViewHolder {
    public ImageView icon;
    public TextView title;
    public TextView text_right;
    public ImageView arrow;

    public SimpleMenuHolder(View view) {
        super(view);
        icon = getView(R.id.icon);
        title = getView(R.id.title);
        text_right = getView(R.id.text_right);
        arrow = getView(R.id.arrow);
    }
}
