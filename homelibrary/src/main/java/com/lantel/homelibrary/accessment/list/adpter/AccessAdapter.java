package com.lantel.homelibrary.accessment.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.accessment.list.holder.AccessHolder;
import com.lantel.homelibrary.accessment.list.model.AccessItemModel;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.DisplayUtil;

import java.util.List;

public class AccessAdapter extends BaseRecyclerViewAdapter<AccessItemModel> {
    public AccessAdapter(Context context, List<AccessItemModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.accessment_item, parent, false);
        return new AccessHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, AccessItemModel data, int position, int viewType) {
        AccessHolder attenceHolder = (AccessHolder) holder;

    }

    private int getStateImgRes(int state) {
        int res = -1;
        switch (state){
            case Config.STATE_NORMAL:
                res = R.mipmap.state_normal;
                break;
            case Config.STATE_LEAVE:
                res = R.mipmap.state_leave;
                break;
            case Config.STATE_ABSENCE:
                res = R.mipmap.state_absence;
                break;
        }
        return res;
    }

}
