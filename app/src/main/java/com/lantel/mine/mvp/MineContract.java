package com.lantel.mine.mvp;

import com.lantel.common.list.model.SimpleMenuModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface MineContract {
    interface View extends BaseView {
        void notifyCardData(ArrayList<BaseModel> list);

        void notifyMenuData(ArrayList<SimpleMenuModel> list);

        void loadCircleHeadImage(String url);

        void initCardData(String[] titles);

        void initCardData(ArrayList<BaseModel> list);

        void initMenuData(ArrayList<SimpleMenuModel> list);

    }

    abstract class Presenter extends BaseFragmentPresenter<View, MineModel> {

    }
}
