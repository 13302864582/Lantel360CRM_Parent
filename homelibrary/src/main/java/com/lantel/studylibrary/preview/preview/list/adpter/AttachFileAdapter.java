package com.lantel.studylibrary.preview.preview.list.adpter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.studylibrary.preview.preview.list.AttachFileListener;
import com.lantel.studylibrary.preview.preview.list.holder.AttachFileHolder;
import com.lantel.studylibrary.preview.preview.list.model.AttachFile;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;
import java.io.File;
import java.util.List;

public class AttachFileAdapter extends BaseRecyclerViewAdapter<AttachFile> {
    private AttachFileListener listener;

    public void setListener(AttachFileListener listener) {
        this.listener = listener;
    }

    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public AttachFileAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new AttachFileHolder(inflater.inflate(R.layout.attach_file,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, AttachFile data, int position, int viewType) {
        String filePath = DisplayUtil.getFilePath(data.getFile_url());
        File f = new File(filePath);
        boolean exist = f.exists();
        if(viewType == 0){
            bindImg((AttachFileHolder)holder,data,position,exist,filePath);
        }else if(viewType == 1){
            bindVideo((AttachFileHolder)holder,data,position,exist,filePath);
        }else if(viewType == 2){
            bindAudio((AttachFileHolder)holder,data,position,exist,filePath);
        }else if(viewType == 3){
            bindFile((AttachFileHolder)holder,data,position,exist,filePath);
        }

        holder.itemView.setOnClickListener((View view)-> {
            if(!exist){
                if(null != listener)
                    listener.downLoadFile(f,data.getFile_url(),position);
            }else {
                if(null != listener)
                    listener.OpenFile(data.getFile_type(),f);
            }
        });
    }

    private void bindFile(AttachFileHolder holder, AttachFile data, int position, boolean exist, String filePath) {
        notifyFile(holder, data);
        holder.icon.setImageResource(exist?R.mipmap.file:R.mipmap.download);
    }

    private void bindAudio(AttachFileHolder holder, AttachFile data, int position, boolean exist, String filePath) {
       notifyFile(holder,data);
        holder.icon.setImageResource(exist?R.mipmap.record:R.mipmap.download);
    }

    private void notifyFile(AttachFileHolder holder, AttachFile data) {
        holder.file_img.setVisibility(View.GONE);
        holder.thumb.setVisibility(View.GONE);
        holder.download_lay.setVisibility(View.VISIBLE);
        setText(TextUtils.isEmpty(data.getTitle())?getString(R.string.unknown):data.getTitle(),holder.fileName);
        setText(DisplayUtil.byteToMB(data.getFile_size()),holder.fileSize);
    }

    private void bindVideo(AttachFileHolder holder, AttachFile data, int position, boolean exist, String filePath) {
        if(exist){
            holder.file_img.setVisibility(View.VISIBLE);
            String imgUrl = data.getFile_url()+"?vframe/jpg/offset/1";
            GlideUtils.loadImageView(context,imgUrl,holder.file_img);
            holder.download_lay.setVisibility(View.GONE);
            holder.thumb.setVisibility(View.VISIBLE);
            holder.thumb.setImageResource(R.mipmap.play);
        }else {
            holder.download_lay.setVisibility(View.VISIBLE);
            holder.file_img.setVisibility(View.GONE);
            holder.thumb.setVisibility(View.GONE);
            setText(TextUtils.isEmpty(data.getTitle())?getString(R.string.unknown):data.getTitle(),holder.fileName);
            setText(DisplayUtil.byteToMB(data.getFile_size()),holder.fileSize);
        }
    }

    private void bindImg(AttachFileHolder holder, AttachFile data, int position, boolean exist, String filePath) {
        holder.thumb.setVisibility(View.GONE);
        if(exist){
            holder.file_img.setVisibility(View.VISIBLE);
            holder.download_lay.setVisibility(View.GONE);
            holder.file_img.setImageBitmap(BitmapFactory.decodeFile(filePath));
        }else {
            holder.file_img.setVisibility(View.GONE);
            holder.download_lay.setVisibility(View.VISIBLE);
            setText(TextUtils.isEmpty(data.getTitle())?getString(R.string.unknown):data.getTitle(),holder.fileName);
            setText(DisplayUtil.byteToMB(data.getFile_size()),holder.fileSize);
        }
    }

    @Override
    public int getItemViewType(int position) {
        String type = datas.get(position).getFile_type();
        int media_type = -1;
        switch (type){
            case Config.MEDIA_IMG:
                media_type = 0;
                break;
            case Config.MEDIA_VIDEO:
                media_type = 1;
                break;
            case Config.MEDIA_RECORD:
                media_type = 2;
                break;
            case Config.MEDIA_FILE:
                media_type = 3;
                break;
        }
        return media_type;
    }
}
