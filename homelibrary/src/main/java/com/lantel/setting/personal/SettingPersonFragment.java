package com.lantel.setting.personal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.common.HttpResBean;
import com.lantel.common.NormalRxObserver;
import com.lantel.common.PhotoSelectListener;
import com.lantel.common.PopUtil;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.setting.bindfile.bindstudent.api.BindStudentBean;
import com.lantel.setting.bindfile.bindstudent.api.BindStudentService;
import com.lantel.setting.personal.api.UploadBean;
import com.lantel.setting.personal.api.UploadReq;
import com.lantel.setting.personal.api.UploadResultBean;
import com.lantel.setting.personal.api.UploadService;
import com.lantel.setting.personal.list.adpter.SettingPersonAdapter;
import com.lantel.setting.personal.list.model.SettingPersonItemModel;
import com.lantel.setting.personal.mvp.SettingPersonContract;
import com.lantel.setting.personal.mvp.SettingPersonModel;
import com.lantel.setting.personal.mvp.SettingPersonPresenter;
import com.ldoublem.loadingviewlib.view.LVFunnyBar;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UploadManager;
import com.xiao360.baselibrary.base.BaseMVPFragment;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.image.GlideUtils;
import com.xiao360.baselibrary.util.MediaBean;
import com.xiao360.baselibrary.util.PhotoUtil;
import com.xiao360.baselibrary.util.SpCache;
import com.xiao360.baselibrary.util.ToastUitl;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.runtime.Permission;

