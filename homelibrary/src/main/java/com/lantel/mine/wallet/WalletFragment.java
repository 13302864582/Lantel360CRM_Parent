package com.lantel.mine.wallet;

import android.view.View;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.mine.wallet.list.adpter.WalletAdapter;
import com.lantel.mine.wallet.list.model.WalletItemModel;
import com.lantel.mine.wallet.mvp.WalletContract;
import com.lantel.mine.wallet.mvp.WalletModel;
import com.lantel.mine.wallet.mvp.WalletPresenter;
import com.xiao360.baselibrary.base.NormalListFragment;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;

import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class WalletFragment extends NormalListFragment<WalletPresenter, WalletModel> implements WalletContract.View {
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.money)
    TextView money;
    @BindView(R2.id.date_title)
    TextView dateTitle;

    @Override
    protected void InitView() {
        ArrayList list = new ArrayList();
        for(int i=0;i<20;i++){
            list.add(new WalletItemModel());
        }
        WalletAdapter adapter = (WalletAdapter) mAdapter;
        adapter.setDatas(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected int getListView() {
        return R.id.wallet_list;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new WalletAdapter(getContext(), null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.wallet;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.wallet;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected WalletModel getModel() {
        return FindModel(WalletModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @OnClick(R2.id.pick_date)
    public void onViewClicked(View v) {
        LogUtils.d("onViewClicked===pick_date");
    }
}
