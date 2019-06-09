package com.lantel.homelibrary.output.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class RemarkHolder extends BaseViewHolder {
    public TextView name;
    public ImageView img;
    public TextView time;
    public TextView content;

    public RemarkHolder(View view) {
        super(view);
        name = getView(R.id.name);
        img = getView(R.id.img);
        time = getView(R.id.time);
        content = getView(R.id.content);
    }
}
