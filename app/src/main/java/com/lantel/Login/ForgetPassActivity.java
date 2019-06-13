package com.lantel.Login;

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
import com.lantel.Login.api.LoginService;
import com.lantel.Login.api.LoginVerifyBean;
import com.lantel.Login.api.LoginVerifyReq;
import com.lantel.Login.api.RegsistBean;
import com.lantel.Login.api.RsetBean;
import com.lantel.Login.api.RsetReq;
import com.lantel.Login.api.SignUpReq;
import com.lantel.Login.api.UserRsetReq;
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

@Route(path = "/lantelhome/360/forgetOrRegsist")
public class ForgetPassActivity extends BaseActivity {
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
        busssness = getIntent().getStringExtra(Config.FORGET_BUSSNESS_TYPE);
        setTitle();
        //设置密码不可见
        editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        mService = Http.getInstance().createRequest(LoginService.class);
    }

    public void setTitle() {
        String toolbartitle = "";
        if(busssness.equals(Config.SIGNUP)){
            toolbartitle = getString(R.string.regsist_now);
        }else if(busssness.equals(Config.RESETPWD)){
            toolbartitle = getString(R.string.forget_pass);
        }
        else if(busssness.equals(Config.USER_RESETPWD)){
            toolbartitle = getString(R.string.reset_pwd);
        }
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
                            SendRequest(phone,verifyCode,password);
                        }
                    }
                }
        }
    }

    private void SendRequest(String phone, String verifyCode, String password) {
        if(busssness.equals(Config.SIGNUP)){
            requestRegsist(phone,verifyCode,password);
        }else if(busssness.equals(Config.RESETPWD)){
            requestForgetPwd(phone,verifyCode,password);
        }
        else if(busssness.equals(Config.USER_RESETPWD)){
            requestChangPwd(verifyCode,password);
        }
    }

    private void requestChangPwd(String verifyCode, String password) {
        UserRsetReq userRsetReq = new UserRsetReq();
        userRsetReq.setNew_pwd(password);
        userRsetReq.setVcode(verifyCode);
        mService.userresetpwd(userRsetReq)
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

    private void requestRegsist(String phone, String verifyCode, String password) {
        SignUpReq regsistReq = new SignUpReq();
        regsistReq.setApp_client_id(2);
        regsistReq.setVcode(verifyCode);
        regsistReq.setPassword(password);
        regsistReq.setMobile(phone);
        mService.signup(regsistReq)
                .compose(RxHelper.io_main())
                .compose(bindToLifecycle())
                .subscribe(new BaseRxObserver<RegsistBean>() {
                    @Override
                    public void onSuccess(RegsistBean regsistBean) {
                        if(regsistBean.getCode()==0){
                            ToastUitl.showShort(R.string.success_regsist);
                            finish();
                        }else {
                            ToastUitl.showShort(regsistBean.getMessage());
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
            mService.sendVerifyCode(request)
                    .compose(RxHelper.io_main())
                    .compose(bindToLifecycle())
                    .subscribe(new BaseRxObserver<LoginVerifyBean>() {
                        @Override
                        public void onSuccess(LoginVerifyBean smsBean) {
                            if(smsBean.getError()==0){
                                ToastUitl.showShort(com.lantel.homelibrary.R.string.success_sms);
                            }else
                                ToastUitl.showShort(smsBean.getMessage());
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
