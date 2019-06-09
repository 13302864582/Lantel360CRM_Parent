package com.lantel.homelibrary.output.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class AttachTitleHolder extends BaseViewHolder {
    public TextView title;
    public ImageView icon;

    public AttachTitleHolder(View view) {
        super(view);
        title = getView(R.id.title);
        icon = getView(R.id.icon);
    }
}
