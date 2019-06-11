package com.lantel.studylibrary.preview.preview.list.adpter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.studylibrary.preview.preview.list.AttachFileListener;
import com.lantel.studylibrary.preview.preview.list.holder.AttachFileHolder;
import com.lantel.studylibrary.preview.preview.list.model.AttachFile;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.DisplayUtil;
import java.io.File;
import java.util.ArrayList;
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
        AttachFileHolder attachFileHolder=(AttachFileHolder)holder;
        String fileName = DisplayUtil.getFilePath(data.getFile_url());

        File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),fileName);
        boolean exist = f.exists();
        String filePath = f.getPath();
        if(viewType == 0){
            bindImg(attachFileHolder,data,position,exist,filePath);
        }else if(viewType == 1){
            bindVideo(attachFileHolder,data,exist);
        }else if(viewType == 2){
            bindAudio(attachFileHolder,data,position,exist,filePath);
        }else if(viewType == 3){
            bindFile(attachFileHolder,data,position,exist,filePath);
        }

        if(!exist){
            holder.itemView.setOnClickListener((View view)-> {
                if(listener!=null)
                    listener.downLoadFile(f,data.getFile_url(),position);
            });
        }
    }

    private void bindFile(AttachFileHolder holder, AttachFile data, int position, boolean exist, String filePath) {
        notifyFile(holder, data);
        holder.icon.setImageResource(exist?R.mipmap.file:R.mipmap.download);
        holder.itemView.setOnClickListener((View view)-> {
            if(exist){
                ARouter.getInstance().build("/lantel/360/WebView").withString(Config.FILE_URL,data.getFile_url()).navigation();
            }
        });
    }

    private void bindAudio(AttachFileHolder holder, AttachFile data, int position, boolean exist, String filePath) {
       notifyFile(holder,data);
        holder.icon.setImageResource(exist?R.mipmap.record:R.mipmap.download);
        if(exist){

        }
    }

    private void notifyFile(AttachFileHolder holder, AttachFile data) {
        holder.file_img.setVisibility(View.GONE);
        holder.thumb.setVisibility(View.GONE);
        holder.download_lay.setVisibility(View.VISIBLE);
        setText(TextUtils.isEmpty(data.getTitle())?getString(R.string.unknown):data.getTitle(),holder.fileName);
        setText(DisplayUtil.byteToMB(data.getFile_size()),holder.fileSize);
    }

    private void bindVideo(AttachFileHolder holder, AttachFile data,boolean exist) {
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
        holder.file_img.setOnClickListener((View view)-> {
            if(exist){
                List<MediaModel> mediaModelList = new ArrayList<>();
                MediaModel mediaModel = new MediaModel();
                mediaModel.setType(Config.PHOTO);
                mediaModel.setFile_url(data.getFile_url());
                mediaModel.setFile_name(data.getTitle());
                mediaModelList.add(mediaModel);
                Gson gson = new Gson();
                ARouter.getInstance().build("/lantel/360/galleyDetail").withString(Config.JSON_IMG_VIDEO,gson.toJson(mediaModelList)).withInt(Config.POSITION,0).navigation();
            }
        });
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
        holder.file_img.setOnClickListener((View view)-> {
            if(exist){
                List<MediaModel> mediaModelList = new ArrayList<>();
                MediaModel mediaModel = new MediaModel();
                mediaModel.setType(Config.PHOTO);
                mediaModel.setFile_url(data.getFile_url());
                mediaModel.setFile_name(data.getTitle());
                mediaModelList.add(mediaModel);
                Gson gson = new Gson();
                ARouter.getInstance().build("/lantel/360/galleyDetail").withString(Config.JSON_IMG_VIDEO,gson.toJson(mediaModelList)).withInt(Config.POSITION,0).navigation();
            }
        });

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
