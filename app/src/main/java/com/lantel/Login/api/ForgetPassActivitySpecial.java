package com.lantel.Login.api;

import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.VerificationCountDownTimer;
import com.lantel.crmparent.R;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.ToastUitl;

import java.util.regex.Pattern;

import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantelhome/360/forgetpwd")
public class ForgetPassActivitySpecial extends BaseActivity {
    @BindView(R.id.statebarView)
    View statebarView;
    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.send_sms)
    TextView sendSms;
    @BindView(R.id.edit_sms)
    EditText editSms;
    @BindView(R.id.see)
    ImageView see;
    @BindView(R.id.edit_pass)
    EditText editPass;
    @BindView(R.id.confirm_btn)
    AppCompatButton confirmBtn;
    private boolean isOpenEye = false;
    private String busssness = "";
    private LoginService mService;
    private boolean isLogin;

    @Override
    protected int getStateBarviewID() {
        return com.lantel.homelibrary.R.id.statebarView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.forget_pass;
    }

    @Override
    public void initView() {
        setTitle();
        //设置密码不可见
        editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        mService = Http.getInstance().createRequest(LoginService.class);
    }

    public void setTitle() {
        String toolbartitle = getString(R.string.forget_pass);
        title.setText(toolbartitle);
    }

    @OnClick({R.id.back, R.id.send_sms, R.id.see, R.id.confirm_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.send_sms:
                sendVerifyCode();
                break;
            case R.id.see:
                toogleSee();
                break;
            case R.id.confirm_btn:
                String phone  = editPhone.getText().toString().trim();
                String password  = editPass.getText().toString().trim();
                String verifyCode  = editSms.getText().toString().trim();
                if(CheckPhone(phone)){
                    if(CheckVerifyCode(verifyCode)){
                        if(CheckPass(password)){
                            requestForgetPwd(phone,verifyCode,password);
                        }
                    }
                }
        }
    }

    private void requestForgetPwd(String phone, String verifyCode, String password) {
        RsetReq rsetReq = new RsetReq();
        rsetReq.setNew_pwd(password);
        rsetReq.setVcode(verifyCode);
        rsetReq.setAccount(phone);
        mService.resetpwd(rsetReq)
                .compose(RxHelper.io_main())
                .compose(bindToLifecycle())
                .subscribe(new BaseRxObserver<RsetBean>() {
                    @Override
                    public void onSuccess(RsetBean rsetBean) {
                        if(rsetBean.getCode()==0){
                            ToastUitl.showShort(R.string.success_setpass);
                            finish();
                        }else {
                            ToastUitl.showShort(rsetBean.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        ToastUitl.showShort(R.string.net_error);
                    }
                });
    }

    public void sendVerifyCode() {
        String phone  = editPhone.getText().toString().trim();
        new VerificationCountDownTimer(this,sendSms);
        if(!TextUtils.isEmpty(phone)){
            LoginVerifyReq request = new LoginVerifyReq();
            request.setMobile(phone);
            request.setApp_client_id(2);
            request.setBusiness_type(busssness);
                VerifyUnloginReq req = new VerifyUnloginReq();
                req.setMobile(phone);
                req.setType("student_forget");
                mService.sendVerifyUnlogin(req)
                        .compose(RxHelper.io_main())
                        .compose(bindToLifecycle())
                        .subscribe(new BaseRxObserver<LogoutBean>() {
                            @Override
                            public void onSuccess(LogoutBean bean) {
                                ToastUitl.showShort(bean.getData());
                            }

                            @Override
                            public void onFailure(Throwable e) {
                                ToastUitl.showShort(com.lantel.homelibrary.R.string.fail_sms);
                            }
                        });
        }else
            ToastUitl.showShort(R.string.empty_phone);
    }



    public void toogleSee() {
        if (!isOpenEye) {
            see.setSelected(true);
            isOpenEye = true;
            //密码可见
            editPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            see.setSelected(false);
            isOpenEye = false;
            //密码不可见
            editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public boolean CheckPass(String password) {
        if(!TextUtils.isEmpty(password)){
            String regex  = "(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8}$^";
            boolean formate = Pattern.matches(regex, password);
            if(formate){
                return true;
            }else
                ToastUitl.showShort(R.string.set_password_hint);
        }else
            ToastUitl.showShort(R.string.login_edit_password);
        return false;
    }

    public boolean CheckPhone(String phone) {
        if(!TextUtils.isEmpty(phone)){
            return true;
        }else
            ToastUitl.showShort(R.string.empty_phone);
        return false;
    }

    public boolean CheckVerifyCode(String verifyCode) {
        if(!TextUtils.isEmpty(verifyCode)){
            return true;
        }else
            ToastUitl.showShort(R.string.empty_sms);
        return false;
    }
}
