package com.lantel.studylibrary.preview.preview.list.adpter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.studylibrary.preview.preview.list.holder.PreviewHolder;
import com.lantel.studylibrary.preview.preview.list.model.PreviewItemModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.LogUtils;
import com.zzhoujay.richtext.RichText;
import java.util.List;

public class PreviewAdapter extends BaseRecyclerViewAdapter<PreviewItemModel> {
    public PreviewAdapter(Context context, List<PreviewItemModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.preview_item,parent, false);
        return new PreviewHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, PreviewItemModel data, int position, int viewType) {
        PreviewHolder previewHolder = (PreviewHolder) holder;
        setText(data.getTitle(),previewHolder.course_name);
        setText(data.getTime(),previewHolder.time);
        setText(data.getDate(),previewHolder.date);
        String content = data.getContent();
        if(!TextUtils.isEmpty(content))
        RichText.fromHtml(content).into(previewHolder.content);
        previewHolder.detail.setOnClickListener((View view)-> {
            if(!TextUtils.isEmpty(data.getCa_id()))
            ARouter.getInstance().build("/lantel/360/preview/detail").withString(Config.CA_ID,data.getCa_id()).navigation();
        });
    }
}
