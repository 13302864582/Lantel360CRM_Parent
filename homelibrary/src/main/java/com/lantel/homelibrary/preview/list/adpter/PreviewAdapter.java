package com.lantel.homelibrary.preview.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.preview.list.holder.PreviewHolder;
import com.lantel.homelibrary.preview.list.model.PreviewItemModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class PreviewAdapter extends BaseRecyclerViewAdapter<PreviewItemModel> {
    public PreviewAdapter(Context context, List<PreviewItemModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.preview_item
                , parent, false);
        return new PreviewHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, PreviewItemModel data, int position, int viewType) {
        PreviewHolder attenceHolder = (PreviewHolder) holder;
        attenceHolder.itemView.setOnClickListener((View view)-> {

        });
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
