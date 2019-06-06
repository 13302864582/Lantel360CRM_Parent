package com.lantel.homelibrary.output.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.output.list.adpter.ImagAdapter;
import com.xiao360.baselibrary.base.BaseModel;

import java.util.ArrayList;
import java.util.Arrays;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AlbumFileView extends LinearLayout {
    private boolean isDetail;
    private Context context;
    private ConstraintLayout img_list_constraintLayout;
    private RecyclerView img_list;
    private RecyclerView file_list;
    private ImagAdapter mImageAdapter;

    public AlbumFileView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.Album_FileStyle);
        isDetail = ta.getBoolean(R.styleable.Album_FileStyle_isDetail,false);
        ta.recycle();
        LayoutInflater.from(context).inflate(R.layout.album_file_list, this);
        img_list_constraintLayout = findViewById(R.id.img_list_constraintLayout);
        img_list = findViewById(R.id.img_list);
        file_list = findViewById(R.id.file_list);
        mImageAdapter = new ImagAdapter(context,null,isDetail);
        img_list.setLayoutManager(new LinearLayoutManager(context));
        img_list.setAdapter(mImageAdapter);
    }

    public void bindImageList(ArrayList<BaseModel> images, boolean isDetail) {
        RecyclerView.LayoutManager manager =  null;
        int count = null==images?0:images.size();
        ConstraintSet set= new ConstraintSet();
        //获取当前使用的约束布局
        set.clone(img_list_constraintLayout);

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
        set.applyTo(img_list_constraintLayout);
        mImageAdapter.setDatas(images);
        img_list.setLayoutManager(manager);
        img_list.setAdapter(mImageAdapter);
    }

    public void bindFileList(String[] images,boolean isDetail) {
        mImageAdapter = new ImagAdapter(context, Arrays.asList(images),isDetail);
        img_list.setLayoutManager(new GridLayoutManager(context,3));
        img_list.setAdapter(mImageAdapter);
    }
}
