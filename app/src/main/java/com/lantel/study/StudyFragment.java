package com.lantel.study;

import com.lantel.common.BannerMenuFragment;
import com.lantel.crmparent.R;

public class StudyFragment extends BannerMenuFragment {
    @Override
    protected int getIcons() {
        return R.array.study_menu_icon;
    }

    @Override
    protected int getRouterPath() {
        return R.array.study_menu_router_path;
    }

    @Override
    protected int getTitles() {
        return R.array.study_menu_title;
    }

    @Override
    protected int getBannerDefault() {
        return R.mipmap.study_ad;
    }

    @Override
    protected int getTitle() {
        return R.string.tabhost_study;
    }
}
