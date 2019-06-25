package com.lantel.groupUp;

import com.lantel.common.BannerMenuFragment;
import com.lantel.crmparent.R;

/***
 *  成长界面，时间原因暂时搁置
 */
public class GroupUpFragment extends BannerMenuFragment {
    @Override
    protected int getIcons() {
        return R.array.groupup_menu_icon;
    }

    @Override
    protected int getRouterPath() {
        return R.array.groupup_menu_router_path;
    }

    @Override
    protected int getTitles() {
        return R.array.groupup_menu_title;
    }

    @Override
    protected int getBannerDefault() {
        return R.mipmap.group_ad;
    }

    @Override
    protected int getTitle() {
        return R.string.tabhost_growup;
    }
}
