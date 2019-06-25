package com.lantel.live.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.common.view.EqulizerSeekBar;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class LiveHolder extends BaseViewHolder {
    public ImageView head_img;
    public TextView classes_name;
    public TextView classes_time;
    public TextView live_in_room;
    public TextView classes_percent;
    public EqulizerSeekBar seekBar;

    public LiveHolder(View view) {
        super(view);
        head_img = getView(R.id.head_img);
        classes_name = getView(R.id.classes_name);
        classes_time = getView(R.id.classes_time);
        live_in_room = getView(R.id.live_in_room);
        classes_percent = getView(R.id.classes_percent);
        seekBar = getView(R.id.seekbar);
    }
}
