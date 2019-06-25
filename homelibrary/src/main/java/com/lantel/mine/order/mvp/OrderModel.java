package com.lantel.mine.order.mvp;

import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.mine.order.api.OrderBean;
import com.lantel.mine.order.api.OrderService;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;


public class OrderModel extends ViewModel {
    public Observable<OrderBean> loadOrderData(String page, String pageSize) {
        OrderService service = Http.getInstance().createRequest(OrderService.class);
        return service.getOrderListData(HeaderUtil.getJsonHeaderMap(),page,pageSize).compose(RxHelper.io_main());
    }
}
