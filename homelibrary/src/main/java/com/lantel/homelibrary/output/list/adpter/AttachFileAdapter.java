package com.lantel.homelibrary.output.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.output.list.holder.AttachTitleHolder;
import com.lantel.studylibrary.preview.preview.list.holder.AttachFileHolder;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.DisplayUtil;
import java.util.List;

public class AttachFileAdapter extends BaseRecyclerViewAdapter<MediaModel> {
    private ClickMore clickMore;
    private boolean isDetail = false;

    /**
     * 适配器构造
     * @param context
     * @param datas
     * @param isDetail
     * @param clickMore
     */
    public AttachFileAdapter(Context context, List datas, boolean isDetail, ClickMore clickMore) {
        super(context, datas);
        this.isDetail = isDetail;
        this.clickMore = clickMore;
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(getLayout(viewType),parent,false);
        if(viewType == Config.RECORD || viewType == Config.FILE)
        return new AttachFileHolder(view);
        else
            return new AttachTitleHolder(view);
    }

    private int getLayout(int viewType) {
        if(viewType == Config.RECORD || viewType == Config.FILE)
         return R.layout.attach_file;
        else
            return R.layout.attach_title;
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, MediaModel data, int position, int viewType) {
        if(viewType == Config.RECORD || viewType == Config.FILE){
            bindFileHolder((AttachFileHolder)holder,data,position,viewType);
        }else {
            bindTitleHolder((AttachTitleHolder)holder,data);
        }
    }

    private void bindTitleHolder(AttachTitleHolder holder, MediaModel data) {
        setText(data.getTitle(),holder.title);
    }

    private void bindFileHolder(AttachFileHolder holder, MediaModel data, int position, int viewType) {
        holder.thumb.setVisibility(View.GONE);
        if(null != datas && position == 3 && datas.size()>4 && !isDetail){
            holder.download_lay.setVisibility(View.GONE);
            holder.file_img.setImageResource(R.mipmap.more);
            holder.file_img.setVisibility(View.VISIBLE);
            holder.file_img.setOnClickListener((View view)-> {
                if(null != clickMore)
                    clickMore.GoDetail();
            });
        }else {
            holder.file_img.setVisibility(View.GONE);
            if(viewType == Config.RECORD)
            holder.icon.setImageResource(R.mipmap.record);
            else
                holder.icon.setImageResource(R.mipmap.file);
            setText(data.getFile_name(),holder.fileName);
            setText(DisplayUtil.byteToMB(data.getFile_size()),holder.fileSize);
            holder.download_lay.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        if(isDetail)
        return super.getItemCount();
        else {
            return null == datas ? 0 : (datas.size()>4?4:datas.size());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }
}
