package com.lantel.homelibrary.homework.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class HomeWorkHolder extends BaseViewHolder {
    public TextView homework_finish;
    public ImageView homewrok_img;
    public TextView homewrok_teacher;
    public TextView homewrok_classes;
    public TextView homewrok_start_time;
    public TextView homewrok_end_time;

    public HomeWorkHolder(View view) {
        super(view);
        homework_finish = getView(R.id.homework_finish);
        homewrok_img = getView(R.id.homewrok_img);
        homewrok_teacher = getView(R.id.homewrok_teacher);
        homewrok_classes = getView(R.id.homewrok_classes);
        homewrok_start_time = getView(R.id.homewrok_start_time);
        homewrok_end_time = getView(R.id.homewrok_end_time);
    }
}
