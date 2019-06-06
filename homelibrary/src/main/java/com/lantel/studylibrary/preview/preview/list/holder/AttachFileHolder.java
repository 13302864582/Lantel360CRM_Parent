package com.lantel.studylibrary.preview.preview.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class AttachFileHolder extends BaseViewHolder {
    public ImageView icon;
    public ImageView file_img;
    public ImageView thumb;
    public TextView fileSize;
    public TextView fileName;
    public LinearLayout download_lay;

    public AttachFileHolder(View view) {
        super(view);
        icon = getView(R.id.icon);
        thumb = getView(R.id.thumb);
        file_img = getView(R.id.file_img);
        fileName = getView(R.id.file_name);
        fileSize = getView(R.id.file_size);
        download_lay = getView(R.id.download_lay);
    }
}
