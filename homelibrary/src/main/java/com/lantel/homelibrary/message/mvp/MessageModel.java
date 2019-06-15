package com.lantel.homelibrary.message.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.homelibrary.message.api.MessageBean;
import com.lantel.homelibrary.message.api.MessageService;

import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;

public class MessageModel extends ViewModel {
    public Observable<MessageBean> loadData(String page, String pageSize) {
        MessageService service = Http.getInstance().createRequest(MessageService.class);
        return service.getMessageData(HeaderUtil.getHeaderMap(),page,pageSize).compose(RxHelper.io_main());
    }
}
