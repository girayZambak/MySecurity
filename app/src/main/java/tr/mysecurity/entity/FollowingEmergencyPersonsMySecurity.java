package tr.mysecurity.entity;

public class FollowingEmergencyPersonsMySecurity {

    private static final String TEXT_TABLE_NAME = "FOLLWING_EMERGENCY_PERSON_MY_SECURITY";
    private static final String TEXT_ID = "ID";
    private static final String TEXT_FK_SENDER_USER_ID = "FK_SENDER_USER_ID";
    private static final String TEXT_FK_RECEIVER_NUMBER_ID = "FK_RECEIVER_NUMBER_ID";
    private static final String TEXT_AREA_CODE = "AREA_CODE";
    private static final String TEXT_NUMBER = "NUMBER";
    private static final String TEXT_NAME = "NAME";
    private static final String TEXT_SURNAME = "SURNAME";
    private static final String TEXT_ACTIVE = "ACTIVE";
    private static final String TEXT_IS_CONFIRMED = "IS_CONFIRMED";
    private static final String TEXT_IS_EMERGENCY_FOLLOW = "IS_EMERGENCY_FOLLOW";
    private static final String TEXT_IS_EMERGENCY_SMS = "IS_EMERGENCY_SMS";
    private static final String TEXT_SERVER_EMERGENCY_PERSON_ID = "SERVER_EMERGENCY_PERSON_ID";

    private static final String TEXT_ID_TYPE = " INTEGER";
    private static final String TEXT_FK_SENDER_USER_ID_TYPE = " INTEGER";
    private static final String TEXT_FK_RECEIVER_NUMBER_ID_TYPE = " INTEGER";
    private static final String TEXT_AREA_CODE_TYPE = " STRING";
    private static final String TEXT_NUMBER_TYPE = " STRING";
    private static final String TEXT_NAME_TYPE = " STRING";
    private static final String TEXT_SURNAME_TYPE = " STRING";
    private static final String TEXT_ACTIVE_TYPE = " INTEGER";
    private static final String TEXT_IS_CONFIRMED_TYPE = " INTEGER";
    private static final String TEXT_IS_EMERGENCY_FOLLOW_TYPE = " INTEGER";
    private static final String TEXT_IS_EMERGENCY_SMS_TYPE = " INTEGER";
    private static final String TEXT_SERVER_EMERGENCY_PERSON_ID_TYPE = " INTEGER";

    private static final String[] columnList = {TEXT_ID, TEXT_FK_SENDER_USER_ID, TEXT_FK_RECEIVER_NUMBER_ID, TEXT_AREA_CODE,
                                                TEXT_NUMBER, TEXT_NAME, TEXT_SURNAME, TEXT_ACTIVE, TEXT_IS_CONFIRMED,
                                                TEXT_IS_EMERGENCY_FOLLOW, TEXT_IS_EMERGENCY_SMS, TEXT_SERVER_EMERGENCY_PERSON_ID};

    private static final String[] columnListTypes = {TEXT_ID_TYPE, TEXT_FK_SENDER_USER_ID_TYPE, TEXT_FK_RECEIVER_NUMBER_ID_TYPE,
                                                    TEXT_AREA_CODE_TYPE, TEXT_NUMBER_TYPE, TEXT_NAME_TYPE, TEXT_SURNAME_TYPE,
                                                    TEXT_ACTIVE_TYPE, TEXT_IS_CONFIRMED_TYPE, TEXT_IS_EMERGENCY_FOLLOW_TYPE,
                                                    TEXT_IS_EMERGENCY_SMS_TYPE, TEXT_SERVER_EMERGENCY_PERSON_ID_TYPE};

    public FollowingEmergencyPersonsMySecurity() {
    }

