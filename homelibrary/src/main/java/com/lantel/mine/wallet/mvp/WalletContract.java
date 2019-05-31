package com.lantel.mine.wallet.mvp;

import com.lantel.mine.wallet.list.model.WalletItemModel;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

import java.util.ArrayList;

public interface WalletContract {
    interface View extends BaseView {

        void refreshData(ArrayList<WalletItemModel> userBeanList);

        void setLoadMoreData(ArrayList<WalletItemModel> userBeanList);
    }

    abstract class Presenter extends BaseFragmentPresenter<View, WalletModel> {

    }
}
