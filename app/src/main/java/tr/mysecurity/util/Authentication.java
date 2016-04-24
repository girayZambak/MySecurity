package tr.mysecurity.util;

import android.content.Context;
import android.content.Intent;

import tr.mysecurity.dao.UserDao;
import tr.mysecurity.dro.User;
import tr.mysecurity.managedBeans.authentication.ConfirmActivity;
import tr.mysecurity.managedBeans.authentication.LoginActivity;
import tr.mysecurity.managedBeans.authentication.RegistrationActivity;
import tr.mysecurity.util.enums.UserControlEnum;

public class Authentication {
    private static UserDao userDao;
    private static UserControlEnum userControlEnum;
    private static User user;

    public void reLocate(Context context){
        userDao = new UserDao(context);
        userControlEnum = userDao.checkUser();

        user = userDao.getUser();

        if(userControlEnum == UserControlEnum.NO_USER){
            Intent intent = new Intent(context, RegistrationActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else if(userControlEnum == UserControlEnum.NOT_CONFIRMED){
            Intent intent = new Intent(context, ConfirmActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else if(userControlEnum == UserControlEnum.LOGGED_OUT){
            Intent intent = new Intent(context, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

    public static void login(){
        userDao.userLogIn();
    }

    public static UserControlEnum getUserControlEnum() {
        return userControlEnum;
    }

    public static void setUserControlEnum(UserControlEnum userControlEnum) {
        Authentication.userControlEnum = userControlEnum;
    }

    public static User getUser() {
        return user;
    }
}
