package com.lantel.homelibrary.notify.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.homelibrary.notify.api.NotifyBean;
import com.lantel.homelibrary.notify.api.NotifyService;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class NotifyModel extends ViewModel {
    public Observable<NotifyBean> loadData(String page, String pageSize) {
        NotifyService service = Http.getInstance().createRequest(NotifyService.class);
        return service.getNotifyData(page,pageSize).compose(RxHelper.io_main());
    }
}
