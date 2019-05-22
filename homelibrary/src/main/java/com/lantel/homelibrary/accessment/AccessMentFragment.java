package com.lantel.homelibrary.accessment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.accessment.list.adpter.AccessAdapter;
import com.lantel.homelibrary.accessment.list.model.AccessItemModel;
import com.lantel.homelibrary.accessment.mvp.AccessContract;
import com.lantel.homelibrary.accessment.mvp.AccessModel;
import com.lantel.homelibrary.accessment.mvp.AccessPresenter;
import com.lantel.homelibrary.output.list.adpter.OutputAdapter;
import com.lantel.homelibrary.output.mvp.OutputContract;
import com.lantel.homelibrary.output.mvp.OutputModel;
import com.lantel.homelibrary.output.mvp.OutputPresenter;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.base.ToolBarFragment;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class AccessMentFragment extends ToolBarStateFragment<AccessPresenter, AccessModel> implements AccessContract.View {
    @BindView(R2.id.output_listView)
    RecyclerView outputListView;
    @BindView(R2.id.title)
    TextView title;
    private AccessAdapter mAdapter;

    @Override
    protected int getContainerLayoutID() {
        return R.layout.course_container;
    }

    @Override
    protected int getFailViewId() {
        return R.id.fail;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.loading;
    }

    @Override
    protected int getEmptyViewId() {
        return R.id.empty;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.ouput_content;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected int getToolBarLayoutID() {
        return R.layout.attence_toolbar;
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected AccessModel getModel() {
        return FindModel(AccessModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        initToolBar();
        stateLayout.showContentView();
        outputListView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new AccessAdapter(getContext(), null);
        outputListView.setAdapter(mAdapter);
    }

    private void initToolBar() {
        title.setText(getString(R.string.accessment));
    }

    @OnClick(R2.id.back)
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.back)
        LogUtils.d("=====onViewClicked:back");
    }

    @Override
    public void initAttenceData(ArrayList<AccessItemModel> menu) {
        mAdapter.setDatas(menu);
        mAdapter.notifyDataSetChanged();
    }
}
