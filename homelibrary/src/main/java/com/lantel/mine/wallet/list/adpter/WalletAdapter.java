package com.lantel.mine.wallet.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.mine.wallet.list.holder.WalletHolder;
import com.lantel.mine.wallet.list.model.WalletItemModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;

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
        WalletHolder changeAccountHolder = (WalletHolder) holder;

    }
}
