package com.lantel.setting.bindfile.bindstudent;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.utils.TextUtils;
import com.flyco.dialog.widget.NormalDialog;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.util.ToastUitl;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantel/360/Setting/BindAdd")
public class BindAddActivity extends BaseActivity {
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.text_right)
    TextView textRight;
    @BindView(R2.id.edit_organ)
    EditText editOrgan;
    @BindView(R2.id.edit_username)
    EditText editUsername;
    @BindView(R2.id.edit_password)
    EditText editPassword;

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.bind_add;
    }

    @Override
    public void initView() {
        title.setText(getString(R.string.bind_add));
        textRight.setText(getString(R.string.confirm_sure));
    }

    @OnClick({R2.id.back, R2.id.text_right})
    public void onViewClicked(View view) {
        int id = view.getId();
        if(id == R.id.text_right){
            bindAdd();
        }else if(id == R.id.back){
            finish();
        }
    }

    public void bindAdd() {
        String organ = editOrgan.getText().toString();
        String userName = editUsername.getText().toString();
        String password = editPassword.getText().toString();
        if(TextUtils.isEmpty(organ)){
            ToastUitl.showShort(R.string.organ_hint);
        }else if(TextUtils.isEmpty(userName)){
            ToastUitl.showShort(R.string.username_hint);
        }else if(TextUtils.isEmpty(password)){
            ToastUitl.showShort(R.string.password_hint);
        }else {

        }
    }

    public void showDialog(boolean success) {
        NormalDialog dialog = new NormalDialog(this);
        dialog.isTitleShow(false)
                .widthScale(0.75f)
                .content(getString(success?R.string.bind_success:R.string.bind_error))
                .contentTextSize(15)
                .contentTextColor(R.color.black)
                .setOnBtnClickL(()-> {
                    if(success){
                      finish();
                    }
                    dialog.dismiss();
                });
    }
}
