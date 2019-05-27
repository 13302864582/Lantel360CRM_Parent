package com.lantel.setting.bindfile.bindstudent;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.setting.bindfile.bindstudent.list.adpter.BindStudentAdapter;
import com.lantel.setting.bindfile.bindstudent.list.model.BindStudentListModel;
import com.lantel.setting.bindfile.bindstudent.mvp.BindStudentContract;
import com.lantel.setting.bindfile.bindstudent.mvp.BindStudentModel;
import com.lantel.setting.bindfile.bindstudent.mvp.BindStudentPresenter;
import com.xiao360.baselibrary.base.NormalListFragment;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class BindStudentFragment extends NormalListFragment<BindStudentPresenter, BindStudentModel> implements BindStudentContract.View {
    @BindView(R2.id.text_right)
    TextView add;

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.common_list_layout;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected int getToolBarLayoutID() {
        return R.layout.toolbar_btt;
    }

    @Override
    protected BindStudentModel getModel() {
        return FindModel(BindStudentModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void InitView() {
        stateLayout.showContentView();
        add.setText(R.string.addFile);
    }

    @Override
    protected int getListView() {
        return R.id.recyclerView;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new BindStudentAdapter(getContext(), null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.bind_student;
    }

    @Override
    public void initAttenceData(ArrayList<BindStudentListModel> menu) {
        BindStudentAdapter adapter = (BindStudentAdapter) mAdapter;
        adapter.setDatas(menu);
        adapter.notifyDataSetChanged();
    }

    @OnClick({R2.id.text_right})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.text_right){
            ARouter.getInstance().build("/lantel/360/Setting/BindAdd").navigation(getActivity(), Config.REQUEST_BIND_ADD);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

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
}
