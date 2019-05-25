package com.lantel.homelibrary.classreview.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class ClassReviewHolder extends BaseViewHolder {
    public TextView attence_class_name;
    public TextView attence_time;
    public TextView attence_date;
    public ImageView attence_state;

    public ClassReviewHolder(View view) {
        super(view);

    }
}
