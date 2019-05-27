package com.lantel.mine.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.mine.api.MineCardBean;
import com.lantel.mine.api.MineCardService;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class MineModel extends ViewModel {
    public Observable<MineCardBean> loadData(String uid) {
        MineCardService service = Http.getInstance().createRequest(MineCardService.class);
        return service.getCardData(uid).compose(RxHelper.io_main());
    }
}
