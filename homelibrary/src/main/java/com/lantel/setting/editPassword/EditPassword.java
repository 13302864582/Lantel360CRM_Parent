package com.lantel.setting.editPassword;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.BarHide;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.xiao360.baselibrary.base.BaseMVPActivity;
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
    @BindView(R2.id.user_name)
    TextView userName;
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

    }

    @OnClick({R2.id.back, R2.id.text_right,R2.id.forget_pass})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.back){

        }else if(id ==  R.id.text_right){

        }else if(id == R.id.forget_pass){

        }
    }
}
