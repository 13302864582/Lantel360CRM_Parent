package com.lantel.setting.bindAccount;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.BarHide;
import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.setting.bindAccount.list.adapter.BindAccountAdapter;
import com.lantel.setting.bindAccount.list.model.BindAccountModel;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.SpCache;

import java.util.ArrayList;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantel/360/Setting/BindAccount")
public class BindAccount extends BaseMVPActivity implements BindAccountAdapter.onClickBindListener {
    @BindView(R2.id.statebarView)
    View statebarView;
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.filter_date)
    ImageView filterDate;
    @BindView(R2.id.bind_account_list)
    RecyclerView bindAccountList;
    private BindAccountAdapter mAdapter;
    private BindAccountDialog bindPhone;

    @Override
    protected BarHide hideBar() {
        return BarHide.FLAG_SHOW_BAR;
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
    public int getLayoutId() {
        return R.layout.setting_bindaccount_content;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        title.setText(R.string.bind_account);
        bindAccountList.setLayoutManager(new LinearLayoutManager(this));

        //添加菜单数据
        ArrayList<BaseModel> menu = new ArrayList<>();
        Resources resources = getResources();
        String[] titles = resources.getStringArray(R.array.bindaccount_menu_title);
        String[] bind_flag = resources.getStringArray(R.array.bindaccount_menu_flag);
        TypedArray icons = resources.obtainTypedArray(R.array.bindaccount_menu_icon);
        for (int i = 0; i < titles.length; i++) {
            BindAccountModel menuModel = new BindAccountModel();
            menuModel.setTitle(titles[i]);
            menuModel.setImage_path(icons.getResourceId(i,0));
            menuModel.setState(false);
            menuModel.setRoute_flag(bind_flag[i]);
            menu.add(menuModel);
        }
        mAdapter = new BindAccountAdapter(this,menu);
        mAdapter.setListener(this);
        bindAccountList.setAdapter(mAdapter);
    }


    @OnClick(R2.id.back)
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.back){
            finish();
        }
    }

    @Override
    public void clickBind(String flag) {
        switch (flag){
            case Config.BIND_PHONE:
                bindPhone = new BindAccountDialog(this);
                bindPhone.show();
                break;
            case Config.BIND_WEIBO:

                break;
            case Config.BIND_QQ:

                break;
            case Config.BIND_WEIXIN:

                break;
        }
    }
}
