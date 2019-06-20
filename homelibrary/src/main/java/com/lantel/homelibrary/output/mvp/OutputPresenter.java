package com.lantel.homelibrary.output.mvp;

import android.os.Bundle;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.output.api.OutputBean;
import com.lantel.homelibrary.output.api.StudentBean;
import com.lantel.homelibrary.output.api.ZipOutputStudengtBean;
import com.lantel.homelibrary.output.list.model.CardOutputModel;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.SpCache;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import io.reactivex.Observable;

public class OutputPresenter extends OutputContract.Presenter<ZipOutputStudengtBean, CardOutputModel> {
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
    protected void ViewSetLoadMoreData(ArrayList<CardOutputModel> list) {
        mView.setLoadMoreData(list);
    }

    @Override
    protected void ViewRefreshData(ArrayList<CardOutputModel> list) {
        mView.refreshData(list);
    }

    @Override
    protected void showEmpty() {
        mView.showEmpty();
    }

    @Override
    protected int getTotal(ZipOutputStudengtBean data) {
        return data.getTotal();
    }

    @Override
    protected int getErrorCode(ZipOutputStudengtBean data) {
        return data.getOutputError();
    }

    @Override
    protected void setUpData(ArrayList<CardOutputModel> list, ZipOutputStudengtBean data) {
        String headImg = "";
        List<StudentBean.DataBean.ListBean> listBeans = data.getStudentList();
        if(null!=listBeans)
            for(StudentBean.DataBean.ListBean bean : listBeans){
                if(bean.getSid().equals(SpCache.getString(Config.SID,"")))
                    headImg =bean.getPhoto_url();
            }

        List<OutputBean.DataBean.ListBean> outputBeanList= data.getOutputList();
        if(null != outputBeanList){
            for(OutputBean.DataBean.ListBean bean : outputBeanList){
                CardOutputModel cardOutputModel= new CardOutputModel();
                cardOutputModel.setHeadImg(headImg);
                Date date = DisplayUtil.formatIntDay("yyyy-MM-dd HH:mm:ss",bean.getCreate_time());
                cardOutputModel.setTime(DisplayUtil.praseformatIntDay("MM-dd",date));
                cardOutputModel.setContent(bean.getArt_desc());
                cardOutputModel.setTitle(bean.getArt_name());
                    //假数据
                    cardOutputModel.setClasses("没数据");
                    cardOutputModel.setAdress("没数据");

               List<OutputBean.DataBean.ListBean.StudentArtworkAttachmentBean> student_artwork_attachments = bean.getStudent_artwork_attachment();
                Map<String,ArrayList<MediaModel>> map = new HashMap<>();

                ArrayList<MediaModel> images = new ArrayList<>();
                map.put(Config.IMG_LIST,images);

                ArrayList<MediaModel> files = new ArrayList<>();
                map.put(Config.FILE_LIST,files);

                ArrayList<MediaModel> records = new ArrayList<>();
                map.put(Config.RECORD_LIST,records);

                if(null != student_artwork_attachments){
                    for(OutputBean.DataBean.ListBean.StudentArtworkAttachmentBean attachmentBean : student_artwork_attachments){
                        int mediaType = getMediaType(attachmentBean.getMedia_type());
                        MediaModel mediaModel = new MediaModel();
                        mediaModel.setFile_name(attachmentBean.getFile_name());
                        mediaModel.setFile_size(attachmentBean.getFile_size());
                        mediaModel.setType(mediaType);
                        mediaModel.setDuration(attachmentBean.getDuration());
                        mediaModel.setFile_type(attachmentBean.getFile_type());
                        mediaModel.setFile_url(attachmentBean.getFile_url());
                        mediaModel.setLocal(false);
                        if(mediaType==Config.PHOTO || mediaType==Config.VIDEO)
                            map.get(Config.IMG_LIST).add(mediaModel);
                        else if(mediaType==Config.FILE){
                            map.get(Config.FILE_LIST).add(mediaModel);
                        }else if(mediaType==Config.RECORD){
                            map.get(Config.RECORD_LIST).add(mediaModel);
                        }
                    }
                    cardOutputModel.setMap(map);
                }
               list.add(cardOutputModel);
            }
        }
    }

    private int getMediaType(String mediaType) {
        if(mediaType.equals(Config.MEDIA_IMG)){
            return Config.PHOTO;
        }else if(mediaType.equals(Config.MEDIA_VIDEO)){
            return Config.VIDEO;
        }else if(mediaType.equals(Config.MEDIA_RECORD)){
            return Config.RECORD;
        }else
        return Config.FILE;
    }

    @Override
    protected String getErrorMessage(ZipOutputStudengtBean data) {
        return data.getOutputMess();
    }

    @Override
    protected Observable<ZipOutputStudengtBean> getObserver(boolean isMore) {
        if(!isMore)
            return mModel.loadData(String.valueOf(1),String.valueOf(10));
        else
            return mModel.loadData(String.valueOf(mCurrentPage+1),String.valueOf(10));
    }
}
