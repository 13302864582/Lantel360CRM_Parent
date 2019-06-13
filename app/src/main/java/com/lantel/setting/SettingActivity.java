package com.lantel.setting;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.Login.api.LoginService;
import com.lantel.Login.api.LogoutBean;
import com.lantel.common.HeaderUtil;
import com.lantel.common.list.LineDecoration;
import com.lantel.crmparent.BuildConfig;
import com.lantel.crmparent.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.setting.list.adpter.SettingListApater;
import com.lantel.setting.list.model.SettingModel;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.AppManager;
import com.xiao360.baselibrary.util.SpCache;
import com.xiao360.baselibrary.util.ToastUitl;

import java.util.ArrayList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantelhome/360/SettingActivity")
public class SettingActivity extends BaseActivity implements LogoutListener{
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.setting_list)
    RecyclerView settingList;
    private SettingListApater mAdapter;

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

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
        mAdapter = new SettingListApater(this,menu,this);
        settingList.setAdapter(mAdapter);
    }

    @OnClick({R.id.back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
          break;
        }
    }

    @Override
    public void logout() {
        LoginService loginService = Http.getInstance().createRequest(LoginService.class);
        loginService.logout(HeaderUtil.getHeaderMap())
                .compose(RxHelper.io_main())
                .compose(bindToLifecycle())
                .subscribe(new BaseRxObserver<LogoutBean>() {
                    @Override
                    public void onSuccess(LogoutBean logoutBean) {
                        ToastUitl.showShort(logoutBean.getMessage());
                        if(logoutBean.getError()==0){
                            SpCache.putBoolean(Config.IS_LOGIN,false);
                            ARouter.getInstance().build("/lantelhome/360/login").navigation();
                            AppManager.getAppManager().finishAllActivity();
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        ToastUitl.showShort(R.string.net_error);
                    }
                });

    }

    @Override
    public void navigatePerson() {
        String json = getIntent().getStringExtra(Config.JSON_PERSON);
        if(null != json){
            ARouter.getInstance().build("/lantel/360/SetPersonal").withString(Config.JSON_PERSON,json).navigation();
        }else {
            ToastUitl.showShort(R.string.emoty_person);
        }
    }
}
