package com.lantel.mine.wallet.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.mine.wallet.list.holder.WalletHolder;
import com.lantel.mine.wallet.list.model.WalletItemModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.List;

public class WalletAdapter extends BaseRecyclerViewAdapter<WalletItemModel> {
    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public WalletAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new WalletHolder(inflater.inflate(R.layout.item_wallet,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, WalletItemModel data, int position, int viewType) {
        WalletHolder walletHolder = (WalletHolder) holder;
        setText(getBussinessType(data.getBusiness_type()),walletHolder.title);
        setText(data.getMoney_record(),walletHolder.money_record);
        setText(data.getDateTime(),walletHolder.date_time);
        setText(data.getRemark(),walletHolder.detail);
        boolean isFirst = position == 0;
        boolean isDifferentDate = false;
        String curentDate = data.getDateMonth();
        if(position -1 >= 0 ){
            String lastDate = datas.get(position - 1).getDateMonth();
            isDifferentDate = !(curentDate.equals(lastDate));
        }

        if(isFirst || isDifferentDate){
            walletHolder.date_title.setText(data.getDateMonth());
            walletHolder.date_title.setVisibility(View.VISIBLE);
        }else
            walletHolder.date_title.setVisibility(View.GONE);
    }

    private String getBussinessType(int business_type) {
        int bussinessStr = -1;
        //1:结转,2:退费,3:充值, 4:下单, 5:订单续费 ,10 导入,11:用户手动增加， 12手动减少
        switch (business_type){
            case 1:
                bussinessStr = R.string.bussinessType1;
                break;
            case 2:
                bussinessStr = R.string.bussinessType2;
                break;
            case 3:
                bussinessStr = R.string.bussinessType3;
                break;
            case 4:
                bussinessStr = R.string.bussinessType4;
                break;
            case 5:
                bussinessStr = R.string.bussinessType5;
                break;
            case 10:
                bussinessStr = R.string.bussinessType10;
                break;
            case 11:
                bussinessStr = R.string.bussinessType11;
                break;
            case 12:
                bussinessStr = R.string.bussinessType12;
                break;
        }
        if(bussinessStr==-1)
            return "";
        else
        return getString(bussinessStr);
    }
}
