package com.example.leonardo.ejemplosqllite.models;

public class Autor {
    private Integer id, dni;
    private String nombre, apellido, detalle;

    public Integer getId() {
        return id;
    }

    public Integer getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDetalle() {
        return detalle;
    }

    public Autor(Integer id, String nombre, String apellido, String detalle) {
        this.id = id;
         this.nombre = nombre;
        this.apellido = apellido;
        this.detalle = detalle;
    }


}
