package com.lantel.homelibrary.output.list.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.output.list.AlbumFileView;
import com.xiao360.baselibrary.listview.BaseViewHolder;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class CardOutputHolder extends BaseViewHolder {
    public ImageView head_img;
    public TextView name;
    public TextView time;
    public TextView content;
   /* public RecyclerView img_list;
    public RecyclerView file_list;*/
    public TextView text_classes;
    public TextView text_adress;
    public ImageView share_img;
    public ImageView support_img;
    public ImageView remark_img;
    public ConstraintLayout card_ConstraintLayout;
    public AlbumFileView album_file_list;

    public CardOutputHolder(View view) {
        super(view);
        head_img = getView(R.id.head_img);
        name = getView(R.id.name);
        time = getView(R.id.time);
        content = getView(R.id.content);
       /* img_list = getView(R.id.img_list);
        file_list = getView(R.id.file_list);*/
        album_file_list = getView(R.id.album_file_list);
        text_classes = getView(R.id.text_classes);
        text_adress = getView(R.id.text_adress);
        share_img = getView(R.id.share_img);
        support_img = getView(R.id.support_img);
        remark_img = getView(R.id.remark_img);
        card_ConstraintLayout = getView(R.id.card_ConstraintLayout);
    }
}
