package com.lantel.homelibrary.notify.list.adpter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.notify.NotifyDetailActivity;
import com.lantel.homelibrary.notify.list.holder.NotifyHolder;
import com.lantel.homelibrary.notify.list.model.NotifyItemModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.zzhoujay.richtext.RichText;

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
        NotifyHolder notifyHolder = (NotifyHolder) holder;
        setText(data.getTitle(),notifyHolder.title);
        setText(data.getTime(),notifyHolder.time);
        String contentStr = data.getContent();
        RichText.fromHtml(contentStr)
                .into(notifyHolder.content);
        notifyHolder.itemView.setOnClickListener((View view)-> {
            if(data.isPush())
            ARouter.getInstance().build("/lantel/360/notify/detail").withString(Config.JSON_NOTIFY,new Gson().toJson(data)).navigation();
        });
        ((NotifyHolder) holder).content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.isPush())
                    ARouter.getInstance().build("/lantel/360/notify/detail").withString(Config.JSON_NOTIFY,new Gson().toJson(data)).navigation();
            }
        });
    }
}
