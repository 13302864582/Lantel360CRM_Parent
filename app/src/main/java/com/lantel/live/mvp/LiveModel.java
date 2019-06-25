package com.lantel.live.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.live.api.LiveBean;
import com.lantel.live.api.LiveService;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;


public class LiveModel extends ViewModel {
    public Observable<LiveBean> loadData(String page, String pageSize) {
        LiveService service = Http.getInstance().createRequest(LiveService.class);
        return service.getLiveData(HeaderUtil.getJsonHeaderMap(),"0","1",page,pageSize).compose(RxHelper.io_main());
    }
}
