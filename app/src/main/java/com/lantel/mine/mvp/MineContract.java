package com.lantel.mine.mvp;

import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.mine.api.MineCardBean;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface MineContract {
    interface View extends BaseView {
        void notifyCardData(MineCardBean cardBean);

        void initCardData(String[] titles);

        void initMenuData(ArrayList<SimpleMenuModel> list);

        void LoadCardFail();
    }

    abstract class Presenter extends BaseFragmentPresenter<View, MineModel> {

    }
}
