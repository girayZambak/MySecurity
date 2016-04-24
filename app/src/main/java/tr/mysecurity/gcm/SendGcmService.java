package tr.mysecurity.gcm;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;

import tr.mysecurity.util.enums.PingKeys;
import tr.mysecurity.util.enums.TrackingEvent;

/**
 * Created by user on 13.04.2016.
 */
public class SendGcmService {
    Context context;

    public SendGcmService(Context context){
        this.context = context;
    }

    public static SendGcmService getInstance(Context context){
        return new SendGcmService(context);
    }

    public void sendToGcm(){
        Bundle data = new Bundle();
        data.putString(PingKeys.ACTION, PingKeys.PING_CLIENT);
        data.putString(PingKeys.TO, RegisterApp.regid);
        data.putString(PingKeys.SENDER, RegisterApp.regid);

        try {
            GoogleCloudMessaging googleCloudMessaging = GoogleCloudMessaging.getInstance(context);
            googleCloudMessaging.send(PingKeys.PING_SERVER, String.valueOf(System.currentTimeMillis()), data);
            AnalyticsHelper.send(context, TrackingEvent.PING_SENT);
        } catch (IOException e) {
            Toast.makeText(context, "Hata", Toast.LENGTH_LONG).show();//Log.w(TAG, "Could not ping client.", e);
        }
        //mPingerAdapter.moveToTop(pinger);
    }
}