    public static String createTable() {
        return "CREATE TABLE " + TEXT_TABLE_NAME + "("
                + TEXT_ID + TEXT_ID_TYPE +" PRIMARY KEY,"
                + TEXT_FK_SENDER_USER_ID + TEXT_FK_SENDER_USER_ID_TYPE+","
                + TEXT_FK_RECEIVER_NUMBER_ID + TEXT_FK_RECEIVER_NUMBER_ID_TYPE+","
                + TEXT_AREA_CODE +TEXT_AREA_CODE_TYPE+","
                + TEXT_NUMBER + TEXT_NUMBER_TYPE+","
                + TEXT_NAME + TEXT_NAME_TYPE+","
                + TEXT_SURNAME + TEXT_SURNAME_TYPE+","
                + TEXT_ACTIVE + TEXT_ACTIVE_TYPE+","
                + TEXT_IS_CONFIRMED + TEXT_IS_CONFIRMED_TYPE+","
                + TEXT_IS_EMERGENCY_FOLLOW + TEXT_IS_EMERGENCY_FOLLOW_TYPE+","
                + TEXT_IS_EMERGENCY_SMS + TEXT_IS_EMERGENCY_SMS_TYPE+","
                + TEXT_SERVER_EMERGENCY_PERSON_ID + TEXT_SERVER_EMERGENCY_PERSON_ID_TYPE
                +")";
    }

    public static String dropTable() {
        return "DROP TABLE " + TEXT_TABLE_NAME;
    }

    public static String getTextTableName() {
        return TEXT_TABLE_NAME;
    }

    public static String getTextId() {
        return TEXT_ID;
    }

    public static String getTextFkSenderUserId() {
        return TEXT_FK_SENDER_USER_ID;
    }

    public static String getTextFkReceiverNumberId() {
        return TEXT_FK_RECEIVER_NUMBER_ID;
    }

    public static String getTextAreaCode() {
        return TEXT_AREA_CODE;
    }

    public static String getTextNumber() {
        return TEXT_NUMBER;
    }

    public static String getTextName() {
        return TEXT_NAME;
    }

    public static String getTextSurname() {
        return TEXT_SURNAME;
    }

    public static String getTextActive() {
        return TEXT_ACTIVE;
    }

    public static String getTextIsConfirmed() {
        return TEXT_IS_CONFIRMED;
    }

    public static String getTextIsEmergencyFollow() {
        return TEXT_IS_EMERGENCY_FOLLOW;
    }

    public static String getTextIsEmergencySms() {
        return TEXT_IS_EMERGENCY_SMS;
    }

    public static String getTextServerEmergencyPersonId() {
        return TEXT_SERVER_EMERGENCY_PERSON_ID;
    }

    public static String getTextIdType() {
        return TEXT_ID_TYPE;
    }

    public static String getTextFkSenderUserIdType() {
        return TEXT_FK_SENDER_USER_ID_TYPE;
    }

    public static String getTextFkReceiverNumberIdType() {
        return TEXT_FK_RECEIVER_NUMBER_ID_TYPE;
    }

    public static String getTextAreaCodeType() {
        return TEXT_AREA_CODE_TYPE;
    }

    public static String getTextNumberType() {
        return TEXT_NUMBER_TYPE;
    }

    public static String getTextNameType() {
        return TEXT_NAME_TYPE;
    }

    public static String getTextSurnameType() {
        return TEXT_SURNAME_TYPE;
    }

    public static String getTextActiveType() {
        return TEXT_ACTIVE_TYPE;
    }

    public static String getTextIsConfirmedType() {
        return TEXT_IS_CONFIRMED_TYPE;
    }

    public static String getTextIsEmergencyFollowType() {
        return TEXT_IS_EMERGENCY_FOLLOW_TYPE;
    }

    public static String getTextIsEmergencySmsType() {
        return TEXT_IS_EMERGENCY_SMS_TYPE;
    }

    public static String getTextServerEmergencyPersonIdType() {
        return TEXT_SERVER_EMERGENCY_PERSON_ID_TYPE;
    }

    public static String[] getColumnList() {
        return columnList;
    }

    public static String[] getColumnListTypes() {
        return columnListTypes;
    }
}
