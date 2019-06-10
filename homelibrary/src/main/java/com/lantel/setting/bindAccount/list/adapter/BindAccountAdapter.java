package com.lantel.setting.bindAccount.list.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.setting.bindAccount.list.holder.BindAccountHolder;
import com.lantel.setting.bindAccount.list.model.BindAccountModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.SpCache;

import java.util.List;

public class BindAccountAdapter extends BaseRecyclerViewAdapter<BaseModel> {
    public onClickBindListener listener;

    public void setListener(onClickBindListener listener) {
        this.listener = listener;
    }

    public interface onClickBindListener{
        void clickBind(String flag);
    }


    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public BindAccountAdapter(Context context, List<BaseModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new BindAccountHolder(inflater.inflate(R.layout.bindaccount_item,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, BaseModel data, int position, int viewType) {
        BindAccountHolder accountHolder = (BindAccountHolder) holder;
        BindAccountModel accountModel = (BindAccountModel) data;
        GlideUtils.loadImageView(context,accountModel.getImage_path(),((BindAccountHolder) holder).icon);
        setText(accountModel.getTitle(),accountHolder.title);

        if(accountModel.getRoute_flag().equals(Config.BIND_PHONE)){
            String phone = SpCache.getString(Config.PNONE_NUMBER,"");
            if(!TextUtils.isEmpty(phone)){
                accountHolder.value.setVisibility(View.VISIBLE);
                setText(phone,accountHolder.value);
            }
        }
        accountHolder.value.setVisibility(View.GONE);

        boolean isBind = SpCache.getBoolean(accountModel.getRoute_flag(),false);
        if(isBind){
            setText(getString(R.string.bind),accountHolder.state_btn);
            accountHolder.state_btn.setEnabled(false);
        }else {
            setText(getString(R.string.unbind),accountHolder.state_btn);
            accountHolder.state_btn.setEnabled(true);
        }

        accountHolder.state_btn.setOnClickListener((View view)-> {
            if(listener!=null)
                listener.clickBind(accountModel.getRoute_flag());
        });
    }
}
