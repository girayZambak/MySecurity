package tr.mysecurity.entity;

public class UserMySecurity {

    private static final String TEXT_TABLE_NAME = "USER_MY_SECURITY";
    private static final String TEXT_ID = "ID";
    private static final String TEXT_FK_NUMBER_ID = "FK_NUMBER_ID";
    private static final String TEXT_NAME = "NAME";
    private static final String TEXT_SURNAME = "SURNAME";
    private static final String TEXT_E_MAIL = "E_MAIL";
    private static final String TEXT_REG_ID = "REG_ID";
    private static final String TEXT_DATE_OF_BIRTH = "DATE_OF_BIRTH";
    private static final String TEXT_DEVICE_ID = "DEVICE_ID";
    private static final String TEXT_SIM_SERIAL_NUMBER = "SIM_SERIAL_NUMBER";
    private static final String TEXT_ACTIVE = "ACTIVE";
    private static final String TEXT_IS_LOGIN = "IS_LOGIN";
    private static final String TEXT_IS_CONFIRMED = "IS_CONFIRMED";
    private static final String TEXT_AREA_CODE = "ALAN_KODU";
    private static final String TEXT_NUMBER = "NUMBER";
    private static final String TEXT_SERVER_USER_ID = "SERVER_USER_ID";

    private static final String TEXT_ID_TYPE = " INTEGER";
    private static final String TEXT_FK_NUMBER_ID_TYPE = " INTEGER";
    private static final String TEXT_NAME_TYPE = " TEXT";
    private static final String TEXT_SURNAME_TYPE = " TEXT";
    private static final String TEXT_E_MAIL_TYPE = " TEXT";
    private static final String TEXT_REG_ID_TYPE = " TEXT";
    private static final String TEXT_DATE_OF_BIRTH_TYPE = " DATE";
    private static final String TEXT_DEVICE_ID_TYPE = " TEXT";
    private static final String TEXT_SIM_SERIAL_NUMBER_TYPE = " TEXT";
    private static final String TEXT_ACTIVE_TYPE = " INTEGER";
    private static final String TEXT_IS_LOGIN_TYPE = " INTEGER";
    private static final String TEXT_IS_CONFIRMED_TYPE = " INTEGER";
    private static final String TEXT_AREA_CODE_TYPE = " TEXT";
    private static final String TEXT_NUMBER_TYPE = " TEXT";
    private static final String TEXT_SERVER_USER_ID_TYPE = " INTEGER";


    private static final String[] columnList = {TEXT_TABLE_NAME, TEXT_ID, TEXT_FK_NUMBER_ID, TEXT_NAME, TEXT_SURNAME, TEXT_E_MAIL,
            TEXT_REG_ID, TEXT_DATE_OF_BIRTH, TEXT_DEVICE_ID, TEXT_SIM_SERIAL_NUMBER, TEXT_ACTIVE, TEXT_IS_LOGIN, TEXT_IS_CONFIRMED,
            TEXT_AREA_CODE, TEXT_NUMBER, TEXT_SERVER_USER_ID};

    private static final String[] columnListTypes = {TEXT_TABLE_NAME, TEXT_ID_TYPE, TEXT_FK_NUMBER_ID_TYPE, TEXT_NAME_TYPE, TEXT_SURNAME_TYPE, TEXT_E_MAIL_TYPE,
            TEXT_REG_ID_TYPE, TEXT_DATE_OF_BIRTH_TYPE, TEXT_DEVICE_ID_TYPE, TEXT_SIM_SERIAL_NUMBER_TYPE, TEXT_ACTIVE_TYPE, TEXT_IS_LOGIN_TYPE, TEXT_IS_CONFIRMED_TYPE,
            TEXT_AREA_CODE_TYPE, TEXT_NUMBER_TYPE, TEXT_SERVER_USER_ID_TYPE};

    public UserMySecurity() {
    }

