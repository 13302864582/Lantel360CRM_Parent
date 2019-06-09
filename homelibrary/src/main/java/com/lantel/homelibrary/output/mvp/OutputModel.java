package com.lantel.homelibrary.output.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.output.api.OutputBean;
import com.lantel.homelibrary.output.api.OutputService;
import com.lantel.homelibrary.output.api.StudentBean;
import com.lantel.homelibrary.output.api.StudentService;
import com.lantel.homelibrary.output.api.ZipOutputStudengtBean;
import com.xiao360.baselibrary.util.SpCache;
import java.util.List;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class OutputModel extends ViewModel {
    public Observable<ZipOutputStudengtBean> loadData(String page, String pageSize) {
        StudentService studentService = Http.getInstance().createRequest(StudentService.class);
        Observable<StudentBean> studentBeanObservable = studentService.getStudentData(HeaderUtil.getHeaderMap(), SpCache.getString(Config.UID,""));
        OutputService outputService = Http.getInstance().createRequest(OutputService.class);
        Observable<OutputBean> outputBeanObservable = outputService.getArtWorkDate(HeaderUtil.getHeaderMap(),"student_artworks?with=student_artwork_attachment&page="+page+"&pagesize="+pageSize);
        return Observable.zip(studentBeanObservable, outputBeanObservable,(StudentBean studentBean, OutputBean outputBean)->{
            ZipOutputStudengtBean zipOutputStudengtBean = new ZipOutputStudengtBean();
            zipOutputStudengtBean.setOutputError(outputBean.getError());
            zipOutputStudengtBean.setStudentError(studentBean.getError());
            zipOutputStudengtBean.setOutputMess(outputBean.getMessage());
            zipOutputStudengtBean.setStudentMess(studentBean.getMessage());
            zipOutputStudengtBean.setTotal(null == outputBean.getData()?0:outputBean.getData().getTotal());
            outputBean.getData().getTotal();
            List<OutputBean.DataBean.ListBean> outputbeanList = outputBean.getData().getList();
            if(null != outputbeanList)
            zipOutputStudengtBean.setOutputList(outputbeanList);

            List<StudentBean.DataBean.ListBean> studentbeanList = studentBean.getData().getList();
            if(null != studentbeanList)
                zipOutputStudengtBean.setStudentList(studentbeanList);

            return zipOutputStudengtBean;
        }).compose(RxHelper.io_main());
    }
}
