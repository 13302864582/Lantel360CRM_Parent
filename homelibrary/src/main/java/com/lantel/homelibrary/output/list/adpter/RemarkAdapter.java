package com.lantel.homelibrary.output.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.lantel.homelibrary.R;
import com.lantel.homelibrary.output.list.holder.RemarkHolder;
import com.lantel.homelibrary.output.list.model.RemarkModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class RemarkAdapter extends BaseRecyclerViewAdapter<RemarkModel> {

    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public RemarkAdapter(Context context, List<RemarkModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new RemarkHolder(inflater.inflate(R.layout.remark_item,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, RemarkModel data, int position, int viewType) {

    }
}
