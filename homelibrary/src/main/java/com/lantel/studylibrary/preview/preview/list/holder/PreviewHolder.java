package com.lantel.studylibrary.preview.preview.list.holder;

import android.view.View;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class PreviewHolder extends BaseViewHolder {
    public TextView course_name;
    public TextView time;
    public TextView location;
    public TextView detail;

    public TextView date;

    public PreviewHolder(View view) {
        super(view);
        course_name = getView(R.id.course_name);
        time = getView(R.id.time);
        location = getView(R.id.location);
        detail = getView(R.id.detail);
       // content = getView(R.id.content);
        date = getView(R.id.date);
    }
}
