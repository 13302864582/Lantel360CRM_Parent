package com.lantel.homelibrary.output;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.flyco.dialog.utils.CornerUtils;
import com.flyco.dialog.widget.base.BaseDialog;
import com.lantel.homelibrary.R;
import com.xiao360.baselibrary.util.ToastUitl;

public class RemarkDialog extends BaseDialog {
    private EditText remark_edit;
    private TextView commit;
    private RemarkListener listener;

    public EditText getRemark_edit() {
        return remark_edit;
    }

    public RemarkDialog(Context context, RemarkListener listener) {
        super(context,true);
        this.listener = listener;
    }

    @Override
    public View onCreateView() {
        setCanceledOnTouchOutside(true);
        View inflate = View.inflate(getContext(), R.layout.dialog_remark, null);
        commit = inflate.findViewById(R.id.commit);
        remark_edit = inflate.findViewById(R.id.remark_edit);
        inflate.setBackgroundDrawable(CornerUtils.cornerDrawable(Color.parseColor("#ffffff"), dp2px(5)));
        return inflate;
    }

    @Override
    public void setUiBeforShow() {
        remark_edit.setFocusable(true);
        remark_edit.setFocusableInTouchMode(true);
        remark_edit.requestFocus();
        Handler handle =new Handler();
        handle.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager inputManager =
                        (InputMethodManager)remark_edit.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(remark_edit, 0);
            }
        }, 100);

        commit.setOnClickListener((View view)-> {
            String remark = remark_edit.getText().toString();
            if(TextUtils.isEmpty(remark)){
                ToastUitl.showShort(R.string.empty_remark);
            } else{
                if(null != listener)
                    listener.commitRemark(remark);
            }
        });
    }


}
