package com.lantel.setting.bindfile.bindstudent.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.common.view.EqulizerSeekBar;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class BindStudentHolder extends BaseViewHolder {
    public ImageView head_img;
    public ImageView sex_img;
    public ImageView bind_img;
    public TextView name;
    public TextView age;
    public TextView classes_room;
    public TextView classes_area;
    public TextView bind_text;

    public BindStudentHolder(View view) {
        super(view);
        head_img = getView(R.id.head_img);
        name = getView(R.id.name);
        sex_img = getView(R.id.sex_img);
        age = getView(R.id.age);
        bind_img = getView(R.id.bind_img);
        bind_text = getView(R.id.bind_text);
        classes_room = getView(R.id.classes_room);
        classes_area = getView(R.id.classes_area);
    }
}
