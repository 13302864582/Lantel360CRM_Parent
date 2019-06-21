package com.lantel.homelibrary.output.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.output.list.holder.ImageHolder;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;

public class ImagAdapter extends BaseRecyclerViewAdapter<MediaModel> {
    private ClickMore clickMore;
    private boolean isDetail = false;

    /**
     * 适配器构造
     * @param context
     * @param datas
     * @param isDetail
     * @param clickMore
     */
    public ImagAdapter(Context context, List datas, boolean isDetail, ClickMore clickMore) {
        super(context, datas);
        this.isDetail = isDetail;
        this.clickMore = clickMore;
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        return new ImageHolder(inflater.inflate(getLayout(),parent,false));
    }

    private int getLayout() {
        int count = getItemCount();
        if(count == 1)
            return R.layout.img_item;
        else return R.layout.img_item_square;
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, MediaModel data, int position, int viewType) {
        ImageHolder imageHolder = (ImageHolder) holder;
        String imgUrl = "";
        if(viewType == Config.VIDEO){
            if(data.isLocal())
                imgUrl = data.getFile_url();
            else
                 imgUrl = data.getFile_url()+"?vframe/jpg/offset/1";
        }else if(viewType == Config.PHOTO){
            imgUrl = data.getFile_url();
        }

        if(null != datas && position == 8 && datas.size()>9 && !isDetail){
            imageHolder.img.setImageResource(R.mipmap.more);
            imageHolder.img.setOnClickListener((View view)-> {
                if(null != clickMore)
                    clickMore.GoDetail();
            });
        }else {
            imageHolder.play.setVisibility(viewType == Config.VIDEO?View.VISIBLE:View.GONE);
            GlideUtils.loadImageView(context,imgUrl,imageHolder.img,R.mipmap.img_load_fail);
            imageHolder.img.setOnClickListener((View view)-> {
                Gson gson = new Gson();
                ARouter.getInstance().build("/lantel/360/galleyDetail").withString(Config.JSON_IMG_VIDEO,gson.toJson(datas)).withInt(Config.POSITION,position).navigation();
            });
        }
    }

    @Override
    public int getItemCount() {
        if(isDetail)
        return super.getItemCount();
        else {
            return null == datas ? 0 : (datas.size()>9?9:datas.size());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return datas.get(position).getType();
    }
}
