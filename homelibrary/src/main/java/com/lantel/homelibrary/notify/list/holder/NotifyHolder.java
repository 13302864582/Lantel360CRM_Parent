package com.lantel.homelibrary.notify.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class NotifyHolder extends BaseViewHolder {
    public TextView title;
    public TextView time;
    public TextView content;

    public NotifyHolder(View view) {
        super(view);
        title = getView(R.id.title);
        time = getView(R.id.time);
        content = getView(R.id.content);
    }
}
