package com.lantel.common;

import android.widget.TextView;
import com.lantel.common.list.adapter.DetailAdapter;
import com.lantel.common.list.model.PhotoModel;
import com.lantel.common.list.model.VideoModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseModel;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import github.hellocsl.layoutmanager.gallery.GalleryLayoutManager;

public class GalleryDetailActivity extends BaseActivity {
    @BindView(R2.id.gally_list)
    RecyclerView mPagerRecycleView;
    @BindView(R2.id.title)
    TextView title;
    private DetailAdapter mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.gallery_detail;
    }

    @Override
    public void initView() {
        title.setText(R.string.output);
        ArrayList<BaseModel> menu = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            BaseModel menuModel1 = new VideoModel();
            BaseModel menuModel2 = new PhotoModel();
            menu.add(menuModel1);
            menu.add(menuModel2);
        }
        mPagerRecycleView.setItemViewCacheSize(7);
        GalleryLayoutManager layoutManager = new GalleryLayoutManager(GalleryLayoutManager.HORIZONTAL);
        layoutManager.attach(mPagerRecycleView);
        //添加 Item 转换器，和 ViewPager 一样使用
        layoutManager.setItemTransformer(new ScaleTransformer());
        mAdapter = new DetailAdapter(this, menu);
        //为 RecycleView 绑定 adapter
        mPagerRecycleView.setAdapter(mAdapter);
    }

    @OnClick(R2.id.back)
    public void onViewClicked() {

    }
}
