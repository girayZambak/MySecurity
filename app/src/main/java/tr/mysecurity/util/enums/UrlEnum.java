package tr.mysecurity.util.enums;

public class UrlEnum{
    public static final String BASE_URL = "http://78.175.45.174:8082/";

    public static final String SAVE_USER = BASE_URL+"user/saveUser";
    public static final String LOGIN = BASE_URL+"user/logIn";
    public static final String LOGOUT = BASE_URL+"user/logOut";

    public static final String CONFIRM_USER = BASE_URL+"confirm/checkConfirmSaveUser";

    public static final String LOCATION_SEND = BASE_URL+"location/sendLocation";
    public static final String LOCATION_GET_BY_EMERGENCY = BASE_URL+"location/getLocationByEmergency";

    public static final String EMERGENCY_PERSON_CREATE = BASE_URL+"emergencyPerson/createEmergencyPerson";
    public static final String EMERGENCY_PERSON_CONFIRM = BASE_URL+"emergencyPerson/confirmEmergencyPerson";
    public static final String EMERGENCY_PERSON_DELETE = BASE_URL+"emergencyPerson/deleteEmergencyPerson";
    public static final String EMERGENCY_PERSONS_GET_MY = BASE_URL+"emergencyPerson/getMyEmergencyPersons";
    public static final String EMERGENCY_PERSONS_GET_FOLLOWING = BASE_URL+"emergencyPerson/getFollowingEmergencyPersons";

    public static final String EMERGENCY_CREATE = BASE_URL+"emergency/createEmergency";
    public static final String EMERGENCY_CHECK_ACTIVE = BASE_URL+"emergency/checkActiveEmergency";
    public static final String EMERGENCY_PASSIVE = BASE_URL+"emergency/passiveEmergency";


}