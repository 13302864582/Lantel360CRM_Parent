package com.lantel.homelibrary.homework.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.homelibrary.homework.api.HomeWorkBean;
import com.lantel.homelibrary.homework.api.HomeWorkService;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class HomeWorkModel extends ViewModel {
    public Observable<HomeWorkBean> loadData(String sid,String page, String pageSize) {
        HomeWorkService studentService = Http.getInstance().createRequest(HomeWorkService.class);
        Observable<HomeWorkBean> finish = studentService.getHomeWorkDate(HeaderUtil.getHeaderMap(),sid,page,pageSize);
        return finish.compose(RxHelper.io_main());
    }
}
