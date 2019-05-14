package com.lantel.homelibrary.course.list.holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.view.ImageText;
import androidx.cardview.widget.CardView;

public class CardCourseHolder extends BaseViewHolder {
    public TextView start_time;
    public TextView end_time;
    public TextView class_name;
    public TextView course_name;
    public ImageText room;
    public ImageText teacher;
    public ImageText imformation;
    public CardView card;
    public FrameLayout check_layout;
    public FrameLayout cl_root;
    public CheckBox check;
    public ImageView ver_line;
    public ImageView leave;

    public CardCourseHolder(View view) {
        super(view);
        start_time = getView(R.id.start_time);
        end_time = getView(R.id.end_time);
        class_name = getView(R.id.class_name);
        course_name = getView(R.id.course_name);
        room = getView(R.id.room);
        teacher = getView(R.id.teacher);
        imformation = getView(R.id.imformation);
        check_layout = getView(R.id.check_layout);
        cl_root = getView(R.id.cl_root);
        card = getView(R.id.card);
        check = getView(R.id.check);
        ver_line = getView(R.id.ver_line);
        leave = getView(R.id.img_leave);
    }
}
