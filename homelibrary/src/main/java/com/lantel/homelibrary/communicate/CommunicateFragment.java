package com.lantel.homelibrary.communicate;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.communicate.list.adpter.CommunicateAdapter;
import com.lantel.homelibrary.communicate.list.model.ItemModel;
import com.lantel.homelibrary.communicate.mvp.CommunicateContract;
import com.lantel.homelibrary.communicate.mvp.CommunicateModel;
import com.lantel.homelibrary.communicate.mvp.CommunicatePresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.xiao360.baselibrary.base.NormalListFragment;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class CommunicateFragment extends NormalListFragment<CommunicatePresenter, CommunicateModel> implements CommunicateContract.View {
    @BindView(R2.id.chat_commit_edit)
    EditText chat_commit_edit;

    @BindView(R2.id.chat_commit)
    TextView chat_commit;
    @Override
    protected int getContentViewLayoutId() {
        return R.layout.goutong_layout;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected CommunicateModel getModel() {
        return FindModel(CommunicateModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void InitView() {

        stateLayout.showContentView();
        mPresenter.onLoadMore(null);
        chat_commit.setOnClickListener((View view)-> {
            String content = chat_commit_edit.getText().toString();
            if(!TextUtils.isEmpty(content)){
                commitMessage(content);
            }
        });
        /*interval(4000, new RxAction() {
            @Override
            public void action(long number) {
                mPresenter.onLoadMore(null);
            }
        });*/
    }

    private void commitMessage(String content) {

    }

    @Override
    protected void initView() {
        initEmptyView();
        initLoadingView();
        initFailView();
        initToolBar();
        stateLayout.showContentView();
        recyclerView = rootView.findViewById(getListView());
        final LinearLayoutManager manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        mAdapter = getAdapter();
        recyclerView.setAdapter(mAdapter);
        stateLayout.refreshLayout.setEnableLoadMore(false);
        stateLayout.refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mPresenter.refreshData(refreshLayout);
            }
        });
        InitView();
    }

    @Override
    protected int getListView() {
        return R.id.output_listView;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new CommunicateAdapter(getContext(),new ArrayList<>());
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.communicate;
    }

    @Override
    public void showEmpty() {
        stateLayout.showEmptyView();
    }

    @Override
    public void showLoading() {
        stateLayout.showLoadingView();
    }

    @Override
    public void showNetWorkError() {
        stateLayout.showFailView();
    }

    @Override
    public void refreshData(ArrayList<ItemModel> oldList) {
        int start = 0;
        ((CommunicateAdapter)mAdapter).getDatas().addAll(start,oldList);
        mAdapter.notifyItemRangeInserted(start,oldList.size());
        mAdapter.notifyItemRangeChanged(start,oldList.size());
    }

    @Override
    public void setLoadMoreData(ArrayList<ItemModel> list) {
        int start = mAdapter.getItemCount();
        ((CommunicateAdapter)mAdapter).getDatas().addAll(list);
        if(start ==0)
            mAdapter.notifyDataSetChanged();
        else {
            mAdapter.notifyItemRangeInserted(start,list.size());
            mAdapter.notifyItemRangeChanged(start,list.size());
        }
    }

    @Override
    public int getItemCount() {
        return null == mAdapter?0:mAdapter.getItemCount();
    }



    /**
     * 每隔milliseconds毫秒后执行指定动作
     *
     * @param milliSeconds
     * @param rxAction
     */
    public void interval(long milliSeconds, final RxAction rxAction) {
        Observable.interval(milliSeconds, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .compose(bindToLifecycle())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {

                    }

                    @Override
                    public void onNext(@NonNull Long number) {
                        if (rxAction != null) {
                            rxAction.action(number);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface RxAction {
        /**
         * 让调用者指定指定动作
         *
         * @param number
         */
        void action(long number);
    }

}
