package com.lantel.studylibrary.preview.preview.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.homelibrary.app.Config;
import com.lantel.studylibrary.classes.api.ClassBean;
import com.lantel.studylibrary.preview.preview.api.PreviewBean;
import com.lantel.studylibrary.preview.preview.api.PreviewDetailBean;
import com.lantel.studylibrary.preview.preview.api.PreviewService;
import com.xiao360.baselibrary.util.SpCache;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class PreviewModel extends ViewModel {
    public Observable<PreviewBean> loadData(String page, String pageSize) {
        String sid = SpCache.getString(Config.SID,"");
        PreviewService service = Http.getInstance().createRequest(PreviewService.class);
        return service.getPrepareData(HeaderUtil.getHeaderMap(),"one_class",sid,page,pageSize).compose(RxHelper.io_main());
    }
}
