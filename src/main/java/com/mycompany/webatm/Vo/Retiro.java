package com.mycompany.webatm.Vo;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Retiro {
    private int id;
    private int id_cajero;
    private int id_cuenta;
    private BigDecimal cantidad_retirada;
    private LocalDateTime fecha_de_retiro;

    // Constructor
    public Retiro(int id, int id_cajero, int id_cuenta, BigDecimal cantidad_retirada, LocalDateTime fecha_de_retiro) {
        this.id = id;
        this.id_cajero = id_cajero;
        this.id_cuenta = id_cuenta;
        this.cantidad_retirada = cantidad_retirada;
        this.fecha_de_retiro = fecha_de_retiro;
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

    public BigDecimal getCantidad_retirada() {
        return cantidad_retirada;
    }

    public void setCantidad_retirada(BigDecimal cantidad_retirada) {
        this.cantidad_retirada = cantidad_retirada;
    }

    public LocalDateTime getFecha_de_retiro() {
        return fecha_de_retiro;
    }

    public void setFecha_de_retiro(LocalDateTime fecha_de_retiro) {
        this.fecha_de_retiro = fecha_de_retiro;
    }
}
