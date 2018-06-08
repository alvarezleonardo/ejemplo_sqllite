package com.example.leonardo.ejemplosqllite.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASENAME = "Libreria";
    private static final Integer DATABASEVERSION = 3;
    private Context context;
    private SQLiteDatabase conexion = null;

    public MyOpenHelper(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable;

        createTable = "CREATE TABLE autor (id INTEGER PRIMARY KEY AUTOINCREMENT,  nombre "
                + " TEXT, "
                + " apellido TEXT, "
                + " detalle TEXT, fecha_nac TEXT "
                + " )";

        db.execSQL(createTable);

        createTable = "CREATE TABLE libro (id INTEGER PRIMARY KEY AUTOINCREMENT,  nombre "
                + " TEXT, "
                + " detalle TEXT, "
                + " isbn INTEGER, "
                + " precio INTEGER "
                + " )";

        db.execSQL(createTable);

        createTable = "CREATE TABLE libro_autor (id INTEGER PRIMARY KEY AUTOINCREMENT,  id_autor "
                + " INTEGER, "
                + " id_libro INTEGER "
                + " )";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < 2){
            String query = "alter table autor add column fecha_nac TEXT";
            db.execSQL(query);
        }
        if(oldVersion < 3){
            String query = "alter table libreo add column PRECIO INTEGER";
            db.execSQL(query);
        }
    }

    public SQLiteDatabase conectar(){
        this.conexion = getWritableDatabase();
        return this.conexion;
    }

    public void desconectar(){
        this.conexion.close();
    }

}
