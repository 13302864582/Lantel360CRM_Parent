package com.lantel.homelibrary.homework;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.MyApplication;
import com.lantel.common.HeaderUtil;
import com.lantel.common.Lesson;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.homework.api.HomeWorkDetailFinishBean;
import com.lantel.homelibrary.homework.api.HomeWorkService;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.ToastUitl;
import com.zzhoujay.richtext.RichText;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantel/360/homework/detail")
public class HomeWorkDetailActivity extends BaseActivity{
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;

    @BindView(R2.id.head_img_task)
    ImageView headImgTask;
    @BindView(R2.id.name_task)
    TextView nameTask;
    @BindView(R2.id.text_classes_task)
    TextView textClassesTask;
    @BindView(R2.id.homewrok_start_time_task)
    TextView homewrokStartTimeTask;
    @BindView(R2.id.homewrok_end_time_task)
    TextView homewrokEndTimeTask;
    @BindView(R2.id.content_task)
    TextView contentTask;
    @BindView(R2.id.AlbumFileView_task)
    com.lantel.homelibrary.output.list.AlbumFileView AlbumFileViewTask;
    @BindView(R2.id.date_task)
    TextView dateTask;

    @BindView(R2.id.text_homework)
    TextView textHomework;
    @BindView(R2.id.head_img)
    ImageView headImg;
    @BindView(R2.id.name)
    TextView name;
    @BindView(R2.id.content)
    TextView content;
    @BindView(R2.id.AlbumFileView)
    com.lantel.homelibrary.output.list.AlbumFileView AlbumFileView;
    @BindView(R2.id.homewrok_deadline_time)
    TextView homewrokDeadlineTime;
    private int business_id;

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.homework_detail_finish;
    }

    @Override
    public void initView() {
        title.setText(R.string.title_homework_detail);
        business_id = getIntent().getIntExtra(Config.BUSINESS_ID,-1);
        /*if(business_id != -1){
            loadData(business_id);
            LogUtils.d("business_id=="+business_id);
        }*/
        loadData(6);
    }

    private void loadData(int business_id) {
        HomeWorkService homeWorkService = Http.getInstance().createRequest(HomeWorkService.class);
        homeWorkService.getHomeWorkDetailFinish(HeaderUtil.getHeaderMap(),business_id+"")
                .compose(RxHelper.io_main())
                .compose(bindToLifecycle())
                .subscribe(new BaseRxObserver<HomeWorkDetailFinishBean>() {
                    @Override
                    public void onSuccess(HomeWorkDetailFinishBean detailFinishBean) {
                        if(detailFinishBean.getError()==0){
                            HomeWorkDetailFinishBean.DataBean dataBean = detailFinishBean.getData();
                            if(null != dataBean){
                                HomeWorkDetailFinishBean.DataBean.HomeworkTaskBean taskBean = dataBean.getHomework_task();
                               //布置作业文本内容
                                if(!TextUtils.isEmpty(taskBean.getContent()))
                                    RichText.fromHtml(taskBean.getContent()).into(contentTask);

                                //布置作业开始日期
                                String stime = DisplayUtil.getFormateStr("yyyy-MM-dd HH:mm:ss","yyyy-MM-dd",taskBean.getCreate_time());
                                String start_time = String.format(getString(R.string.publish_time_format),stime);
                                if(!TextUtils.isEmpty(start_time))
                                homewrokStartTimeTask.setText(start_time);

                                //布置作业截止日期
                                String etime = DisplayUtil.getFormateStr("yyyyMMdd","yyyy-MM-dd",taskBean.getDeadline()+"");
                                String end_time = String.format(getString(R.string.deadline_time_format),etime);
                                if(!TextUtils.isEmpty(end_time))
                                homewrokEndTimeTask.setText(end_time);

                                HomeWorkDetailFinishBean.DataBean.HomeworkTaskBean.EmployeeBean employeeBean=taskBean.getEmployee();
                                if(null != employeeBean){
                                    //布置作业老师
                                    String name = employeeBean.getEname();
                                    if(!TextUtils.isEmpty(name))
                                        nameTask.setText(name);
                                    //布置作业头像
                                    String photo_url = employeeBean.getPhoto_url();
                                    if(!TextUtils.isEmpty(photo_url))
                                        GlideUtils.loadCircle(HomeWorkDetailActivity.this,photo_url,headImgTask);
                                }
                                //布置作业班级,没有班级显示课程
                                HomeWorkDetailFinishBean.DataBean.OneClassBean oneClassBean = dataBean.getOne_class();
                                if(null != oneClassBean){
                                    String class_name = oneClassBean.getClass_name();
                                    if(null != class_name)
                                       textClassesTask.setText(class_name);
                                }else {
                                    MyApplication application = (MyApplication)getApplication();
                                    List<Lesson> lessonList = application.getLessonList();
                                    if(null != lessonList && lessonList.size()>0){
                                        for(Lesson lesson : lessonList){
                                            if(lesson.getLid() == dataBean.getLid()){
                                                textClassesTask.setText(lesson.getLesson_name());
                                            }
                                        }
                                    }
                                }

                                //设置附件数据
                                List<HomeWorkDetailFinishBean.DataBean.HomeworkTaskBean.HomeworkAttachmentBean> taskHomework_attachment = taskBean.getHomework_attachment();
                                Map<String,ArrayList<MediaModel>> map = new HashMap<>();

                                ArrayList<MediaModel> images = new ArrayList<>();
                                map.put(Config.IMG_LIST,images);

                                ArrayList<MediaModel> files = new ArrayList<>();
                                map.put(Config.FILE_LIST,files);

                                ArrayList<MediaModel> records = new ArrayList<>();
                                map.put(Config.RECORD_LIST,records);
                                if(null != taskHomework_attachment && taskHomework_attachment.size()>0){
                                    for(HomeWorkDetailFinishBean.DataBean.HomeworkTaskBean.HomeworkAttachmentBean attachmentBean : taskHomework_attachment){
                                        int mediaType = getMediaType(attachmentBean.getMedia_type());
                                        MediaModel mediaModel = new MediaModel();
                                        mediaModel.setFile_name(attachmentBean.getFile_name());
                                        mediaModel.setFile_size(attachmentBean.getFile_size());
                                        mediaModel.setType(mediaType);
                                        mediaModel.setDuration(attachmentBean.getDuration());
                                        mediaModel.setFile_type(attachmentBean.getFile_type());
                                        mediaModel.setFile_url(attachmentBean.getFile_url());
                                        if(mediaType==Config.PHOTO || mediaType==Config.VIDEO)
                                            map.get(Config.IMG_LIST).add(mediaModel);
                                        else if(mediaType==Config.FILE){
                                            map.get(Config.FILE_LIST).add(mediaModel);
                                        }else if(mediaType==Config.RECORD){
                                            map.get(Config.RECORD_LIST).add(mediaModel);
                                        }
                                    }
                                    setUpAttachFile(map);
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        ToastUitl.showShort(R.string.net_error);
                    }
                });
    }

    private void setUpAttachFile(Map<String, ArrayList<MediaModel>> map) {
        AlbumFileViewTask.bindImageList(map.get(Config.IMG_LIST));
        AlbumFileViewTask.bindFileList(map.get(Config.FILE_LIST),map.get(Config.RECORD_LIST));
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

    @OnClick(R2.id.back)
    public void onViewClicked(View v) {
        int id = v.getId();
        if(id == R.id.back){
            finish();
        }
    }
}
