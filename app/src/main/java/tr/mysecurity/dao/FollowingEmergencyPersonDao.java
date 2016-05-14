package tr.mysecurity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import tr.mysecurity.dro.EmergencyPersonDRO;
import tr.mysecurity.entity.FollowingEmergencyPersonsMySecurity;
import tr.mysecurity.util.Database;


public class FollowingEmergencyPersonDao extends Database {
    private static final String tableName = FollowingEmergencyPersonsMySecurity.getTextTableName();
    private static final String[] columnList = FollowingEmergencyPersonsMySecurity.getColumnList();
    private static final String[] columnListTypes = FollowingEmergencyPersonsMySecurity.getColumnListTypes();

    public FollowingEmergencyPersonDao(Context context) {
        super(context);
        new Database(context).checkColumns(tableName, columnList, columnListTypes);
    }

    public void resetTable(){
        resetTable(tableName);
    }

    public void dropTable(){
        dropTable(FollowingEmergencyPersonsMySecurity.dropTable());
    }

    public void createTable(){
        createTable(FollowingEmergencyPersonsMySecurity.createTable());
    }

    public void addLocalFollowingEmergencyPerson(EmergencyPersonDRO emergencyPersonDRO){
        ContentValues values = new ContentValues();

        values.put(FollowingEmergencyPersonsMySecurity.getTextFkSenderUserId(), emergencyPersonDRO.getFkSenderUserId());
        values.put(FollowingEmergencyPersonsMySecurity.getTextFkReceiverNumberId(), emergencyPersonDRO.getFkReceiverNumberId());
        values.put(FollowingEmergencyPersonsMySecurity.getTextAreaCode(), emergencyPersonDRO.getAreaCode());
        values.put(FollowingEmergencyPersonsMySecurity.getTextNumber(), emergencyPersonDRO.getNumber());
        values.put(FollowingEmergencyPersonsMySecurity.getTextName(), emergencyPersonDRO.getName());
        values.put(FollowingEmergencyPersonsMySecurity.getTextSurname(), emergencyPersonDRO.getSurname());
        values.put(FollowingEmergencyPersonsMySecurity.getTextActive(), emergencyPersonDRO.getActive() ? 1 : 0);
        values.put(FollowingEmergencyPersonsMySecurity.getTextIsConfirmed(), emergencyPersonDRO.getIsConfirmed() ? 1 : 0);
        values.put(FollowingEmergencyPersonsMySecurity.getTextIsEmergencyFollow(), emergencyPersonDRO.getIsEmergencyFollow() ? 1 : 0);
        values.put(FollowingEmergencyPersonsMySecurity.getTextIsEmergencySms(), emergencyPersonDRO.getIsEmergencySms() ? 1 : 0);
        values.put(FollowingEmergencyPersonsMySecurity.getTextServerEmergencyPersonId(), emergencyPersonDRO.getId());

        save(tableName, values);

    }

    public void deleteFollowingEmergencyPerson(Long id){
        delete(tableName, FollowingEmergencyPersonsMySecurity.getTextId(), id);
    }

    public void updateFollowingEmergencyPerson(EmergencyPersonDRO emergencyPersonDRO){
        ContentValues values = new ContentValues();

        values.put(FollowingEmergencyPersonsMySecurity.getTextFkSenderUserId(), emergencyPersonDRO.getFkSenderUserId());
        values.put(FollowingEmergencyPersonsMySecurity.getTextFkReceiverNumberId(), emergencyPersonDRO.getFkReceiverNumberId());
        values.put(FollowingEmergencyPersonsMySecurity.getTextAreaCode(), emergencyPersonDRO.getAreaCode());
        values.put(FollowingEmergencyPersonsMySecurity.getTextNumber(), emergencyPersonDRO.getNumber());
        values.put(FollowingEmergencyPersonsMySecurity.getTextName(), emergencyPersonDRO.getName());
        values.put(FollowingEmergencyPersonsMySecurity.getTextSurname(), emergencyPersonDRO.getSurname());
        values.put(FollowingEmergencyPersonsMySecurity.getTextActive(), emergencyPersonDRO.getActive() ? 1 : 0);
        values.put(FollowingEmergencyPersonsMySecurity.getTextIsConfirmed(), emergencyPersonDRO.getIsConfirmed() ? 1 : 0);
        values.put(FollowingEmergencyPersonsMySecurity.getTextIsEmergencyFollow(), emergencyPersonDRO.getIsEmergencyFollow() ? 1 : 0);
        values.put(FollowingEmergencyPersonsMySecurity.getTextIsEmergencySms(), emergencyPersonDRO.getIsEmergencySms() ? 1 : 0);
        values.put(FollowingEmergencyPersonsMySecurity.getTextServerEmergencyPersonId(), emergencyPersonDRO.getId());

        String whereClause = FollowingEmergencyPersonsMySecurity.getTextId()+" = "+emergencyPersonDRO.getId();

        update(tableName, values, whereClause, null);
    }


    public List<EmergencyPersonDRO> getFollowingEmergencyPersons(){
        List<EmergencyPersonDRO> emergencyPersonDROList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + tableName;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor != null){
            if (cursor.moveToFirst()) {
                EmergencyPersonDRO emergencyPersonDRO = new EmergencyPersonDRO(
                            cursor.getLong(0),
                            cursor.getLong(1),
                            cursor.getLong(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getString(5),
                            cursor.getString(6),
                            cursor.getLong(7) == 1 ? true : false,
                            cursor.getLong(8) == 1 ? true : false,
                            cursor.getLong(9) == 1 ? true : false,
                            cursor.getLong(10) == 1 ? true : false,
                            cursor.getLong(11)
                        );
                emergencyPersonDROList.add(emergencyPersonDRO);
            }
        }
        return emergencyPersonDROList;
    }
}
