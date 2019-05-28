package com.lantel.mine.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.crmparent.R;
import com.lantel.mine.list.holder.ChangeAccountHolder;
import com.lantel.mine.list.model.ChangeAccountBean;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class ChangeAcountAdapter extends BaseRecyclerViewAdapter<ChangeAccountBean> {
    private int mSelectPosition = -1;

    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public ChangeAcountAdapter(Context context, List datas) {
        super(context, datas);
    }

    private String sid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new ChangeAccountHolder(inflater.inflate(R.layout.item_change_account,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, ChangeAccountBean data, int position, int viewType) {
        ChangeAccountHolder changeAccountHolder = (ChangeAccountHolder) holder;
        setText(data.getStudent_name(),changeAccountHolder.title);
        GlideUtils.loadCircle(context,data.getPhoto_url(),changeAccountHolder.head_img,R.mipmap.circle_default);
        boolean isSelect = sid.equals(data.getSid());
        if(isSelect){
            if(mSelectPosition!=position)
            mSelectPosition = position;
            changeAccountHolder.check.setVisibility(View.VISIBLE);
        }else
            changeAccountHolder.check.setVisibility(View.INVISIBLE);
            holder.itemView.setOnClickListener((View view)-> {
            if(!isSelect){
                int lastPosition = mSelectPosition;
                mSelectPosition = position;
                sid = data.getSid();
                notifyItemChanged(lastPosition);
                notifyItemChanged(mSelectPosition);
            }
        });
    }

    public String getSelectSid() {
        if(mSelectPosition == -1){
            return "";
        }else {
            return datas.get(mSelectPosition).getSid();
        }
    }


}
