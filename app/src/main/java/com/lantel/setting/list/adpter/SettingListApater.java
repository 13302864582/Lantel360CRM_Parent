package com.lantel.setting.list.adpter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lantel.common.list.holder.SimpleMenuHolder;
import com.lantel.crmparent.R;
import com.lantel.setting.list.holder.SettingHolder;
import com.lantel.setting.list.model.SettingModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.AppManager;

import java.util.List;

public class SettingListApater extends BaseRecyclerViewAdapter<SettingModel> {
    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public SettingListApater(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new SettingHolder(inflater.inflate(R.layout.mine_menu_item,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, SettingModel data, int position, int viewType) {
        SettingHolder menuHolder = (SettingHolder) holder;
        menuHolder.icon.setVisibility(View.INVISIBLE);
        setText(data.getTitle(),menuHolder.title);
        menuHolder.exit_count.setVisibility(position==getItemCount()-1?View.VISIBLE:View.GONE);
        menuHolder.exit_count.setOnClickListener((View view)-> {
            ARouter.getInstance().build("/lantel/360/curriculum").navigation();
            AppManager.getAppManager().finishAllActivity();
        });
        if(!TextUtils.isEmpty(data.getVersion())){
            menuHolder.arrow.setVisibility(View.GONE);
            menuHolder.text_right.setVisibility(View.VISIBLE);
            setText(data.getVersion(),menuHolder.text_right);
        }else
        menuHolder.itemView.setOnClickListener((View view)->{
            ARouter.getInstance().build(data.getRouterpath()).navigation();
    });
    }
}
