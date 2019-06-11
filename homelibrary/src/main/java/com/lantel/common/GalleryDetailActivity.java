package com.lantel.common;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lantel.common.list.adapter.DetailAdapter;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao360.baselibrary.base.BaseActivity;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

@Route(path = "/lantel/360/galleyDetail")
public class GalleryDetailActivity extends BaseActivity {
    @BindView(R2.id.viewpager)
    ViewPager viewpager;

    @Override
    protected int getStateBarviewID() {
        return -1;
    }

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

    @Override
    protected void onStop() {
        super.onStop();
        // 在onStop时释放掉播放器
        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    public void onBackPressed() {
        // 在全屏或者小窗口时按返回键要先退出全屏或小窗口，
        // 所以在Activity中onBackPress要交给NiceVideoPlayer先处理。
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;
        super.onBackPressed();
    }
}
