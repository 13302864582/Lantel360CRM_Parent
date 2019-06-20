package com.lantel.homelibrary.communicate.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

import androidx.constraintlayout.widget.ConstraintLayout;

public class CommunicateHolder extends BaseViewHolder {
    public ImageView head_img;
    public TextView name;
    public TextView time;
    public TextView content;

    public CommunicateHolder(View view) {
        super(view);
        head_img = getView(R.id.head_img);
        name = getView(R.id.name);
        time = getView(R.id.time);
        content = getView(R.id.content);
    }
}
