package tr.mysecurity.util;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;

import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class CallRestService extends AppCompatActivity {

    public JSONObject callPost(String url, String data) throws UnsupportedEncodingException {

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        HttpClient client = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(client.getParams(), 10000); //Timeout Limit
        HttpResponse response;
        try {
            HttpPost post = new HttpPost(url);

            StringEntity se = new StringEntity(data);
            se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
            post.setEntity(se);
            response = client.execute(post);

            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            return new JSONObject(rd.readLine());
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


}


