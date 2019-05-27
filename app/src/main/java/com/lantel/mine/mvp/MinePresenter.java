package com.lantel.mine.mvp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;

import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;
import com.lantel.mine.api.MineCardBean;
import com.lantel.mine.list.model.CardModel;
import com.lantel.studylibrary.classes.api.ClassBean;
import com.lantel.studylibrary.classes.list.model.ClassesCardModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.base.BaseModel;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

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
        initCardList();
        initMenuList();
        loadData();
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

    private void loadData() {
        mModel.loadData("10028")
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<MineCardBean>() {
                    @Override
                    public void onSuccess(MineCardBean data) {
                        if(data.getError()==0){
                                mView.notifyCardData(data);
                        }else {
                            onFailure(new Throwable(data.getMessage()));
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        mView.LoadCardFail();
                    }
                });
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
