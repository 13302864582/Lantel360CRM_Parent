package com.lantel.homelibrary.communicate;

import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lantel.common.KeyboardUtil;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.communicate.list.adpter.CommunicateAdapter;
import com.lantel.homelibrary.communicate.list.model.ItemModel;
import com.lantel.homelibrary.communicate.mvp.CommunicateContract;
import com.lantel.homelibrary.communicate.mvp.CommunicateModel;
import com.lantel.homelibrary.communicate.mvp.CommunicatePresenter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.xiao360.baselibrary.base.NormalListFragment;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class CommunicateFragment extends NormalListFragment<CommunicatePresenter, CommunicateModel> implements CommunicateContract.View,OnRefreshListener {
    @BindView(R2.id.chat_commit_edit)
    EditText chat_commit_edit;

    @BindView(R2.id.chat_commit)
    TextView chat_commit;
    @BindView(R2.id.chat_lay)
    ConstraintLayout chat_lay;


    private LinearLayoutManager manager;

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
                chat_commit_edit.setText("");
            }
        });
        KeyboardUtil keyboardUtil = new KeyboardUtil(getActivity());
        keyboardUtil.setOnKeyboardChangeListener(new KeyboardUtil.KeyboardChangeListener() {
            @Override
            public void onKeyboardShow(int keyboardHight) {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) chat_lay.getLayoutParams();
                params.bottomMargin = keyboardHight;
                chat_lay.setLayoutParams(params);
                int count = mAdapter.getItemCount();
                if(count>0){
                    recyclerView.scrollToPosition(mAdapter.getItemCount()-1);
                }
            }

            @Override
            public void onKeyboardHide() {
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) chat_lay.getLayoutParams();
                params.bottomMargin = 0;
                chat_lay.setLayoutParams(params);
            }
        });

        interval(6000, new RxAction() {
            @Override
            public void action(long number) {
                mPresenter.onLoadMore(null);
            }
        });
    }

    private boolean isKeyboardShown(View rootView) {
        final int softKeyboardHeight = 100;
        Rect r = new Rect();
        rootView.getWindowVisibleDisplayFrame(r);
        DisplayMetrics dm = rootView.getResources().getDisplayMetrics();
        int heightDiff = rootView.getBottom() - r.bottom;
        return heightDiff > softKeyboardHeight * dm.density;
    }


    private void commitMessage(String content) {
        mPresenter.commitMessage(content);
    }

    @Override
    protected void initView() {
        initEmptyView();
        initLoadingView();
        initFailView();
        initToolBar();
        stateLayout.showContentView();
        recyclerView = rootView.findViewById(getListView());
        manager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(manager);
        mAdapter = getAdapter();
        recyclerView.setAdapter(mAdapter);
        stateLayout.refreshLayout.setEnableLoadMore(false);
        stateLayout.refreshLayout.setOnRefreshListener(this);
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
        if(oldList.size()==0)
            return;
        int count = mAdapter.getItemCount();
        int start = 0;
        if(count==0){
            ((CommunicateAdapter)mAdapter).getDatas().addAll(oldList);
            mAdapter.notifyDataSetChanged();
        }else {
            ((CommunicateAdapter)mAdapter).getDatas().addAll(start,oldList);
            mAdapter.notifyItemRangeInserted(start,oldList.size());
            mAdapter.notifyItemRangeChanged(start,oldList.size());
        }
    }

    @Override
    public void setLoadMoreData(ArrayList<ItemModel> list) {
        if(list.size()==0)
            return;

        int start = mAdapter.getItemCount();
        ((CommunicateAdapter)mAdapter).getDatas().addAll(list);
        if(start ==0){
            mAdapter.notifyDataSetChanged();
            recyclerView.scrollToPosition(mAdapter.getItemCount()-1);
        }else {
            mAdapter.notifyItemRangeInserted(start,list.size());
            mAdapter.notifyItemRangeChanged(start,list.size());
            int position_first = manager.findFirstVisibleItemPosition();//获取第一个先是的View的索引
            int position_last = start + list.size() ;//获取最后一个先是的View的索引
            LogUtils.d("position===="+position_first+"==="+position_last);
            if(position_last-position_first<4){
                recyclerView.scrollToPosition(mAdapter.getItemCount()-1);
            }
        }
    }

    @Override
    public int getItemCount() {
        return null == mAdapter?0:mAdapter.getItemCount();
    }

    @Override
    public String getTimeUrl(boolean isMore) {
        int count = mAdapter.getItemCount();
        if(count>0){
            //有数据
            List<ItemModel> datas = ((CommunicateAdapter)mAdapter).getDatas();
            if(isMore){
                String format = getString(R.string.newMessFormat);
                String itemTime = datas.get(count-1).getTime();
                Date date = DisplayUtil.formatIntDay("yyyy-MM-dd HH:mm:ss",itemTime);
                return String.format(format,date.getTime()/1000+"")+"&with=student,employee&is_reverse=1";
            }else {
                String format = getString(R.string.historyMessFormat);
                String itemTime = datas.get(0).getTime();
                Date date = DisplayUtil.formatIntDay("yyyy-MM-dd HH:mm:ss",itemTime);
                return String.format(format,date.getTime()/1000+"")+"&with=student,employee&is_reverse=1";
            }
        }else {
            //无数据
            return "im_chats?with=student,employee&page=1&pagesize=20&is_reverse=1";
        }
    }
    /**
     * 每隔milliseconds毫秒后执行指定动作
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

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        mPresenter.refreshData(refreshLayout);
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
