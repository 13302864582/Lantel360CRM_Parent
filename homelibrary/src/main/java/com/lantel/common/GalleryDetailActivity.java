package com.lantel.common;

import com.lantel.common.list.adapter.DetailAdapter2;
import com.lantel.common.list.model.PhotoModel;
import com.lantel.common.list.model.VideoModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseModel;

import java.util.ArrayList;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

public class GalleryDetailActivity extends BaseActivity {
    @BindView(R2.id.viewpager)
    ViewPager viewpager;

    @Override
    public int getLayoutId() {
        return R.layout.gallery_detail2;
    }

    @Override
    public void initView() {
        ArrayList<BaseModel> menu = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            BaseModel menuModel1 = new VideoModel();
            BaseModel menuModel2 = new PhotoModel();
            menu.add(menuModel1);
            menu.add(menuModel2);
        }
        viewpager.setAdapter(new DetailAdapter2(this,menu));
    }

}
