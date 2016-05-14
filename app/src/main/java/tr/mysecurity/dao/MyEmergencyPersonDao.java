package tr.mysecurity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import tr.mysecurity.dro.EmergencyPersonDRO;
import tr.mysecurity.entity.MyEmergencyPersonsMySecurity;
import tr.mysecurity.util.Database;

public class MyEmergencyPersonDao extends Database {
    private static final String tableName = MyEmergencyPersonsMySecurity.getTextTableName();
    private static final String[] columnList = MyEmergencyPersonsMySecurity.getColumnList();
    private static final String[] columnListTypes = MyEmergencyPersonsMySecurity.getColumnListTypes();

    public MyEmergencyPersonDao(Context context) {
        super(context);
        new Database(context).checkColumns(tableName, columnList, columnListTypes);
    }

    public void resetTable(){
        resetTable(tableName);
    }

    public void dropTable(){
        dropTable(MyEmergencyPersonsMySecurity.dropTable());
    }

    public void createTable(){
        createTable(MyEmergencyPersonsMySecurity.createTable());
    }

    public void addLocalMyEmergencyPerson(EmergencyPersonDRO emergencyPersonDRO){
        ContentValues values = new ContentValues();

        values.put(MyEmergencyPersonsMySecurity.getTextFkSenderUserId(), emergencyPersonDRO.getFkSenderUserId());
        values.put(MyEmergencyPersonsMySecurity.getTextFkReceiverNumberId(), emergencyPersonDRO.getFkReceiverNumberId());
        values.put(MyEmergencyPersonsMySecurity.getTextAreaCode(), emergencyPersonDRO.getAreaCode());
        values.put(MyEmergencyPersonsMySecurity.getTextNumber(), emergencyPersonDRO.getNumber());
        values.put(MyEmergencyPersonsMySecurity.getTextName(), emergencyPersonDRO.getName());
        values.put(MyEmergencyPersonsMySecurity.getTextSurname(), emergencyPersonDRO.getSurname());
        values.put(MyEmergencyPersonsMySecurity.getTextActive(), emergencyPersonDRO.getActive() ? 1 : 0);
        values.put(MyEmergencyPersonsMySecurity.getTextIsConfirmed(), emergencyPersonDRO.getIsConfirmed() ? 1 : 0);
        values.put(MyEmergencyPersonsMySecurity.getTextIsEmergencyFollow(), emergencyPersonDRO.getIsEmergencyFollow() ? 1 : 0);
        values.put(MyEmergencyPersonsMySecurity.getTextIsEmergencySms(), emergencyPersonDRO.getIsEmergencySms() ? 1 : 0);
        values.put(MyEmergencyPersonsMySecurity.getTextServerEmergencyPersonId(), emergencyPersonDRO.getId());

        save(tableName, values);

    }

    public void deleteMyEmergencyPerson(Long id){
        delete(tableName, MyEmergencyPersonsMySecurity.getTextId(), id);
    }

    public void updateMyEmergencyPerson(EmergencyPersonDRO emergencyPersonDRO){
        ContentValues values = new ContentValues();

        values.put(MyEmergencyPersonsMySecurity.getTextFkSenderUserId(), emergencyPersonDRO.getFkSenderUserId());
        values.put(MyEmergencyPersonsMySecurity.getTextFkReceiverNumberId(), emergencyPersonDRO.getFkReceiverNumberId());
        values.put(MyEmergencyPersonsMySecurity.getTextAreaCode(), emergencyPersonDRO.getAreaCode());
        values.put(MyEmergencyPersonsMySecurity.getTextNumber(), emergencyPersonDRO.getNumber());
        values.put(MyEmergencyPersonsMySecurity.getTextName(), emergencyPersonDRO.getName());
        values.put(MyEmergencyPersonsMySecurity.getTextSurname(), emergencyPersonDRO.getSurname());
        values.put(MyEmergencyPersonsMySecurity.getTextActive(), emergencyPersonDRO.getActive() ? 1 : 0);
        values.put(MyEmergencyPersonsMySecurity.getTextIsConfirmed(), emergencyPersonDRO.getIsConfirmed() ? 1 : 0);
        values.put(MyEmergencyPersonsMySecurity.getTextIsEmergencyFollow(), emergencyPersonDRO.getIsEmergencyFollow() ? 1 : 0);
        values.put(MyEmergencyPersonsMySecurity.getTextIsEmergencySms(), emergencyPersonDRO.getIsEmergencySms() ? 1 : 0);
        values.put(MyEmergencyPersonsMySecurity.getTextServerEmergencyPersonId(), emergencyPersonDRO.getId());

        String whereClause = MyEmergencyPersonsMySecurity.getTextId()+" = "+emergencyPersonDRO.getId();

        update(tableName, values, whereClause, null);
    }


    public List<EmergencyPersonDRO> getMyEmergencyPersons(){
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
