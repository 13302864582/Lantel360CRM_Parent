package com.lantel.mine.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.crmparent.R;
import com.lantel.mine.list.holder.CardHolder;
import com.lantel.mine.list.model.CardModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class mineCardListApater extends BaseRecyclerViewAdapter<CardModel> {
    private String[] titles;

    /**
     * 适配器构造
     *
     * @param context
     */
    public mineCardListApater(Context context,String[] titles) {
        super(context, null);
        this.titles = titles;
    }

    public mineCardListApater(Context context, List<CardModel> datas) {
        super(context, datas);
    }

    public void setTitles(String[] titles) {
        this.titles = titles;
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.mine_card_item,parent,false);
        return new CardHolder(view);
    }

    @Override
    public int getItemCount() {
        return null == titles?(super.getItemCount()):titles.length;
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, CardModel data, int position, int viewType) {
        CardHolder cardHolder = (CardHolder) holder;
        if(null != titles){
            setText(titles[position],cardHolder.title);
        }else {
            setText(datas.get(position).getTitle(),cardHolder.title);
        }
        String value = null == data ? "0.00":data.getValue();
        setText(value,"0.00",cardHolder.value);
    }
}
