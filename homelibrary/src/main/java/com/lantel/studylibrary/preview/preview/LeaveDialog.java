package com.lantel.studylibrary.preview.preview;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.flyco.dialog.utils.CornerUtils;
import com.flyco.dialog.widget.base.BaseDialog;
import com.lantel.common.VerificationCountDownTimer;
import com.lantel.homelibrary.R;
import com.lantel.setting.bindAccount.BindPhoneListener;
import com.xiao360.baselibrary.util.ToastUitl;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LeaveDialog extends BaseDialog {
    private Context context;
    private LeaveDialogBean data;
    private ImageView close;
    private TextView teacher;
    private TextView time;
    private RecyclerView leave_list;
    private AppCompatButton confirm_btn;
    private CheckBox check;

    public LeaveDialog(Context context,LeaveDialogBean bean) {
        super(context);
        this.context = context;
        this.data = bean;
    }

    @Override
    public View onCreateView() {
        widthScale(0.85f);
        setCanceledOnTouchOutside(false);
        View inflate = View.inflate(getContext(), R.layout.dialog_leave, null);
        close = inflate.findViewById(R.id.close);
        teacher = inflate.findViewById(R.id.teacher);
        time = inflate.findViewById(R.id.time);
        leave_list = inflate.findViewById(R.id.leave_list);
        confirm_btn = inflate.findViewById(R.id.confirm_btn);
        check = inflate.findViewById(R.id.check);
        inflate.setBackgroundDrawable(CornerUtils.cornerDrawable(Color.parseColor("#ffffff"), dp2px(5)));
        return inflate;
    }

    @Override
    public void setUiBeforShow() {
        close.setOnClickListener((View view)-> {
            dismiss();
        });

        confirm_btn.setOnClickListener((View view)-> {
            boolean isDecCourseTime = check.isChecked();
        });

        teacher.setText(data.getTeacher());
        time.setText(data.getTime());
        leave_list.setLayoutManager(new LinearLayoutManager(context));
        //leave_list.setAdapter();
    }


}
