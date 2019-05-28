package com.lantel.homelibrary.classreview.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.classreview.list.holder.ClassReviewHolder;
import com.lantel.homelibrary.classreview.list.model.ClassReviewCardModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.List;

public class ClassReviewAdapter extends BaseRecyclerViewAdapter<ClassReviewCardModel> {
    public ClassReviewAdapter(Context context, List<ClassReviewCardModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.classreview_item, parent, false);
        return new ClassReviewHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, ClassReviewCardModel data, int position, int viewType) {
        ClassReviewHolder classReviewHolder = (ClassReviewHolder) holder;
        setText(data.getTeacherName(),classReviewHolder.teacher_name);
        setText(data.getClassName(),classReviewHolder.classes_name);
        setText(data.getDate(),classReviewHolder.date_text);
        setText(data.getContent(),classReviewHolder.review_content);
        GlideUtils.loadCircle(context,data.getHeadImg(),classReviewHolder.head_img,R.mipmap.circle_default);
        classReviewHolder.review_detail.setOnClickListener((View view)-> {
            LogUtils.d("ClickListener=======review_detail");
        });
    }
}
