package com.lantel.homelibrary.classreview.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.homelibrary.classreview.api.ClassReviewBean;
import com.lantel.homelibrary.classreview.api.ClassReviewService;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class ClassReviewModel extends ViewModel {
    public Observable<ClassReviewBean> loadData(String page, String pageSize) {
        ClassReviewService service = Http.getInstance().createRequest(ClassReviewService.class);
        return service.getClassReviewData(HeaderUtil.getHeaderMap(),page,pageSize).compose(RxHelper.io_main());
    }
}
