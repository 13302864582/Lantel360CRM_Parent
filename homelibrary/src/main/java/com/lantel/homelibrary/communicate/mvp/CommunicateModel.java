package com.lantel.homelibrary.communicate.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.communicate.api.CommunicateBean;
import com.lantel.homelibrary.communicate.api.CommunicateService;
import com.xiao360.baselibrary.util.SpCache;

import java.util.List;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class CommunicateModel extends ViewModel {
    public Observable<CommunicateBean> loadData(String page, String pageSize) {
       return null;
    }
}
