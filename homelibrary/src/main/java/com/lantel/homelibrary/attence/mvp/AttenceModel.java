package com.lantel.homelibrary.attence.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.homelibrary.attence.api.AttenceService;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import okhttp3.ResponseBody;


public class AttenceModel extends ViewModel {
    public Observable<ResponseBody> loadData(String page, String pageSize) {
        AttenceService service = Http.getInstance().createRequest(AttenceService.class);
        return service.getAttenceData(page,pageSize).compose(RxHelper.io_main());
    }

    public Observable<ResponseBody> loadRangeData(String url) {
        AttenceService service = Http.getInstance().createRequest(AttenceService.class);
        return service.getAttenceDataRange(url).compose(RxHelper.io_main());
    }
}
