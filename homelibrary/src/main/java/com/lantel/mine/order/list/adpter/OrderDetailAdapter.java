package com.lantel.mine.order.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.mine.order.list.holder.DetailEndHolder;
import com.lantel.mine.order.list.holder.DetailListHolder;
import com.lantel.mine.order.list.holder.DetailTopHolder;
import com.lantel.mine.order.list.model.DetailEndModel;
import com.lantel.mine.order.list.model.DetailListModel;
import com.lantel.mine.order.list.model.DetailTopModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class OrderDetailAdapter extends BaseRecyclerViewAdapter<BaseModel> {
    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public OrderDetailAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        if(viewType == Config.TYPE_ORDER_TOP){
            return new DetailTopHolder(getHolderView(inflater,parent,viewType));
        }else if(viewType == Config.TYPE_ORDER_LIST){
            return new DetailListHolder(getHolderView(inflater,parent,viewType));
        }else
        return new DetailEndHolder(getHolderView(inflater,parent,viewType));
    }

    private View getHolderView(LayoutInflater inflater, ViewGroup parent, int viewType) {
        int layRes = -1;
        switch (viewType){
            case Config.TYPE_ORDER_TOP:
                layRes = R.layout.order_d_top;
                break;
            case Config.TYPE_ORDER_END:
                layRes = R.layout.order_d_end;
                break;
            case Config.TYPE_ORDER_LIST:
                layRes = R.layout.order_d_list;
                break;
        }
        return inflater.inflate(layRes,parent,false);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, BaseModel data, int position, int viewType) {
       if(viewType == Config.TYPE_ORDER_TOP){
           bindOrderTop((DetailTopHolder)holder,(DetailTopModel)data);
       }else if(viewType == Config.TYPE_ORDER_LIST){
           bindOrderList((DetailListHolder)holder,(DetailListModel)data);
       }else
           bindOrderEnd((DetailEndHolder)holder,(DetailEndModel)data);
    }

    private void bindOrderList(DetailListHolder holder, DetailListModel data) {
        setText(data.getList_title(),holder.list_title);
        setText(data.getCourse_time(),holder.course_time);
        setText(data.getUseful_date(),holder.useful_date);
        setText(data.getPaid_money(),holder.paid_money);
        setText(data.getOrigin_price(),holder.origin_price);
        setText(data.getPrice(),holder.price);
        setText(data.getDiscount_amount(),holder.discount_amount);
        setText(data.getReduced_amount(),holder.reduced_amount);
        setText(data.getPresent_times(),holder.present_times);
        GlideUtils.loadImageView(context,data.getList_img(),holder.list_img,R.mipmap.ad);
    }

    private void bindOrderTop(DetailTopHolder holder, DetailTopModel data) {
        setText(data.getOrder_id(),holder.order_id);
        setText(data.getJoin_time(),holder.join_time);
        setText(data.getOrder_time(),holder.order_time);
    }

    private void bindOrderEnd(DetailEndHolder holder, DetailEndModel data) {
        setText(data.getMoney(),holder.order_end_money);
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }
}
