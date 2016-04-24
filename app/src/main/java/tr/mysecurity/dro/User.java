package tr.mysecurity.dro;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;

public class User {
    private Long id;
    private Long fkNumberId;
    private String name;
    private String surname;
    private String eMail;
    private String regId;
    private Date dateOfBirth;
    private String deviceId;
    private String simSerialNumber;
    private Boolean active;
    private Boolean isLogin;
    private Boolean isConfirmed;
    private String number;
    private String areaCode;
    private Long serverUserId;

    public User(JSONObject jsonObject) throws JSONException {
        this.fkNumberId = jsonObject.getLong("fkNumberId");
        this.name = jsonObject.getString("name");
        this.surname = jsonObject.getString("surname");
        this.eMail = jsonObject.getString("eMail");
        this.regId = jsonObject.getString("regId");
        //this.dateOfBirth = jsonObject.("fkNumberId");
        this.deviceId = jsonObject.getString("deviceId");
        this.simSerialNumber = jsonObject.getString("simSerialNumber");
        this.active = jsonObject.getBoolean("active");
        this.isLogin = jsonObject.getBoolean("isLogin");
        this.isConfirmed = jsonObject.getBoolean("isConfirmed");
        this.number = jsonObject.getString("number");
        this.areaCode = jsonObject.getString("areaCode");
        this.serverUserId = jsonObject.getLong("id");

    }

    public User(Long id, Long fkNumberId, String name, String surname, String eMail, String regId, Date dateOfBirth, String deviceId, String simSerialNumber, Boolean active, Boolean isLogin, Boolean isConfirmed, String number, String areaCode, Long serverUserId) {
        this.id = id;
        this.fkNumberId = fkNumberId;
        this.name = name;
        this.surname = surname;
        this.eMail = eMail;
        this.regId = regId;
        this.dateOfBirth = dateOfBirth;
        this.deviceId = deviceId;
        this.simSerialNumber = simSerialNumber;
        this.active = active;
        this.isLogin = isLogin;
        this.isConfirmed = isConfirmed;
        this.number = number;
        this.areaCode = areaCode;
        this.serverUserId = serverUserId;
    }

    public Long getId() {
        return id;
    }

    public Long getFkNumberId() {
        return fkNumberId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String geteMail() {
        return eMail;
    }

    public String getRegId() {
        return regId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getSimSerialNumber() {
        return simSerialNumber;
    }

    public Boolean getActive() {
        return active;
    }

    public Boolean getIsLogin() {
        return isLogin;
    }

    public Boolean getIsConfirmed() {
        return isConfirmed;
    }

    public String getNumber() {
        return number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public Long getServerUserId() {
        return serverUserId;
    }

    public void setServerUserId(Long serverUserId) {
        this.serverUserId = serverUserId;
    }
}
