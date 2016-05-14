package tr.mysecurity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import tr.mysecurity.dro.EmergencyDRO;
import tr.mysecurity.entity.EmergencyMySecurity;
import tr.mysecurity.util.Database;

public class EmergencyDao extends Database {
    private static final String tableName = EmergencyMySecurity.getTextTableName();
    private static final String[] columnList = EmergencyMySecurity.getColumnList();
    private static final String[] columnListTypes = EmergencyMySecurity.getColumnListTypes();

    public EmergencyDao(Context context) {
        super(context);
        new Database(context).checkColumns(tableName, columnList, columnListTypes);
    }

    public void resetTable(){
        resetTable(tableName);
    }

    public void dropTable(){
        dropTable(EmergencyMySecurity.dropTable());
    }

    public void createTable(){
        createTable(EmergencyMySecurity.createTable());
    }

    public void addLocalEmergency(EmergencyDRO emergencyDRO){
        resetTable();

        ContentValues values = new ContentValues();

        values.put(EmergencyMySecurity.getTextFkServerEmergencyId(), emergencyDRO.getFkServerEmergencyId());
        values.put(EmergencyMySecurity.getTextFkNumberId(), emergencyDRO.getFkNumberId());
        values.put(EmergencyMySecurity.getTextFkEmergencyStatusId(), emergencyDRO.getFkEmergencyStatusId());
        values.put(EmergencyMySecurity.getTextFkEmergencyTypeId(), emergencyDRO.getFkEmergencyTypeId());

        save(tableName, values);

    }

    public void deleteEmergency(Long id){
        delete(tableName, EmergencyMySecurity.getTextId(), id);
    }

    public void updateEmergency(EmergencyDRO emergencyDRO){
        ContentValues values = new ContentValues();

        values.put(EmergencyMySecurity.getTextFkNumberId(), emergencyDRO.getFkNumberId());
        values.put(EmergencyMySecurity.getTextFkEmergencyStatusId(), emergencyDRO.getFkEmergencyStatusId());
        values.put(EmergencyMySecurity.getTextFkEmergencyTypeId(), emergencyDRO.getFkEmergencyTypeId());

        String whereClause = EmergencyMySecurity.getTextId()+" = "+emergencyDRO.getId();

        update(tableName, values, whereClause, null);
    }


    public EmergencyDRO getEmergency(){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + tableName;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor != null){
            if (cursor.moveToFirst()) {
                return new EmergencyDRO(
                                cursor.getLong(0),
                                cursor.getLong(1),
                                cursor.getLong(2),
                                cursor.getLong(3),
                                cursor.getLong(4)
                );
            }
        }
        return null;
    }
}
