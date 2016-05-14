package tr.mysecurity.business;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import tr.mysecurity.dro.EmergencyPersonDRO;
import tr.mysecurity.util.CallRestService;
import tr.mysecurity.util.enums.UrlEnum;

public class EmergencyPersonService {
    private CallRestService callRestService;

    public EmergencyPersonDRO createEmergencyPerson(Long fkSenderUserId, String areaCode, String number, String name, String surname, Boolean emergencySms, Boolean emergencyFollow){
        EmergencyPersonDRO emergencyPersonDRO = null;
        try{
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("fkSenderUserId", fkSenderUserId);
            jsonObject.put("areaCode", areaCode);
            jsonObject.put("number", number);
            jsonObject.put("name", name);
            jsonObject.put("surname", surname);
            jsonObject.put("emergencySms", emergencySms);
            jsonObject.put("emergencyFollow", emergencyFollow);

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.EMERGENCY_PERSON_CREATE, data);
            if (object != null) {
                if (object.getString("emergencyPersonDRO") != "null") {
                    emergencyPersonDRO = new EmergencyPersonDRO(object.getJSONObject("emergencyPersonDRO"));

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return emergencyPersonDRO;
    }

    public EmergencyPersonDRO updateEmergencyPerson(Long fkEmergencyPersonId, Boolean emergencySms, Boolean emergencyFollow){
        EmergencyPersonDRO emergencyPersonDRO = null;
        try{
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("fkEmergencyPersonId", fkEmergencyPersonId);
            jsonObject.put("emergencySms", emergencySms);
            jsonObject.put("emergencyFollow", emergencyFollow);

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.EMERGENCY_PERSON_CREATE, data);
            if (object != null) {
                if (object.getString("emergencyPersonDRO") != "null") {
                    emergencyPersonDRO = new EmergencyPersonDRO(object.getJSONObject("emergencyPersonDRO"));

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return emergencyPersonDRO;
    }

    public Boolean confirmEmergencyPerson(Long fkEmergencyPersonId, Long fkUserId) {
        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("fkEmergencyPersonId", fkEmergencyPersonId);
            jsonObject.put("fkUserId", fkUserId);

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.EMERGENCY_PERSON_CONFIRM, data);
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

    public Boolean deleteEmergencyPerson(Long fkEmergencyPersonId) {
        try {
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("fkEmergencyPersonId", fkEmergencyPersonId);

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.EMERGENCY_PERSON_DELETE, data);
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

    public List<EmergencyPersonDRO> getFollowingEmergencyPersons(Long fkNumberId){
        List<EmergencyPersonDRO> emergencyPersonDROList = new ArrayList<>();
        try{
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("fkNumberId", fkNumberId);

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.EMERGENCY_PERSONS_GET_FOLLOWING, data);
            if (object != null) {
                JSONArray responseDROList = object.getJSONArray("emergencyPersonDROList");
                if (responseDROList.length() != 0) {
                    for(int i = 0; i < responseDROList.length();i++){
                        emergencyPersonDROList.add(new EmergencyPersonDRO(responseDROList.getJSONObject(i)));
                    }

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return emergencyPersonDROList;
    }

    public List<EmergencyPersonDRO> getMyEmergencyPersons(Long fkUserId){
        List<EmergencyPersonDRO> emergencyPersonDROList = new ArrayList<>();
        try{
            JSONObject jsonObject = new JSONObject();

            jsonObject.put("fkUserId", fkUserId);

            String data = jsonObject.toString();

            if (callRestService == null) {
                callRestService = new CallRestService();
            }

            JSONObject object = callRestService.callPost(UrlEnum.EMERGENCY_PERSONS_GET_MY, data);
            if (object != null) {
                JSONArray responseDROList = object.getJSONArray("emergencyPersonDROList");
                if (responseDROList.length() != 0) {
                    for(int i = 0; i < responseDROList.length();i++){
                        emergencyPersonDROList.add(new EmergencyPersonDRO(responseDROList.getJSONObject(i)));
                    }

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return emergencyPersonDROList;
    }
}