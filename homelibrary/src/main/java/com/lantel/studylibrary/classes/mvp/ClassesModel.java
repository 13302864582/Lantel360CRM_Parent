package com.lantel.studylibrary.classes.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.homelibrary.course.api.CourseBean;
import com.lantel.homelibrary.course.api.CourseService;
import com.lantel.homelibrary.course.calendar.CalenderSchemBean;
import com.lantel.studylibrary.classes.api.ClassBean;
import com.lantel.studylibrary.classes.api.ClassService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class ClassesModel extends ViewModel {
    public Observable<ClassBean> loadData(String page, String pageSize) {
        ClassService service = Http.getInstance().createRequest(ClassService.class);
        return service.getClassData(HeaderUtil.getHeaderMap(),page,pageSize).compose(RxHelper.io_main());
    }
}
