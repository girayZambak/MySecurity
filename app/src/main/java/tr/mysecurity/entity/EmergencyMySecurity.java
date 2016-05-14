package tr.mysecurity.entity;

public class EmergencyMySecurity {

    private static final String TEXT_TABLE_NAME = "EMERGENCY_MY_SECURITY";
    private static final String TEXT_ID = "ID";
    private static final String TEXT_FK_NUMBER_ID = "FK_NUMBER_ID";
    private static final String TEXT_FK_EMERGENCY_TYPE_ID = "FK_EMERGENCY_TYPE_ID";
    private static final String TEXT_FK_EMERGENCY_STATUS_ID = "FK_EMERGENCY_STATUS_ID";
    private static final String TEXT_FK_SERVER_EMERGENCY_ID = "FK_SERVER_EMERGENCY_ID";

    private static final String TEXT_ID_TYPE = " INTEGER";
    private static final String TEXT_FK_NUMBER_ID_TYPE = " INTEGER";
    private static final String TEXT_FK_EMERGENCY_TYPE_ID_TYPE = " INTEGER";
    private static final String TEXT_FK_EMERGENCY_STATUS_ID_TYPE = " INTEGER";
    private static final String TEXT_FK_SERVER_EMERGENCY_ID_TYPE = " INTEGER";


    private static final String[] columnList = {TEXT_TABLE_NAME, TEXT_ID, TEXT_FK_NUMBER_ID, TEXT_FK_EMERGENCY_TYPE_ID, TEXT_FK_EMERGENCY_STATUS_ID, TEXT_FK_SERVER_EMERGENCY_ID};

    private static final String[] columnListTypes = {TEXT_TABLE_NAME, TEXT_ID_TYPE, TEXT_FK_NUMBER_ID_TYPE,  TEXT_FK_EMERGENCY_TYPE_ID_TYPE, TEXT_FK_EMERGENCY_STATUS_ID_TYPE, TEXT_FK_SERVER_EMERGENCY_ID_TYPE};

    public EmergencyMySecurity() {
    }

    public static String createTable() {
        return "CREATE TABLE " + TEXT_TABLE_NAME + "("
                + TEXT_ID + TEXT_ID_TYPE +" PRIMARY KEY,"
                + TEXT_FK_NUMBER_ID + TEXT_FK_NUMBER_ID_TYPE + ","
                + TEXT_FK_EMERGENCY_TYPE_ID + TEXT_FK_EMERGENCY_TYPE_ID_TYPE + ","
                + TEXT_FK_EMERGENCY_STATUS_ID + TEXT_FK_EMERGENCY_STATUS_ID_TYPE + ","
                + TEXT_FK_SERVER_EMERGENCY_ID + TEXT_FK_SERVER_EMERGENCY_ID_TYPE
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

    public static String getTextFkEmergencyTypeId() {
        return TEXT_FK_EMERGENCY_TYPE_ID;
    }

    public static String getTextFkEmergencyStatusId() {
        return TEXT_FK_EMERGENCY_STATUS_ID;
    }

    public static String getTextFkServerEmergencyId() {
        return TEXT_FK_SERVER_EMERGENCY_ID;
    }

    public static String getTextIdType() {
        return TEXT_ID_TYPE;
    }

    public static String getTextFkNumberIdType() {
        return TEXT_FK_NUMBER_ID_TYPE;
    }

    public static String getTextFkEmergencyTypeIdType() {
        return TEXT_FK_EMERGENCY_TYPE_ID_TYPE;
    }

    public static String getTextFkEmergencyStatusIdType() {
        return TEXT_FK_EMERGENCY_STATUS_ID_TYPE;
    }

    public static String getTextFkServerEmergencyIdType() {
        return TEXT_FK_SERVER_EMERGENCY_ID_TYPE;
    }

    public static String[] getColumnList() {
        return columnList;
    }

    public static String[] getColumnListTypes() {
        return columnListTypes;
    }
}
