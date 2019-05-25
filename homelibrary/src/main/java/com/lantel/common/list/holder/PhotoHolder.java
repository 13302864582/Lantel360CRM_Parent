package com.lantel.common.list.holder;

import android.view.View;

import com.alexvasilkov.gestures.views.GestureImageView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class PhotoHolder extends BaseViewHolder {
    public GestureImageView detail_photo;

    public PhotoHolder(View view) {
        super(view);
        detail_photo = view.findViewById(R.id.detail_photo);
        //detail_photo = getView();
    }
}
