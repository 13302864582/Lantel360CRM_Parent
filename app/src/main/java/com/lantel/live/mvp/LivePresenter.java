package com.lantel.live.mvp;

import android.os.Bundle;

import com.lantel.live.api.LiveBean;
import com.lantel.live.list.model.LiveCardModel;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

public class LivePresenter extends LiveContract.Presenter<LiveBean, LiveCardModel> {
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
    protected void setUpData(ArrayList<LiveCardModel> list, LiveBean data) {
        List<LiveBean.DataBean.ListBean> listBeans = data.getData().getList();
        for(LiveBean.DataBean.ListBean listBean : listBeans){
            LiveCardModel model = new LiveCardModel();
            LiveBean.DataBean.ListBean.LessonBean lessonBean = listBean.getLesson();
            model.setClasses_time(DisplayUtil.getFormateStr("yyyyMMdd","yyyy-MM-dd",listBean.getStart_int_day()+""));
            if(null != lessonBean){
                model.setHeaImg(lessonBean.getLesson_cover_picture());
                model.setClasses_name(lessonBean.getLesson_name());
            }
            model.setAccount(listBean.getAccount());
            model.setRoom_id(listBean.getRoomID()+"");
            setPrice(listBean,model);
            list.add(model);
        }
    }

    private void setPrice(LiveBean.DataBean.ListBean listBean, LiveCardModel model) {
        int price_type = listBean.getPrice_type();
        //1:按课次计费,2:课时收费,3:按时间收费
        int all_times = 0;
        int prsent_times = 0;
        switch (price_type){
            case 1:
                 all_times = listBean.getLesson_times();
                prsent_times = all_times - listBean.getRemain_times();
                break;
            case 2:
                all_times = Float.valueOf(listBean.getLesson_hours()).intValue();
                prsent_times = all_times - Float.valueOf(listBean.getRemain_lesson_hours()).intValue();
                break;
        }
        model.setPercent(prsent_times);
        model.setTotal(all_times);
    }

    @Override
    protected int getErrorCode(LiveBean data) {
        return data.getError();
    }

    @Override
    protected String getErrorMessage(LiveBean data) {
        return data.getMessage();
    }

    @Override
    protected Observable<LiveBean> getObserver(boolean isMore) {
        if(!isMore)
            return mModel.loadData(String.valueOf(1),String.valueOf(10));
        else
            return mModel.loadData(String.valueOf(mCurrentPage+1),String.valueOf(10));
    }

    @Override
    protected void showLoading() {
        mView.showLoading();
    }

    @Override
    protected void ViewSetLoadMoreData(ArrayList<LiveCardModel> list) {
        mView.setLoadMoreData(list);
    }

    @Override
    protected void ViewRefreshData(ArrayList<LiveCardModel> list) {
        mView.refreshData(list);
    }

    @Override
    protected void showEmpty() {
        mView.showEmpty();
    }

    @Override
    protected int getTotal(LiveBean data) {
        LiveBean.DataBean dataBean = data.getData();
        if(null == dataBean || null == dataBean.getList())
            return 0;
        return dataBean.getList().size();
    }
}
