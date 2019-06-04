package com.lantel.common.list.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.lantel.common.list.holder.PhotoHolder;
import com.lantel.common.list.holder.VideoHolder;
import com.lantel.common.list.model.PhotoModel;
import com.lantel.common.list.model.VideoModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;



public class DetailAdapter extends BaseRecyclerViewAdapter<BaseModel> {
    /**
     * 适配器构造
     *
     * @param context
     * @param datas
     */
    public DetailAdapter(Context context, List datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        if(viewType == Config.VIDEO){
            return new VideoHolder(inflater.inflate(R.layout.item_video,parent,false));
        }else {
            return new PhotoHolder(inflater.inflate(R.layout.item_photo,parent,false));
        }
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, BaseModel data, int position, int viewType) {
        if(viewType == Config.VIDEO){
            bindVideoViewHolder((VideoHolder)holder,(VideoModel)data);
        }else {
            bindPhotoViewHolder((PhotoHolder)holder,(PhotoModel)data);
        }
    }

    private void bindPhotoViewHolder(PhotoHolder holder, PhotoModel data) {
          holder.detail_photo.getController().getSettings()
                .setMinZoom(0.05f)
                .setMaxZoom(5f)
                .enableGestures()
                .setPanEnabled(true)
                .setZoomEnabled(true)
                .setDoubleTapEnabled(true)
                .setRotationEnabled(true)
                .setRestrictRotation(true)
                .setFillViewport(true);

        GlideUtils.loadImageView(context,R.mipmap.ad,holder.detail_photo);
    }

    private void bindVideoViewHolder(VideoHolder holder, VideoModel data) {

    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }
}
