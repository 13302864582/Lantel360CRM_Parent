package com.lantel.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cangwang.core.IBaseClient;
import com.cangwang.core.ModuleBus;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.gyf.immersionbar.BarHide;
import com.gyf.immersionbar.ImmersionBar;
import com.lantel.app.mvp.AppContract;
import com.lantel.app.mvp.AppModel;
import com.lantel.app.mvp.AppPresenter;
import com.lantel.common.HomeClient;
import com.lantel.crmparent.R;
import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.base.BaseMVPActivity;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.ToastUitl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import butterknife.BindView;

/**
 * app启动activity
 * */

@Route(path = "/lantelhome/360/app")
public class AppMVPActivity extends BaseMVPActivity<AppPresenter, AppModel> implements AppContract.View {
    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigation;
    private NavController mNavController;
    private NavHostFragment navHost;
    private int mLastNavId = -1;
    private boolean updateCard = false;
    private boolean updateHome = false;

    @Override
    protected BarHide hideBar() {
        return BarHide.FLAG_SHOW_BAR;
    }

    @Override
    protected int getStateBarviewID() {
        return -1;
    }

    @Override
    protected AppModel getModel() {
        return FindModel(AppModel.class);
    }

    @Override
    public int getLayoutId() {
        return R.layout.app;
    }

    @Override
    public void initPresenter() {
        mPresenter.setVM(this, mModel);
    }

    @Override
    public void initView() {
        bottomNavigation.setItemIconTintList(null);
        bottomNavigation.setOnNavigationItemSelectedListener(mPresenter);

        navHost = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.my_nav_host_fragment);
        mNavController = navHost.getNavController();
        navigate(R.id.action_mine);
        bottomNavigation.setSelectedItemId(R.id.item_mine);

        //初始化状态栏
        ImmersionBar.with(this)
                .hideBar(BarHide.FLAG_SHOW_BAR)
                .init();
    }

    @Override
    public void navigate(int action_id) {
        if(action_id == mLastNavId)
            return;
        mLastNavId = action_id;
        NavOptions.Builder builder = new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setEnterAnim(R.anim.nav_default_enter_anim)
                .setExitAnim(R.anim.nav_default_exit_anim)
                .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
                .setPopExitAnim(R.anim.nav_default_pop_exit_anim);
        NavOptions options = builder.build();
        mNavController.navigate(action_id,null,options);
    }

    @Override
    public void navigateZhibo() {
        if(checkApkExist("air.net.lantel.room")){
            String lang = "";//语言默认空为中文版(中文版zh_CN;英文版en_US)
            String roomID = "";//99,房间号
            String account = "";//test99,账号
            String password = "";//123456,密码
            String visitorFlag = ""; //0,是否游客(0:是;1:否)
            String encryptPwdFlag = "";//0,密码是否加密(0:没加密;1:有加密)
            String server = "";//meeting.tenchong.com,webConfig.xml对应目录(如果你对应的webConfig.xml地址为http://xxx/tcProxy/webConfig.xml，那server的值就要设置为xxx/tcProxy
            String rnd = "1";//随机码

            String url = "net.lantel.room://?lang="+lang+"&roomID="+roomID+"&account="+account+"&password="+password+"&visitorFlag="+visitorFlag+"&encryptPwdFlag="+encryptPwdFlag+"&server="+server+"&rnd="+rnd;
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }else{
            installTCMeeting();
        }
    }

    /**
     * 判断是否安装了直播app
     * @param packageName
     * @return
     */
    public boolean checkApkExist(String packageName){
        try {
            this.getPackageManager().getApplicationInfo(packageName,PackageManager.GET_UNINSTALLED_PACKAGES);
            ToastUitl.showShort("true");
            return true;
        } catch (Exception e) {
            ToastUitl.showShort("false"+e.toString());
            return false;
        }
    }

    /**
     * 安装直播app
     */
    private void installTCMeeting() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String type = "application/vnd.android.package-archive";
        try {
            AssetManager assetManager = getAssets();
            InputStream in;
            OutputStream out;
                in = assetManager.open("LTMeeting.apk");
                String outFileName = Environment.getExternalStorageDirectory().getAbsolutePath();//保存到外部存储,大部分设备是sd卡根目录
                String copyName = "LantelMeeting.apk";//copy后具体名称
                File outFile = new File(outFileName, copyName);
                out = new FileOutputStream(outFile);
                copyFile(in, out);
                in.close();
                out.flush();
                out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String outFileName = Environment.getExternalStorageDirectory().getAbsolutePath();//保存到外部存储,大部分设备是sd卡根目录
        String copyName = "LantelMeeting.apk";//copy后具体名称
        File f = new File(outFileName, copyName);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            //>7.0时 用 provider 共享
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Uri contentUri = FileProvider.getUriForFile(this, "com.lantel.lh01.fileprovider", f);
            intent.setDataAndType(contentUri, type);
        } else {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setDataAndType(Uri.fromFile(f),type);
        }
        this.startActivity(intent);
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

/*/data/data/com.lantel.lh01.test/files/TCMeeting.apk*/
    @Override
    public void showEmpty() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void showNetWorkError() {

    }

    @Override
    protected void onResume() {
        super.onResume();
      if(updateCard){
          updateCard = false;
          ModuleBus.getInstance().post(IBaseClient.class,"refreshCard","");
      }

        if(updateHome){
            updateHome = false;
            ModuleBus.getInstance().post(HomeClient.class,"refreshHomeTop","refreshHomeTop");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        LogUtils.d("REQUEST_CHANGE_BID==="+requestCode+"===="+resultCode);
        if(requestCode == Config.REQUEST_CHANGE_ACCOUNT && resultCode == Activity.RESULT_OK){
            updateCard = true;
        }

        if(requestCode == Config.REQUEST_CHANGE_BID && resultCode == Activity.RESULT_OK){
            updateHome = true;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
