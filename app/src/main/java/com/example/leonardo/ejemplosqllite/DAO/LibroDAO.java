package com.example.leonardo.ejemplosqllite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.leonardo.ejemplosqllite.models.Autor;

import java.util.ArrayList;

public class LibroDAO extends SQLiteOpenHelper {

    private static final String DATABASENAME = "Libreria";
    private static final Integer DATABASEVERSION = 1;
    private Context context;

    public LibroDAO(Context context) {
        super(context, DATABASENAME, null, DATABASEVERSION);
        context = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable;

        createTable = "CREATE TABLE autor (id INTEGER PRIMARY KEY AUTOINCREMENT,  nombre "
                + " TEXT, "
                + " apellido TEXT, "
                + " detalle TEXT "
                + " )";

        db.execSQL(createTable);

        createTable = "CREATE TABLE libro (id INTEGER PRIMARY KEY AUTOINCREMENT,  nombre "
                + " TEXT, "
                + " detalle TEXT, "
                + " isbn INTEGER "
                + " )";

        db.execSQL(createTable);

        createTable = "CREATE TABLE libro_autor (id INTEGER PRIMARY KEY AUTOINCREMENT,  id_autor "
                + " INTEGER, "
                + " id_libro INTEGER "
                + " )";

        db.execSQL(createTable);

        llenarTablas(db);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {



    }

    private void llenarTablas(SQLiteDatabase db){
        ContentValues row = new ContentValues();

        row.put("nombre", "Pedro");
        row.put("apellido", "Alfonso");
        row.put("detalle", "prueba");
        db.insert("autor", null, row);
    }

    public ArrayList<Autor> getAllAutor(){
        ArrayList<Autor> arrayListAutor = new ArrayList<>();

        SQLiteDatabase database = getReadableDatabase();
        String cadenaSql;
        cadenaSql = "select id, nombre, apellido, detalle from autor";
        Cursor cursor = database.rawQuery(cadenaSql, null);

        while(cursor.moveToNext()){

            Autor unAutor = new Autor(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("apellido")), cursor.getString(cursor.getColumnIndex("nombre")), cursor.getString(cursor.getColumnIndex("detalle")));
            arrayListAutor.add(unAutor);
        }

        cursor.close();
        database.close();
        return arrayListAutor;
    }

    public void cargarAutor(ContentValues row){
        SQLiteDatabase db = getWritableDatabase();
        db.insert("autor", null, row);
    }



}
