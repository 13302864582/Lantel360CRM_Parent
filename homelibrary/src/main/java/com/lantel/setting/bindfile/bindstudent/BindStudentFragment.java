package com.lantel.setting.bindfile.bindstudent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.setting.bindfile.bindstudent.list.adpter.BindStudentAdapter;
import com.lantel.setting.bindfile.bindstudent.list.model.BindStudentListModel;
import com.lantel.setting.bindfile.bindstudent.mvp.BindStudentContract;
import com.lantel.setting.bindfile.bindstudent.mvp.BindStudentModel;
import com.lantel.setting.bindfile.bindstudent.mvp.BindStudentPresenter;
import com.xiao360.baselibrary.base.ToolBarFragment;
import com.xiao360.baselibrary.base.ToolBarStateFragment;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class BindStudentFragment extends ToolBarStateFragment<BindStudentPresenter, BindStudentModel> implements BindStudentContract.View {
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.classes_list)
    RecyclerView classes_list;
    @BindView(R2.id.filter_date)
    ImageView filterDate;
    private BindStudentAdapter mAdapter;

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
        return R.layout.classes_content;
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
    protected BindStudentModel getModel() {
        return FindModel(BindStudentModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        stateLayout.showContentView();
        title.setText(R.string.bind_student);
        //filterDate.setImageResource();
        classes_list.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new BindStudentAdapter(getContext(), null);
        classes_list.setAdapter(mAdapter);
    }

    @Override
    public void initAttenceData(ArrayList<BindStudentListModel> menu) {
        mAdapter.setDatas(menu);
        mAdapter.notifyDataSetChanged();
    }

    @OnClick({R2.id.back,R2.id.filter_date})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            getActivity().finish();
        }else if(id == R.id.filter_date){

        }
    }
}
