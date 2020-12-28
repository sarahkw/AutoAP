package io.netcatkate.autoap;

import android.app.NotificationChannel;
import android.app.NotificationManager;

public class ServiceNotification {
    public final static String CHANNEL_ID = "CHANNEL_BACKGROUND_SERVICE";

    public static void createNotificationChannel(NotificationManager notificationManager) {
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Background Service", NotificationManager.IMPORTANCE_LOW);
        channel.setDescription("Indicates Auto AP is active.");
        notificationManager.createNotificationChannel(channel);
    }
}
