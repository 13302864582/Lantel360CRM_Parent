package com.lantel.mine.order.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.mine.order.list.holder.OrderHolder;
import com.lantel.mine.order.list.model.OrderItemModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class OrderAdapter extends BaseRecyclerViewAdapter<OrderItemModel> {
    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public OrderAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new OrderHolder(inflater.inflate(R.layout.item_order,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, OrderItemModel data, int position, int viewType) {
        OrderHolder orderHolder = (OrderHolder) holder;
       /* setText(data.getTitle(),orderHolder.order_title);
        setText(data.getDate_time(),orderHolder.order_date_time);
        setText(data.getOrder_state(),orderHolder.order_state);
        setText(data.getMoney_record(),orderHolder.money_record);
        setText(data.getUnit_count(),orderHolder.order_course_count);*/
        GlideUtils.loadImageView(context,data.getImg(),orderHolder.order_img);
    }
}