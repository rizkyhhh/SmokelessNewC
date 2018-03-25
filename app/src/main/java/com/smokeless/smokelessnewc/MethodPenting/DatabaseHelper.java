package com.smokeless.smokelessnewc.MethodPenting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import static com.smokeless.smokelessnewc.MethodPenting.InputContract.inputEntry;
import static com.smokeless.smokelessnewc.MethodPenting.InputContract.inputEntry.TABLE_NAME;

/**
 * Created by Asus A455L on 3/22/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE = "smokeless.db";
    public static final int DATABASE_VERSION = 1;

    private String sql_drop;
    private String sql_table_input;
    SQLiteDatabase db = getWritableDatabase();
    private long result;

    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, DATABASE_VERSION);
        onCreate(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            sql_table_input = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" +
                    inputEntry._ID+ " TEXT PRIMARY KEY, " +
                    inputEntry.COLUMN_JUMLAH_ROKOK + " INTEGER NOT NULL DEFAULT 0);";
            db.execSQL(sql_table_input);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        sql_drop = "DROP TABLE IF EXIST " + TABLE_NAME;
        db.execSQL(sql_drop);
        onCreate(db);
    }

}
