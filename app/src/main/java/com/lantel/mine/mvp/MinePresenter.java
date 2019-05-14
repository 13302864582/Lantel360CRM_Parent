package com.lantel.mine.mvp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;
import com.lantel.mine.list.model.CardModel;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;

import androidx.lifecycle.LifecycleObserver;

public class MinePresenter extends MineContract.Presenter{
    @Override
    public void onCrete(Bundle savedInstanceState) {
        LogUtils.d("===onCrete: ");
    }

    //onActivityCreated
    @Override
    public void onCrete() {
        LogUtils.d("===onActivityCreated: ");
    }

    @Override
    public void onStart() {
        LogUtils.d("===onStart: ");
      /*  ArrayList<BaseModel> values = new ArrayList<>();
        values.add(new CardModel("5698"));
        values.add(new CardModel("20"));
        values.add(new CardModel("7"));
        values.add(new CardModel("13"));
        mView.notifyCardData(values);*/
    }

    @Override
    public void onResume() {
        LogUtils.d("===onResume: ");
    }

    @Override
    public void onPause() {
        LogUtils.d("===onPause: ");
    }

    @Override
    public void onStop() {
        LogUtils.d("===onStop: ");
    }

    @Override
    public void onDestroy() {
        LogUtils.d("===onCrete: ");
    }

    public void initCardList() {
        mView.initCardData(context.getResources().getStringArray(R.array.mine_card_item_title));
    }

    public void initMenuList() {
        //添加菜单数据
        ArrayList<SimpleMenuModel> menu = new ArrayList<>();
        Resources resources = context.getResources();
        String[] titles = resources.getStringArray(R.array.mine_menu_title);
        String[] router_paths = resources.getStringArray(R.array.mine_menu_router_path);
        TypedArray icons = resources.obtainTypedArray(R.array.mine_menu_icon);
        for (int i = 0; i < titles.length; i++) {
            SimpleMenuModel menuModel = new SimpleMenuModel();
            menuModel.setTitle(titles[i]);
            menuModel.setImgRes(icons.getResourceId(i,0));
            menuModel.setRouterpath(router_paths[i]);
            menu.add(menuModel);
        }
        mView.initMenuData(menu);
    }
}
