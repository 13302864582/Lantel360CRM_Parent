package com.lantel.homelibrary.attence.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.attence.list.holder.AttenceHolder;
import com.lantel.homelibrary.attence.list.model.AttenceCardModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.DisplayUtil;
import java.util.List;

public class AttenceAdapter extends BaseRecyclerViewAdapter<AttenceCardModel> {
    public AttenceAdapter(Context context, List<AttenceCardModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.attence_item, parent, false);
        return new AttenceHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, AttenceCardModel data, int position, int viewType) {
        AttenceHolder attenceHolder = (AttenceHolder) holder;
        boolean isFirst = position == 0;
        boolean isDifferentDate = false;
        if(position -1 >= 0 ){
            String curentDate = data.getDate();
            String lastDate = datas.get(position - 1).getDate();
            isDifferentDate = !(curentDate.equals(lastDate));
        }

        if(isFirst || isDifferentDate){
            attenceHolder.attence_date.setVisibility(View.VISIBLE);
            attenceHolder.attence_date.setText(DisplayUtil.getDateString(data.getDate()));
        }else
            attenceHolder.attence_date.setVisibility(View.GONE);
        setText(data.getClassName(),attenceHolder.attence_class_name);
        setText(DisplayUtil.getTimeString(data.getTime()),attenceHolder.attence_time);
        attenceHolder.attence_state.setImageResource(getStateImgRes(data.getState()));

    }

    private int getStateImgRes(int state) {
        int res = -1;
        switch (state){
            case Config.STATE_NORMAL:
                res = R.mipmap.state_normal;
                break;
            case Config.STATE_LEAVE:
                res = R.mipmap.state_leave;
                break;
            case Config.STATE_ABSENCE:
                res = R.mipmap.state_absence;
                break;
        }
        return res;
    }
}