    public static String createTable() {
        return "CREATE TABLE " + TEXT_TABLE_NAME + "("
                + TEXT_ID + TEXT_ID_TYPE +" PRIMARY KEY,"
                + TEXT_FK_NUMBER_ID + TEXT_FK_NUMBER_ID_TYPE + ","
                + TEXT_NAME + TEXT_NAME_TYPE + ","
                + TEXT_SURNAME + TEXT_SURNAME_TYPE + ","
                + TEXT_E_MAIL + TEXT_E_MAIL_TYPE + ","
                + TEXT_REG_ID + TEXT_REG_ID_TYPE + ","
                + TEXT_DATE_OF_BIRTH + TEXT_DATE_OF_BIRTH_TYPE + ","
                + TEXT_DEVICE_ID + TEXT_DEVICE_ID_TYPE + ","
                + TEXT_SIM_SERIAL_NUMBER + TEXT_SIM_SERIAL_NUMBER_TYPE + ","
                + TEXT_ACTIVE + TEXT_ACTIVE_TYPE + ","
                + TEXT_IS_LOGIN + TEXT_IS_LOGIN_TYPE + ","
                + TEXT_IS_CONFIRMED + TEXT_IS_CONFIRMED_TYPE + ","
                + TEXT_AREA_CODE + TEXT_AREA_CODE_TYPE + ","
                + TEXT_NUMBER + TEXT_NUMBER_TYPE + ","
                + TEXT_SERVER_USER_ID + TEXT_SERVER_USER_ID_TYPE
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

    public static String getTextFkNumberId() {
        return TEXT_FK_NUMBER_ID;
    }

    public static String getTextName() {
        return TEXT_NAME;
    }

    public static String getTextSurname() {
        return TEXT_SURNAME;
    }

    public static String getTextEMail() {
        return TEXT_E_MAIL;
    }

    public static String getTextRegId() {
        return TEXT_REG_ID;
    }

    public static String getTextDateOfBirth() {
        return TEXT_DATE_OF_BIRTH;
    }

    public static String getTextDeviceId() {
        return TEXT_DEVICE_ID;
    }

    public static String getTextSimSerialNumber() {
        return TEXT_SIM_SERIAL_NUMBER;
    }

    public static String getTextActive() {
        return TEXT_ACTIVE;
    }

    public static String getTextIsLogin() {
        return TEXT_IS_LOGIN;
    }

    public static String getTextIsConfirmed() {
        return TEXT_IS_CONFIRMED;
    }

    public static String getTextAreaCode() {
        return TEXT_AREA_CODE;
    }

    public static String getTextNumber() {
        return TEXT_NUMBER;
    }

    public static String getTextServerUserId() {
        return TEXT_SERVER_USER_ID;
    }

    public static String getTextIdType() {
        return TEXT_ID_TYPE;
    }

    public static String getTextFkNumberIdType() {
        return TEXT_FK_NUMBER_ID_TYPE;
    }

    public static String getTextNameType() {
        return TEXT_NAME_TYPE;
    }

    public static String getTextSurnameType() {
        return TEXT_SURNAME_TYPE;
    }

    public static String getTextEMailType() {
        return TEXT_E_MAIL_TYPE;
    }

    public static String getTextRegIdType() {
        return TEXT_REG_ID_TYPE;
    }

    public static String getTextDateOfBirthType() {
        return TEXT_DATE_OF_BIRTH_TYPE;
    }

    public static String getTextDeviceIdType() {
        return TEXT_DEVICE_ID_TYPE;
    }

    public static String getTextSimSerialNumberType() {
        return TEXT_SIM_SERIAL_NUMBER_TYPE;
    }

    public static String getTextActiveType() {
        return TEXT_ACTIVE_TYPE;
    }

    public static String getTextIsLoginType() {
        return TEXT_IS_LOGIN_TYPE;
    }

    public static String getTextIsConfirmedType() {
        return TEXT_IS_CONFIRMED_TYPE;
    }

    public static String getTextAreaCodeType() {
        return TEXT_AREA_CODE_TYPE;
    }

    public static String getTextNumberType() {
        return TEXT_NUMBER_TYPE;
    }

    public static String getTextServerUserIdType() {
        return TEXT_SERVER_USER_ID_TYPE;
    }

    public static String[] getColumnList() {
        return columnList;
    }

    public static String[] getColumnListTypes() {
        return columnListTypes;
    }
}
