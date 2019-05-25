package com.lantel.homelibrary.preview;

import android.view.View;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.preview.list.adpter.PreviewAdapter;
import com.lantel.homelibrary.preview.list.model.PreviewItemModel;
import com.lantel.homelibrary.preview.mvp.PreviewContract;
import com.lantel.homelibrary.preview.mvp.PreviewModel;
import com.lantel.homelibrary.preview.mvp.PreviewPresenter;
import com.xiao360.baselibrary.base.NormalListFragment;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;

public class PreviewFragment extends NormalListFragment<PreviewPresenter, PreviewModel> implements PreviewContract.View{
    @Override
    protected void InitView() {

    }

    @Override
    protected int getListView() {
        return R.id.recyclerView;
    }

    @Override
    protected RecyclerView.Adapter getAdapter() {
        return new PreviewAdapter(getContext(),null);
    }

    @Override
    protected int getToolbarTitle() {
        return R.string.class_review;
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.common_list_layout;
    }

    @Override
    protected View getContentView() {
        return null;
    }

    @Override
    protected PreviewModel getModel() {
        return FindModel(PreviewModel.class);
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this,mModel);
    }

    @Override
    public void initAttenceData(ArrayList<PreviewItemModel> menu) {
        ((PreviewAdapter)mAdapter).setDatas(menu);
         mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFail() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNetWorkError() {

    }
}
