package com.lantel.studylibrary.course.list.holder;

import android.view.View;
import android.widget.TextView;
import com.lantel.common.view.EqulizerSeekBar;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class CourseCardHolder extends BaseViewHolder {
    public TextView course_name;
    public TextView course_start_date;
    public TextView course_end_date;
    public TextView course_percent;
    public EqulizerSeekBar seekBar;
    public TextView total_course;
    public TextView use_course;
    public TextView left_course;

    public CourseCardHolder(View view) {
        super(view);
        course_name = getView(R.id.course_name);
        course_start_date = getView(R.id.course_start_date);
        course_end_date = getView(R.id.course_end_date);
        course_percent = getView(R.id.course_percent);
        seekBar = getView(R.id.seekbar);
        total_course = getView(R.id.total_course);
        use_course = getView(R.id.use_course);
        left_course = getView(R.id.left_course);
    }
}
