package com.lantel.homelibrary.notify.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lantel.homelibrary.R;
import com.lantel.homelibrary.notify.list.holder.ClassReviewHolder;
import com.lantel.homelibrary.notify.list.model.NotifyItemModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;

import java.util.List;

public class ClassReviewAdapter extends BaseRecyclerViewAdapter<NotifyItemModel> {
    public ClassReviewAdapter(Context context, List<NotifyItemModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.classreview_item, parent, false);
        return new ClassReviewHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, NotifyItemModel data, int position, int viewType) {
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
