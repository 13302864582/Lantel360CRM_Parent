package com.lantel.mine.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.crmparent.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.mine.api.ChangeAccountListener;
import com.lantel.mine.list.holder.ChangeAccountHolder;
import com.lantel.mine.list.model.ChangeAccountBean;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.SpCache;
import java.util.List;

public class ChangeAcountAdapter extends BaseRecyclerViewAdapter<ChangeAccountBean> {
    private ChangeAccountListener listener;
    private int mSelectPosition = -1;

    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public ChangeAcountAdapter(Context context, List datas, ChangeAccountListener listener) {
        super(context, datas);
        this.listener = listener;
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
        String sid = SpCache.getString(Config.SID,"");
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
                notifyItemChanged(lastPosition);
                notifyItemChanged(mSelectPosition);
                SpCache.putString(Config.SID,data.getSid());
                if(null != listener)
                    listener.changeAccount(SpCache.getString(Config.UID,"0"),data.getSid());
            }
        });
    }
}
