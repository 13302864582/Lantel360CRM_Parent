package com.lantel.homelibrary.communicate.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.communicate.list.holder.CommunicateHolder;
import com.lantel.homelibrary.communicate.list.model.ItemModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseRecyclerViewSetAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;


import java.util.ArrayList;

import androidx.collection.ArraySet;

public class CommunicateAdapter extends BaseRecyclerViewAdapter<ItemModel> {

    public CommunicateAdapter(Context context, ArrayList<ItemModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(getLayout(viewType), parent, false);
        return new CommunicateHolder(view);
    }

    private int getLayout(int viewType) {
        if(viewType == Config.MINE)
            return R.layout.item_mine;
         else
         return R.layout.item_other;
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, ItemModel model, int position, int viewType) {
        CommunicateHolder communicateHolder = (CommunicateHolder) holder;
        setText(model.getTitle(),communicateHolder.name);
        setText(model.getTime(),communicateHolder.time);
        setText(model.getContent(),communicateHolder.content);
        GlideUtils.loadCircle(context,model.getHeadImg(),communicateHolder.head_img,R.mipmap.circle_default);
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }
}
