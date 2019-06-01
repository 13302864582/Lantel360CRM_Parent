package com.lantel.mine;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.crmparent.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.mine.list.adpter.ChangeAcountAdapter;
import com.lantel.mine.list.model.ChangeAccountBean;
import com.lantel.mine.mvp.ChangeAccountModel;
import com.xiao360.baselibrary.base.NormalListFragment;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.SpCache;

import java.util.ArrayList;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChangeAccountFragment extends NormalListFragment {
    private ChangeAccountModel model;
    private ArrayList<ChangeAccountBean> changeAccountBeans;

    @Override
    protected void InitView() {

    }

    @Override
    protected void initView() {
        stateLayout.showContentView();
        recyclerView = rootView.findViewById(getListView());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = getAdapter();
        recyclerView.setAdapter(mAdapter);
        model = ViewModelProviders.of(getActivity()).get(ChangeAccountModel.class);
        changeAccountBeans = model.getChangeAccountBeans();
        stateLayout.refreshLayout.setEnableLoadMore(false);
        stateLayout.refreshLayout.setEnableRefresh(false);
        ((ChangeAcountAdapter)mAdapter).setDatas(changeAccountBeans);
        mAdapter.notifyDataSetChanged();
        TextView title = rootView.findViewById(com.example.baselibrary.R.id.title);
        title.setText(getString(getToolbarTitle()));
        ImageView back = rootView.findViewById(com.example.baselibrary.R.id.back);
        back.setOnClickListener((View view)-> {
            getActivity().setResult(Activity.RESULT_OK);
            getActivity().finish();
        });
    }


    @Override
    protected int getListView() {
        return R.id.attence_list;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new ChangeAcountAdapter(getContext(),null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.change_account;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.attence_content;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected ViewModel getModel() {
        return null;
    }

    @Override
    public void initPresenter() {

    }
}
