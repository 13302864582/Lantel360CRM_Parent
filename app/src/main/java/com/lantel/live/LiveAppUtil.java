package com.lantel.live;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;

import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.ToastUitl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import androidx.core.content.FileProvider;

public class LiveAppUtil {
    //进入直播app
    public static void NavigateLiveApp(Context context,String Room_ID,String Account){
        //检查是否安装了
        if(checkApkExist(context,"air.net.lantel.room")){
            //安装了就进入app，传房间号和账号
            String lang = "";//语言默认空为中文版(中文版zh_CN;英文版en_US)
            String roomID = Room_ID;//99,房间号
            String account = Account;//test99,账号
            String password = "";//123456,密码
            String visitorFlag = "1"; //0,是否游客(0:是;1:否)
            String encryptPwdFlag = "0";//0,密码是否加密(0:没加密;1:有加密)
            String server = "stu.forbestacademy.com";//meeting.tenchong.com,webConfig.xml对应目录(如果你对应的webConfig.xml地址为http://xxx/tcProxy/webConfig.xml，那server的值就要设置为xxx/tcProxy
            String rnd = "1";//随机码
            String url = "net.lantel.room://?lang="+lang+"&roomID="+roomID+"&account="+account+"&password="+password+"&visitorFlag="+visitorFlag+"&encryptPwdFlag="+encryptPwdFlag+"&server="+server+"&rnd="+rnd;
            LogUtils.d("Liveurl====="+url);
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent);
        }else{
            //没有，从包中取出，复制到本地并安装app
            installTCMeeting(context);
        }
    }


    /**
     * 判断是否安装了直播app
     * @param packageName
     * @return
     */
    private static boolean checkApkExist(Context context,String packageName){
        try {
            context.getPackageManager().getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
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
    private static void installTCMeeting(Context context) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String type = "application/vnd.android.package-archive";
        try {
            AssetManager assetManager = context.getAssets();
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
            Uri contentUri = FileProvider.getUriForFile(context, "com.lantel.lh01.fileprovider", f);
            intent.setDataAndType(contentUri, type);
        } else {
            intent.setDataAndType(Uri.fromFile(f),type);
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }

}
