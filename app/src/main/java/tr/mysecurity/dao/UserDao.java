package tr.mysecurity.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Date;

import tr.mysecurity.dro.User;
import tr.mysecurity.entity.UserMySecurity;
import tr.mysecurity.util.Database;
import tr.mysecurity.util.enums.UserControlEnum;

public class UserDao extends Database {
    private static final String tableName = UserMySecurity.getTextTableName();
    private static final String[] columnList = UserMySecurity.getColumnList();
    private static final String[] columnListTypes = UserMySecurity.getColumnListTypes();

    public UserDao(Context context) {
        super(context);
        new Database(context).checkColumns(tableName, columnList, columnListTypes);
    }

    public void resetTable(){
        resetTable(tableName);
    }

    public void dropTable(){
        dropTable(UserMySecurity.dropTable());
    }

    public void createTable(){
        createTable(UserMySecurity.createTable());
    }

    public void addLocalUser(User user){
        resetTable();

        ContentValues values = new ContentValues();

        values.put(UserMySecurity.getTextId(), user.getId());
        values.put(UserMySecurity.getTextFkNumberId(), user.getFkNumberId());
        values.put(UserMySecurity.getTextName(), user.getName());
        values.put(UserMySecurity.getTextSurname(), user.getSurname());
        values.put(UserMySecurity.getTextEMail(), user.geteMail());
        values.put(UserMySecurity.getTextRegId(), user.getRegId());
        //values.put(UserMySecurity.getTextDateOfBirth(), user.getDateOfBirth());
        values.put(UserMySecurity.getTextDeviceId(), user.getDeviceId());
        values.put(UserMySecurity.getTextSimSerialNumber(), user.getSimSerialNumber());
        values.put(UserMySecurity.getTextActive(), user.getActive() ? 1 : 0);
        values.put(UserMySecurity.getTextIsLogin(), user.getIsLogin() ? 1 : 0);
        values.put(UserMySecurity.getTextIsConfirmed(), user.getIsConfirmed() ? 1 : 0);
        values.put(UserMySecurity.getTextAreaCode(), user.getAreaCode());
        values.put(UserMySecurity.getTextNumber(), user.getNumber());
        values.put(UserMySecurity.getTextServerUserId(), user.getServerUserId());

        save(tableName, values);

    }

    public void deleteUser(Long id){
        delete(tableName, UserMySecurity.getTextId(), id);
    }

    public void updateUser(User user){
        ContentValues values = new ContentValues();

        values.put(UserMySecurity.getTextId(), user.getId());
        values.put(UserMySecurity.getTextFkNumberId(), user.getFkNumberId());
        values.put(UserMySecurity.getTextName(), user.getName());
        values.put(UserMySecurity.getTextSurname(), user.getSurname());
        values.put(UserMySecurity.getTextEMail(), user.geteMail());
        values.put(UserMySecurity.getTextRegId(), user.getRegId());
        //values.put(UserMySecurity.getTextDateOfBirth(), user.getDateOfBirth());
        values.put(UserMySecurity.getTextDeviceId(), user.getDeviceId());
        values.put(UserMySecurity.getTextSimSerialNumber(), user.getSimSerialNumber());
        values.put(UserMySecurity.getTextActive(), user.getActive() ? 1 : 0);
        values.put(UserMySecurity.getTextIsLogin(), user.getIsLogin() ? 1 : 0);
        values.put(UserMySecurity.getTextIsConfirmed(), user.getIsConfirmed() ? 1 : 0);
        values.put(UserMySecurity.getTextAreaCode(), user.getAreaCode());
        values.put(UserMySecurity.getTextNumber(), user.getNumber());
        values.put(UserMySecurity.getTextServerUserId(), user.getServerUserId());

        String whereClause = UserMySecurity.getTextId()+" = "+user.getId();

        update(tableName, values, whereClause, null);
    }


    public User getUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + tableName;
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor != null){
            if (cursor.moveToFirst()) {
                return new User(cursor.getLong(0),
                                cursor.getLong(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                cursor.getString(4),
                                cursor.getString(5),
                                new Date(2015,01,01),//Date Olacak
                                cursor.getString(7),
                                cursor.getString(8),
                                cursor.getLong(9) == 1 ? true : false,
                                cursor.getLong(10) == 1 ? true : false,
                                cursor.getLong(11) == 1 ? true : false,
                                cursor.getString(12),
                                cursor.getString(13),
                                cursor.getLong(14)
                        );
            }
        }
        return null;
    }

    public void userLogOut(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE " + tableName + " SET " + UserMySecurity.getTextIsLogin() + " = 0;");
        db.close();
    }

    public void userLogIn(){
        SQLiteDatabase db = this.getReadableDatabase();
        db.execSQL("UPDATE " + tableName + " SET " + UserMySecurity.getTextIsLogin() + " = 1;");
        db.close();
    }

    public UserControlEnum checkUser(){
        User user = getUser();
        if(user == null){
            return UserControlEnum.NO_USER;
        }else if(!user.getIsConfirmed()){
            return UserControlEnum.NOT_CONFIRMED;
        }else if(!user.getIsLogin()){
            return UserControlEnum.LOGGED_OUT;
        }else{
            return UserControlEnum.CHECK_OK;
        }
    }

}
