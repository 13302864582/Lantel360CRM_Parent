package com.lantel.studylibrary.classes.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.studylibrary.classes.list.holder.ClassesHolder;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;

import java.util.List;

public class ClassesAdapter extends BaseRecyclerViewAdapter<ClassesCardModel> {
    public ClassesAdapter(Context context, List<ClassesCardModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.attence_item, parent, false);
        return new ClassesHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, ClassesCardModel data, int position, int viewType) {
        ClassesHolder attenceHolder = (ClassesHolder) holder;
        boolean isFirst = position == 0;
        boolean isDifferentDate = false;
        if(position -1 >= 0 ){
            String curentDate = data.getDate();
            String lastDate = datas.get(position - 1).getDate();
            isDifferentDate = !(curentDate.equals(lastDate));
        }

        /*if(isFirst || isDifferentDate){
            attenceHolder.attence_date.setVisibility(View.VISIBLE);
            attenceHolder.attence_date.setText(getDateString(data.getDate()));
        }else
            attenceHolder.attence_date.setVisibility(View.GONE);
        attenceHolder.attence_time.setText(getTimeString(data.getTime()));
        attenceHolder.attence_state.setImageResource(getStateImgRes(data.getState()));*/

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

    private String getDateString(String date) {
        String year = date.substring(0,4);
        String month = date.substring(4,6);
        String day = date.substring(6);
        StringBuilder builder = new StringBuilder();
        builder.append(year).append("-").append(month).append("-").append(day);
        return builder.toString();
    }

    private String getTimeString(String time) {
        String hour = time.substring(0,2);
        String minute = time.substring(2);
        StringBuilder builder = new StringBuilder();
        builder.append(hour).append(":").append(minute);
        return builder.toString();
    }
}
