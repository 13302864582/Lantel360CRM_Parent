package com.lantel.setting.feedback;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.gyf.immersionbar.BarHide;
import com.httpsdk.http.Http;
import com.httpsdk.http.RxHelper;
import com.lantel.common.HeaderUtil;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.lantel.setting.feedback.api.FeedBackBean;
import com.lantel.setting.feedback.api.FeedBackReqBean;
import com.lantel.setting.feedback.api.FeedBackService;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.xiao360.baselibrary.base.BaseRxObserver;
import com.xiao360.baselibrary.util.SpCache;
import com.xiao360.baselibrary.util.ToastUitl;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.http.HeaderMap;

@Route(path = "/lantel/360/feedback")
public class FeedBackActivity extends BaseMVPActivity {
    @BindView(R2.id.statebarView)
    View statebarView;
    @BindView(R2.id.back)
    ImageView back;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.edit_text)
    EditText editText;
    @BindView(R2.id.text_progress)
    TextView textProgress;
    @BindView(R2.id.edit_content)
    LinearLayout editContent;
    @BindView(R2.id.exit_commit)
    Button exitCount;
    @BindView(R2.id.content)
    ConstraintLayout content;

    private int maxLength = 200;


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
        return R.layout.feedback_content;
    }

    @Override
    public void initPresenter() {

    }

    @Override
    public void initView() {
        title.setText(getString(R.string.feed_back));
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(editText.getText().length()>maxLength)
                    return;
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                textProgress.setText(editText.getText().length()+"/"+maxLength);
            }
        });
    }

    @OnClick({R2.id.back,R2.id.exit_commit})
    public void onViewClicked(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        }else if(id == R.id.exit_commit){
            String content = editText.getText().toString().trim();
            FeedBackService feedBackService = Http.getInstance().createRequest(FeedBackService.class);
            FeedBackReqBean reqBean = new FeedBackReqBean();
            reqBean.setSid(SpCache.getString(Config.SID,""));
            reqBean.setBid(SpCache.getString(Config.BID,""));
            if(!TextUtils.isEmpty(content))
            reqBean.setContent(content);
            feedBackService.feedback(HeaderUtil.getHeaderMap(),reqBean)
                    .compose(RxHelper.io_main())
                    .compose(bindToLifecycle())
                    .subscribe(new BaseRxObserver<FeedBackBean>() {
                        @Override
                        public void onSuccess(FeedBackBean data) {
                            ToastUitl.showShort(data.getMessage());
                            if(data.getError()==0){
                                finish();
                            }
                        }

                        @Override
                        public void onFailure(Throwable e) {
                            ToastUitl.showShort(e.getMessage());
                        }
                    });
        }
    }
}
