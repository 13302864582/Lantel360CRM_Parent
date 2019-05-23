package com.lantel.study;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantel.common.AdBanner;
import com.lantel.common.GlideImageLoader;
import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;
import com.lantel.study.list.adpter.StudyMenuListApater;
import com.lantel.study.mvp.StudyContract;
import com.lantel.study.mvp.StudyModel;
import com.lantel.study.mvp.StudyPresenter;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import com.xiao360.baselibrary.listview.listener.OnActionPathListener;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class StudyFragment extends ToolBarStateFragment<StudyPresenter, StudyModel> implements StudyContract.View, OnActionPathListener {
    @BindView(R.id.statebarView)
    View statebarView;
    @BindView(R.id.top_img_right)
    ImageView topImgRight;
    @BindView(R.id.toolbarTitle)
    TextView toolbarTitle;
    @BindView(R.id.toolbar)
    ConstraintLayout toolbar;
    @BindView(R.id.banner)
    AdBanner banner;
    @BindView(R.id.study_menu_list)
    RecyclerView studyMenuList;
    private StudyMenuListApater mStudyMenuAdapter;

    @Override
    public void notifyMenuData(ArrayList<SimpleMenuModel> list) {
        mStudyMenuAdapter.setDatas(list);
        mStudyMenuAdapter.notifyDataSetChanged();
    }

    @Override
    public void initMenuData(ArrayList<SimpleMenuModel> menu) {
        studyMenuList.setLayoutManager(new LinearLayoutManager(getContext()));
        mStudyMenuAdapter = new StudyMenuListApater(getContext(), menu);
        mStudyMenuAdapter.setListener(this);
        studyMenuList.setAdapter(mStudyMenuAdapter);
    }

    @Override
    protected int getContainerLayoutID() {
        return R.layout.common_container;
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
        return R.layout.moudle_study;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected int getToolBarLayoutID() {
        return R.layout.layout_toolbar_mine;
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected StudyModel getModel() {
        return FindModel(StudyModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        initToolbar();
        mPresenter.initMenu();
        initBanner();
        stateLayout.showContentView();
    }

    private void initBanner() {
        banner.setImageLoader(new GlideImageLoader(R.mipmap.study_ad));
        //设置图片集合
        /*List list = new ArrayList<String>();
        list.add("fz");
        banner.setImages(list);*/
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    private void initToolbar() {
        statebarView.setBackgroundColor(getResColor(R.color.white));
        toolbar.setBackgroundColor(getResColor(R.color.white));
        topImgRight.setVisibility(View.GONE);
        toolbarTitle.setText(R.string.tabhost_study);
    }

    @Override
    public void navigationPath(String path) {
        LogUtils.d("onViewClicked===navigationPath=======" + path);
    }

    @OnClick({ R.id.banner})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.banner) {
            LogUtils.d("onViewClicked===banner");
        }
    }
}
