package com.lantel.homelibrary.classreview.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.classreview.list.holder.ClassReviewHolder;
import com.lantel.homelibrary.classreview.list.model.ClassReviewCardModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
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
        ClassReviewHolder attenceHolder = (ClassReviewHolder) holder;

    }

    private String getDateString(String date) {
        String year = date.substring(0,4);
        String month = date.substring(4,6);
        String day = date.substring(6);
        StringBuilder builder = new StringBuilder();
        builder.append(year).append("-").append(month).append("-").append(day);
        return builder.toString();
    }
}
