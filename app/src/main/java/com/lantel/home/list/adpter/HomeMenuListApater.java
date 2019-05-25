package com.lantel.home.list.adpter;

import android.content.Context;
import com.lantel.common.adpter.SimpleMenuListApater;
import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;
import java.util.List;

public class HomeMenuListApater extends SimpleMenuListApater {
    public HomeMenuListApater(Context context, List<SimpleMenuModel> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.home_menu_item;
    }
}
