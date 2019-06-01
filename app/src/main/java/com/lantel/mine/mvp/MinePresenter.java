package com.lantel.mine.mvp;

import android.os.Bundle;
import com.lantel.mine.api.MineCardBean;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.LogUtils;

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
        LogUtils.d("MinePresenter===onStart: ");
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



    private void loadData() {
        mModel.loadData()
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


}
