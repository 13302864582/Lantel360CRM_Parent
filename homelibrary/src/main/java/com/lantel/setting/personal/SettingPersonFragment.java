package com.lantel.setting.personal;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.setting.personal.list.adpter.SettingPersonAdapter;
import com.lantel.setting.personal.mvp.SettingPersonContract;
import com.lantel.setting.personal.mvp.SettingPersonModel;
import com.lantel.setting.personal.mvp.SettingPersonPresenter;
import com.xiao360.baselibrary.base.BaseMVPFragment;
import com.xiao360.baselibrary.base.BaseModel;
import java.util.ArrayList;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class SettingPersonFragment extends BaseMVPFragment<SettingPersonPresenter, SettingPersonModel> implements SettingPersonContract.View, SettingPersonAdapter.NaviEditListener {
    @BindView(R2.id.headImg)
    ImageView headImg;
    @BindView(R2.id.setting_personal_list)
    RecyclerView settingPersonalList;
    @BindView(R2.id.title)
    TextView title;

    private SettingPersonAdapter mAdapter;

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected SettingPersonModel getModel() {
        return FindModel(SettingPersonModel.class);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.setting_personal_content;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {

    }

    @OnClick({R2.id.headImg, R2.id.chageHead,R2.id.back, R2.id.text_right})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.headImg || id == R.id.chageHead){

        }else if(id == R.id.back){
            getActivity().finish();
        }else if(id == R.id.text_right){

        }

    }

    @Override
    public void initList(ArrayList<BaseModel> menu) {
        settingPersonalList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new SettingPersonAdapter(getContext(),menu);
        settingPersonalList.setAdapter(mAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
       if(requestCode == Config.REQUEST_EDIT_TEXT && resultCode == Activity.RESULT_OK){
           mAdapter.notifyValue(data.getStringExtra(Config.EDIT_TEXT_RESULT));
       }
    }

    @Override
    public void editText(String editText) {
        ARouter.getInstance().build("/lantel/360/EditText").withString(Config.EDIT_TEXT,editText).navigation(getActivity(),Config.TYPE_EDIT_TEXT);
    }
}
