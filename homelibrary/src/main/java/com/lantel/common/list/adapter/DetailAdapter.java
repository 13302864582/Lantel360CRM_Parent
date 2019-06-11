package com.lantel.common.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.alexvasilkov.gestures.views.GestureImageView;
import com.bumptech.glide.Glide;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.xiao.nicevideoplayer.Clarity;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;
import com.xiao360.baselibrary.image.GlideUtils;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class DetailAdapter extends PagerAdapter {
    private LayoutInflater inflater;
    private Context context;
    private List<MediaModel> datas;

    public DetailAdapter(Context context, List<MediaModel> datas) {
        this.context = context;
        this.datas = datas;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return null == datas ? 0 : datas.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        if (object instanceof ThumbnailHolder) {
            return view == ((ThumbnailHolder) object).itemView;
        }
        return view == object;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        int viewType = getItemViewType(position);
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
         if (viewType == Config.PHOTO) {
            View v = inflater.inflate(R.layout.item_photo,null);
            PhotoViewHolder vh = new PhotoViewHolder(v);
            container.addView(vh.itemView);
            onBindPhotoViewHolder(vh, position);
            return vh;
        }else if(viewType == Config.VIDEO){
             View v = inflater.inflate(R.layout.item_video,null);
             VideoViewHolder vh = new VideoViewHolder(v);
             container.addView(vh.itemView);
             onBindVideoViewHolder(vh, position);
             return vh;
         }
        return null;
    }

    private void onBindVideoViewHolder(VideoViewHolder vh, int position) {
        MediaModel videoModel = datas.get(position);
        String videoImgUrl = videoModel.getFile_url()+"?vframe/jpg/offset/1";

        vh.mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_IJK); // IjkPlayer or MediaPlayer
        vh.mNiceVideoPlayer.setUp(/*videoModel.getFile_url()*/"http://s10.xiao360.com/qms/1/0/n2etB1wWU5dhr3OxrNiSxmkQx0kHiNNt.m4a",null);
        TxVideoPlayerController controller = new TxVideoPlayerController(context);
        controller.setTitle(videoModel.getFile_name());
        Glide.with(context)
                .load(videoImgUrl)
                .placeholder(R.drawable.img_default)
                .into(controller.imageView());
        vh.mNiceVideoPlayer.setController(controller);
    }

    public List<Clarity> getClarites(String videoUrl) {
        List<Clarity> clarities = new ArrayList<>();
        clarities.add(new Clarity("高清", "480P", videoUrl));
        return clarities;
    }

    private void onBindPhotoViewHolder(PhotoViewHolder vh, int position) {
        MediaModel photoModel = datas.get(position);
        GlideUtils.loadImageView(context,photoModel.getFile_url(),vh.thumbnail);
    }

    private int getItemViewType(int position) {
        return datas.get(position).getType();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        int viewType = getItemViewType(position);
        if (viewType == Config.PHOTO) {
            if (object instanceof PhotoViewHolder) {
                PhotoViewHolder photoViewHolder = (PhotoViewHolder) object;
                container.removeView(photoViewHolder.itemView);
            }
        }else if(viewType == Config.VIDEO){
            if (object instanceof VideoViewHolder) {
                VideoViewHolder videoHolder = (VideoViewHolder) object;
                if (videoHolder.mNiceVideoPlayer == NiceVideoPlayerManager.instance().getCurrentNiceVideoPlayer()) {
                    NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
                }
                container.removeView(videoHolder.itemView);
            }

        }
    }

    private abstract class ThumbnailHolder {
        final View itemView;
        ImageView thumbnail;

        public ThumbnailHolder(@NonNull View itemView) {
            this.itemView = itemView;
        }
    }

    private class PhotoViewHolder extends ThumbnailHolder {
        public PhotoViewHolder(View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.detail_photo);
            ((GestureImageView) thumbnail).getController().getSettings()
                    .setMinZoom(0.05f)
                    .setMaxZoom(5f)
                    .enableGestures()
                    .setPanEnabled(true)
                    .setZoomEnabled(true)
                    .setDoubleTapEnabled(true)
                    .setRotationEnabled(true)
                    .setRestrictRotation(true)
                    .setFillViewport(true);
            thumbnail.setBackgroundColor(context.getResources().getColor(R.color.black));
        }
    }

    private class VideoViewHolder extends ThumbnailHolder{
        public NiceVideoPlayer mNiceVideoPlayer;

        public VideoViewHolder(View itemView) {
            super(itemView);
            mNiceVideoPlayer = itemView.findViewById(R.id.nice_video_player);
        }
    }
}
