package com.lantel.setting.editPassword;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.BarHide;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.xiao360.baselibrary.util.SpCache;
import com.xiao360.baselibrary.util.ToastUitl;

import androidx.lifecycle.ViewModel;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantel/360/Setting/EditPasswrod")
public class EditPassword extends BaseMVPActivity {
    @BindView(R2.id.statebarView)
    View statebarView;
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.text_right)
    TextView textRight;
  /*  @BindView(R2.id.user_name)
    TextView userName;*/
    @BindView(R2.id.user_oldpass)
    EditText userOldpass;
    @BindView(R2.id.user_newpass)
    EditText userNewpass;
    @BindView(R2.id.user_confirm_newpass)
    EditText userConfirmNewpass;
    @BindView(R2.id.forget_pass)
    TextView forgetPass;

    @Override
    protected BarHide hideBar() {
        return BarHide.FLAG_SHOW_BAR;
    }

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    protected ViewModel getModel() {
        return null;
    }

    @Override
    public int getLayoutId() {
        return R.layout.edit_password;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        title.setText(R.string.setting_EditPasswrod);

       /* String phone = SpCache.getString(Config.PNONE_NUMBER,"");
        if(!TextUtils.isEmpty(phone))
        userName.setText(phone);*/

        textRight.setText(R.string.finish);
        textRight.setVisibility(View.VISIBLE);
    }

    @OnClick({R2.id.back, R2.id.text_right,R2.id.forget_pass})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.back){
            finish();
        }else if(id ==  R.id.text_right){
           // String phone = userName.getText().toString();
            String oldpass = userOldpass.getText().toString();
            String newpass = userNewpass.getText().toString();
            String confirmpass = userConfirmNewpass.getText().toString();
          /*  if(TextUtils.isEmpty(phone)){
                ToastUitl.showShort(R.string.bind_phone);
            }else */if(TextUtils.isEmpty(oldpass)){
                ToastUitl.showShort(R.string.oldPassTitle_hint);
            }else if(TextUtils.isEmpty(newpass)){
                ToastUitl.showShort(R.string.newPassTitle_hint);
            }else if(TextUtils.isEmpty(confirmpass)){
                ToastUitl.showShort(R.string.confirmTitle_hint);
            }else {
                if(newpass.equals(confirmpass)){
                    ChangePassWord(oldpass,newpass);
                }else {
                    ToastUitl.showShort(R.string.password_unsame);
                }
            }
        }else if(id == R.id.forget_pass){

        }
    }

    private void ChangePassWord(String oldpass, String newpass) {

    }
}
