package com.lantel.setting.bindfile.bindstudent.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.homelibrary.app.Config;
import com.lantel.setting.bindfile.bindstudent.api.BindStudentBean;
import com.lantel.setting.bindfile.bindstudent.api.BindStudentService;
import com.xiao360.baselibrary.util.SpCache;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class BindStudentModel extends ViewModel {
    public Observable<BindStudentBean> loadData() {
        BindStudentService service = Http.getInstance().createRequest(BindStudentService.class);
        return service.getAccountData(HeaderUtil.getHeaderMap(), SpCache.getString(Config.UID,"0")).compose(RxHelper.io_main());
    }
}
