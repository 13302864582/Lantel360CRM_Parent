package com.lantel.mine.list.adpter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.common.list.adpter.SimpleMenuListApater;
import com.lantel.common.list.holder.SimpleMenuHolder;
import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class mineMenuListApater extends SimpleMenuListApater {
    public mineMenuListApater(Context context, List<SimpleMenuModel> datas) {
        super(context, datas);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.mine_menu_item;
    }
}
