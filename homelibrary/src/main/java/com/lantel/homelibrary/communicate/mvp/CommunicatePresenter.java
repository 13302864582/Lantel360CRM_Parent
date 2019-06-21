package com.lantel.homelibrary.communicate.mvp;

import android.os.Bundle;

import com.httpsdk.http.RxHelper;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.communicate.api.CommitChatReq;
import com.lantel.homelibrary.communicate.api.CommunicateBean;
import com.lantel.homelibrary.communicate.list.model.ItemModel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.SpCache;
import com.xiao360.baselibrary.util.ToastUitl;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class CommunicatePresenter extends CommunicateContract.Presenter<CommunicateBean, ItemModel> {
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

    @Override
    protected void showLoading() {
        mView.showLoading();
    }

    @Override
    protected void ViewSetLoadMoreData(ArrayList<ItemModel> list) {
        mView.setLoadMoreData(list);
    }

    @Override
    protected void ViewRefreshData(ArrayList<ItemModel> list) {
        mView.refreshData(list);
    }

    @Override
    protected void showEmpty() {
        mView.showEmpty();
    }

    @Override
    protected int getTotal(CommunicateBean data) {
        if(null == data.getData())
            return 0;
        return data.getData().getList().size();
    }

    @Override
    protected int getErrorCode(CommunicateBean data) {
        return data.getError();
    }
    @Override
    protected String getErrorMessage(CommunicateBean data) {
        return data.getMessage();
    }

    @Override
    protected void setUpData(ArrayList<ItemModel> list, CommunicateBean data) {
        List<CommunicateBean.DataBean.ListBean> listBeans = data.getData().getList();
        if(null!=listBeans && listBeans.size()>0){
            for(CommunicateBean.DataBean.ListBean listBean : listBeans){
                ItemModel model = new ItemModel();
                boolean isMine = listBean.getSend_type()==0;
                model.setType(isMine?Config.MINE:Config.OTHER);
                model.setContent(listBean.getMessage());
                model.setTime(listBean.getCreate_time());
                //设置名字，头像
                if(isMine){
                    CommunicateBean.DataBean.ListBean.StudentBean studentBean = listBean.getStudent();
                    if(null != studentBean){
                        model.setTitle(studentBean.getStudent_name());
                        model.setHeadImg(studentBean.getPhoto_url());
                    }
                }else {
                    CommunicateBean.DataBean.ListBean.EmployeeBean employeeBean = listBean.getEmployee();
                    if(null != employeeBean){
                        model.setTitle(employeeBean.getEname());
                        model.setHeadImg(employeeBean.getPhoto_url());
                    }
                }
                list.add(model);
            }
        }

    }

    @Override
    protected Observable<CommunicateBean> getObserver(boolean isMore) {
        String timeUrl = mView.getTimeUrl(isMore);
        return mModel.loadData(timeUrl);
    }

    @Override
    public void setUpCurrentPage(boolean isLoadMore) {

    }

    public void commitMessage(String content) {
        CommitChatReq req = new CommitChatReq();
        req.setSid(Integer.valueOf(SpCache.getString(Config.SID,"0")));
        req.setMessage(content);
        req.setMessage_type(0);
        req.setApp_client_id(2);
        req.setSend_type(0);
        mModel.commitData(req)
                .compose(RxHelper.io_main())
                .compose(context.bindToLifecycle())
                .subscribe(new BaseRxObserver<CommunicateBean>() {
                    @Override
                    public void onSuccess(CommunicateBean demo) {
                        onLoadMore(null);
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        ToastUitl.showShort(R.string.mess_error);
                    }
                });
    }
}
