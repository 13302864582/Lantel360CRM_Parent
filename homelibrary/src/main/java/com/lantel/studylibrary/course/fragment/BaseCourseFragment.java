package com.lantel.studylibrary.course.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.homelibrary.R;
import com.lantel.studylibrary.course.list.adpter.CourseAdapter;
import com.xiao360.baselibrary.base.BaseFragmentPresenter;
import com.xiao360.baselibrary.base.ToolBarStateFragment;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public abstract class BaseCourseFragment<T extends BaseFragmentPresenter, E extends ViewModel> extends ToolBarStateFragment<T,E>{
    @BindView(R.id.classes_list)
    protected RecyclerView classes_list;
    protected CourseAdapter mAdapter;

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
        return -1;
    }

    @Override
    protected int getStateBarviewID() {
        return -1;
    }

    @Override
    protected void initView() {
        stateLayout.showContentView();
        classes_list.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new CourseAdapter(getContext(),null);
        classes_list.setAdapter(mAdapter);
        PresenterSetTag();
    }

    protected abstract void PresenterSetTag();

    protected abstract int getFragmentTag();
}
