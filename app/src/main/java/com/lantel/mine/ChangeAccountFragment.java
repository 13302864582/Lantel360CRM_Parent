package com.lantel.mine;

import android.view.View;
import com.lantel.crmparent.R;
import com.lantel.mine.list.adpter.ChangeAcountAdapter;
import com.xiao360.baselibrary.base.NormalListFragment;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

public class ChangeAccountFragment extends NormalListFragment {

    @Override
    protected void InitView() {

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
