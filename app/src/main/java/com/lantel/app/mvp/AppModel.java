package com.lantel.app.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.Login.api.DeviceBean;
import com.lantel.Login.api.LoginBean;
import com.lantel.Login.api.LoginService;
import com.lantel.app.api.AllBean;
import com.lantel.app.api.AllService;
import com.lantel.common.HeaderUtil;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class AppModel extends ViewModel {
    public Observable<AllBean> loadData() {
        AllService service = Http.getInstance().createRequest(AllService.class);
        return service.getGlobleData(HeaderUtil.getJsonHeaderMap()).compose(RxHelper.io_main());
    }

    public Observable<LoginBean> bindDevice(String uid, DeviceBean deviceBean) {
        LoginService service = Http.getInstance().createRequest(LoginService.class);
        return service.bindDevice(HeaderUtil.getJsonHeaderMap(),uid,deviceBean).compose(RxHelper.io_main());
    }
}
