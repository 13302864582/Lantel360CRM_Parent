package com.lantel.common;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class NormalRxObserver implements Observer<HttpResBean> {
    private static final String TAG = "BaseObserver";
    @Override
    public void onSubscribe(Disposable d) {
        //Log.d(TAG, "onSubscribe: " );
    }

    @Override
    public void onNext(HttpResBean resBean) {
        if(resBean.getError()==0){
            onSuccess(resBean);
        }else if(resBean.getError()== 401){
            HeaderUtil.goToLogin();
        }else onFailure(new Throwable(resBean.getMessage()));
    }

    protected abstract void onSuccess(HttpResBean resBean);

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException){             //HTTP错误
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            if(code == 401){
                HeaderUtil.goToLogin();
            }else onFailure(e);
        }else
        onFailure(e);
    }

    protected abstract void onFailure(Throwable e);

    @Override
    public void onComplete() {
        // Log.d(TAG, "onComplete: " );
    }
}
