package com.lantel.homelibrary.homework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.transition.SidePropagation;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.MyApplication;
import com.lantel.common.HeaderUtil;
import com.lantel.common.Lesson;
import com.lantel.common.PhotoSelectListener;
import com.lantel.common.PopUtil;
import com.lantel.common.list.model.MediaModel;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.homelibrary.homework.api.CommitHomeReq;
import com.lantel.homelibrary.homework.api.HomeWorkDetailFinishBean;
import com.lantel.homelibrary.homework.api.HomeWorkService;
import com.lantel.homelibrary.homework.api.HomeworkAttachmentBean;
import com.lantel.homelibrary.homework.api.UpLoadAttach;
import com.lantel.homelibrary.homework.api.UploadResponeBean;
import com.lantel.homelibrary.homework.list.adpter.ClickAddListener;
import com.lantel.homelibrary.homework.list.adpter.MediaFileAdapter;
import com.lantel.homelibrary.output.list.AlbumFileView;
import com.lantel.setting.bindAccount.api.BindAccountBean;
import com.lantel.setting.personal.SettingPersonFragment;
import com.lantel.setting.personal.api.UploadBean;
import com.lantel.setting.personal.api.UploadService;
import com.ldoublem.loadingviewlib.view.LVFunnyBar;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.util.DisplayUtil;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.MediaBean;
import com.xiao360.baselibrary.util.PhotoUtil;
import com.xiao360.baselibrary.util.SpCache;
import com.xiao360.baselibrary.util.ToastUitl;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;
import com.zzhoujay.richtext.RichText;

import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

@Route(path = "/lantel/360/homework/detail")
public class HomeWorkDetailActivity extends BaseActivity implements ClickAddListener, PhotoSelectListener {
    //获取视频信息
    String[] projectionVideo = new String[]{
            MediaStore.Video.Media.DISPLAY_NAME,
            MediaStore.Video.Media.SIZE,
            MediaStore.Video.Media.DATA,//绝对路径
            MediaStore.Video.Media.DURATION
    };

