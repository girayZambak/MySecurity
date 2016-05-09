package tr.mysecurity.business;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import tr.mysecurity.dro.EmergencyDRO;
import tr.mysecurity.util.CallRestService;
import tr.mysecurity.util.enums.UrlEnum;

public class EmergencyService {
    private CallRestService callRestService;

    public EmergencyDRO createEmergency(Long fkNumberId, Long fkEmergencyTypeId, Long fkEmergencyStatusId){
        EmergencyDRO emergencyDRO = null;
        try{
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("fkNumberId", fkNumberId);
            jsonObject.put("fkEmergencyTypeId", fkEmergencyTypeId);
            jsonObject.put("fkEmergencyStatusId", fkEmergencyStatusId);

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.EMERGENCY_CREATE, data);
            if (object != null) {
                if (object.getString("emergencyDRO") != "null") {
                    emergencyDRO = new EmergencyDRO(object.getJSONObject("emergencyDRO"));

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return emergencyDRO;
    }

    public EmergencyDRO checkActiveEmergency(Long fkNumberId){
        EmergencyDRO emergencyDRO = null;
        try{
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("fkNumberId", fkNumberId);

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.EMERGENCY_CHECK_ACTIVE, data);
            if (object != null) {
                if (object.getString("emergencyDRO") != "null") {
                    emergencyDRO = new EmergencyDRO(object.getJSONObject("emergencyDRO"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return emergencyDRO;
    }

    public Boolean disableEmergency(Long emergencyId){
        try{
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("emergencyId", emergencyId);

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.EMERGENCY_PASSIVE, data);
            if (object != null) {
                return object.getBoolean("isEmergencyDisabled");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }


}