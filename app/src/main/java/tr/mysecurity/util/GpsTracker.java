package tr.mysecurity.util;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;

public class GpsTracker extends Service implements LocationListener {

    private final Context context;

    Boolean isGpsEnabled = false;
    Boolean isNetworkEnabled = false;
    Boolean canGetLocation = false;

    Location location;

    double latitude;
    double longitude;

    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATE = 10;
    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1;

    protected LocationManager locationManager;

    public GpsTracker(Context context) {
        this.context = context;
        getLocation();
    }

    public Location getLocation() {
        try {
            locationManager = (LocationManager) context.getSystemService(LOCATION_SERVICE);

            isGpsEnabled = locationManager.isProviderEnabled(locationManager.GPS_PROVIDER);
            isNetworkEnabled = locationManager.isProviderEnabled(locationManager.NETWORK_PROVIDER);

            if (!isGpsEnabled && !isNetworkEnabled) {

            } else {
                if(1==2) {
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    }
                }

                if (isNetworkEnabled) {
                    this.canGetLocation = true;
                    locationManager.requestLocationUpdates(
                            LocationManager.NETWORK_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATE, this);

                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(locationManager.NETWORK_PROVIDER);
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }
                if (isGpsEnabled) {
                    this.canGetLocation = true;
                    locationManager.requestLocationUpdates(
                            LocationManager.GPS_PROVIDER,
                            MIN_TIME_BW_UPDATES,
                            MIN_DISTANCE_CHANGE_FOR_UPDATE, this);

                    if (locationManager != null) {
                        location = locationManager.getLastKnownLocation(locationManager.GPS_PROVIDER);
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return location;
    }

    public void stopUsingGPS() {
        if (locationManager != null) {
            if(1==2) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                }
            }
            locationManager.removeUpdates(GpsTracker.this);
        }
    }

    public double getLatitude(){
        if(location != null){
            latitude = location.getLatitude();
        }
        return latitude;
    }

    public double getLongitude(){
        if(location != null){
            longitude = location.getLongitude();
        }
        return longitude;
    }

    public Boolean getCanGetLocation(){
        return this.canGetLocation;
    }

    public void showSettingsAlert(){

    }

    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
