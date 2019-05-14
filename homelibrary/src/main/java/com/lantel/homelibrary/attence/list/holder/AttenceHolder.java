package com.lantel.homelibrary.attence.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;

public class AttenceHolder extends BaseViewHolder {
    public TextView attence_class_name;
    public TextView attence_time;
    public TextView attence_date;
    public ImageView attence_state;

    public AttenceHolder(View view) {
        super(view);
        attence_class_name = getView(R.id.attence_class_name);
        attence_time = getView(R.id.attence_time);
        attence_date = getView(R.id.attence_date);
        attence_state = getView(R.id.attence_state);
    }
}
