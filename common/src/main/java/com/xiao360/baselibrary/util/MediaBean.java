package com.xiao360.baselibrary.util;

import android.net.Uri;

import java.io.File;

public class MediaBean {
    private File imgFile;
    private Uri imgUri;

    public MediaBean(File imgFile, Uri imgUri) {
        this.imgFile = imgFile;
        this.imgUri = imgUri;
    }

    public File getImgFile() {
        return imgFile;
    }

    public void setImgFile(File imgFile) {
        this.imgFile = imgFile;
    }

    public Uri getImgUri() {
        return imgUri;
    }

    public void setImgUri(Uri imgUri) {
        this.imgUri = imgUri;
    }
}
