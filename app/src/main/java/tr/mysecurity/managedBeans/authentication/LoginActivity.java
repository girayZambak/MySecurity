package tr.mysecurity.managedBeans.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

import tr.mysecurity.R;
import tr.mysecurity.business.UserService;
import tr.mysecurity.dao.UserDao;
import tr.mysecurity.managedBeans.MainActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    public void newUser(View v){
        Intent in = new Intent(getApplicationContext(), RegistrationActivity.class);
        startActivity(in);
    }

    public void login(View v){
        String numara = ((TextView)findViewById(R.id.loginPhoneNumber)).getText().toString();
        String password = ((TextView)findViewById(R.id.loginPassword)).getText().toString();
        if(numara != null && numara != "" && password != null && password != ""){
            UserService userService = new UserService();
            userService.logIn(password, getApplicationContext());

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        }
    }

    public void deletUser(View v){
        UserDao userDao = new UserDao(getApplicationContext());
        userDao.resetTable();
    }

    @Override
     public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
