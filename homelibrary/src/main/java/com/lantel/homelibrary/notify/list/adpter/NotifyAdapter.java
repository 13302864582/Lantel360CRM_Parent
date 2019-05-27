package com.lantel.homelibrary.notify.list.adpter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.notify.NotifyDetailActivity;
import com.lantel.homelibrary.notify.list.holder.NotifyHolder;
import com.lantel.homelibrary.notify.list.model.NotifyItemModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class NotifyAdapter extends BaseRecyclerViewAdapter<NotifyItemModel> {
    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public NotifyAdapter(Context context, List<NotifyItemModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new NotifyHolder(inflater.inflate(R.layout.item_notify,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, NotifyItemModel data, int position, int viewType) {
        holder.itemView.setOnClickListener((View view)-> {
            Intent intent = new Intent(context, NotifyDetailActivity.class);
            intent.putExtra("desc",data.getContent());
            context.startActivity(intent);
        });
    }
}
