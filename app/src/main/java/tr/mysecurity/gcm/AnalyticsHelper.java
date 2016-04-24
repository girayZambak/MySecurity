package tr.mysecurity.gcm;

import android.content.Context;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.analytics.Tracker;

import tr.mysecurity.R;
import tr.mysecurity.util.enums.TrackingEvent;

/**
 * Created by user on 13.04.2016.
 */
public class AnalyticsHelper {
    private static Tracker mTracker;

    public static synchronized Tracker getDefaultTracker(Context context) {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(context.getApplicationContext());
            analytics.getLogger().setLogLevel(Logger.LogLevel.VERBOSE);
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }

    public static synchronized void send(Context context, TrackingEvent event) {
        getDefaultTracker(context.getApplicationContext()).send(new HitBuilders.EventBuilder(event.getCategory(), event.getAction()).build());
    }
}
