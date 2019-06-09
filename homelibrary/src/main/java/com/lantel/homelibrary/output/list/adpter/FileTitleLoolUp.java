package com.lantel.homelibrary.output.list.adpter;

import com.lantel.homelibrary.app.Config;
import androidx.recyclerview.widget.GridLayoutManager;

public class FileTitleLoolUp extends GridLayoutManager.SpanSizeLookup {
    private AttachFileAdapter adapter;

    public FileTitleLoolUp(AttachFileAdapter attenceAdapter) {
        this.adapter = attenceAdapter;
    }

    @Override
    public int getSpanSize(int position) {
        int viewType = adapter.getItemViewType(position);
        switch (viewType){
            case Config.RECORD://表格app
            case Config.FILE:
                return 1;
            case Config.TITLE:
                return 3;
                default:
                    return 3;
        }
    }
}
