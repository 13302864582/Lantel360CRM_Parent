package com.lantel.studylibrary.course.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.studylibrary.course.list.holder.CourseCardHolder;
import com.lantel.studylibrary.course.list.model.CourseCardModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class CourseAdapter extends BaseRecyclerViewAdapter<CourseCardModel> {
    public CourseAdapter(Context context, List<CourseCardModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.course_item, parent, false);
        return new CourseCardHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, CourseCardModel data, int position, int viewType) {
        CourseCardHolder classesHolder = (CourseCardHolder) holder;
        setText(data.getCourse_name(),classesHolder.course_name);
        setText(data.getCourse_end_date(),classesHolder.course_end_date);
        setText(data.getCourse_start_date(),classesHolder.course_start_date);
        String percent = String.valueOf(data.getPercent());
        String total = String.valueOf(data.getTotal());
        String left = String.valueOf(data.getTotal()-data.getPercent());
        setText(percent+"/"+total,classesHolder.course_percent);
        setText(total, classesHolder.total_course);
        setText(percent, classesHolder.use_course);
        setText(left, classesHolder.left_course);
        if(data.getTotal() != 0)
        classesHolder.seekBar.setMaxprogress(data.getTotal());
        classesHolder.seekBar.setProgress(data.getPercent());
    }
}
