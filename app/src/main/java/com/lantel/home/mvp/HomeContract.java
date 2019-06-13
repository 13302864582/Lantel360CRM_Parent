package com.lantel.home.mvp;

import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.home.api.HomeTopModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface HomeContract {
    interface View extends BaseView {
        void notifyMenuData(ArrayList<SimpleMenuModel> list);

        void loadCircleHeadImage(String url);

        void initMenuData(ArrayList<SimpleMenuModel> menu);

        void updateTopView(HomeTopModel homeTopModel);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, HomeModel> {

    }
}
