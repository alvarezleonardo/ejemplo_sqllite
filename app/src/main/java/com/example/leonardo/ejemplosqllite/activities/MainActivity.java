package com.example.leonardo.ejemplosqllite.activities;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.example.leonardo.ejemplosqllite.DAO.LibroDAO;
import com.example.leonardo.ejemplosqllite.R;
import com.example.leonardo.ejemplosqllite.adapters.AutorRscAdapter;
import com.example.leonardo.ejemplosqllite.models.Autor;
import com.example.leonardo.ejemplosqllite.models.Libro;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LibroDAO libroDAO;
    private RecyclerView recyclerViewAutor;
    private AutorRscAdapter autorRscAdapter;
    protected final String TAG = MainActivity.class.getSimpleName();
    public static MainActivity interfaz;
    private ArrayList<Autor> autorArrayList;

    public RecyclerView getRecyclerViewAutor() {
        return recyclerViewAutor;
    }

    public ArrayList<Autor> getAutorArrayList() {
        return autorArrayList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        interfaz = this;
        libroDAO = new LibroDAO(this);

       // this.llenarAutor();
        autorArrayList = libroDAO.getAllAutor();
        autorRscAdapter = new AutorRscAdapter(this, autorArrayList);
        recyclerViewAutor = findViewById(R.id.rscAutor);
        recyclerViewAutor.setAdapter(autorRscAdapter);
        recyclerViewAutor.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerViewAutor.setHasFixedSize(true);


        //Toast.makeText(this, libroDAO.getAllAutor().get(0).getNombre(), Toast.LENGTH_SHORT).show();


    }

    /*
    private void llenarLibro(){
        Autor unAutor = new Autor(2, "Stephen", "King", "Es un comerciante de la literatura");
        Autor unAutorDos = new Autor(3, "Stephen Jr.", "King", "Lo ayuda al padre");
        Libro unlibro = new Libro(1, 1234, "Cujo", "Es un libro de terror");
        unlibro.addAutor(unAutor);
        unlibro.addAutor(unAutorDos);
    }
    */

    public void llenarAutor(){
        ContentValues row = new ContentValues();

        row.put("nombre", "Rodrigo");
        row.put("apellido", "Herera");
        row.put("detalle", "Es un groso y usa capucha");
        libroDAO.cargarAutor(row);
        row.put("nombre", "Emmanuel");
        row.put("apellido", "Arca");
        row.put("detalle", "Es un buen compañero");
        libroDAO.cargarAutor(row);
        row.put("nombre", "Alejandro");
        row.put("apellido", "Pineda");
        row.put("detalle", "Nunca me acuerdo del nombre");
        libroDAO.cargarAutor(row);
        row.put("nombre", "Mariano");
        row.put("apellido", "Pais");
        row.put("detalle", "Se prepara el pan");
        libroDAO.cargarAutor(row);
        row.put("nombre", "Marcelo");
        row.put("apellido", "D'Aversa");
        row.put("detalle", "Le gusta la F1 y tomar mate dulce");
        libroDAO.cargarAutor(row);
        row.put("nombre", "Sebastian");
        row.put("apellido", "Iuliano");
        row.put("detalle", "Es pareja de Ginko en la facu");
        libroDAO.cargarAutor(row);
        row.put("nombre", "German");
        row.put("apellido", "Peveri");
        row.put("detalle", "Le dicen pantera y no llega ni a gatito");
        libroDAO.cargarAutor(row);
    }
}
