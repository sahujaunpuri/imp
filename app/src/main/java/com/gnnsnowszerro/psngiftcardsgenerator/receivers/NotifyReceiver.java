package com.gnnsnowszerro.psngiftcardsgenerator.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.gnnsnowszerro.psngiftcardsgenerator.services.ShowNotification;

/**
 * Created by mykola on 19.06.17.
 */

public class NotifyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ShowNotification.setServiceAlarm(context);
    }
}
