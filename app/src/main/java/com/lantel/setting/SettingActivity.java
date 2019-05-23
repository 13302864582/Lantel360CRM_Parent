package com.lantel.setting;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.lantel.common.list.LineDecoration;
import com.lantel.crmparent.BuildConfig;
import com.lantel.crmparent.R;
import com.lantel.setting.list.adpter.SettingListApater;
import com.lantel.setting.list.model.SettingModel;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantelhome/360/SettingActivity")
public class SettingActivity extends BaseActivity {
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.setting_list)
    RecyclerView settingList;
    private SettingListApater mAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.setting;
    }

    @Override
    public void initView() {
        title.setText(R.string.setting);
        initMenuList();
    }

    private void initMenuList() {
        //添加菜单数据
        ArrayList<SettingModel> menu = new ArrayList<>();
        Resources resources = getResources();
        String[] titles = resources.getStringArray(R.array.setting_menu_title);
        String[] router_paths = resources.getStringArray(R.array.setting_menu_router_path);
        for (int i = 0; i < titles.length; i++) {
            SettingModel menuModel = new SettingModel();
            menuModel.setTitle(titles[i]);
            menuModel.setRouterpath(router_paths[i]);
            menu.add(menuModel);
        }
        //单独添加版本项
        SettingModel version = new SettingModel();
        version.setTitle(getText(R.string.version).toString());
        version.setVersion(BuildConfig.VERSION_NAME);
        menu.add(version);
        settingList.setLayoutManager(new LinearLayoutManager(this));
        settingList.addItemDecoration(new LineDecoration(this));
        mAdapter = new SettingListApater(this,menu);
        settingList.setAdapter(mAdapter);
    }

    @OnClick({R.id.back, R.id.exit_count})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                LogUtils.d("onViewClicked====back");
                break;
            case R.id.exit_count:
                LogUtils.d("onViewClicked====exit_count");

                break;
        }
    }
}
