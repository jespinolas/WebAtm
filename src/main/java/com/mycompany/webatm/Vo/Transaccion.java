package com.mycompany.webatm.Vo;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaccion {
    private int id;
    private int id_cuenta_origen;
    private int id_cuenta_destino;
    private BigDecimal cantidad_transferida;
    private LocalDateTime fecha_de_transferencia;

    // Constructor
    public Transaccion(int id, int id_cuenta_origen, int id_cuenta_destino, BigDecimal cantidad_transferida, LocalDateTime fecha_de_transferencia) {
        this.id = id;
        this.id_cuenta_origen = id_cuenta_origen;
        this.id_cuenta_destino = id_cuenta_destino;
        this.cantidad_transferida = cantidad_transferida;
        this.fecha_de_transferencia = fecha_de_transferencia;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cuenta_origen() {
        return id_cuenta_origen;
    }

    public void setId_cuenta_origen(int id_cuenta_origen) {
        this.id_cuenta_origen = id_cuenta_origen;
    }

    public int getId_cuenta_destino() {
        return id_cuenta_destino;
    }

    public void setId_cuenta_destino(int id_cuenta_destino) {
        this.id_cuenta_destino = id_cuenta_destino;
    }

    public BigDecimal getCantidad_transferida() {
        return cantidad_transferida;
    }

    public void setCantidad_transferida(BigDecimal cantidad_transferida) {
        this.cantidad_transferida = cantidad_transferida;
    }

    public LocalDateTime getFecha_de_transferencia() {
        return fecha_de_transferencia;
    }

    public void setFecha_de_transferencia(LocalDateTime fecha_de_transferencia) {
        this.fecha_de_transferencia = fecha_de_transferencia;
    }
}
