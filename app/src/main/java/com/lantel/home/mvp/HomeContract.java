package com.lantel.home.mvp;

import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.home.api.HomeTopModel;
import com.lantel.mine.list.model.ChangeAccountBean;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;
import java.util.List;

public interface HomeContract {
    interface View extends BaseView {
        void initMenuData(ArrayList<SimpleMenuModel> menu);

        void updateTopView(HomeTopModel homeTopModel, ArrayList<ChangeAccountBean> changeAccountBeans);

        void setNotifyText(List<String> list);

        void setUpNotifyMessage(int today_num);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, HomeModel> {

    }
}
