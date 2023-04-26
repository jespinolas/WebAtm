package com.mycompany.webatm.Vo;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Deposito {
    private int id;
    private int id_cajero;
    private int id_cuenta;
    private BigDecimal cantidad_depositada;
    private LocalDateTime fecha_de_deposito;

    // Constructor
    public Deposito(int id, int id_cajero, int id_cuenta, BigDecimal cantidad_depositada, LocalDateTime fecha_de_deposito) {
        this.id = id;
        this.id_cajero = id_cajero;
        this.id_cuenta = id_cuenta;
        this.cantidad_depositada = cantidad_depositada;
        this.fecha_de_deposito = fecha_de_deposito;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cajero() {
        return id_cajero;
    }

    public void setId_cajero(int id_cajero) {
        this.id_cajero = id_cajero;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public BigDecimal getCantidad_depositada() {
        return cantidad_depositada;
    }

    public void setCantidad_depositada(BigDecimal cantidad_depositada) {
        this.cantidad_depositada = cantidad_depositada;
    }

    public LocalDateTime getFecha_de_deposito() {
        return fecha_de_deposito;
    }

    public void setFecha_de_deposito(LocalDateTime fecha_de_deposito) {
        this.fecha_de_deposito = fecha_de_deposito;
    }
}
