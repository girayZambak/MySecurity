package tr.mysecurity.dro;

import org.json.JSONException;
import org.json.JSONObject;

public class EmergencyPersonDRO {
    private Long id;
    private Long fkSenderUserId;
    private Long fkReceiverNumberId;
    private String areaCode;
    private String number;
    private String name;
    private String surname;
    private Boolean active;
    private Boolean isConfirmed;
    private Boolean isEmergencySms;
    private Boolean isEmergencyFollow;
    private Long fkServerEmergencyPersonId;

    public EmergencyPersonDRO(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getLong("id");
        this.fkSenderUserId = jsonObject.getLong("fkSenderUserId");
        this.fkReceiverNumberId = jsonObject.getLong("fkReceiverNumberId");
        this.areaCode = jsonObject.getString("areaCode");
        this.number = jsonObject.getString("number");
        this.name = jsonObject.getString("name");
        this.surname = jsonObject.getString("surname");
        this.active = jsonObject.getBoolean("active");
        this.isConfirmed = jsonObject.getBoolean("isConfirmed");
        this.isEmergencyFollow =  jsonObject.getBoolean("isEmergencyFollow");
        this.isEmergencySms =  jsonObject.getBoolean("isEmergencySms");
    }

    public EmergencyPersonDRO(Long id, Long fkSenderUserId, Long fkReceiverNumberId, String areaCode, String number, String name, String surname, Boolean active, Boolean isConfirmed, Boolean isEmergencySms, Boolean isEmergencyFollow, Long fkServerEmergencyPersonId) {
        this.id = id;
        this.fkSenderUserId = fkSenderUserId;
        this.fkReceiverNumberId = fkReceiverNumberId;
        this.areaCode = areaCode;
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.active = active;
        this.isConfirmed = isConfirmed;
        this.isEmergencySms = isEmergencySms;
        this.isEmergencyFollow = isEmergencyFollow;
        this.fkServerEmergencyPersonId = fkServerEmergencyPersonId;
    }

    public Long getFkServerEmergencyPersonId() {
        return fkServerEmergencyPersonId;
    }

    public void setFkServerEmergencyPersonId(Long fkServerEmergencyPersonId) {
        this.fkServerEmergencyPersonId = fkServerEmergencyPersonId;
    }

    public Boolean getIsEmergencySms() {
        return isEmergencySms;
    }

    public void setIsEmergencySms(Boolean isEmergencySms) {
        this.isEmergencySms = isEmergencySms;
    }

    public Boolean getIsEmergencyFollow() {
        return isEmergencyFollow;
    }

    public void setIsEmergencyFollow(Boolean isEmergencyFollow) {
        this.isEmergencyFollow = isEmergencyFollow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkSenderUserId() {
        return fkSenderUserId;
    }

    public void setFkSenderUserId(Long fkSenderUserId) {
        this.fkSenderUserId = fkSenderUserId;
    }

    public Long getFkReceiverNumberId() {
        return fkReceiverNumberId;
    }

    public void setFkReceiverNumberId(Long fkReceiverNumberId) {
        this.fkReceiverNumberId = fkReceiverNumberId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getIsConfirmed() {
        return isConfirmed;
    }

    public void setIsConfirmed(Boolean isConfirmed) {
        this.isConfirmed = isConfirmed;
    }
}
