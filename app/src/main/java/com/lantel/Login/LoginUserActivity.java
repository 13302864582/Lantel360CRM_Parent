package com.lantel.Login;

import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.Login.api.LoginBean;
import com.lantel.Login.api.LoginService;
import com.lantel.crmparent.R;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.SpCache;
import com.xiao360.baselibrary.util.ToastUitl;

import java.util.List;

import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantelhome/360/login")
public class LoginUserActivity extends BaseActivity {
    @BindView(R.id.login_edit_user)
    EditText loginEditUser;
    @BindView(R.id.see)
    ImageView see;
    @BindView(R.id.login_edit_password)
    EditText loginEditPassword;
    @BindView(R.id.login_btn)
    AppCompatButton loginBtn;
    @BindView(R.id.login_forgetPassWord)
    TextView loginForgetPassWord;

    private boolean isOpenEye = false;

    @Override
    protected int getStateBarviewID() {
        return -1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.login_user;
    }

    @Override
    public void initView() {
        //默认记住用户名密码，登陆后自动保存
        String account = SpCache.getString(Config.ACCOUNT, "");
        if(!TextUtils.isEmpty(account))
            loginEditUser.setText(account);
        String password = SpCache.getString(Config.PASSWORD, "");
        if(!TextUtils.isEmpty(password))
            loginEditPassword.setText(password);
        //设置密码不可见
        loginEditPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    @OnClick({R.id.see, R.id.login_btn,R.id.login_forgetPassWord,R.id.login_regsist})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.see:
                if (!isOpenEye) {
                    see.setSelected(true);
                    isOpenEye = true;
                    //密码可见
                    loginEditPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    see.setSelected(false);
                    isOpenEye = false;
                    //密码不可见
                    loginEditPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
            case R.id.login_btn:
                String account = loginEditUser.getText().toString();
                String password = loginEditPassword.getText().toString();
                if (TextUtils.isEmpty(account) || TextUtils.isEmpty(password)) {
                    ToastUitl.showShort(R.string.empty_edit_login);
                } else {
                    LoginService loginService = Http.getInstance().createRequest(LoginService.class);
                    String url = "signin?account="+account+"&password="+password;
                    loginService.login(url)
                            .compose(RxHelper.io_main())
                            .compose(this.bindToLifecycle())
                            .subscribe(new BaseRxObserver<LoginBean>() {
                                @Override
                                public void onSuccess(LoginBean bean) {
                                    int errorCode = bean.getCode();
                                    if (errorCode == 0) {
                                        SpCache.putBoolean(Config.IS_LOGIN,true);
                                        LoginBean.DataBean dataBean = bean.getData();
                                        //保存用户header参数x-sub-host
                                        if (null != dataBean.getX_sub_host())
                                            SpCache.putString(Config.X_SUB_HOST, dataBean.getX_sub_host());
                                        //保存用户header参数token
                                        if (null != dataBean.getToken())
                                            SpCache.putString(Config.TOKEN, dataBean.getToken());
                                        //保存用户名
                                        if (null != dataBean.getAccount())
                                            SpCache.putString(Config.ACCOUNT, dataBean.getAccount());
                                        //保存用户密码
                                        if (null != dataBean.getPassword())
                                            SpCache.putString(Config.PASSWORD, dataBean.getPassword());
                                        //保存用户唯一标识参数uid
                                        SpCache.putString(Config.UID, dataBean.getUid()+"");
                                        //保存校区标识参数bid
                                        SpCache.putString(Config.BID, dataBean.getBid()+"");

                                        String mobile = dataBean.getMobile();

                                        if(!TextUtils.isEmpty(mobile))
                                            SpCache.putBoolean(Config.BIND_PHONE,true);

                                        SpCache.putString(Config.PNONE_NUMBER,mobile);

                                        List<LoginBean.DataBean.StudentsBean> studentsBean =  dataBean.getStudents();
                                        if(null != studentsBean && studentsBean.size()>0)
                                            SpCache.putString(Config.SID,studentsBean.get(0).getSid()+"");

                                        ARouter.getInstance().build("/lantelhome/360/app").navigation();
                                        finish();
                                    } else{
                                        ToastUitl.showShort(bean.getMessage());
                                    }
                                }

                                @Override
                                public void onFailure(Throwable e) {
                                    ToastUitl.showShort(R.string.fail_login);
                                }
                            });
                }
                break;
            case R.id.login_forgetPassWord:
                //ARouter.getInstance().build("/lantelhome/360/forgetOrRegsist").withString(Config.FORGET_BUSSNESS_TYPE,Config.RESETPWD).navigation();
                ARouter.getInstance().build("/lantelhome/360/forgetpwd").navigation();
                break;

            case R.id.login_regsist:
                //ARouter.getInstance().build("/lantelhome/360/forgetOrRegsist").withString(Config.FORGET_BUSSNESS_TYPE,Config.SIGNUP).navigation();
                break;
        }
    }
}
