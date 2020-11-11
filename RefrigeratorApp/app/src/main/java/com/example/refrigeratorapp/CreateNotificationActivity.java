package com.example.refrigeratorapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.NotificationCompat;

public class CreateNotificationActivity extends NotificationReciever {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notification);
    }

    public void createNotification(View view) {
        /**
         * Maybe implement to create stack
         */
//        Intent resultIntent = new Intent(this, ResultActivity.class);
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        stackBuilder.addParentStack(ResultActivity.class);

        Notification.Builder notif = new Notification.Builder(this)
                .setSmallIcon(R.drawable.icon)
                .setContentTitle("An item in your refrigerator is about to expire")
                .setContentText("This item" + " item " + "is about to expire" );

        Intent notificationIntent = new Intent(this, NotificationReciever.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this,
                (int) System.currentTimeMillis(), notificationIntent, 0);
                notif.setContentIntent(contentIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        // hide the notification after its selected
        notificationManager.notify(0, notif.build());
    }
}