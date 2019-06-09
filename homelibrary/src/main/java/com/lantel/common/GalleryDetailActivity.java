package com.lantel.common;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lantel.common.list.adapter.DetailAdapter;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

@Route(path = "/lantel/360/galleyDetail")
public class GalleryDetailActivity extends BaseActivity {
    @BindView(R2.id.viewpager)
    ViewPager viewpager;

    @Override
    public int getLayoutId() {
        return R.layout.gallery_detail2;
    }

    @Override
    public void initView() {
        String jsonData =getIntent().getStringExtra(Config.JSON_IMG_VIDEO);
        int position =getIntent().getIntExtra(Config.POSITION,0);
        Gson gson = new Gson();
        List<MediaModel> mediaModelList = gson.fromJson(jsonData,new TypeToken<List<MediaModel>>(){}.getType());
        viewpager.setAdapter(new DetailAdapter(this,mediaModelList));
        viewpager.setCurrentItem(position);
    }

}
