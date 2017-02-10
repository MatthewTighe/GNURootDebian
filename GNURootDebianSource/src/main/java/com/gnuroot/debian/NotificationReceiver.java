package com.gnuroot.debian;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        int notificationId = intent.getIntExtra("notificationId", 0);
        String notificationType = intent.getStringExtra("notificationType");
        if(notificationType == null) {
            //TODO this should never be null
        }

        //cancel notification
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        //notificationManager.cancel(notificationId);

        switch(notificationType) {
            case "GNURoot Service":
                Intent killIntent = new Intent("com.gnuroot.debian.KILL_EVERYTHING");
                killIntent.addCategory(Intent.CATEGORY_DEFAULT);
                killIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(killIntent);
                break;
            case "VNC Service":
                Intent vncReconnect = new Intent("com.gnuroot.debian.VNC_RECONNECT");
                vncReconnect.addCategory(Intent.CATEGORY_DEFAULT);
                vncReconnect.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(vncReconnect);
                break;
        }
    }
}
