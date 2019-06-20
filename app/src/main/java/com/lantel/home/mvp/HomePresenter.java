package com.lantel.home.mvp;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.common.list.model.SimpleMenuModel;
import com.lantel.crmparent.R;
import com.lantel.home.api.HomeBean;
import com.lantel.home.api.HomeMessageBean;
import com.lantel.home.api.HomeService;
import com.lantel.home.api.HomeTopModel;
import com.lantel.homelibrary.notify.api.NotifyBean;
import com.lantel.homelibrary.notify.api.NotifyService;
import com.lantel.mine.api.MineCardBean;
import com.lantel.mine.list.model.ChangeAccountBean;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.LogUtils;
import java.util.ArrayList;
import java.util.List;

public class HomePresenter extends HomeContract.Presenter{
    @Override
    public void onCrete(Bundle savedInstanceState) {
        LogUtils.d("onCrete: ");
    }

    //onActivityCreated
    @Override
    public void onCrete() {
        LogUtils.d("onActivityCreated: ");
    }

    @Override
    public void onStart() {
        LogUtils.d("onStart: ");
    }

    @Override
    public void onResume() {
        LogUtils.d("onResume: ");
    }

    @Override
    public void onPause() {
        LogUtils.d("onPause: ");
    }

    @Override
    public void onStop() {
        LogUtils.d("onStop: ");
    }

    @Override
    public void onDestroy() {
        LogUtils.d("onCrete: ");
    }

    public void initMenu() {
        //添加菜单数据
        ArrayList<SimpleMenuModel> menu = new ArrayList<>();
        Resources resources = context.getResources();
        String[] titles = resources.getStringArray(R.array.home_menu_title);
        String[] router_paths = resources.getStringArray(R.array.home_menu_router_path);
        TypedArray icons = resources.obtainTypedArray(R.array.home_menu_icon);
        for (int i = 0; i < titles.length; i++) {
            SimpleMenuModel menuModel = new SimpleMenuModel();
            menuModel.setTitle(titles[i]);
            menuModel.setImgRes(icons.getResourceId(i,0));
            menuModel.setRouterpath(router_paths[i]);
            menu.add(menuModel);
        }
        mView.initMenuData(menu);
    }

    public void laodHomeTop() {
        HomeService homeService = Http.getInstance().createRequest(HomeService.class);
        homeService.getHomeData(HeaderUtil.getJsonHeaderMap())
                .compose(RxHelper.io_main())
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<HomeBean>() {
                    @Override
                    public void onSuccess(HomeBean homeBean) {
                        int error = homeBean.getError();
                        if(error == 0){
                            HomeTopModel homeTopModel = new HomeTopModel();
                            HomeBean.DataBean dataBean = homeBean.getData();
                            ArrayList<ChangeAccountBean> changeAccountBeans = new ArrayList<>();
                            if (null != dataBean) {
                                homeTopModel.setOrg_name(dataBean.getOrg_name());
                                homeTopModel.setBranch_address(dataBean.getBranch_address());
                                homeTopModel.setBranch_name(dataBean.getBranch_name());
                                homeTopModel.setBranch_tel(dataBean.getBranch_tel());
                                homeTopModel.setRecommend_cover(dataBean.getRecommend_cover());
                                if(null != dataBean.getStudent()){
                                    homeTopModel.setStudent_img(dataBean.getStudent().getPhoto_url());
                                    homeTopModel.setStudent_name(dataBean.getStudent().getStudent_name());
                                }

                                if(null != dataBean.getStudents()){
                                    List<HomeBean.DataBean.StudentsBean> studentsBean = dataBean.getStudents();

                                    for(HomeBean.DataBean.StudentsBean listBean : studentsBean){
                                        ChangeAccountBean accountBean = new ChangeAccountBean();
                                        accountBean.setSid(listBean.getSid()+"");
                                        accountBean.setPhoto_url(listBean.getPhoto_url());
                                        accountBean.setStudent_name(listBean.getStudent_name());
                                        changeAccountBeans.add(accountBean);
                                    }
                                }
                            }
                            mView.updateTopView(homeTopModel,changeAccountBeans);
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                });

        homeService.getMessageData(HeaderUtil.getJsonHeaderMap())
                .compose(RxHelper.io_main())
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<HomeMessageBean>() {
                    @Override
                    public void onSuccess(HomeMessageBean bean) {
                        if(bean.getError()==0){
                            HomeMessageBean.DataBean dataBean =  bean.getData();
                            if(null != dataBean){
                                int today_num = dataBean.getToday_msg_num();
                                mView.setUpNotifyMessage(today_num);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                });
    }

    public void laodNotifyText() {
        NotifyService notifyService = Http.getInstance().createRequest(NotifyService.class);
        notifyService.getNotifyData(HeaderUtil.getHeaderMap(),String.valueOf(1),String.valueOf(10))
                .compose(RxHelper.io_main())
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<NotifyBean>() {
                    @Override
                    public void onSuccess(NotifyBean data) {
                        List<String> list = new ArrayList<>();
                        NotifyBean.DataBean dataBean = data.getData();
                        if(null != dataBean && null != dataBean.getList()){
                                for(NotifyBean.DataBean.ListBean listBean : dataBean.getList()){
                                    list.add(listBean.getTitle());
                                }
                        }
                        mView.setNotifyText(list);
                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                });
    }
}
