package com.lantel.mine.order.mvp;

import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

public interface OrderContract {
    interface View extends BaseView {

    }

    abstract class Presenter extends BaseFragmentPresenter<View, OrderModel> {

    }
}
