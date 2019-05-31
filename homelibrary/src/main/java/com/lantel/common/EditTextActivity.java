package com.lantel.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.utils.TextUtils;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseActivity;
import androidx.appcompat.widget.AppCompatButton;
import butterknife.BindView;
import butterknife.OnClick;

@Route(path = "/lantel/360/EditText")
public class EditTextActivity extends BaseActivity {
    @BindView(R2.id.text)
    EditText editText;
    @BindView(R2.id.tip)
    TextView tip;
    @BindView(R2.id.btn_save_editText)
    AppCompatButton btnSaveEditText;
    private String edit_tip;
    private String edit_str;

    @Override
    public int getLayoutId() {
        return R.layout.edit_text;
    }

    @Override
    public void initView() {
        Intent intent = getIntent();
        edit_tip = intent.getStringExtra(Config.EDIT_TIP);
        edit_str = intent.getStringExtra(Config.EDIT_TEXT);
        if (edit_tip != null) {
            tip.setVisibility(View.VISIBLE);
            tip.setText(edit_tip);
        }

        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        if (edit_str != null) {
            editText.setText(edit_str);
            editText.setSelection(edit_str.length());
        }
    }

    @OnClick(R2.id.btn_save_editText)
    public void onViewClicked(View view) {
        if(view.getId() == R.id.btn_save_editText){
            String text = editText.getText().toString();
            if(!TextUtils.isEmpty(text)){
                Intent intent = new Intent();
                intent.putExtra(Config.EDIT_TEXT_RESULT,text);
                setResult(RESULT_OK,intent);
            }
            finish();
        }
    }
}