import org.json.JSONObject;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class SettingPersonFragment extends BaseMVPFragment<SettingPersonPresenter, SettingPersonModel> implements SettingPersonContract.View, SettingPersonAdapter.NaviEditListener, PhotoSelectListener {
    @BindView(R2.id.headImg)
    ImageView headImg;
    @BindView(R2.id.setting_personal_list)
    RecyclerView settingPersonalList;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.text_right)
    TextView textRight;
    @BindView(R2.id.progress_bar)
    LVFunnyBar progressBar;
    @BindView(R2.id.progress_text)
    TextView progressText;
    @BindView(R2.id.progress_lay)
    ConstraintLayout progressLay;

    private SettingPersonAdapter mAdapter;
    private Uri photoUrl;
    private String photoPath;
    private String studentName;

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected SettingPersonModel getModel() {
        return FindModel(SettingPersonModel.class);
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.setting_personal_content;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    protected void initView() {
        textRight.setText(R.string.finish);
        BindStudentService service = Http.getInstance().createRequest(BindStudentService.class);
        service.getAccountData(HeaderUtil.getJsonHeaderMap(), SpCache.getString(Config.UID,"0"))
                .compose(RxHelper.io_main())
                .compose(bindToLifecycle())
                .subscribe(new NormalRxObserver() {
                    @Override
                    public void onSuccess(HttpResBean resBean) {
                        BindStudentBean studentBean = (BindStudentBean) resBean;
                        BindStudentBean.DataBean dataBean = studentBean.getData();
                        if(null != dataBean && null != dataBean.getList()){
                            String sid = SpCache.getString(Config.SID,"");
                            List<BindStudentBean.DataBean.ListBean> listBeans = dataBean.getList();
                            for(int i = 0;i < listBeans.size();i++){
                                BindStudentBean.DataBean.ListBean bean = listBeans.get(i);
                                if(String.valueOf(bean.getSid()).equals(sid)){
                                    photoPath = bean.getPhoto_url();
                                    studentName = bean.getStudent_name();
                                    GlideUtils.loadCircle(getContext(),photoPath, headImg,R.mipmap.circle_default);
                                    PersonBean personBean = new PersonBean();
                                    personBean.setBirthDate(bean.getBirth_time());
                                    personBean.setName(studentName);
                                    personBean.setSex(bean.getSex());
                                    mPresenter.initMenu(personBean);
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {

                    }
                });
    }

    @OnClick({R2.id.headImg, R2.id.chageHead, R2.id.back, R2.id.text_right})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.headImg || id == R.id.chageHead) {
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
                            popUtil.showPickPop(SettingPersonFragment.this, SettingPersonFragment.this);
                        }
                    })
                    .start();
        } else if (id == R.id.back) {
            getActivity().finish();
        } else if (id == R.id.text_right) {
            upLoadHeadImg();
        }
    }

    private void commitRequest() {
        if(!TextUtils.isEmpty(studentName)){
            UploadService uploadService = Http.getInstance().createRequest(UploadService.class);
            String sid = SpCache.getString(Config.SID,"");
            List<SettingPersonItemModel> models = mAdapter.getDatas();
            String sex = (models.get(1).getIndex()+1)+"";
            String date = models.get(2).getValue()+"";
            UploadReq uploadReq = new UploadReq();
            uploadReq.setSex(sex);
            uploadReq.setPhoto_url(photoPath);
            uploadReq.setBirth_time(date);
            uploadReq.setSid(Integer.valueOf(sid));
            uploadReq.setStudent_name(studentName);
            uploadService.commitUpload(HeaderUtil.getJsonHeaderMap(),uploadReq)
                    .compose(RxHelper.io_main())
                    .compose(bindToLifecycle())
                    .subscribe(new BaseRxObserver<UploadResultBean>() {
                        @Override
                        public void onSuccess(UploadResultBean resultBean) {
                            progressBar.stopAnim();
                            progressLay.setVisibility(View.GONE);
                            String error = resultBean.getError();
                            if(error.equals("0")){
                                ToastUitl.showShort(R.string.upload_success);
                                getActivity().finish();
                            }else if(error.equals("401"))
                                HeaderUtil.goToLogin();
                        }

                        @Override
                        public void onFailure(Throwable e) {
                            progressBar.stopAnim();
                            progressLay.setVisibility(View.GONE);
                            ToastUitl.showShort(R.string.net_error);
                        }
                    });
        }
    }

    @Override
    public void initList(ArrayList<SettingPersonItemModel> menu) {
        settingPersonalList.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new SettingPersonAdapter(getContext(), menu);
        mAdapter.setListener(this);
        settingPersonalList.setAdapter(mAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case Config.REQUEST_EDIT_TEXT:
                    //mAdapter.notifyValue(data.getStringExtra(Config.EDIT_TEXT_RESULT), options1);
                    break;
                case Config.REQUEST_TAKE_PHOTO:
                    setupIMg(photoUrl);
                    break;
                case Config.REQUEST_SELECT_PHOTO:
                    photoUrl=data.getData();
                    setupIMg(photoUrl);
                    break;
            }
        }
    }

    private void setupIMg(Uri uri) {
        try {
            Bitmap bitmap = PhotoUtil.getBitmapFormUri(getContext(), uri);
            headImg.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //上传头像
    private void upLoadHeadImg() {
        if (null != photoUrl) {
            UploadService uploadService = Http.getInstance().createRequest(UploadService.class);
            uploadService.getUploadData(HeaderUtil.getJsonHeaderMap(), "http://dev.xiao360.com/api/upload")
                    .compose(RxHelper.io_main())
                    .compose(bindToLifecycle())
                    .subscribe(new BaseRxObserver<UploadBean>() {
                        @Override
                        public void onSuccess(UploadBean uploadBean) {
                            try {
                                progressLay.setVisibility(View.VISIBLE);
                                progressBar.startAnim();
                                Bitmap bitmap = PhotoUtil.getBitmapFormUri(getContext(), photoUrl);
                                String filePath = PhotoUtil.getRealPathFromUri(getContext(), photoUrl);
                                String filekey = uploadBean.getPrefix()+ "com.lantel.lh01/personalSet/" + filePath.substring(filePath.lastIndexOf("/") + 1);
                                // 重用uploadManager。一般地，只需要创建一个uploadManager对象
                                UploadManager uploadManager = new UploadManager();
                                uploadManager.put(Bitmap2Bytes(bitmap), filekey, uploadBean.getUptoken(), (String key, ResponseInfo info, JSONObject response) -> {
                                    if (info.isOK()) {
                                        photoPath = uploadBean.getDomain() + key;
                                    }
                                    commitRequest();
                                }, null);
                            } catch (Exception e) {
                                progressBar.stopAnim();
                                progressLay.setVisibility(View.GONE);
                                e.printStackTrace();
                            }

                        }

                        @Override
                        public void onFailure(Throwable e) {
                            ToastUitl.showShort(R.string.net_error);
                        }
                    });
        }else
            commitRequest();
    }

    public byte[] Bitmap2Bytes(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }


    @Override
    public void editText(String editText) {
       // ARouter.getInstance().build("/lantel/360/EditText").withString(Config.EDIT_TEXT, editText).navigation(getActivity(), Config.TYPE_EDIT_TEXT);
    }

    @Override
    public void showEmpty() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNetWorkError() {

    }

    @Override
    public void onPhotoSelect(MediaBean photoBean) {
        photoUrl = photoBean.getImgUri();
        startActivityForResult(PhotoUtil.getTakePhotoIntent(photoUrl), Config.REQUEST_TAKE_PHOTO);
    }

    @Override
    public void onSelectAlbum() {
        startActivityForResult(PhotoUtil.getPickIntent(), Config.REQUEST_SELECT_PHOTO);
    }
}
