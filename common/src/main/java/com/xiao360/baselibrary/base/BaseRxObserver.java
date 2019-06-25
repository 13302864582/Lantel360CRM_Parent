package com.xiao360.baselibrary.base;

import com.alibaba.android.arouter.launcher.ARouter;
import com.xiao360.baselibrary.util.AppConfig;
import com.xiao360.baselibrary.util.AppManager;
import com.xiao360.baselibrary.util.SpCache;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.HttpException;

public abstract class BaseRxObserver<T> implements Observer<T> {

    private static final String TAG = "BaseObserver";
    @Override
    public void onSubscribe(Disposable d) {
        //Log.d(TAG, "onSubscribe: " );
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof HttpException){             //HTTP错误
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            if(code == 401){
                SpCache.putBoolean(AppConfig.IS_LOGIN,false);
                ARouter.getInstance().build("/lantelhome/360/login").navigation();
                AppManager.getAppManager().finishAllActivity();
            }
        }else
            onFailure(e);
    }

    @Override
    public void onComplete() {
       // Log.d(TAG, "onComplete: " );
    }

    public abstract void onSuccess(T demo);

    public abstract void onFailure(Throwable e);
}
