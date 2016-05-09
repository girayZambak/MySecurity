package tr.mysecurity.dro;

import org.json.JSONException;
import org.json.JSONObject;

public class EmergencyDRO {
    private Long id;
    private Long fkNumberId;
    private Long fkEmergencyTypeId;
    private Long fkEmergencyStatusId;

    public EmergencyDRO(JSONObject jsonObject) throws JSONException {
        this.id = jsonObject.getLong("id");
        this.fkNumberId = jsonObject.getLong("fkNumberId");
        this.fkEmergencyTypeId = jsonObject.getLong("fkEmergencyTypeId");
        this.fkEmergencyStatusId = jsonObject.getLong("fkEmergencyStatusId");
    }

    public EmergencyDRO(Long id, Long fkNumberId, Long fkEmergencyTypeId, Long fkEmergencyStatusId) {
        this.id = id;
        this.fkNumberId = fkNumberId;
        this.fkEmergencyTypeId = fkEmergencyTypeId;
        this.fkEmergencyStatusId = fkEmergencyStatusId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFkNumberId() {
        return fkNumberId;
    }

    public void setFkNumberId(Long fkNumberId) {
        this.fkNumberId = fkNumberId;
    }

    public Long getFkEmergencyTypeId() {
        return fkEmergencyTypeId;
    }

    public void setFkEmergencyTypeId(Long fkEmergencyTypeId) {
        this.fkEmergencyTypeId = fkEmergencyTypeId;
    }

    public Long getFkEmergencyStatusId() {
        return fkEmergencyStatusId;
    }

    public void setFkEmergencyStatusId(Long fkEmergencyStatusId) {
        this.fkEmergencyStatusId = fkEmergencyStatusId;
    }
}
