package com.example.leonardo.ejemplosqllite.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import com.example.leonardo.ejemplosqllite.DAO.LibroDAO;
import com.example.leonardo.ejemplosqllite.R;
import com.example.leonardo.ejemplosqllite.models.Autor;
import com.example.leonardo.ejemplosqllite.models.Libro;

public class MainActivity extends AppCompatActivity {
    private LibroDAO libroDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        libroDAO = new LibroDAO(this);

        Toast.makeText(this, libroDAO.getAllAutor().get(0).getNombre(), Toast.LENGTH_SHORT).show();


    }

    private void llenarLibro(){
        Autor unAutor = new Autor(2, "Stephen", "King", "Es un comerciante de la literatura");
        Autor unAutorDos = new Autor(3, "Stephen Jr.", "King", "Lo ayuda al padre");
        Libro unlibro = new Libro(1, 1234, "Cujo", "Es un libro de terror");
        unlibro.addAutor(unAutor);
        unlibro.addAutor(unAutorDos);



    }
}
