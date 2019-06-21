package com.lantel.homelibrary.homework.list.adpter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.homework.list.holder.MediaFileHolder;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.util.PhotoUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MediaFileAdapter extends BaseRecyclerViewAdapter<MediaModel> {
    private ClickAddListener addListener;

    public void setAddListener(ClickAddListener addListener) {
        this.addListener = addListener;
    }

    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public MediaFileAdapter(Context context, List<MediaModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new MediaFileHolder(inflater.inflate(R.layout.media_file_lay,parent,false));
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, MediaModel data, int position, int viewType) {
        MediaFileHolder mediaFileHolder = (MediaFileHolder) holder;
        if(viewType == Config.PHOTO){
            bindPhoto(mediaFileHolder,data,position);
        }else if(viewType == Config.VIDEO){
            bindVideo(mediaFileHolder,data,position);
        }else if(viewType == Config.RECORD){
            bindRecord(mediaFileHolder,data,position);
        }else {
            mediaFileHolder.delete.setVisibility(View.GONE);
            mediaFileHolder.play.setVisibility(View.GONE);
            mediaFileHolder.duration.setVisibility(View.GONE);
            mediaFileHolder.img.setImageResource(R.mipmap.commit_add);
            mediaFileHolder.itemView.setOnClickListener((View view)-> {
                if(null != addListener)
                    addListener.clickAdd();
            });
        }
    }

    private void bindRecord(MediaFileHolder mediaFileHolder, MediaModel data, int position) {
        mediaFileHolder.play.setVisibility(View.VISIBLE);
        mediaFileHolder.duration.setVisibility(View.VISIBLE);
        mediaFileHolder.delete.setVisibility(View.VISIBLE);
        mediaFileHolder.itemView.setOnClickListener((View view)-> {

        });
    }

    private void bindVideo(MediaFileHolder mediaFileHolder, MediaModel data, int position) {
        mediaFileHolder.play.setVisibility(View.VISIBLE);
        mediaFileHolder.duration.setVisibility(View.GONE);
        mediaFileHolder.delete.setVisibility(View.VISIBLE);
        String photoUrl = "";
        if(data.isLocal()){
             photoUrl = data.getFile_url();
        }else
             photoUrl = data.getFile_url()+"?vframe/jpg/offset/1";
        GlideUtils.loadImageView(context,photoUrl,mediaFileHolder.img,R.mipmap.img_load_fail);
        mediaFileHolder.img.setOnClickListener((View view)-> {
            navigateGallery(data);
        });
        mediaFileHolder.delete.setOnClickListener((View view)-> {
            removeItem(position);
        });
    }

    private void removeItem(int position) {
        datas.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, getItemCount()); //刷新被删除数据，以及其后面的数据
    }

    private void navigateGallery(MediaModel data) {
        List<MediaModel> mediaModelList = new ArrayList<>();
        mediaModelList.add(data);
        ARouter.getInstance().build("/lantel/360/galleyDetail").withString(Config.JSON_IMG_VIDEO,new Gson().toJson(mediaModelList)).withInt(Config.POSITION,0).navigation();
    }

    private void bindPhoto(MediaFileHolder mediaFileHolder, MediaModel data, int position) {
        mediaFileHolder.delete.setVisibility(View.VISIBLE);
        mediaFileHolder.play.setVisibility(View.GONE);
        mediaFileHolder.duration.setVisibility(View.GONE);
        GlideUtils.loadImageView(context,data.getFile_url(),mediaFileHolder.img,R.mipmap.img_load_fail);
        mediaFileHolder.img.setOnClickListener((View view)-> {
            navigateGallery(data);
        });
        mediaFileHolder.delete.setOnClickListener((View view)-> {
            removeItem(position);
        });
    }

    @Override
    public int getItemViewType(int position) {
        if(position>=super.getItemCount()){
            return -1;
        }else
        return datas.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return super.getItemCount()+1;
    }
}
