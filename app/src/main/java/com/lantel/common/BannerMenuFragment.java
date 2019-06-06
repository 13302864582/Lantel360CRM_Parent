package com.lantel.common;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.lantel.common.adpter.BannerMenuListApater;
import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;
import com.xiao360.baselibrary.base.ToolBarStateFragment;
import com.xiao360.baselibrary.listview.listener.OnActionPathListener;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BannerMenuFragment extends ToolBarStateFragment implements OnActionPathListener {
    protected TextView title;
    protected AdBanner banner;
    protected RecyclerView studyMenuList;
    protected BannerMenuListApater mStudyMenuAdapter;

    public void initMenuData() {
        //添加菜单数据
        ArrayList<SimpleMenuModel> menu = new ArrayList<>();
        Resources resources = getContext().getResources();
        String[] titles = resources.getStringArray(getTitles());
        String[] router_paths = resources.getStringArray(getRouterPath());
        TypedArray icons = resources.obtainTypedArray(getIcons());
        for (int i = 0; i < titles.length; i++) {
            SimpleMenuModel menuModel = new SimpleMenuModel();
            menuModel.setTitle(titles[i]);
            menuModel.setImgRes(icons.getResourceId(i,0));
            menuModel.setRouterpath(router_paths[i]);
            menu.add(menuModel);
        }
        studyMenuList.setLayoutManager(new LinearLayoutManager(getContext()));
        mStudyMenuAdapter = new BannerMenuListApater(getContext(), menu);
        mStudyMenuAdapter.setListener(this);
        studyMenuList.setAdapter(mStudyMenuAdapter);
    }

    protected abstract int getIcons();

    protected abstract int getRouterPath();

    protected abstract int getTitles();

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
        return R.layout.common_toolbar;
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected ViewModel getModel() {
        return null;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    protected void initView() {
        stateLayout.refreshLayout.setEnableLoadMore(false);
        stateLayout.refreshLayout.setEnableRefresh(false);
        stateLayout.showContentView();
        title = rootView.findViewById(R.id.title);
        studyMenuList = rootView.findViewById(R.id.study_menu_list);
        banner = rootView.findViewById(R.id.banner);
        initToolbar();
        initBanner();
        initMenuData();
    }

    private void initBanner() {
        banner.setImageLoader(new GlideImageLoader(getBannerDefault()));
        //设置图片集合
        List list = new ArrayList<String>();
        list.add("fz");
        banner.setImages(list);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    protected abstract int getBannerDefault();

    private void initToolbar() {
        title.setText(getString(getTitle()));
    }

    protected abstract int getTitle();

    @Override
    public void navigationPath(String path) {
        ARouter.getInstance().build(path).navigation();
        LogUtils.d("onViewClicked===navigationPath=======" + path);
    }
}
