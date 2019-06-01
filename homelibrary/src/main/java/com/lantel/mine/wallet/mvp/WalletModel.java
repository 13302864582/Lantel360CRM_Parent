package com.lantel.mine.wallet.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.attence.api.AttenceService;
import com.lantel.mine.wallet.api.WalletService;
import com.xiao360.baselibrary.util.SpCache;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class WalletModel extends ViewModel {
    private String walletMoney;

    public String getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(String walletMoney) {
        this.walletMoney = walletMoney;
    }

    public Observable<ResponseBody> loadData(String page, String pageSize) {
        String sid = SpCache.getString(Config.SID,"");
        WalletService service = Http.getInstance().createRequest(WalletService.class);
        return service.getWalletListData(HeaderUtil.getHeaderMap(),sid,page,pageSize).compose(RxHelper.io_main());
    }

    public Observable<ResponseBody> loadMonthData(String month,String page, String pageSize) {
        String sid = SpCache.getString(Config.SID,"");
        WalletService service = Http.getInstance().createRequest(WalletService.class);
        return service.getWalletMonthData(HeaderUtil.getHeaderMap(),sid,month,page,pageSize).compose(RxHelper.io_main());
    }
}
