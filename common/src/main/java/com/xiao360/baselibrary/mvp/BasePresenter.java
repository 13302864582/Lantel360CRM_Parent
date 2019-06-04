package com.xiao360.baselibrary.mvp;

import com.xiao360.baselibrary.lifecycle.BaseLifecycleObserver;

public abstract class BasePresenter<V,M> implements BaseLifecycleObserver {
    protected M mModel;
    protected V mView;

    public void setVM(V v, M m) {
        this.mView = v;
        this.mModel = m;
    }
}
