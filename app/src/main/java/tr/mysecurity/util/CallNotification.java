package tr.mysecurity.util;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;

import tr.mysecurity.R;

/**
 * Created by user on 13.04.2016.
 */
public class CallNotification {
    private Context context;
    public CallNotification(Context context){
        this.context = context;
    }

    public static CallNotification getInstance(Context context){
        return new CallNotification(context);
    }

    public void callNotification(PendingIntent contentIntent, String title, String ad, Integer notificationId) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.ic_action_about)
                        .setContentTitle(title)
                        .setContentText(ad)
                        .setContentIntent(contentIntent)
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                        .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});

        manager.notify(notificationId, builder.build());
    }
}
