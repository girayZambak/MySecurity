package tr.mysecurity.managedBeans.map;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Timer;
import java.util.TimerTask;

import tr.mysecurity.R;
import tr.mysecurity.business.LocationService;
import tr.mysecurity.dro.LocationDRO;
import tr.mysecurity.managedBeans.MainActivity;
import tr.mysecurity.util.CallRestService;
import tr.mysecurity.util.GpsTracker;

public class MapActivity  extends FragmentActivity {
    private LocationService locationService;
    private CallRestService callRestService;
    private Long acilDurumId = 469L;
    private final int DELAY = 3000;
    private Integer zoomNumber= 13;
    private String data = "";
    private GoogleMap googleHarita;
    private GpsTracker gpsTracker;
    private Marker markerLastAdded;
    private Marker markerFirst;
    private Double latitude;
    private Double longitude;
    private LatLng koordinat;
    private LatLng myKoordinat;
    private Timer timer;
    private MyTask task;
    private Boolean follow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        haritaOlustur();
        timerBaslat();
    }

    private void timerBaslat() {
        if (timer != null) {
            timer.cancel();
        }
        timer = new Timer();
        task = new MyTask();
        callRestService = new CallRestService();
        timer.schedule(task, 2500, DELAY);

    }

    private void haritaOlustur() {
        if (googleHarita == null) {
            googleHarita = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.haritafragment)).getMap();
            googleHarita.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            gpsTracker = new GpsTracker(MapActivity.this);

            myKoordinat = new LatLng(gpsTracker.getLatitude(), gpsTracker.getLongitude());
            MarkerOptions markerOptions = new MarkerOptions().position(myKoordinat).title("Kendi Lokasyonum");
            markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));

            markerFirst = googleHarita.addMarker(markerOptions);
            googleHarita.moveCamera(CameraUpdateFactory.newLatLngZoom(myKoordinat, zoomNumber));
        }
    }

    private void getKoordinats(){
        if(locationService == null){
            locationService = LocationService.getInstance();
        }
        LocationDRO locationDRO = locationService.getLocationByEmergency(acilDurumId);

            if(locationDRO != null){
                if(locationDRO.getLatitude() != null && locationDRO.getLongitude() != null){
                    latitude = locationDRO.getLatitude();
                    longitude = locationDRO.getLongitude();
                }
            }
    }

    class MyTask extends TimerTask {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setLocation();
                }
            });
        }

    }

    public void setLocation(){
        this.getKoordinats();
        if (latitude != null && longitude != null) {
            koordinat = new LatLng(latitude, longitude);
            MarkerOptions markerOptions = new MarkerOptions().position(koordinat).title(latitude + " - " + longitude + " Ben Buradayım");

            if (markerLastAdded != null) {
                markerLastAdded.remove();
                googleHarita.addPolyline((new PolylineOptions()).add(markerLastAdded.getPosition(), koordinat).width(5).color(Color.BLUE).geodesic(true));
            }

            markerLastAdded = googleHarita.addMarker(markerOptions);
            if(follow){
                googleHarita.moveCamera(CameraUpdateFactory.newLatLng(koordinat));
            }
        }
    }

    public void anaSayfayaDon(View v){
        try {
            if (timer != null) {
                timer.cancel();
                task.cancel();
            }
        }finally {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void focus(View v){
        googleHarita.moveCamera(CameraUpdateFactory.newLatLng(koordinat));
    }

    public void follow(View v){
        follow = !follow;
    }

    public void zoomIn(View v){
        googleHarita.moveCamera(CameraUpdateFactory.zoomIn());
    }

    public void zoomOut(View v){
        googleHarita.moveCamera(CameraUpdateFactory.zoomOut());

    }

    public void mapType(View v){
        if(googleHarita.getMapType() == GoogleMap.MAP_TYPE_NORMAL){
            googleHarita.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            ((TextView)v).setText("Harita");
        }else{
            googleHarita.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            ((TextView)v).setText("Uydu");
        }
    }
}