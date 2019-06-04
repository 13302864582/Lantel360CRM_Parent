package com.xiao360.baselibrary.base;

import com.xiao360.baselibrary.mvp.BasePresenter;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

public abstract class BaseActivityPresenter<V,M> extends BasePresenter<V,M> {
    protected RxAppCompatActivity context;
}
