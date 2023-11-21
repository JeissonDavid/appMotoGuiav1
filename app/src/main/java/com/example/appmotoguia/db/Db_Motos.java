package com.example.appmotoguia.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import androidx.annotation.Nullable;

public class Db_Motos extends dbhelper {

    Context context;
    public Db_Motos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarMotos(String modelo, String marca, String ano, String manual, String creado, String imagen) {
        long id = -1;
        try (SQLiteDatabase db = getWritableDatabase()) {
            ContentValues values = new ContentValues();
            values.put("modelo", modelo);
            values.put("marca", marca);
            values.put("ano", ano);
            values.put("manual", manual);
            values.put("creado", creado);
            values.put("imagen", imagen);

            id = db.insert(TABLE_MOTOS, null, values);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return id;
    }
    public Cursor getdata() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM TABLE_MOTOS", null);
        return cursor;
    }

}

