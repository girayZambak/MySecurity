package tr.mysecurity.managedBeans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import tr.mysecurity.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();

    }
}