    //获取圖片信息
    String[] projectionImg = new String[]{
            MediaStore.Images.Media.DATA,//绝对路径
    };

    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.text_right)
    TextView textRight;

    @BindView(R2.id.card_task)
    CardView card_task;
    @BindView(R2.id.head_img_task)
    ImageView headImgTask;
    @BindView(R2.id.name_task)
    TextView nameTask;
    @BindView(R2.id.text_classes_task)
    TextView textClassesTask;
    @BindView(R2.id.text_homework)
    TextView textHomework;
    @BindView(R2.id.homewrok_start_time_task)
    TextView homewrokStartTimeTask;
    @BindView(R2.id.homewrok_end_time_task)
    TextView homewrokEndTimeTask;
    @BindView(R2.id.content_task)
    TextView contentTask;
    @BindView(R2.id.AlbumFileView_task)
    AlbumFileView AlbumFileViewTask;

    @BindView(R2.id.card_respone)
    CardView cardRespone;
    @BindView(R2.id.head_img_respone)
    ImageView head_img_respone;
    @BindView(R2.id.name_respone)
    TextView name_respone;
    @BindView(R2.id.content_respone)
    TextView content_respone;
    @BindView(R2.id.AlbumFileView_respone)
    AlbumFileView AlbumFileView_respone;
    @BindView(R2.id.homewrok_deadline_time_respone)
    TextView homewrok_deadline_time_respone;

    @BindView(R2.id.card_commit)
    CardView cardCommit;
    @BindView(R2.id.commit_list)
    RecyclerView cardCommitList;
    @BindView(R2.id.commit_edit)
    EditText commit_edit;
    @BindView(R2.id.select_lay)
    LinearLayout select_lay;

    @BindView(R2.id.commit_record)
    ImageView commit_record;
    @BindView(R2.id.commit_img)
    ImageView commit_img;
    @BindView(R2.id.commit_video)
    ImageView commit_video;
    @BindView(R2.id.commit_cancel)
    ImageView commit_cancel;
    @BindView(R2.id.progress_bar)
    LVFunnyBar progressBar;
    @BindView(R2.id.progress_text)
    TextView progressText;
    @BindView(R2.id.progress_lay)
    ConstraintLayout progressLay;

    private int business_id;
    private boolean isFinish;
    private MediaFileAdapter mCommitAdapter;
    private Uri photoUri;

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
        textRight.setText(R.string.upload);
        textRight.setVisibility(isFinish?View.GONE:View.VISIBLE);
        textRight.setOnClickListener((View view) -> {
            closeInputMethod(commit_edit);
            upLoadHomeWork();
        });
        business_id = getIntent().getIntExtra(Config.BUSINESS_ID, -1);
        isFinish = getIntent().getBooleanExtra(Config.IS_FINISH, false);
        if (isFinish) {
            cardRespone.setVisibility(View.VISIBLE);
            cardCommit.setVisibility(View.GONE);
        } else {
            cardCommitList.setLayoutManager(new GridLayoutManager(this, 4));
            List<MediaModel> mediaModelList = new ArrayList<>();
            mCommitAdapter = new MediaFileAdapter(this, mediaModelList);
            mCommitAdapter.setAddListener(this);
            cardCommitList.setAdapter(mCommitAdapter);

            cardRespone.setVisibility(View.GONE);
            cardCommit.setVisibility(View.VISIBLE);
            commit_record.setOnClickListener((View view) -> {
                Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
                startActivityForResult(intent, Config.RECORD_AUDIO);
            });
            commit_img.setOnClickListener((View view) -> {
                AndPermission.with(this)
                        .runtime()
                        .permission(
                                Permission.CAMERA
                                ,Permission.READ_EXTERNAL_STORAGE
                                ,Permission.WRITE_EXTERNAL_STORAGE)
                        .onGranted(new Action<List<String>>() {
                            @Override
                            public void onAction(List<String> data) {
                                PopUtil popUtil = new PopUtil();
                                popUtil.showPickPop(HomeWorkDetailActivity.this, HomeWorkDetailActivity.this);
                            }
                        })
                        .start();
            });
            commit_video.setOnClickListener((View view) -> {
                AndPermission.with(this)
                        .runtime()
                        .permission(
                                Permission.CAMERA
                                ,Permission.READ_EXTERNAL_STORAGE
                                ,Permission.WRITE_EXTERNAL_STORAGE)
                        .onGranted(new Action<List<String>>() {
                            @Override
                            public void onAction(List<String> data) {
                                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                                try {
                                    // start the Video Capture Intent
                                    //限制时长s
                                    intent.putExtra(MediaStore.EXTRA_DURATION_LIMIT, 5 * 60);
                                    //限制大小
                                    //intent.putExtra(MediaStore.EXTRA_SIZE_LIMIT, 10*1024*1024);
                                    //设置质量
                                    intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
                                    //设置输出位置
                                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.parse(Environment.getExternalStorageDirectory() + File.separator + "gridview" + File.separator + System.currentTimeMillis() + ".mp4"));

                                    startActivityForResult(intent, Config.REQUEST_TAKE_VIDEO);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                } }
                        })
                        .start();

            });
            commit_cancel.setOnClickListener((View view) -> {
                select_lay.setVisibility(View.INVISIBLE);
                select_lay.setClickable(false);
            });
        }

        loadFinishData(business_id);
    }

    private void upLoadHomeWork() {
        String content = commit_edit.getText().toString();
        int count = mCommitAdapter.getItemCount();
        if (TextUtils.isEmpty(content) && count == 0) {
            ToastUitl.showShort(R.string.empty_homework);
            return;
        }
        progressLay.setVisibility(View.VISIBLE);
        progressBar.startAnim();
        progressText.setText(R.string.uploading);

        List<MediaModel> mediaModels = mCommitAdapter.getDatas();
        if (null != mediaModels && mediaModels.size() > 0) {
            //上传附件，再提交作业
            UploadService uploadService = Http.getInstance().createRequest(UploadService.class);
            uploadService.getUploadData(HeaderUtil.getJsonHeaderMap(), "http://dev.xiao360.com/api/upload")
                    .compose(RxHelper.io_main())
                    .compose(bindToLifecycle())
                    .subscribe(new BaseRxObserver<UploadBean>() {
                        @Override
                        public void onSuccess(UploadBean uploadBean) {
                            String domain = uploadBean.getDomain();
                            String qiniu_token = uploadBean.getUptoken();
                            String pre_fix = uploadBean.getPrefix();
                            // 重用uploadManager。一般地，只需要创建一个uploadManager对象
                            UploadManager uploadManager = new UploadManager();
                            putFiles(uploadManager, qiniu_token, mediaModels, domain,pre_fix,content);
                        }

                        @Override
                        public void onFailure(Throwable e) {
                            //只有文本，直接提交
                            commitContent(content,null);
                        }
                    });
        }else {
            //只有文本，直接提交
            commitContent(content,null);
        }
    }

    private void commitContent(String content,List<HomeworkAttachmentBean> homework_attachments) {
            HomeWorkService homeWorkService = Http.getInstance().createRequest(HomeWorkService.class);
            CommitHomeReq req = new CommitHomeReq();
            req.setHt_id(business_id+"");
            req.setStar(0);
            req.setSid(Integer.valueOf(SpCache.getString(Config.SID,"")));
            req.setContent(content);
            if(null != homework_attachments)
            req.setHomework_attachment(homework_attachments);

            homeWorkService.uploadHomeWork(HeaderUtil.getJsonHeaderMap(),business_id+"",req)
                    .compose(RxHelper.io_main())
                    .compose(bindToLifecycle())
                    .subscribe(new BaseRxObserver<BindAccountBean>() {
                        @Override
                        public void onSuccess(BindAccountBean demo) {
                            progressBar.stopAnim();
                            progressLay.setVisibility(View.GONE);
                            ToastUitl.showShort(demo.getMessage());
                            setResult(Activity.RESULT_OK);
                            finish();
                        }

                        @Override
                        public void onFailure(Throwable e) {
                            progressBar.stopAnim();
                            progressLay.setVisibility(View.GONE);
                            ToastUitl.showShort(R.string.net_error);
                        }
                    });
    }

    public void putFiles(UploadManager uploadManager, String token, List<MediaModel> images, String domain,String pre_fix,String content) {
        // 七牛返回的文件
        ArrayList<HomeworkAttachmentBean> resultFiles= new ArrayList<>();
        // 依次发送list中的数据
        Observable.fromIterable(images)
                // 变换，在这里上传图片
                // 修改为concatMap确保图片顺序
                .concatMap((Function<MediaModel, ObservableSource<UploadResponeBean>>) path ->
                        Observable.create((ObservableOnSubscribe<UploadResponeBean>) emitter -> {
                            String filename =  UUID.randomUUID().toString() + "." + path.getFile_url().split("\\.")[1];
                            String key =  pre_fix+  "com.lantel.lh01/homework/" + filename;
                            ResponseInfo info = uploadManager.syncPut(path.getFile_url(), key, token,null);
                            if (info.isOK()) {
                                HomeWorkService service = Http.getInstance().createRequest(HomeWorkService.class);
                                UpLoadAttach attach = new UpLoadAttach();
                                attach.setFile_name(filename);
                                attach.setFile_url(domain+key);
                                String filetype = getFileExtensionName(path.getFile_url());
                                attach.setFile_type(filetype);
                                attach.setJs_upload(1);
                                try {
                                    File f = new File(path.getFile_url());
                                    long size = getFileSizes(f);
                                    attach.setFile_size(size);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                service.uploadAttachFile(HeaderUtil.getJsonHeaderMap(),"http://dev.xiao360.com/api/upload",attach)
                                        .compose(RxHelper.io_main())
                                        .subscribe(new BaseRxObserver<UploadResponeBean>() {
                                            @Override
                                            public void onSuccess(UploadResponeBean bean) {
                                                emitter.onNext(bean);
                                                emitter.onComplete();
                                            }

                                            @Override
                                            public void onFailure(Throwable e) {
                                                emitter.onError(new IOException(info.error));
                                            }
                                        });
                            } else {
                                // 上传失败，告辞
                                emitter.onError(new IOException(info.error));
                            }
                        }).subscribeOn(Schedulers.io())
                )
                // 线程切换
                .observeOn(AndroidSchedulers.mainThread())
                .compose(bindToLifecycle())
                .subscribe(response -> {
                    UploadResponeBean.DataBean responeBean = response.getData();
                    HomeworkAttachmentBean attachmentBean = new HomeworkAttachmentBean();
                        // 上传成功，发送这张图片的文件名
                    attachmentBean.setFile_name(responeBean.getFile_name());
                    attachmentBean.setFile_url(responeBean.getFile_url());
                    attachmentBean.setFile_id(Integer.valueOf(responeBean.getFile_id()));
                    attachmentBean.setFile_size(responeBean.getFile_size());
                    attachmentBean.setCreate_uid(responeBean.getCreate_uid());
                    attachmentBean.setOg_id(responeBean.getOg_id());
                    attachmentBean.setFile_type(responeBean.getFile_type());
                    resultFiles.add(attachmentBean);
                    // 如果全部完成，调用成功接口
                    if(resultFiles.size()== images.size()){
                        LogUtils.d("全部上传完毕====");
                        commitContent(content,resultFiles);
                    }
                }, throwable -> {
                    commitContent(content,null);
                    LogUtils.e(throwable.getMessage());
                });
    }

    private String getStrValue(String val) {
        return TextUtils.isEmpty(val) ? "" : val;
    }

    private void loadFinishData(int business_id) {
        HomeWorkService homeWorkService = Http.getInstance().createRequest(HomeWorkService.class);
        homeWorkService.getHomeWorkDetail(HeaderUtil.getJsonHeaderMap(), business_id + "")
                .compose(RxHelper.io_main())
                .compose(bindToLifecycle())
                .subscribe(new BaseRxObserver<HomeWorkDetailFinishBean>() {
                    @Override
                    public void onSuccess(HomeWorkDetailFinishBean detailFinishBean) {
                        if (detailFinishBean.getError() == 0) {
                            HomeWorkDetailFinishBean.DataBean dataBean = detailFinishBean.getData();
                            if (null != dataBean) {
                                setTaskFinish(dataBean);
                                if (isFinish)
                                    setRespone(dataBean);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        ToastUitl.showShort(R.string.net_error);
                    }
                });
    }

    private void setRespone(HomeWorkDetailFinishBean.DataBean dataBean) {
        HomeWorkDetailFinishBean.DataBean.HomeworkCompleteBean completeBean = dataBean.getHomework_complete();
        if (null != completeBean) {
            String content = completeBean.getContent();
            if (!TextUtils.isEmpty(content)) {
                content_respone.setText(content);
            }

            //提交作业日期
            String time = DisplayUtil.getFormateStr("yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", completeBean.getCreate_time());
            String deadline_time = String.format(getString(R.string.publish_time_format), time);
            if (!TextUtils.isEmpty(deadline_time)) {
                homewrok_deadline_time_respone.setText(deadline_time);
            }

            Map<String, ArrayList<MediaModel>> map = getNewMap();
            List<HomeWorkDetailFinishBean.DataBean.HomeworkCompleteBean.CompleteAttachmentBean> attachmentBeans = completeBean.getComplete_attachment();
            if (null != attachmentBeans && attachmentBeans.size() > 0) {
                for (HomeWorkDetailFinishBean.DataBean.HomeworkCompleteBean.CompleteAttachmentBean attachmentBean : attachmentBeans) {
                    int mediaType = getMediaType(attachmentBean.getMedia_type());
                    MediaModel mediaModel = new MediaModel();
                    mediaModel.setFile_name(attachmentBean.getFile_name());
                    mediaModel.setFile_size(attachmentBean.getFile_size());
                    mediaModel.setType(mediaType);
                    mediaModel.setDuration(attachmentBean.getDuration());
                    mediaModel.setFile_type(attachmentBean.getFile_type());
                    mediaModel.setFile_url(attachmentBean.getFile_url());
                    putMediaMap(map, mediaType, mediaModel);
                }
            }
            setUpAttachFileRespone(map);
        }


        HomeWorkDetailFinishBean.DataBean.StudentBean studentBean = dataBean.getStudent();
        if (null != studentBean) {
            String student_name = studentBean.getStudent_name();
            if (!TextUtils.isEmpty(student_name)) {
                name_respone.setText(student_name);
            }
            GlideUtils.loadCircle(this, studentBean.getPhoto_url(), head_img_respone,R.mipmap.circle_default);
        }
    }

    public void setTaskFinish(HomeWorkDetailFinishBean.DataBean dataBean) {
        String content = dataBean.getContent();

        //布置作业开始日期
        String stime = DisplayUtil.getFormateStr("yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", dataBean.getCreate_time());
        String start_time = String.format(getString(R.string.publish_time_format), stime);

        //布置作业截止日期
        String etime = DisplayUtil.getFormateStr("yyyyMMdd", "yyyy-MM-dd", dataBean.getDeadline() + "");
        String end_time = String.format(getString(R.string.deadline_time_format), etime);

        String name = "";
        String photo_url = "";
        HomeWorkDetailFinishBean.DataBean.EmployeeBean employeeBean = dataBean.getEmployee();
        if (null != employeeBean) {
            //布置作业老师
            name = employeeBean.getEname();
            //布置作业头像
            photo_url = employeeBean.getPhoto_url();
        }

        String class_name = "";
        //布置作业班级,没有班级显示课程
        HomeWorkDetailFinishBean.DataBean.OneClassBean oneClassBean = dataBean.getOne_class();
        if (null != oneClassBean) {
            class_name = oneClassBean.getClass_name();

        } else {
            MyApplication application = (MyApplication) getApplication();
            List<Lesson> lessonList = application.getLessonList();
            if (null != lessonList && lessonList.size() > 0) {
                for (Lesson lesson : lessonList) {
                    if (lesson.getLid() == dataBean.getLid()) {
                        class_name = lesson.getLesson_name();
                    }
                }
            }
        }

        //设置附件数据
        List<HomeWorkDetailFinishBean.DataBean.HomeworkAttachmentBean> taskHomework_attachment = dataBean.getHomework_attachment();
        Map<String, ArrayList<MediaModel>> map = getNewMap();

        if (null != taskHomework_attachment && taskHomework_attachment.size() > 0) {
            for (HomeWorkDetailFinishBean.DataBean.HomeworkAttachmentBean attachmentBean : taskHomework_attachment) {
                int mediaType = getMediaType(attachmentBean.getMedia_type());
                MediaModel mediaModel = new MediaModel();
                mediaModel.setFile_name(attachmentBean.getFile_name());
                mediaModel.setFile_size(attachmentBean.getFile_size());
                mediaModel.setType(mediaType);
                mediaModel.setDuration(attachmentBean.getDuration());
                mediaModel.setFile_type(attachmentBean.getFile_type());
                mediaModel.setFile_url(attachmentBean.getFile_url());
                putMediaMap(map, mediaType, mediaModel);
            }
        }
        setUpTaskView(content, start_time, end_time, name, photo_url, class_name, map);
    }

    public void putMediaMap(Map<String, ArrayList<MediaModel>> map, int mediaType, MediaModel mediaModel) {
        if (mediaType == Config.PHOTO || mediaType == Config.VIDEO)
            map.get(Config.IMG_LIST).add(mediaModel);
        else if (mediaType == Config.FILE) {
            map.get(Config.FILE_LIST).add(mediaModel);
        } else if (mediaType == Config.RECORD) {
            map.get(Config.RECORD_LIST).add(mediaModel);
        }
    }

    public Map<String, ArrayList<MediaModel>> getNewMap() {
        Map<String, ArrayList<MediaModel>> map = new HashMap<>();
        ArrayList<MediaModel> images = new ArrayList<>();
        map.put(Config.IMG_LIST, images);

        ArrayList<MediaModel> files = new ArrayList<>();
        map.put(Config.FILE_LIST, files);

        ArrayList<MediaModel> records = new ArrayList<>();
        map.put(Config.RECORD_LIST, records);
        return map;
    }

    private void setUpTaskView(String content, String start_time, String end_time, String name, String photo_url, String class_name, Map<String, ArrayList<MediaModel>> map) {
        //布置作业文本内容
        if (!TextUtils.isEmpty(content))
            RichText.fromHtml(content).into(contentTask);

        if (!TextUtils.isEmpty(start_time))
            homewrokStartTimeTask.setText(start_time);

        if (!TextUtils.isEmpty(end_time))
            homewrokEndTimeTask.setText(end_time);

        if (!TextUtils.isEmpty(class_name))
            textClassesTask.setText(class_name);

        if (!TextUtils.isEmpty(name))
            nameTask.setText(name);

        if (!TextUtils.isEmpty(photo_url))
            GlideUtils.loadCircle(HomeWorkDetailActivity.this, photo_url, headImgTask,R.mipmap.circle_default);

        setUpAttachFileTask(map);
    }

    private void setUpAttachFileTask(Map<String, ArrayList<MediaModel>> map) {
        AlbumFileViewTask.bindImageList(map.get(Config.IMG_LIST));
        AlbumFileViewTask.bindFileList(map.get(Config.FILE_LIST), map.get(Config.RECORD_LIST));
    }

    private void setUpAttachFileRespone(Map<String, ArrayList<MediaModel>> map) {
        AlbumFileView_respone.bindImageList(map.get(Config.IMG_LIST));
        AlbumFileView_respone.bindFileList(map.get(Config.FILE_LIST), map.get(Config.RECORD_LIST));
    }

    private int getMediaType(String mediaType) {
        if (mediaType.equals(Config.MEDIA_IMG)) {
            return Config.PHOTO;
        } else if (mediaType.equals(Config.MEDIA_VIDEO)) {
            return Config.VIDEO;
        } else if (mediaType.equals(Config.MEDIA_RECORD)) {
            return Config.RECORD;
        } else
            return Config.FILE;
    }

    @OnClick(R2.id.back)
    public void onViewClicked(View v) {
        int id = v.getId();
        if (id == R.id.back) {
            finish();
        }
    }

    @Override
    public void clickAdd() {
        select_lay.setVisibility(View.VISIBLE);
        select_lay.setClickable(true);
    }

    @Override
    public void onPhotoSelect(MediaBean photoBean) {
        photoUri = photoBean.getImgUri();
        startActivityForResult(PhotoUtil.getTakePhotoIntent(photoUri), Config.REQUEST_TAKE_PHOTO);
    }

    @Override
    public void onSelectAlbum() {
        startActivityForResult(PhotoUtil.getPickIntent(), Config.REQUEST_SELECT_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case Config.REQUEST_TAKE_VIDEO:
                    Uri v_uri = data.getData();
                    addVideo(v_uri);
                    break;
                case Config.REQUEST_TAKE_PHOTO:
                    if (null != photoUri) {
                        addPhoto(photoUri);
                    }
                    break;
                case Config.REQUEST_SELECT_PHOTO:
                    Uri i_uri = data.getData();
                    if (null != i_uri) {
                        addPhoto(i_uri);
                    }
                    break;
                case Config.RECORD_AUDIO:

                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void addPhoto(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, projectionImg, null, null, null);
        if (cursor.moveToFirst()) {
            String path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA));
            File file = new File(path);
            if (file.length() > 0) {
                MediaModel mediaModel = new MediaModel();
                mediaModel.setType(Config.PHOTO);
                mediaModel.setFile_url(path);
                mediaModel.setFile_uri(uri.getPath());
                mediaModel.setLocal(true);
                insertModel(mediaModel);
            } else {
                ToastUitl.showShort(R.string.size_error);
            }
        }
        if (null != cursor)
            cursor.close();
    }

    private void addVideo(Uri uri) {
        if (null != uri) {
            Cursor cursor = getContentResolver().query(uri, projectionVideo, null, null, null);
            if (cursor.moveToFirst()) {
                String name = cursor.getString(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DISPLAY_NAME));
                long size = cursor.getLong(cursor.getColumnIndex(MediaStore.Video.VideoColumns.SIZE));
                String path = cursor.getString(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DATA));
                String duration = cursor.getString(cursor.getColumnIndex(MediaStore.Video.VideoColumns.DURATION));
                File file = new File(path);
                if (file.length() > 0) {
                    MediaModel mediaModel = new MediaModel();
                    mediaModel.setLocal(true);
                    mediaModel.setFile_name(name);
                    mediaModel.setFile_size(size);
                    mediaModel.setDuration(duration);
                    mediaModel.setType(Config.VIDEO);
                    mediaModel.setFile_url(path);
                    mediaModel.setFile_uri(uri.getPath());
                    insertModel(mediaModel);
                } else {
                    ToastUitl.showShort(R.string.size_error);
                }
            }
            if (null != cursor)
                cursor.close();
        }
    }

    private void insertModel(MediaModel mediaModel) {
        if (null != mCommitAdapter) {
            List<MediaModel> mediaModelList = mCommitAdapter.getDatas();
            int start = null == mediaModelList ? 0 : mediaModelList.size();
            mCommitAdapter.getDatas().add(mediaModel);
            mCommitAdapter.notifyItemRangeInserted(start, 1);
            mCommitAdapter.notifyItemRangeChanged(start, 1);
        }
    }


    public long getFileSizes(File f) throws Exception {
        long s = 0;
        if (f.exists()) {
            FileInputStream fis = null;
            fis = new FileInputStream(f);
            s = fis.available();
            fis.close();
        } else {
            f.createNewFile();
            LogUtils.d("文件不存在");
        }
        return s;
    }

    /*
     * Java文件操作 获取文件扩展名
     * */
    public static String getFileExtensionName(String filename) {
        if ((filename != null) && (filename.length() > 0)) {
            int dot = filename.lastIndexOf('.');
            if ((dot >-1) && (dot < (filename.length() - 1))) {
                return filename.substring(dot + 1);
            }
        }
        return filename;
    }

    /**
     * 隐藏键盘
     */
//隐藏键盘
    public void closeInputMethod(EditText tv_works_name) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        boolean isOpen = imm.isActive();
        if(isOpen) {
            imm.hideSoftInputFromWindow(tv_works_name.getWindowToken(), 0); //强制隐藏键盘
            isOpen=false;
        }
    }
}
