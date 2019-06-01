package com.lantel.mine.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.homelibrary.app.Config;
import com.lantel.mine.api.MineCardBean;
import com.lantel.mine.api.MineCardService;
import com.xiao360.baselibrary.util.SpCache;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class MineModel extends ViewModel {
    public Observable<MineCardBean> loadData() {
        MineCardService service = Http.getInstance().createRequest(MineCardService.class);
        return service.getCardData(HeaderUtil.getHeaderMap(), SpCache.getString(Config.UID,"")).compose(RxHelper.io_main());
    }
}
