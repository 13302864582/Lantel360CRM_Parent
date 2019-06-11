package com.lantel.Login;

import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.Login.api.LoginService;
import com.lantel.common.VerificationCountDownTimer;
import com.lantel.crmparent.R;
import com.lantel.setting.bindAccount.api.SmsBean;
import com.lantel.setting.bindAccount.api.SmsRequest;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.ToastUitl;
import java.util.regex.Pattern;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.OnClick;

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
        title.setText(R.string.forget_pass);
        //设置密码不可见
        editPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
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
                ChangePass();
                break;
        }
    }

    public void sendVerifyCode() {
        new VerificationCountDownTimer(this,sendSms);
        String phone  = editPhone.getText().toString().trim();
        if(!TextUtils.isEmpty(phone)){
            LoginService service = Http.getInstance().createRequest(LoginService.class);
            SmsRequest request = new SmsRequest();
            request.setMobile(phone);
            service.sendVerifyCode(request)
                    .compose(RxHelper.io_main())
                    .compose(bindToLifecycle())
                    .subscribe(new BaseRxObserver<SmsBean>() {
                        @Override
                        public void onSuccess(SmsBean smsBean) {
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

    public void ChangePass() {
        String password  = editPass.getText().toString().trim();
        if(!TextUtils.isEmpty(password)){
            String regex  = "(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8}$^";
            boolean formate = Pattern.matches(regex, password);
            if(formate){

            }else
                ToastUitl.showShort(R.string.set_password_hint);
        }else
            ToastUitl.showShort(R.string.login_edit_password);
    }
}
