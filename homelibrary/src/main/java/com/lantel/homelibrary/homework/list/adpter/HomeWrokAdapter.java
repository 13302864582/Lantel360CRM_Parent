package com.lantel.homelibrary.homework.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.homework.list.holder.HomeWorkHolder;
import com.lantel.homelibrary.homework.list.model.HomeWorkItemModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class HomeWrokAdapter extends BaseRecyclerViewAdapter<HomeWorkItemModel> {
    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public HomeWrokAdapter(Context context, List<HomeWorkItemModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new HomeWorkHolder(inflater.inflate(R.layout.item_homework,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, HomeWorkItemModel data, int position, int viewType) {
        HomeWorkHolder homeWorkHolder = (HomeWorkHolder) holder;
        setText(data.getTeacher(),homeWorkHolder.homewrok_teacher);
        setText(data.getClasses(),homeWorkHolder.homewrok_classes);
        setText(data.getStartTime(),homeWorkHolder.homewrok_start_time);
        setText(data.getEndTime(),homeWorkHolder.homewrok_end_time);
        boolean isFinish = data.isFinish();
        setText(getString(isFinish?R.string.finished:R.string.unfinish),homeWorkHolder.homework_finish);
        GlideUtils.loadCircle(context,data.getImgUrl(),homeWorkHolder.homewrok_img);
    }
}
