package tr.mysecurity.dro;

import org.json.JSONException;
import org.json.JSONObject;

public class LocationDRO {
    private Long id;
    private Double latitude;
    private Double longitude;
    private Long fkEmergencyId;
    private Long fkLocationSendType;
    private Boolean isEmergencyActive;
    private String locationSendType;

    public LocationDRO(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getLong("id");
        this.latitude = jsonObject.getDouble("latitude");
        this.longitude = jsonObject.getDouble("longitude");
        this.fkEmergencyId = jsonObject.getLong("fkEmergencyId");
        this.fkLocationSendType = jsonObject.getLong("fkLocationSendType");
        this.isEmergencyActive = jsonObject.getBoolean("isEmergencyActive");
        this.locationSendType = jsonObject.getString("locationSendType");
    }

    public LocationDRO(Double latitude, Double longitude, Long fkEmergencyId, Long fkLocationSendType) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.fkEmergencyId = fkEmergencyId;
        this.fkLocationSendType = fkLocationSendType;
    }

    public Boolean getIsEmergencyActive() {
        return isEmergencyActive;
    }

    public void setIsEmergencyActive(Boolean isEmergencyActive) {
        this.isEmergencyActive = isEmergencyActive;
    }

    public String getLocationSendType() {
        return locationSendType;
    }

    public void setLocationSendType(String locationSendType) {
        this.locationSendType = locationSendType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Long getFkEmergencyId() {
        return fkEmergencyId;
    }

    public void setFkEmergencyId(Long fkEmergencyId) {
        this.fkEmergencyId = fkEmergencyId;
    }

    public Long getFkLocationSendType() {
        return fkLocationSendType;
    }

    public void setFkLocationSendType(Long fkLocationSendType) {
        this.fkLocationSendType = fkLocationSendType;
    }
}
