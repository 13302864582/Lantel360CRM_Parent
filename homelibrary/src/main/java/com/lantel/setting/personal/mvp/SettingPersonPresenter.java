package com.lantel.setting.personal.mvp;

import android.os.Bundle;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.setting.personal.PersonBean;
import com.lantel.setting.personal.list.model.SettingPersonItemModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;

public class SettingPersonPresenter extends SettingPersonContract.Presenter {
    @Override
    public void onCrete(Bundle savedInstanceState) {
        LogUtils.d("onCrete: ");
    }

    //onActivityCreated
    @Override
    public void onCrete() {
        LogUtils.d("onActivityCreated: ");
    }

    @Override
    public void onStart() {
        LogUtils.d("onStart: ");
    }

    @Override
    public void onResume() {
        LogUtils.d("onResume: ");
    }

    @Override
    public void onPause() {
        LogUtils.d("onPause: ");
    }

    @Override
    public void onStop() {
        LogUtils.d("onStop: ");
    }

    @Override
    public void onDestroy() {
        LogUtils.d("onCrete: ");
    }

    public void initMenu(PersonBean personBean) {
        //添加菜单数据
        ArrayList<BaseModel> menu = new ArrayList<>();
        SettingPersonItemModel model1 = new SettingPersonItemModel();
        model1.setType(Config.TYPE_EDIT_TEXT);
        model1.setTitle(context.getString(R.string.name));
        model1.setValue(personBean.getName());

        String[] sex = context.getResources().getStringArray(R.array.sex);
        SettingPersonItemModel model2 = new SettingPersonItemModel();
        model2.setType(Config.TYPE_SELECT_TEXT);
        model2.setTitle(context.getString(R.string.sex));
        model2.setValue(sex[Integer.valueOf(personBean.getSex())]);
        model2.setStrs(sex);

        SettingPersonItemModel model3 = new SettingPersonItemModel();
        model3.setType(Config.TYPE_SELECT_DATE);
        model3.setTitle(context.getString(R.string.birth));
        model3.setValue(personBean.getBirthDate());

        menu.add(model1);
        menu.add(model2);
        menu.add(model3);
        mView.initList(menu);
    }
}
