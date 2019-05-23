package com.lantel.mine.wallet.mvp;

import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.mvp.BaseView;

public interface WalletContract {
    interface View extends BaseView {

    }

    abstract class Presenter extends BaseFragmentPresenter<View, WalletModel> {

    }
}
