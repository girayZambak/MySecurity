package tr.mysecurity.managedBeans.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import tr.mysecurity.R;
import tr.mysecurity.business.UserService;
import tr.mysecurity.managedBeans.MainActivity;
import tr.mysecurity.util.Authentication;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_activity);
    }

    public void confirmUser(View v){

        String code = ((TextView)findViewById(R.id.confirm_code)).getText().toString();
        UserService userService = new UserService();
        userService.confirmUser(Authentication.getUser().getFkNumberId(), Authentication.getUser().getServerUserId(), code, getApplicationContext());

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
