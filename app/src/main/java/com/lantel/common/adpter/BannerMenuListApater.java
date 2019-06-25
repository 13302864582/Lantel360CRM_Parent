package com.lantel.common.adpter;

import android.content.Context;

import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;


import java.util.List;

/***
 *  学习列表的适配器
 */
public class BannerMenuListApater extends SimpleMenuListApater {
    public BannerMenuListApater(Context context, List<SimpleMenuModel> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_menu_item;
    }
}
