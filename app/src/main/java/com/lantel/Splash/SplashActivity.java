package com.lantel.Splash;

import android.annotation.SuppressLint;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleEvent;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.lantel.common.LocalImageHolderView;
import com.lantel.crmparent.R;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.util.SpCache;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import me.jessyan.retrofiturlmanager.RetrofitUrlManager;

public class SplashActivity extends BaseActivity {
    @BindView(R.id.banner)
    ConvenientBanner banner;
    @BindView(R.id.power)
    ImageView power;

    private int defaultSecond = 2;  //显示默认图时间2s

    @SuppressLint("HandlerLeak")
    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            defaultSecond--;
            if (defaultSecond == 0) {
                //倒计时完
                boolean isFirst = SpCache.getBoolean(Config.IS_FIRST, true);
                if (isFirst) {
                    //第一次，进入引导页
                    //SpCache.putBoolean(Config.IS_FIRST, false);
                    power.setVisibility(View.GONE);
                } else {
                    NavigateApp();
                }
            } else {
                handler.sendEmptyMessageDelayed(1, 1000);
            }
        }
    };

    private void NavigateApp() {
        //不是首次，判断是否登陆
        boolean isLogin = SpCache.getBoolean(Config.IS_LOGIN, false);
        if (isLogin) {
            ARouter.getInstance().build("/lantelhome/360/app").navigation();
        } else {
            ARouter.getInstance().build("/lantelhome/360/login").navigation();
        }
        finish();
    }

    @ModuleEvent(coreClientClass = IBaseClient.class)
    public void GotoApp() {
        NavigateApp();
    }


    @Override
    protected int getStateBarviewID() {
        return -1;
    }

    @Override
    public int getLayoutId() {
        return R.layout.splash;
    }

    @Override
    public void initView() {
        //初始化状态栏
        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_HIDE_BAR)
                .init();

        // 可在 App 运行时,随时切换 BaseUrl (指定了 Domain-Name header 的接口)
        RetrofitUrlManager.getInstance().putDomain("x360p_cetner_api", "http://api.dev.xiao360.com");
        initBanner();
        //倒计2s
        handler.sendEmptyMessageDelayed(1, 1000);
    }

    private void initBanner() {
        //设置图片集合
        List<Integer> list = new ArrayList();
        TypedArray icons = getResources().obtainTypedArray(R.array.splash_img);
        for (int i = 0; i < icons.length(); i++) {
            list.add(icons.getResourceId(i, 0));
        }
        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        banner.setPages(
                new CBViewHolderCreator() {
                    @Override
                    public LocalImageHolderView createHolder(View itemView) {
                        return new LocalImageHolderView(itemView);
                    }

                    @Override
                    public int getLayoutId() {
                        return R.layout.item_splash_image;
                    }
                }, list);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        handler.removeCallbacksAndMessages(null);
    }
}
