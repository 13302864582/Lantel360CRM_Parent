package com.lantel.common;

import android.app.DownloadManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.excellence.downloader.Downloader;
import com.excellence.downloader.exception.DownloadError;
import com.excellence.downloader.utils.IListener;
import com.lantel.homelibrary.R;
import com.lantel.homelibrary.R2;
import com.lantel.homelibrary.app.Config;
import com.ldoublem.loadingviewlib.view.LVFunnyBar;
import com.tencent.smtt.sdk.TbsReaderView;
import com.xiao360.baselibrary.base.BaseActivity;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.ToastUitl;

import java.io.File;
import androidx.constraintlayout.widget.ConstraintLayout;
import butterknife.BindView;

@Route(path = "/lantel/360/WebView")
public class WebOpenFileActivity extends BaseActivity implements TbsReaderView.ReaderCallback {
    private TbsReaderView mTbsReaderView;
    private String mFileName;
    private String mFileUrl;

    @BindView(R2.id.progress_lay)
    ConstraintLayout progressLay;
    @BindView(R2.id.progress_bar)
    LVFunnyBar progressBar;
    @BindView(R2.id.progress_text)
    TextView progressText;

    @Override
    protected int getStateBarviewID() {
        return R.id.statebarView;
    }

    @Override
    public int getLayoutId() {
        return R.layout.webview_lay;
    }

    @Override
    public void initView() {
        // 注册
        Downloader.register(this);
        mTbsReaderView = new TbsReaderView(this, this);
        RelativeLayout rootRl = findViewById(R.id.rl_root);
        rootRl.addView(mTbsReaderView, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        mFileUrl = getIntent().getStringExtra(Config.FILE_URL);
        mFileName = parseName(mFileUrl);
    }

    @Override
    protected void onResume() {
        super.onResume();
        openFile();
    }

    private void displayFile() {
        Bundle bundle = new Bundle();
        bundle.putString("filePath", getLocalFile().getPath());
        bundle.putString("tempPath", Environment.getExternalStorageDirectory().getPath());
        boolean result = mTbsReaderView.preOpen(parseFormat(mFileName), false);
        if (result) {
            mTbsReaderView.openFile(bundle);
        }else {
            ToastUitl.showShort(R.string.open_file_fail);
            finish();
        }

    }

    private String parseFormat(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    private String parseName(String url) {
        String fileName = null;
        try {
            fileName = url.substring(url.lastIndexOf("/") + 1);
        } finally {
            if (TextUtils.isEmpty(fileName)) {
                fileName = String.valueOf(System.currentTimeMillis());
            }
        }
        return fileName;
    }

    private boolean isLocalExist() {
        return getLocalFile().exists();
    }

    private File getLocalFile() {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), mFileName);
    }

    private void openFile() {
        if (isLocalExist()) {
            displayFile();
        } else {
            downLoad();
        }
    }

    @Override
    public void onCallBackAction(Integer integer, Object o, Object o1) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 解绑
        Downloader.unregister(this);
        // 暂停所有下载任务，使用文件长度保存断点
        Downloader.destroy();
        mTbsReaderView.onStop();
    }

    private void downLoad() {
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),mFileName);
        // 文件路径，下载链接，监听接口可以使用IListener接口，也可以使用Listener监听部分回调
        Downloader.addTask(file, mFileUrl, new IListener() {
            @Override
            public void onPreExecute(long fileSize) {
                progressLay.setVisibility(View.VISIBLE);
                progressBar.startAnim();
                progressText.setText("0%");
            }

            @Override
            public void onProgressChange(long fileSize, long downloadedSize) {
                int progress = (int) ((float)downloadedSize/fileSize * 100);
                progressText.setText(progress+"%");
            }

            @Override
            public void onProgressChange(long fileSize, long downloadedSize, long speed) {
                int progress = (int) ((float)downloadedSize/fileSize * 100);
                progressText.setText(progress+"%");
            }

            @Override
            public void onCancel() {
                progressLay.setVisibility(View.GONE);
            }

            @Override
            public void onError(DownloadError error) {
                progressLay.setVisibility(View.GONE);
            }

            @Override
            public void onSuccess() {
                progressLay.setVisibility(View.GONE);
                openFile();
            }
        });
    }
}
