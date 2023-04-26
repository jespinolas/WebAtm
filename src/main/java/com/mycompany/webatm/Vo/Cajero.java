package com.mycompany.webatm.Vo;

public class Cajero {
    private int id;
    private String ubicacion;
    private String estado;

    // Constructor
    public Cajero(int id, String ubicacion, String estado) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
