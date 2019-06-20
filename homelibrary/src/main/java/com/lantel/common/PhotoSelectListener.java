package com.lantel.common;

import com.xiao360.baselibrary.util.MediaBean;

public interface PhotoSelectListener {
    void onPhotoSelect(MediaBean photoBean);

    void onSelectAlbum();
}
