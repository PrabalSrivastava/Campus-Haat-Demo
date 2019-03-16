package com.example.prabal.campushaat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TableControllerHostel extends DatabaseHandler {
    public TableControllerHostel(Context context) {
        super(context);
    }

    public void autoCreate() {
        SQLiteDatabase db = this.getWritableDatabase();
        boolean createSuccessful=false;
        ContentValues values = new ContentValues();
        values.put("address", "Newtown,Kolkata");
        int random = (int )(Math.random() * 3 + 1);
        if(random==1) {
            values.put("name", "Nirmaan Hostel");
            values.put("category", "Hostel"); }
        else if(random==2) {
            values.put("name", "Nirmaan PG");
            values.put("category", "PG"); }
        else if(random==3) {
            values.put("name", "Nirmaan CO-OP");
            values.put("category", "Flat"); }
        createSuccessful = db.insert("hostels", null, values) > 0;
        db.close();

    }

    public int count() {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "SELECT * FROM hostels";
        int recordCount = db.rawQuery(sql, null).getCount();
        db.close();
        return recordCount;
    }

    public List<HostelRecord> read() {
        List<HostelRecord> recordList = new ArrayList<>();
        String sql = "SELECT * FROM hostels ORDER BY id DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {

                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex("id")));
                String hostelName = cursor.getString(cursor.getColumnIndex("name"));
                String hostelAddress = cursor.getString(cursor.getColumnIndex("address"));
                String hostelCategory= cursor.getString(cursor.getColumnIndex("category"));
                HostelRecord objectHostel = new HostelRecord();
                objectHostel.setId(id);
                objectHostel.setName(hostelName);
                objectHostel.setAddress(hostelAddress);
                objectHostel.setCategory(hostelCategory);

                recordList.add(objectHostel);

            } while (cursor.moveToNext());
        }
        return recordList;
    }
}
