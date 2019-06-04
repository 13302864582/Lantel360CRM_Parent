package com.lantel.studylibrary.preview.preview.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.studylibrary.preview.preview.list.holder.PreviewHolder;
import com.lantel.studylibrary.preview.preview.list.model.PreviewItemModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.List;

public class PreviewAdapter extends BaseRecyclerViewAdapter<PreviewItemModel> {
    public PreviewAdapter(Context context, List<PreviewItemModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.preview_item,parent, false);
        return new PreviewHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, PreviewItemModel data, int position, int viewType) {
        PreviewHolder previewHolder = (PreviewHolder) holder;
        setText(data.getTitle(),previewHolder.course_name);
        setText(data.getTime(),previewHolder.time);
        setText(data.getDate(),previewHolder.date);
        //setText(,previewHolder.detail);
        previewHolder.detail.setOnClickListener((View view)-> {
            LogUtils.d("==="+data.getContent());
        });
    }
}
