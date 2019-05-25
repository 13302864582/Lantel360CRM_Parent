package com.lantel.studylibrary.classes.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.common.view.EqulizerSeekBar;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class ClassesHolder extends BaseViewHolder {
    public ImageView head_img;
    public TextView classes_name;
    public TextView classes_place;
    public TextView classes_teacher;
    public TextView classes_percent;
    public EqulizerSeekBar seekBar;

    public ClassesHolder(View view) {
        super(view);
        head_img = getView(R.id.head_img);
        classes_name = getView(R.id.classes_name);
        classes_place = getView(R.id.classes_place);
        classes_teacher = getView(R.id.classes_teacher);
        classes_percent = getView(R.id.classes_percent);
        seekBar = getView(R.id.seekbar);
    }
}
