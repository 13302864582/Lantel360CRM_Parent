package com.lantel.live.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lantel.homelibrary.R;
import com.lantel.live.LiveAppUtil;
import com.lantel.live.list.holder.LiveHolder;
import com.lantel.live.list.model.LiveCardModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;

import java.util.List;

public class LiveAdapter extends BaseRecyclerViewAdapter<LiveCardModel> {
    public LiveAdapter(Context context, List<LiveCardModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.live_item, parent, false);
        return new LiveHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, LiveCardModel data, int position, int viewType) {
        LiveHolder classesHolder = (LiveHolder) holder;
        setText(data.getClasses_time(),classesHolder.classes_time);
        setText(data.getClasses_name(),classesHolder.classes_name);
        setText(data.getPercent()+"/"+data.getTotal(), classesHolder.classes_percent);
        GlideUtils.loadImageView(context,data.getHeaImg(),classesHolder.head_img,R.mipmap.img_fail);
        if(data.getTotal() > 0)
        classesHolder.seekBar.setMaxprogress(data.getTotal());
        classesHolder.seekBar.setProgress(data.getPercent());
        classesHolder.live_in_room.setOnClickListener((View view)-> {
            LiveAppUtil.NavigateLiveApp(context,data.getRoom_id(),data.getAccount());
        });
    }
}
