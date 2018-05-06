package com.example.leonardo.ejemplosqllite.models;

import java.util.ArrayList;

public class Libro {
    private Integer id, isbn;
    private String nombre, detalle;
    private ArrayList<Autor> autorArrayList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void addAutor(Autor autor){
        autorArrayList.add(autor);
    }

    public Autor getAutor(Integer i){
        return autorArrayList.get(i);
    }

    public ArrayList<Autor> getAllAutor(){
        return autorArrayList;
    }

    public Libro(Integer id, Integer isbn, String nombre, String detalle) {
        this.id = id;
        this.isbn = isbn;
        this.nombre = nombre;
        this.detalle = detalle;
    }
}
