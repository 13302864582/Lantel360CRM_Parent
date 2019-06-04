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
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.listview.BaseRecyclerViewAdapter;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import java.util.Arrays;
import java.util.List;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class OutputAdapter extends BaseRecyclerViewAdapter<BaseModel> {
    private ConstraintLayout card_ConstraintLayout;

    public OutputAdapter(Context context, List<BaseModel> datas) {
        super(context, datas);
    }

    @Override
    protected BaseViewHolder CreateViewHolder(LayoutInflater inflater, ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.ouput_card_item, parent, false);
        return new CardOutputHolder(view);
    }

    @Override
    protected void bindViewHolder(BaseViewHolder holder, BaseModel data, int position, int viewType) {
        CardOutputHolder cardOutputHolder = (CardOutputHolder) holder;
        CardOutputModel model = (CardOutputModel) data;
        bindSupport(cardOutputHolder, model);
        if(model.getImgs()!=null){
            bindImageList(cardOutputHolder,model.getImgs());
        }
        cardOutputHolder.card_ConstraintLayout.setOnClickListener((view -> {
            String json = new Gson().toJson(model);
            ARouter.getInstance().build("/lantel/360/output/detail").withString("data",json).navigation();
        }));
    }

    private void bindImageList(CardOutputHolder cardOutputHolder ,String[] images) {
        RecyclerView.LayoutManager manager =  null;
        int count = images.length;
        card_ConstraintLayout = cardOutputHolder.card_ConstraintLayout;
        ConstraintSet set= new ConstraintSet();
        //获取当前使用的约束布局
        set.clone(card_ConstraintLayout);

        if(count == 1){
            set.constrainPercentWidth(R.id.img_list,1f);
            manager = new LinearLayoutManager(context);
        }else if(count == 4){
            set.constrainPercentWidth(R.id.img_list,0.66f);
            manager = new GridLayoutManager(context,2);
        }else{
            set.constrainPercentWidth(R.id.img_list,1f);
            manager = new GridLayoutManager(context,3);
        }
        //最后一步就是设置新的ConstraintLayout约束 这个必须设置;
        set.applyTo(card_ConstraintLayout);
        ImagAdapter adapter = new ImagAdapter(context, Arrays.asList(images),manager);
        cardOutputHolder.img_list.setLayoutManager(manager);
        cardOutputHolder.img_list.setAdapter(adapter);
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
