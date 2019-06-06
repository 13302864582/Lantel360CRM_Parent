package com.lantel.app.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.app.api.AllBean;
import com.lantel.app.api.AllService;
import com.lantel.common.HeaderUtil;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class AppModel extends ViewModel {
    public Observable<AllBean> loadData() {
        AllService service = Http.getInstance().createRequest(AllService.class);
        return service.getGlobleData(HeaderUtil.getHeaderMap()).compose(RxHelper.io_main());
    }
}
