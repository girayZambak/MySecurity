package tr.mysecurity.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import tr.mysecurity.entity.UserMySecurity;


/**
 * Created by usr on 18.1.2016.
 */
public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "sqllite_database";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserMySecurity.createTable());
    }

    public void dropTable(String dropTable){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(dropTable);
    }

    public void createTable(String createTable){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void resetTable(String tableName){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tableName, null, null);
        db.close();
    }

    public void save(String tableName,ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(tableName, null, values);
        db.close();
    }

    public void delete(String tableName,String columnName,Long id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tableName, columnName + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }

    public void update(String tableName, ContentValues values, String whereClause, String[] whereArgs){
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(tableName, values, whereClause, whereArgs);
        db.close();
    }


    public void checkColumns(String tableName, String[] stringList, String[] stringListTypes){
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + tableName;
        Cursor cursor = db.rawQuery(selectQuery, null);

        for(String columnName : stringList){
            int deleteStateColumnIndex = cursor.getColumnIndex(columnName);  // see if the column is there
            if (deleteStateColumnIndex < 0) {
                // missing_column not there - add it
                db.execSQL("ALTER TABLE " + tableName + " ADD COLUMN " + columnName + " int null;");
            }
        }
        db.close();
    }
}
