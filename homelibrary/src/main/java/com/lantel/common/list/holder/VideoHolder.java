package com.lantel.common.list.holder;

import android.view.View;

import com.devbrackets.android.exomedia.ui.widget.VideoView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;


public class VideoHolder extends BaseViewHolder {
    public VideoView jz_video;
    public VideoHolder(View view) {
        super(view);
        jz_video = getView(R.id.jz_video);
    }
}
