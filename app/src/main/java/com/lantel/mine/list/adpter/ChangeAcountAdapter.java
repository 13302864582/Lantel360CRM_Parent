package com.lantel.mine.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.lantel.crmparent.R;
import com.lantel.mine.list.holder.ChangeAccountHolder;
import com.lantel.mine.list.model.ChangeAccountModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class ChangeAcountAdapter extends BaseRecyclerViewAdapter<ChangeAccountModel> {
    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public ChangeAcountAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new ChangeAccountHolder(inflater.inflate(R.layout.item_change_account,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, ChangeAccountModel data, int position, int viewType) {
        ChangeAccountHolder changeAccountHolder = (ChangeAccountHolder) holder;

        setText(data.getTitle(),changeAccountHolder.title);
        GlideUtils.loadCircle(context,data.getHead_img(),changeAccountHolder.head_img);
    }
}
