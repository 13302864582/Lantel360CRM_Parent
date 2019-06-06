package com.lantel.homelibrary.output.list.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.output.list.holder.CardOutputHolder;
import com.lantel.homelibrary.output.list.model.CardOutputModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.List;


public class OutputAdapter extends BaseRecyclerViewAdapter<CardOutputModel> {

    public OutputAdapter(Context context, List<CardOutputModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.ouput_card_item, parent, false);
        return new CardOutputHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, CardOutputModel data, int position, int viewType) {
        CardOutputHolder cardOutputHolder = (CardOutputHolder) holder;
        CardOutputModel model = (CardOutputModel) data;
        bindSupport(cardOutputHolder, model);
        if(model.getImgs()!=null){
           // bindImageList(cardOutputHolder,model.getImgs());
            cardOutputHolder.album_file_list.bindImageList(model.getImgs(),false);
        }
        cardOutputHolder.card_ConstraintLayout.setOnClickListener((view -> {
            String json = new Gson().toJson(model);
            ARouter.getInstance().build("/lantel/360/output/detail").withString("data",json).navigation();
        }));
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
