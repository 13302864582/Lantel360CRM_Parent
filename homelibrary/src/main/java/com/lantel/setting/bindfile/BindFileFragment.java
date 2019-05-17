package com.lantel.setting.bindfile;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.setting.bindfile.list.adpter.BindFileAdapter;
import com.lantel.setting.bindfile.mvp.BindFileContract;
import com.lantel.setting.bindfile.mvp.BindFileModel;
import com.lantel.setting.bindfile.mvp.BindFilePresenter;
import com.xiao360.baselibrary.base.BaseMVPFragment;

import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class BindFileFragment extends BaseMVPFragment<BindFilePresenter, BindFileModel> implements BindFileContract.View{
    @BindView(R2.id.statebarView)
    View statebarView;
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.text_right)
    TextView textRight;
    @BindView(R2.id.setting_bindfile_list)
    RecyclerView setting_bindfile_list;
    private BindFileAdapter mAdapter;

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected BindFileModel getModel() {
        return FindModel(BindFileModel.class);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.setting_bindfile_content;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        title.setText(getString(R.string.setting_BindFile));
    }

    @OnClick({R2.id.back})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            getActivity().finish();
        }
    }

    @Override
    public void initList(ArrayList<SimpleMenuModel> menu) {
        setting_bindfile_list.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new BindFileAdapter(getContext(), menu);
        setting_bindfile_list.setAdapter(mAdapter);
    }
}
