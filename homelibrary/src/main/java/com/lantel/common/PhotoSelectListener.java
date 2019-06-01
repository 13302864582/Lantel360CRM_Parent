package com.lantel.common;

import android.net.Uri;

public interface PhotoSelectListener {
    void onPhotoSelect(Uri uri);

    void onSelectAlbum();
}
