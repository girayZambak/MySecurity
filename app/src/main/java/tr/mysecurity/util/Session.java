package tr.mysecurity.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.gson.*;

import tr.mysecurity.dro.User;

public class Session {
    private SharedPreferences prefs;

    public Session(Context cntx) {
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setUser(User user){
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(user);
        editor.putString("user", json);
        editor.commit();
    }

    public User getUser(){
        Gson gson = new Gson();
        String json = prefs.getString("user", "");
        User obj = gson.fromJson(json, User.class);
        return obj;
    }
}
