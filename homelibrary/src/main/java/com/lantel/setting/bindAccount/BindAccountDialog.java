package com.lantel.setting.bindAccount;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.flyco.dialog.utils.CornerUtils;
import com.flyco.dialog.widget.base.BaseDialog;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.util.LogUtils;
import androidx.appcompat.widget.AppCompatButton;

public class BindAccountDialog extends BaseDialog {
    private ImageView close;
    private EditText edit_phone;
    private EditText edit_sms;
    private TextView send_sms;
    private AppCompatButton confirm_btn;

    public BindAccountDialog(Context context) {
        super(context);
    }

    @Override
    public View onCreateView() {
        widthScale(0.85f);
        setCanceledOnTouchOutside(false);
        View inflate = View.inflate(getContext(), R.layout.dialog_bind_account, null);
        close = inflate.findViewById(R.id.close);
        edit_phone = inflate.findViewById(R.id.edit_phone);
        edit_sms = inflate.findViewById(R.id.edit_sms);
        send_sms = inflate.findViewById(R.id.send_sms);
        confirm_btn = inflate.findViewById(R.id.confirm_btn);
        inflate.setBackgroundDrawable(CornerUtils.cornerDrawable(Color.parseColor("#ffffff"), dp2px(5)));
        return inflate;
    }

    @Override
    public void setUiBeforShow() {
        close.setOnClickListener((View view)-> {
            LogUtils.d("setUiBeforShow=====close");
            dismiss();
        });

        send_sms.setOnClickListener((View view)-> {
            LogUtils.d("setUiBeforShow=====send_sms");
            dismiss();
        });

        confirm_btn.setOnClickListener((View view)-> {
            LogUtils.d("setUiBeforShow=====confirm_btn");
            dismiss();
        });
    }
}
