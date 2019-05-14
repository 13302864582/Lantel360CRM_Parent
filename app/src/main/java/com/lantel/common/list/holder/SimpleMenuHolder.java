package com.lantel.common.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.crmparent.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class SimpleMenuHolder extends BaseViewHolder {
    public ImageView icon;
    public TextView title;

    public SimpleMenuHolder(View view) {
        super(view);
        icon = getView(R.id.icon);
        title = getView(R.id.title);
    }
}
