package com.lantel.homelibrary.message.list.holder;

import android.view.View;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class MessageHolder extends BaseViewHolder {
    public TextView title;
    public TextView time;
    public TextView content;

    public MessageHolder(View view) {
        super(view);
        title = getView(R.id.title);
        time = getView(R.id.time);
        content = getView(R.id.content);
    }
}
