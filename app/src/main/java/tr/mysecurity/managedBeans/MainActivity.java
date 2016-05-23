package tr.mysecurity.managedBeans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import tr.mysecurity.R;
import tr.mysecurity.managedBeans.map.MapActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    public void open_map_activity(View v){
        startActivity(new Intent(this, MapActivity.class));
        finish();
    }
}
