package com.lantel.homelibrary.output.mvp;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class OutputModel extends ViewModel {

    public <R> Observable<R> loadData(String page, String pageSize) {
        return null;
    }
}
