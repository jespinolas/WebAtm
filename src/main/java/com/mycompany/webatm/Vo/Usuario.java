package com.mycompany.webatm.Vo;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private String correo_electronico;
    private String numero_telefono;
    private String contrasena;
    private Cuenta cuenta;

    // Constructor
    public Usuario(int id, String nombre, String apellido, String correo_electronico, String numero_telefono, String contrasena, Cuenta cuenta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_electronico = correo_electronico;
        this.numero_telefono = numero_telefono;
        this.contrasena = contrasena;
        this.cuenta = cuenta;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getNumero_telefono() {
        return numero_telefono;
    }

    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
