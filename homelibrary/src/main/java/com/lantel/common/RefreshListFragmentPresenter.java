package com.lantel.common;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.BaseRxObserver;
import java.util.ArrayList;
import io.reactivex.Observable;

public abstract class RefreshListFragmentPresenter<T, E, V, M> extends BaseFragmentPresenter<V, M> {
    protected int mCurrentPage = 0;

    public void refreshData(RefreshLayout refreshLayout) {
        if(null == refreshLayout)
            showLoading();
        loadData(getObserver(false), false, refreshLayout);
    }

    protected abstract void showLoading();

    private void loadData(Observable<T> observable, boolean isLoadMore, RefreshLayout refreshLayout) {
        observable.compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<T>() {
                    @Override
                    public void onSuccess(T data) {
                        if (getErrorCode(data) == 0) {
                            ArrayList<E> list = new ArrayList<>();
                            if (getTotal(data) != 0) {
                                setUpData(list, data);
                            }

                            if (!isLoadMore)
                                ViewRefreshData(list);
                            else
                                ViewSetLoadMoreData(list);
                            FinishRefreshLoadMore(isLoadMore, refreshLayout);
                            setUpCurrentPage(isLoadMore, refreshLayout);
                        } else {
                            onFailure(new Throwable(getErrorMessage(data)));
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        onFail(refreshLayout, isLoadMore);
                    }
                });
    }

    protected abstract void ViewSetLoadMoreData(ArrayList<E> list);

    protected abstract void ViewRefreshData(ArrayList<E> list);

    public void setUpCurrentPage(boolean isLoadMore, RefreshLayout refreshLayout) {
        if (!isLoadMore) {
            mCurrentPage = 1;
        } else {
            mCurrentPage++;
        }
    }

    public void FinishRefreshLoadMore(boolean isLoadMore, RefreshLayout refreshLayout) {
        if (!isLoadMore) {
            if (null != refreshLayout)
                refreshLayout.finishRefresh();
        } else {
            if (null != refreshLayout)
                refreshLayout.finishLoadMore();
        }
    }

    public void onLoadMore(RefreshLayout refreshLayout) {
        loadData(getObserver(true), true, refreshLayout);
    }

    public void onFail(RefreshLayout refreshLayout, boolean isLoadMore) {
        if (null != refreshLayout) {
            if (!isLoadMore)
                refreshLayout.finishRefresh();
            else
                refreshLayout.finishLoadMore();
        }
        if (!isLoadMore)
            showEmpty();
    }

    protected abstract void showEmpty();

    protected abstract int getTotal(T data);

    protected abstract int getErrorCode(T data);

    protected abstract void setUpData(ArrayList<E> list, T data);

    protected abstract String getErrorMessage(T data);

    protected abstract Observable<T> getObserver(boolean isMore);
}
