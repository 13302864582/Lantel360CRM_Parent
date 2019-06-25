package com.lantel.mine.mvp;

import android.os.Bundle;

import com.lantel.common.HttpResBean;
import com.lantel.common.NormalRxObserver;
import com.lantel.mine.api.MineCardBean;

public class MinePresenter extends MineContract.Presenter{
    @Override
    public void onCrete(Bundle savedInstanceState) {

    }

    //onActivityCreated
    @Override
    public void onCrete() {

    }

    @Override
    public void onStart() {

        loadData();
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }



    private void loadData() {
        mModel.loadData()
                .compose(context.bindToLifecycle())
                .subscribe(new NormalRxObserver() {
                    @Override
                    public void onSuccess(HttpResBean data) {
                        mView.notifyCardData((MineCardBean) data);
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        mView.LoadCardFail();
                    }
                });
    }


}
