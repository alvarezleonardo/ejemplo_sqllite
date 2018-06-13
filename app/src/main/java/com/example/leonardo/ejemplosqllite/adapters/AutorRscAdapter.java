package com.example.leonardo.ejemplosqllite.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leonardo.ejemplosqllite.R;
import com.example.leonardo.ejemplosqllite.listeners.AutorRVListener;
import com.example.leonardo.ejemplosqllite.models.Autor;

import java.util.ArrayList;

public class AutorRscAdapter extends RecyclerView.Adapter {
    private Context contexto;
    private ArrayList<Autor> autorArrayList;
    private AutorRVListener autorRVListener;

    public AutorRscAdapter(Context contexto, ArrayList<Autor> autorArrayList) {
        this.contexto = contexto;
        this.autorArrayList = autorArrayList;
        this.autorRVListener = new AutorRVListener();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View viewDeLaCelda = inflater.inflate(R.layout.celda_autor,parent,false);
        viewDeLaCelda.setOnClickListener(autorRVListener);

        AutorViewHolder autorViewHolder = new AutorViewHolder(viewDeLaCelda);

        return autorViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Autor unAutor = autorArrayList.get(position);
        AutorViewHolder autorViewHolder = (AutorViewHolder)holder;
        autorViewHolder.cargarAutor(unAutor);

    }

    @Override
    public int getItemCount() {
        return autorArrayList.size();

    }

    private class AutorViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre, apellido, detalle;
        public AutorViewHolder(View itemView) {
            super(itemView);
             nombre = itemView.findViewById(R.id.txtNombre);
             apellido = itemView.findViewById(R.id.txtApellido);
             detalle = itemView.findViewById(R.id.txtDetalle);
        }
        public void cargarAutor(Autor unAutor){
            nombre.setText(unAutor.getNombre());
            apellido.setText(unAutor.getApellido());
            detalle.setText(unAutor.getDetalle());
        }


    }

}
