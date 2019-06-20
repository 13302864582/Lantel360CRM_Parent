package com.lantel.homelibrary.homework.list.holder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class MediaFileHolder extends BaseViewHolder {
    public ImageView img;
    public ImageView play;
    public TextView duration;
    public ImageButton delete;

    public MediaFileHolder(View view) {
        super(view);
        img = getView(R.id.img);
        play = getView(R.id.play);
        duration = getView(R.id.duration);
        delete = getView(R.id.delete);
    }
}
