package tr.mysecurity.managedBeans.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import tr.mysecurity.R;
import tr.mysecurity.business.UserService;
import tr.mysecurity.dro.User;
import tr.mysecurity.managedBeans.MainActivity;

/**
 * Created by user on 10.04.2016.
 */
public class RegistrationActivity extends AppCompatActivity {
    private TelephonyManager tm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        tm = (TelephonyManager) getApplicationContext().getSystemService(getApplicationContext().TELEPHONY_SERVICE);
    }

    public void saveUser(View v){
        String ad = ((TextView)findViewById(R.id.registrationName)).getText().toString();
        String soyad = ((TextView)findViewById(R.id.registrationSurName)).getText().toString();
        String phoneNumber = ((TextView)findViewById(R.id.registrationPhone)).getText().toString();
        String phoneNumberCode = ((Spinner)findViewById(R.id.spinnerAlanKodu)).getSelectedItem().toString();
        String birthDate = ((TextView)findViewById(R.id.registrationBirthDate)).getText().toString();
        String password = ((TextView)findViewById(R.id.registrationPassword)).getText().toString();
        String confirmPassword = ((TextView)findViewById(R.id.registrationReplacePassword)).getText().toString();

        if(password.equals(confirmPassword)){
            UserService userService = new UserService();
            User user = new User(
                    null,
                    new Long(41),
                    ad,
                    soyad,
                    null,
                    null,
                    null,
                    tm.getDeviceId(),
                    tm.getSimSerialNumber(),
                    false,
                    false,
                    false,
                    phoneNumber,
                    phoneNumberCode,
                    null
            );
            userService.saveUser(user, password, getApplicationContext());

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
