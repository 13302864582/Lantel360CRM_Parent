package com.lantel.setting.list.holder;

import android.view.View;
import android.widget.Button;
import com.lantel.common.list.holder.SimpleMenuHolder;
import com.lantel.crmparent.R;

public class SettingHolder extends SimpleMenuHolder {
    public Button exit_count;
    public SettingHolder(View view) {
        super(view);
        exit_count = getView(R.id.exit_count);
    }
}
