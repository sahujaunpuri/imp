package com.gnnsnowszerro.psngiftcardsgenerator.services;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.gnnsnowszerro.psngiftcardsgenerator.R;
import com.gnnsnowszerro.psngiftcardsgenerator.activitys.StartActivity;

/**
 * Created by mykola on 19.06.17.
 */

public class ShowNotification extends IntentService {

    public ShowNotification() {
        super("ShowNotification");
    }

    public static Intent newIntent(Context c) {
        return new Intent(c, ShowNotification.class);
    }


    @Override
    protected void onHandleIntent(Intent intent) {

        Intent i = new Intent(this, StartActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, i, 0);
        Resources resources = getResources();
        Notification notification = new NotificationCompat.Builder(this)
                .setTicker(getString(R.string.notivication_message))
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(resources.getString(R.string.app_name))
                .setContentText(getString(R.string.notivication_message))
                .setContentIntent(pi)
                .setAutoCancel(true)
                .build();
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(0, notification);

    }


    public static void setServiceAlarm(Context context) {
        Intent i = newIntent(context);
        PendingIntent pi = PendingIntent.getService(context, 0, i, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() + AlarmManager.INTERVAL_DAY, AlarmManager.INTERVAL_DAY, pi);

    }
}
