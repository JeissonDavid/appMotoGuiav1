package com.example.appmotoguia.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NOMBRE ="moto.db";
    public static final String TABLE_USUARIOS ="t_usuarios";
    public static final String TABLE_MOTOS ="t_MOTOS";
    public static final String TABLE_ROLES = "t_roles";

    public static final String TABLE_DOCUMENTOS = "t_roles";




    public dbhelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USUARIOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "usuario TEXT NOT NULL, " +
                "telefono TEXT NOT NULL, " +
                "correo TEXT NOT NULL, " +
                "contraseña TEXT NOT NULL, " +
                "id_rol INTEGER NOT NULL, " +
                "FOREIGN KEY(id_rol) REFERENCES " + TABLE_ROLES + "(id))");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_MOTOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "modelo TEXT, " +
                "marca TEXT , " +
                "ano INTEGER , " +
                "manual LONGTEXT, " +
                "creado TEXT, " +
                "imagen BLOB)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DOCUMENTOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "rol_nombre TEXT NOT NULL)");


        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_ROLES + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "id_moto INTEGER NOT NULL, " +
                "documento BLOB)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
