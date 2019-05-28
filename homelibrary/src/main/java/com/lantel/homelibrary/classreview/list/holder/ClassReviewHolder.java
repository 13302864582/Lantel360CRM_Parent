package com.lantel.homelibrary.classreview.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class ClassReviewHolder extends BaseViewHolder {
    public TextView review_detail;
    public TextView teacher_name;
    public TextView classes_name;
    public TextView date_text;
    public TextView review_content;
    public ImageView head_img;

    public ClassReviewHolder(View view) {
        super(view);
        teacher_name = getView(R.id.teacher_name);
        classes_name = getView(R.id.classes_name);
        date_text = getView(R.id.date_text);
        review_content = getView(R.id.review_content);
        head_img = getView(R.id.head_img);
        review_detail = getView(R.id.review_detail);
    }
}
