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
public class WebViewActivity extends BaseActivity implements TbsReaderView.ReaderCallback {
    private TbsReaderView mTbsReaderView;
    private ContentObserver mDownloadObserver;
    private DownloadManager mDownloadManager;
    private long mRequestId;
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
        mTbsReaderView = new TbsReaderView(this, this);
        RelativeLayout rootRl = findViewById(R.id.rl_root);
        rootRl.addView(mTbsReaderView, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        mFileUrl = getIntent().getStringExtra(Config.FILE_URL);
        mFileName = parseName(mFileUrl);
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

    private void startDownload() {
        progressText.setText("0%");
        progressLay.setVisibility(View.VISIBLE);
        progressBar.startAnim();
        mDownloadObserver = new DownloadObserver(new Handler());
        Uri uri = Uri.fromFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS));
        LogUtils.d("startDownload==uri===="+uri.getPath());
        getContentResolver().registerContentObserver(/*Uri.parse("content://downloads/my_downloads")*/uri, true, mDownloadObserver);

        mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(mFileUrl));
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, mFileName);
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_HIDDEN);
        mRequestId = mDownloadManager.enqueue(request);
    }

    private void queryDownloadStatus() {
        DownloadManager.Query query = new DownloadManager.Query().setFilterById(mRequestId);
        Cursor cursor = null;
        try {
            cursor = mDownloadManager.query(query);
            if (cursor != null && cursor.moveToFirst()) {
                //已经下载的字节数
                int currentBytes = cursor.getInt(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
                //总需下载的字节数
                int totalBytes = cursor.getInt(cursor.getColumnIndexOrThrow(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
                //状态所在的列索引
                int status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS));
                Log.i("downloadUpdate: ", currentBytes + " " + totalBytes + " " + status);

                int progress = (int) ((float)currentBytes/totalBytes * 100);
                progressText.setText(progress+"%");
                if (DownloadManager.STATUS_SUCCESSFUL == status && progressLay.getVisibility() == View.VISIBLE) {
                    openFile();
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private void openFile() {
        LogUtils.d("LocalExist===="+isLocalExist());
        if (isLocalExist()) {
            progressLay.setVisibility(View.GONE);
            displayFile();
        } else {
            startDownload();
        }
    }

    @Override
    public void onCallBackAction(Integer integer, Object o, Object o1) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTbsReaderView.onStop();
        if (mDownloadObserver != null) {
            getContentResolver().unregisterContentObserver(mDownloadObserver);
        }
    }

    private class DownloadObserver extends ContentObserver {

        private DownloadObserver(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange, Uri uri) {
            Log.i("downloadUpdate: ", "onChange(boolean selfChange, Uri uri)");
            queryDownloadStatus();
        }
    }
}
