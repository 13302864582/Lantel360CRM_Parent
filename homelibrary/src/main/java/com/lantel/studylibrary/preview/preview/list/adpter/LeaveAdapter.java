package com.lantel.studylibrary.preview.preview.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.studylibrary.preview.preview.list.holder.LeaveHolder;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class LeaveAdapter extends BaseRecyclerViewAdapter<BaseModel> {
    private int mCurrentPosition = 0;

    public int getType() {
        return null==datas?-1:datas.get(mCurrentPosition).getType();
    }

    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public LeaveAdapter(Context context, List<BaseModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new LeaveHolder(inflater.inflate(R.layout.leave_item,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, BaseModel data, int position, int viewType) {
        LeaveHolder leaveHolder = (LeaveHolder) holder;
        leaveHolder.checkBox.setText(data.getTitle());
        leaveHolder.checkBox.setChecked(position == mCurrentPosition);
        leaveHolder.itemView.setOnClickListener((View view)-> {
            int lastPosition = mCurrentPosition;
            if (position != mCurrentPosition) {
                mCurrentPosition = position;
                notifyItemChanged(lastPosition);
            }

            boolean state = leaveHolder.checkBox.isChecked();
            if (!state)
                leaveHolder.checkBox.setChecked(true);
        });
    }


}
