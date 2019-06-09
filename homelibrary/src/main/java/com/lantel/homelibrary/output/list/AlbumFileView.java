package com.lantel.homelibrary.output.list;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.output.list.adpter.AttachFileAdapter;
import com.lantel.homelibrary.output.list.adpter.FileTitleLoolUp;
import com.lantel.homelibrary.output.list.adpter.ImagAdapter;
import com.lantel.homelibrary.output.list.adpter.RemarkAdapter;
import com.lantel.homelibrary.output.list.model.RemarkModel;
import java.util.ArrayList;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class AlbumFileView extends LinearLayout {
    private RemarkAdapter mRemarkAdapter;
    private RecyclerView remark_list;
    private AttachFileAdapter mFileAdapter;
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
        remark_list = findViewById(R.id.remark_list);
        mImageAdapter = new ImagAdapter(context,null,isDetail);
        img_list.setLayoutManager(new LinearLayoutManager(context));
        img_list.setAdapter(mImageAdapter);

        mFileAdapter = new AttachFileAdapter(context, null,isDetail);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,3);
        gridLayoutManager.setSpanSizeLookup(new FileTitleLoolUp(mFileAdapter));
        file_list.setLayoutManager(gridLayoutManager);
        file_list.setAdapter(mFileAdapter);

        if(isDetail){
            remark_list.setVisibility(VISIBLE);
            mRemarkAdapter = new RemarkAdapter(context, null);
            remark_list.setLayoutManager(new LinearLayoutManager(context));
            remark_list.setAdapter(mRemarkAdapter);
        }
    }

    public void bindImageList(ArrayList<MediaModel> images) {
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

    public void bindFileList(ArrayList<MediaModel> fileList, ArrayList<MediaModel> recordList) {
        ArrayList<MediaModel> sortFile = new ArrayList<>();
        if(!isDetail){
            MediaModel title = new MediaModel();
            title.setType(Config.TITLE);
            title.setTitle(context.getString(R.string.attach_file));
            sortFile.add(title);
            sortFile.addAll(recordList);
            sortFile.addAll(fileList);
        }else {
            if(recordList.size()>0){
                MediaModel record_title = new MediaModel();
                record_title.setType(Config.TITLE);
                record_title.setTitle(context.getString(R.string.record));
                sortFile.add(record_title);
                sortFile.addAll(recordList);
            }
            if(fileList.size()>0){
                MediaModel file_title = new MediaModel();
                file_title.setType(Config.TITLE);
                file_title.setTitle(context.getString(R.string.doc));
                sortFile.add(file_title);
                sortFile.addAll(fileList);
            }
        }
        mFileAdapter.setDatas(sortFile);
        mFileAdapter.notifyDataSetChanged();
    }

    public void bindRemarkList(ArrayList<RemarkModel> remarkModels) {
        mRemarkAdapter.setDatas(remarkModels);
        mRemarkAdapter.notifyDataSetChanged();
    }
}
