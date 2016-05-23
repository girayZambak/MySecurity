package tr.mysecurity.business;

import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import tr.mysecurity.dao.UserDao;
import tr.mysecurity.dro.User;
import tr.mysecurity.util.CallRestService;
import tr.mysecurity.util.Session;
import tr.mysecurity.util.enums.UrlEnum;

public class UserService {
    private CallRestService callRestService;
    private Session session;

    public void logIn(String password, Context context){
        try{
            session = new Session(context);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fkUserId", session.getUser().getServerUserId());
            jsonObject.put("password", password);
            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.LOGIN, data);
            if (object != null) {
                if (object.getString("userDRO") != "null") {
                    UserDao userDao = new UserDao(context);
                    userDao.addLocalUser(new User(object.getJSONObject("userDRO")));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void logOut(Context context){
        try{
            session = new Session(context);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fkUserId", session.getUser().getServerUserId());
            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.LOGOUT, data);
            if (object != null) {
                if (object.getString("userDRO") != "null") {
                    UserDao userDao = new UserDao(context);
                    userDao.addLocalUser(new User(object.getJSONObject("userDRO")));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void confirmUser(Long fkNumberId, Long fkUserId, String code, Context context){
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("fkNumberId",fkNumberId);
            jsonObject.put("fkUserId",fkUserId);
            jsonObject.put("code",code);

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.CONFIRM_USER, data);
            if (object != null) {
                if (object.getString("userDRO") != "null") {
                    UserDao userDao = new UserDao(context);
                    userDao.addLocalUser(new User(object.getJSONObject("userDRO")));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(User user, String password, Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",user.getName());
            jsonObject.put("surname",user.getSurname());
            jsonObject.put("eMail",user.geteMail());
            jsonObject.put("dateOfBirth",user.getDateOfBirth());
            jsonObject.put("deviceId",user.getDeviceId());
            jsonObject.put("simSerialNumber",user.getSimSerialNumber());
            jsonObject.put("password",password);
            jsonObject.put("areaCode",user.getAreaCode());
            jsonObject.put("number",user.getNumber());
            jsonObject.put("regId",user.getRegId());

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.SAVE_USER, data);
            if (object != null) {
                if (object.getString("userDRO") != "null") {
                    UserDao userDao = new UserDao(context);
                    userDao.addLocalUser(new User(object.getJSONObject("userDRO")));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}