package com.lantel.homelibrary.output.list.holder;

import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import com.xiao360.baselibrary.view.ImageText;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class CardOutputHolder extends BaseViewHolder {
    public ImageView head_img;
    public TextView name;
    public TextView time;
    public TextView content;
    public RecyclerView img_list;

    public TextView text_classes;
    public TextView text_adress;
    public ImageView share_img;
    public ImageView support_img;
    public ImageView remark_img;
    public ConstraintLayout card_ConstraintLayout;

    public CardOutputHolder(View view) {
        super(view);
        head_img = getView(R.id.head_img);
        name = getView(R.id.name);
        time = getView(R.id.time);
        content = getView(R.id.content);
        img_list = getView(R.id.img_list);
        text_classes = getView(R.id.text_classes);
        text_adress = getView(R.id.text_adress);
        share_img = getView(R.id.share_img);
        support_img = getView(R.id.support_img);
        remark_img = getView(R.id.remark_img);
        card_ConstraintLayout = getView(R.id.card_ConstraintLayout);
    }
}
