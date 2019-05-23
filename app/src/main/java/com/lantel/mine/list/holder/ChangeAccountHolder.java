package com.lantel.mine.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.crmparent.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class ChangeAccountHolder extends BaseViewHolder {
    public ImageView head_img;
    public TextView title;
    public ImageView check;

    public ChangeAccountHolder(View view) {
        super(view);
        head_img = getView(R.id.head_img);
        title = getView(R.id.title);
        check = getView(R.id.check);
    }
}
