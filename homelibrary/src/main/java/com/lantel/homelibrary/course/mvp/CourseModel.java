package com.lantel.homelibrary.course.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.homelibrary.course.api.CourseBean;
import com.lantel.homelibrary.course.api.CourseService;
import com.lantel.homelibrary.course.calendar.CalenderSchemBean;
import com.lantel.homelibrary.course.list.model.CourseAllBean;
import com.xiao360.baselibrary.util.LogUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class CourseModel extends ViewModel {
    public Observable<CourseAllBean> loadData(String int_day,String page, String pageSize) {
        CourseService service = Http.getInstance().createRequest(CourseService.class);
        Observable<CalenderSchemBean> schemObservable = service.getSchmeDate(HeaderUtil.getHeaderMap(),"1000");
        Observable<CourseBean> courseObservable = getCourse(int_day,page,pageSize);
        return Observable.zip(courseObservable,schemObservable,(CourseBean courseBean,CalenderSchemBean calenderSchemBean)->{
            CourseAllBean courseAllBean = new CourseAllBean();
            int SchmeError = calenderSchemBean.getError();
            String SchmeMess = calenderSchemBean.getMessage();
            int CourseError = courseBean.getError();
            String CourseMess = courseBean.getMessage();
            List<Integer> SchmeDays = calenderSchemBean.getData().getList();
            List<CourseBean.DataBean.ListBean> listBeans = courseBean.getData().getList();
            courseAllBean.setCourseError(CourseError);
            courseAllBean.setSchmeError(SchmeError);
            courseAllBean.setSchmeMess(SchmeMess);
            courseAllBean.setCourseMess(CourseMess);
            courseAllBean.setSchmeDays(SchmeDays);
            courseAllBean.setListBeans(listBeans);
            return courseAllBean;
        }).compose(RxHelper.io_main());
    }

    public  Observable<CourseBean> getCourse(String int_day,String page,String pagesize) {
        CourseService service = Http.getInstance().createRequest(CourseService.class);
        String with = "course_prepare,one_class,textbook,textbook_section";
        return service.getCourseData(HeaderUtil.getHeaderMap(),"course_arranges?int_day="+int_day+"&with="+with+"&page="+page+"&pagesize="+pagesize);
    }
}
