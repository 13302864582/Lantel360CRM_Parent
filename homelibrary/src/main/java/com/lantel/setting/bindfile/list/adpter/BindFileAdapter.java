package com.lantel.setting.bindfile.list.adpter;

import android.content.Context;

import com.lantel.common.list.adpter.SimpleMenuListApater;
import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.homelibrary.R;

import java.util.List;

public class BindFileAdapter extends SimpleMenuListApater {

    public BindFileAdapter(Context context, List<SimpleMenuModel> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.menu_item;
    }
}
