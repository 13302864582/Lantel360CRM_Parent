package com.lantel.homelibrary.output.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.lantel.common.ShareUtil;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.output.list.holder.CardOutputHolder;
import com.lantel.homelibrary.output.list.model.CardOutputModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.onekeyshare.OnekeyShare;

public class OutputAdapter extends BaseRecyclerViewAdapter<CardOutputModel>{

    public OutputAdapter(Context context, List<CardOutputModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.ouput_card_item, parent, false);
        return new CardOutputHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, CardOutputModel model, int position, int viewType) {
        CardOutputHolder cardOutputHolder = (CardOutputHolder) holder;
        GlideUtils.loadImageView(context,model.getHeadImg(),cardOutputHolder.head_img);
        setText(model.getTitle(),cardOutputHolder.name);
        setText(model.getTime(),cardOutputHolder.time);
        setText(model.getContent(),cardOutputHolder.content);
        bindSupport(cardOutputHolder, model);

        if(null != model.getMap()){
            ArrayList<MediaModel> imgList = model.getMap().get(Config.IMG_LIST);
            cardOutputHolder.album_file_list.setClickMore(new ClickMore() {
                @Override
                public void GoDetail() {
                    gotoDetail(model,false);
                }
            });
            cardOutputHolder.album_file_list.bindImageList(imgList);

            ArrayList<MediaModel> fileList = model.getMap().get(Config.FILE_LIST);
            ArrayList<MediaModel> recordList = model.getMap().get(Config.RECORD_LIST);
            cardOutputHolder.album_file_list.bindFileList(fileList,recordList);
        }

        cardOutputHolder.card_ConstraintLayout.setOnClickListener((view -> {
            gotoDetail(model,false);
        }));

        cardOutputHolder.remark_img.setOnClickListener((View view)-> {
            gotoDetail(model,true);
        });

        cardOutputHolder.share_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareUtil.showShare(context,"fz","https://www.baidu.com","ahahah",null);
            }
        });
    }

    private void gotoDetail(CardOutputModel model,boolean isCkickRemark) {
        String json = new Gson().toJson(model);
        ARouter.getInstance().build("/lantel/360/output/detail").withString("data",json).withBoolean(Config.IS_REMARK,isCkickRemark).navigation();
    }

    private void bindSupport(CardOutputHolder cardOutputHolder, CardOutputModel model) {
        cardOutputHolder.support_img.setSelected(model.isSupport());
        cardOutputHolder.support_img.setOnClickListener((View view)-> {
            boolean state = !cardOutputHolder.support_img.isSelected();
            cardOutputHolder.support_img.setSelected(state);
            model.setSupport(state);
        });
    }
}
