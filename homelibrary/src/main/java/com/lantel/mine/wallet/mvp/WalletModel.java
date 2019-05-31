package com.lantel.mine.wallet.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.homelibrary.attence.api.AttenceService;
import com.lantel.mine.wallet.api.WalletService;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class WalletModel extends ViewModel {
    private String walletMoney;
    private String sid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(String walletMoney) {
        this.walletMoney = walletMoney;
    }

    public Observable<ResponseBody> loadData(String sid,String page, String pageSize) {
        WalletService service = Http.getInstance().createRequest(WalletService.class);
        return service.getWalletListData(sid,page,pageSize).compose(RxHelper.io_main());
    }

    public Observable<ResponseBody> loadMonthData(String sid,String month,String page, String pageSize) {
        WalletService service = Http.getInstance().createRequest(WalletService.class);
        return service.getWalletMonthData(sid,month,page,pageSize).compose(RxHelper.io_main());
    }
}
