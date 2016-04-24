package tr.mysecurity.gcm;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import tr.mysecurity.managedBeans.MainActivity;
import tr.mysecurity.util.CallNotification;

public class GcmBroadcastReceiver extends WakefulBroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        ComponentName comp = new ComponentName(context.getPackageName(),
                GcmIntentService.class.getName());
        startWakefulService(context, (intent.setComponent(comp)));
        setResultCode(Activity.RESULT_OK);
        CallNotification.getInstance(context).callNotification(PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), 0), "baslik", "giray", 1);
    }


}