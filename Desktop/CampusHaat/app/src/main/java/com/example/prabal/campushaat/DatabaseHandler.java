package com.example.prabal.campushaat;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    protected static final String DATABASE_NAME="CampusHaatDatabase";
    protected static final int DATABASE_VERSION=1;
    public DatabaseHandler(Context context) {
        //Creating database
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql="CREATE TABLE hostels "+"( id INTEGER PRIMARY KEY AUTOINCREMENT, "+"name TEXT, "+"address TEXT, "+"category TEXT  ) "; //id,firstname,email are columns
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS hostels";
        db.execSQL(sql);
        onCreate(db);
    }
}
