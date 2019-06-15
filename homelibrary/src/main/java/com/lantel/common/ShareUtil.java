package com.lantel.common;

import android.content.Context;

import cn.sharesdk.onekeyshare.OnekeyShare;

public class ShareUtil {
    public static void showShare(Context context,String title, String shareUrl, String sharetext, String[] imageArray) {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle(title);
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl("http://www.baidu.com");
        // text是分享文本，所有平台都需要这个字段
        oks.setText(sharetext);
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
       // oks.setImageArray(imageArray);
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl("http://www.baidu.com");
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment("我是测试评论文本");
        // 启动分享GUI
        oks.show(context);
    }
}
