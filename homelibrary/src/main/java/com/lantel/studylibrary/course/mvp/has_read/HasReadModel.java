package com.lantel.studylibrary.course.mvp.has_read;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.studylibrary.course.api.CourseBean;
import com.lantel.studylibrary.course.api.CourseService;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class HasReadModel extends ViewModel {
    public Observable<CourseBean> loadData(String page, String pageSize) {
        CourseService service = Http.getInstance().createRequest(CourseService.class);
        return service.getCourseReading(HeaderUtil.getJsonHeaderMap(),String.valueOf(1),page,pageSize).compose(RxHelper.io_main());
    }
}
