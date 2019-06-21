package com.lantel.common.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lantel.common.list.holder.SimpleMenuHolder;
import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.listview.listener.OnActionPathListener;

import java.util.List;

public abstract class SimpleMenuListApater extends BaseRecyclerViewAdapter<SimpleMenuModel> {
    private OnActionPathListener listener;

    public void setListener(OnActionPathListener listener) {
        this.listener = listener;
    }

    public SimpleMenuListApater(Context context, List<SimpleMenuModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(getLayoutResId(),parent,false);
        return new SimpleMenuHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, SimpleMenuModel menuModel, int position, int viewType) {
        GlideUtils.loadImageView(context,menuModel.getImgRes(), ((SimpleMenuHolder)holder).icon);
        setText(menuModel.getTitle(),((SimpleMenuHolder)holder).title);
        holder.itemView.setOnClickListener((View view)-> {
            if(listener!=null)
                listener.navigationPath(menuModel.getRouterpath());
        });
    }

    protected abstract int getLayoutResId();
}
