package com.example.leonardo.ejemplosqllite.listeners;

import android.view.View;
import android.widget.Toast;

import com.example.leonardo.ejemplosqllite.activities.MainActivity;
import com.example.leonardo.ejemplosqllite.models.Autor;

public class AutorRVListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {



        Integer posicionTocada =  MainActivity.interfaz.getRecyclerViewAutor().getChildAdapterPosition(v);
        Autor autorAux = MainActivity.interfaz.getAutorArrayList().get(posicionTocada);

        Toast.makeText(MainActivity.interfaz, autorAux.getNombre(), Toast.LENGTH_SHORT).show();
    }
}
