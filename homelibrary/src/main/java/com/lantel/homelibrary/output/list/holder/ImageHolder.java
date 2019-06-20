package com.lantel.homelibrary.output.list.holder;

import android.view.View;
import android.widget.ImageView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class ImageHolder extends BaseViewHolder {
    public ImageView img;
    public ImageView play;

    public ImageHolder(View view) {
        super(view);
        img = getView(R.id.img);
        play = getView(R.id.play);
    }
}
