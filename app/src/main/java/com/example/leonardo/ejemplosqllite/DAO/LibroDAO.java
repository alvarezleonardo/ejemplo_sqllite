package com.example.leonardo.ejemplosqllite.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.leonardo.ejemplosqllite.models.Autor;
import com.example.leonardo.ejemplosqllite.models.Libro;

import java.util.ArrayList;

public class LibroDAO extends MyOpenHelper {
    public LibroDAO(Context context) {
        super(context);
    }

    private void llenarTablas(){
        SQLiteDatabase db = this.conectar();
        ContentValues row = new ContentValues();

        row.put("nombre", "Pedro");
        row.put("apellido", "Alfonso");
        row.put("detalle", "prueba");
        db.insert("autor", null, row);
        db.close();
    }

    public ArrayList<Autor> getAllAutor(){
        ArrayList<Autor> arrayListAutor = new ArrayList<>();
        SQLiteDatabase database = this.conectar();

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

    public ArrayList<Libro> getAllLibro(){
        ArrayList<Autor> arrayListAutor = new ArrayList<>();
        ArrayList<Libro> arrayListLibro = new ArrayList<>();

        SQLiteDatabase database = this.conectar();
        String queryLibro = "select id, nombre, isbn, detalle, precio from libro ";

        Cursor cursor = database.rawQuery(queryLibro, null);

        while(cursor.moveToNext()){
            String queryAutor = "select a.nombre, a.apellido, a.dni, a.id from autor a " +
                    " where exist (select 'x' from autor_libro where id_libro = " + cursor.getInt(cursor.getColumnIndex("id")) + ")" ;
            Cursor cursorAuror = database.rawQuery(queryAutor, null);
            while(cursorAuror.moveToNext()){
                Autor unAutor = new Autor(cursor.getInt(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("apellido")), cursor.getString(cursor.getColumnIndex("nombre")), cursor.getString(cursor.getColumnIndex("detalle")));
                arrayListAutor.add(unAutor);
            }
            arrayListLibro.add(new Libro(cursor.getInt(cursor.getColumnIndex("id")), cursor.getInt(cursor.getColumnIndex("isbn")), cursor.getString(cursor.getColumnIndex("nombre")),  cursor.getString(cursor.getColumnIndex("detalle")), arrayListAutor));
        }
        return arrayListLibro;
    }


    public void cargarAutor(ContentValues row){
        SQLiteDatabase db = getWritableDatabase();
        db.insert("autor", null, row);
    }



}
