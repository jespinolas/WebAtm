package com.mycompany.webatm.Vo;


import java.math.BigDecimal;

public class Cuenta {
    private int id;
    private String numero_cuenta;
    private BigDecimal saldo;
    private int id_usuario;

    // Constructor
    public Cuenta(int id, String numero_cuenta, BigDecimal saldo, int id_usuario) {
        this.id = id;
        this.numero_cuenta = numero_cuenta;
        this.saldo = saldo;
        this.id_usuario = id_usuario;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero_cuenta() {
        return numero_cuenta;
    }

    public void setNumero_cuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    public void depositar(BigDecimal cantidad) {
    this.saldo = this.saldo.add(cantidad);
}

}
