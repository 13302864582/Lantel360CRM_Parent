package com.lantel.studylibrary.preview.preview;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.excellence.downloader.Downloader;
import com.excellence.downloader.exception.DownloadError;
import com.excellence.downloader.utils.IListener;
import com.google.gson.Gson;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.MyApplication;
import com.lantel.common.ClassRoom;
import com.lantel.common.HeaderUtil;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.studylibrary.preview.preview.api.PreviewDetailBean;
import com.lantel.studylibrary.preview.preview.api.PreviewService;
import com.lantel.studylibrary.preview.preview.list.AttachFileListener;
import com.lantel.studylibrary.preview.preview.list.adpter.AttachFileAdapter;
import com.lantel.studylibrary.preview.preview.list.model.AttachFile;
import com.lantel.studylibrary.preview.preview.list.model.PreviewDetailModel;
import com.ldoublem.loadingviewlib.view.LVFunnyBar;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;
import com.zzhoujay.richtext.RichText;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;

@Route(path = "/lantel/360/preview/detail")
public class PreviewDetailActivity extends BaseActivity implements AttachFileListener {
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.course_title)
    TextView courseTitle;
    @BindView(R2.id.date)
    TextView date;
    @BindView(R2.id.time)
    TextView time;
    @BindView(R2.id.classes)
    TextView classes;
    @BindView(R2.id.teacher)
    TextView teacher;
    @BindView(R2.id.detail)
    TextView detail;
    @BindView(R2.id.content)
    TextView content;
    @BindView(R2.id.preview_file)
    TextView previewFile;
    @BindView(R2.id.preview_file_list)
    RecyclerView previewFileList;
    @BindView(R2.id.text_right)
    TextView textRight;
    @BindView(R2.id.progress_bar)
    LVFunnyBar progressBar;
    @BindView(R2.id.progress_text)
    TextView progressText;
    @BindView(R2.id.progress_lay)
    ConstraintLayout progressLay;

    private AttachFileAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 注册
        Downloader.register(this);
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.preview_detail;
    }

    @Override
    public void initView() {
        textRight.setText(R.string.leave);
        title.setText(R.string.preview_detail);
        String ca_id = "";
        if (null != getIntent())
            ca_id = getIntent().getStringExtra(Config.CA_ID);
        if (!TextUtils.isEmpty(ca_id)) {
            loadDetail(ca_id)
                    .subscribe(new BaseRxObserver<PreviewDetailBean>() {
                        @Override
                        public void onSuccess(PreviewDetailBean bean) {
                            int total = bean.getData().getTotal();
                            if (total != 0) {
                                PreviewDetailBean.DataBean.ListBean listBean = bean.getData().getList().get(0);
                                PreviewDetailBean.DataBean.ListBean.StudentLeaveBean student_leave = listBean.getStudent_leave();
                                boolean canLeave = listBean.getCan_leave() == 1 && null == student_leave;
                                textRight.setVisibility(canLeave?View.VISIBLE:View.GONE);
                                PreviewDetailModel detailModel = new PreviewDetailModel();
                                PreviewDetailBean.DataBean.ListBean.OneClassBean oneClassBean = listBean.getOne_class();
                                PreviewDetailBean.DataBean.ListBean.LessonBean lessonBean = listBean.getLesson();
                                PreviewDetailBean.DataBean.ListBean.TeacherBean teacherBean = listBean.getTeacher();
                                PreviewDetailBean.DataBean.ListBean.CoursePrepareBean coursePrepareBean = listBean.getCourse_prepare();
                                String start = DisplayUtil.getTimeString(listBean.getInt_start_hour() + "");
                                String end = DisplayUtil.getTimeString(listBean.getInt_end_hour() + "");
                                String date = listBean.getInt_day() + "";

                                int cr_id = listBean.getCr_id();
                                String roomName = getClassRoomName(cr_id);
                                detailModel.setCourseName(lessonBean.getLesson_name());

                                if (null != oneClassBean) {
                                    detailModel.setClasses(oneClassBean.getClass_name());
                                } else if (!TextUtils.isEmpty(roomName)) {
                                    detailModel.setClasses(roomName);
                                } else
                                    detailModel.setClasses("-");

                                detailModel.setTeacher(teacherBean.getEname());
                                detailModel.setDate(DisplayUtil.getDateString(date));
                                detailModel.setTime(start + "-" + end);
                                detailModel.setShort_desc(lessonBean.getShort_desc());

                                if (null != coursePrepareBean) {
                                    detailModel.setCourse_content(coursePrepareBean.getContent());
                                    List<PreviewDetailBean.DataBean.ListBean.CoursePrepareBean.CoursePrepareAttachmentBean> attachmentBeanList = coursePrepareBean.getCourse_prepare_attachment();
                                    if (null != attachmentBeanList && attachmentBeanList.size() > 0) {
                                        List<AttachFile> attachFiles = new ArrayList<>();
                                        for (PreviewDetailBean.DataBean.ListBean.CoursePrepareBean.CoursePrepareAttachmentBean attachmentBean : attachmentBeanList) {
                                            AttachFile file = new AttachFile();
                                            file.setTitle(attachmentBean.getFile_name());
                                            file.setFile_type(attachmentBean.getMedia_type());
                                            file.setFile_url(attachmentBean.getFile_url());
                                            file.setFile_size(attachmentBean.getFile_size());
                                            attachFiles.add(file);
                                        }
                                        detailModel.setAttachFiles(attachFiles);
                                    }
                                }
                                updateView(detailModel);
                            }
                        }

                        @Override
                        public void onFailure(Throwable e) {

                        }
                    });
        }
    }

    private void updateView(PreviewDetailModel previewDetailModel) {
        courseTitle.setText(previewDetailModel.getCourseName());
        date.setText(previewDetailModel.getDate());
        time.setText(String.format(getString(R.string.preview_time_format), previewDetailModel.getTime()));
        classes.setText(String.format(getString(R.string.preview_class_format), previewDetailModel.getClasses()));
        teacher.setText(String.format(getString(R.string.preview_teacher_format), previewDetailModel.getTeacher()));
        detail.setText(String.format(getString(R.string.preview_desc_format), previewDetailModel.getShort_desc()));
        String contentStr = previewDetailModel.getCourse_content();
        RichText.fromHtml(TextUtils.isEmpty(contentStr) ? "-" : contentStr).into(content);
        List<AttachFile> attachFiles = previewDetailModel.getAttachFiles();
        if (null != attachFiles) {
            mAdapter = new AttachFileAdapter(this, attachFiles);
            mAdapter.setListener(this);
            previewFileList.setLayoutManager(new GridLayoutManager(this, 2));
            previewFileList.setAdapter(mAdapter);
        }
    }

    private String getClassRoomName(int cr_id) {
        MyApplication application = (MyApplication) getApplication();
        List<ClassRoom> classRoomList = application.getClassRoom();
        if(null != classRoomList)
        for (ClassRoom classRoom : classRoomList) {
            if (classRoom.getCr_id() == cr_id)
                return classRoom.getRoom_name();
        }
        return "";
    }

    @OnClick({R2.id.back, R2.id.text_right})
    public void onViewClicked(View v) {
        int id = v.getId();
        if (id == R.id.back) {
            finish();
        } else if (id == R.id.text_right) {

        }
    }

    public Observable<PreviewDetailBean> loadDetail(String ca_id) {
        PreviewService service = Http.getInstance().createRequest(PreviewService.class);
        String url = "course_arranges?with=one_class,course_prepare.course_prepare_attachment&ca_id=" + ca_id;
        return service.getPrepareDetail(HeaderUtil.getHeaderMap(), url)
                .compose(RxHelper.io_main())
                .compose(bindToLifecycle());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解绑
        Downloader.unregister(this);
        // 暂停所有下载任务，使用文件长度保存断点
        Downloader.destroy();
    }

    private void downLoad(File file, String DownloadURL, int position) {
        // 文件路径，下载链接，监听接口可以使用IListener接口，也可以使用Listener监听部分回调
        Downloader.addTask(file, DownloadURL, new IListener() {
            @Override
            public void onPreExecute(long fileSize) {
                progressLay.setVisibility(View.VISIBLE);
                progressBar.startAnim();
                progressText.setText("0%");
            }

            @Override
            public void onProgressChange(long fileSize, long downloadedSize) {
                int progress = (int) ((float)downloadedSize/fileSize * 100);
                progressText.setText(progress+"%");
            }

            @Override
            public void onProgressChange(long fileSize, long downloadedSize, long speed) {
                int progress = (int) ((float)downloadedSize/fileSize * 100);
                progressText.setText(progress+"%");
            }

            @Override
            public void onCancel() {
                progressLay.setVisibility(View.GONE);
            }

            @Override
            public void onError(DownloadError error) {
                progressLay.setVisibility(View.GONE);
            }

            @Override
            public void onSuccess() {
                progressLay.setVisibility(View.GONE);
                mAdapter.notifyItemChanged(position);
            }
        });
    }

    @Override
    public void downLoadFile(File file, String url, int position) {
        downLoad(file, url, position);
    }
}
