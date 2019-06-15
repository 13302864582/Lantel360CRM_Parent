package com.lantel.homelibrary.message.list.adpter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.message.list.holder.MessageHolder;
import com.lantel.homelibrary.message.list.model.MessageItemModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.zzhoujay.richtext.RichText;
import java.util.List;

public class MessageAdapter extends BaseRecyclerViewAdapter<MessageItemModel> {
    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public MessageAdapter(Context context, List<MessageItemModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new MessageHolder(inflater.inflate(R.layout.item_message,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, MessageItemModel data, int position, int viewType) {
        MessageHolder messageHolder = (MessageHolder) holder;
        setText(data.getTitle(),messageHolder.title);
        setText(data.getContent(),messageHolder.content);
        //setText(data.get(),notifyHolder.time);
        messageHolder.itemView.setOnClickListener((View view)-> {
            String businessType = data.getBusiness_type();
                if(!TextUtils.isEmpty(businessType) && businessType.equals("after_class_push")){
                    //如果是作业类型,跳至作业详情
                    ARouter.getInstance().build("/lantel/360/homework/detail").withInt(Config.BUSINESS_ID,data.getBusiness_id()).navigation();
                }
           });
    }
}
