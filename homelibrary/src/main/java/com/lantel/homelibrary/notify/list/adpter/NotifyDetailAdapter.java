package com.lantel.homelibrary.notify.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.notify.list.holder.NotifyHolder;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.zzhoujay.richtext.RichText;

import java.util.List;

public class NotifyDetailAdapter extends BaseRecyclerViewAdapter<BaseModel> {
    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public NotifyDetailAdapter(Context context, List<BaseModel> datas) {
        super(context, datas);

    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        if(viewType ==  Config.TYPE_IMG){
            return new NotifyHolder(inflater.inflate(R.layout.img_item,parent,false));
        }else
        return new NotifyHolder(inflater.inflate(R.layout.item_text,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, BaseModel data, int position, int viewType) {

    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }
}
