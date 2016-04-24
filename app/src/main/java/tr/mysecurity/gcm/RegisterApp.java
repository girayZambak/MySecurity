package tr.mysecurity.gcm;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import tr.mysecurity.managedBeans.MainActivity;
import tr.mysecurity.managedBeans.Splash;

public class RegisterApp extends AsyncTask<Void, Void, String> {

    private static final String TAG = "GCM";
    Context ctx;
    GoogleCloudMessaging gcm;
    final String PROJECT_ID = "463783117113";
    public static String regid = null;
    private int appVersion;

    public RegisterApp(Context ctx, GoogleCloudMessaging gcm, int appVersion) {
        this.ctx = ctx;
        this.gcm = gcm;
        this.appVersion = appVersion;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }


    @Override
    protected String doInBackground(Void... arg0) {
        String msg = "";
        try {
            if (gcm == null) {
                gcm = GoogleCloudMessaging.getInstance(ctx);
            }
            regid = gcm.register(PROJECT_ID);
            msg = "Registration ID=" + regid;


            sendRegistrationIdToBackend();

            storeRegistrationId(ctx, regid);

        } catch (IOException ex) {
            msg = "Error :" + ex.getMessage();

        }
        return msg;
    }

    private void storeRegistrationId(Context ctx, String regid) {
        final SharedPreferences prefs = ctx.getSharedPreferences(Splash.class.getSimpleName(),
                Context.MODE_PRIVATE);
        Log.i(TAG, "Saving regId on app version " + appVersion);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("registration_id", regid);
        editor.putInt("appVersion", appVersion);
        editor.apply();

    }


    private void sendRegistrationIdToBackend() {
        URI url = null;
        try {
            url = new URI("http://www.mulakatin.com/register.php?regId=" + regid);
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet request = new HttpGet();
        request.setURI(url);
        try {
            httpclient.execute(request);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Toast.makeText(ctx, "Notification alabilirsiniz", Toast.LENGTH_SHORT).show();
        Log.v(TAG, result);
        Intent i = new Intent(ctx, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        ctx.startActivity(i);
    }
}