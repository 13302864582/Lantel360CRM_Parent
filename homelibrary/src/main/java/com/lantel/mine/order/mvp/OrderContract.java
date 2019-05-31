package com.lantel.mine.order.mvp;

import com.lantel.mine.order.list.model.OrderItemModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface OrderContract {
    interface View extends BaseView {

        void refreshData(ArrayList<OrderItemModel> menu);

        void setLoadMoreData(ArrayList<OrderItemModel> menu);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, OrderModel> {

    }
}
