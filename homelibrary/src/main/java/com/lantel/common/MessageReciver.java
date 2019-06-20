package com.lantel.common;

import android.content.Context;

import com.lantel.homelibrary.app.Config;
import com.xiao360.baselibrary.util.LogUtils;
import com.xiao360.baselibrary.util.SpCache;

import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.NotificationMessage;
import cn.jpush.android.service.JPushMessageReceiver;
import me.leolin.shortcutbadger.ShortcutBadger;

public class MessageReciver extends JPushMessageReceiver {
    @Override
    public void onMessage(Context context, CustomMessage customMessage) {
        super.onMessage(context, customMessage);
        int count = SpCache.getInt(Config.COUNT_NOTIFY,0);
        count += 1;
        ShortcutBadger.applyCount(context, count); //for 1.1.4+
        LogUtils.d("onMessage====mess==="+count);
    }

    @Override
    public void onNotifyMessageArrived(Context context, NotificationMessage notificationMessage) {
        super.onNotifyMessageArrived(context, notificationMessage);
        int count = SpCache.getInt(Config.COUNT_NOTIFY,0);
        count += 1;
        ShortcutBadger.applyCount(context, count); //for 1.1.4+
        LogUtils.d("badgeonMessageCount====notify==="+count);
    }
}
