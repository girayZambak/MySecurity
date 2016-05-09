package tr.mysecurity.business;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import tr.mysecurity.dro.LocationDRO;
import tr.mysecurity.util.CallRestService;
import tr.mysecurity.util.enums.UrlEnum;

public class LocationService {
    private CallRestService callRestService;

    public Boolean sendLocation(Double latitude, Double longitude, Long fkEmergencyId, Long fkLocationSendType){
        try{
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("latitude", latitude);
            jsonObject.put("longitude", longitude);
            jsonObject.put("fkEmergencyId", fkEmergencyId);
            jsonObject.put("fkLocationSendType", fkLocationSendType);

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.LOCATION_SEND, data);

            if (object != null) {
                return !object.getBoolean("hasError");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public LocationDRO getLocationByEmergency(Long fkEmergencyId){
        LocationDRO locationDRO = null;
        try{
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("fkEmergencyId", fkEmergencyId);

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.LOCATION_GET_BY_EMERGENCY, data);

            if (object != null) {
                if (object.getString("locationDRO") != "null") {
                    locationDRO = new LocationDRO(object.getJSONObject("locationDRO"));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return locationDRO;
    }


}