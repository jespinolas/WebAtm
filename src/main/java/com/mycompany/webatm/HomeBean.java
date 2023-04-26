package com.mycompany.webatm;

import com.mycompany.webatm.Vo.Usuario;
import com.mycompany.webatm.conexion.ConexionBD;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

@Named
@SessionScoped
public class HomeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal montoDeposito;
    private String numeroCuentaDeposito;

    public void depositar() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConexionBD.obtenerConexion();
            String query = "SELECT * FROM cuentas WHERE numero_cuenta = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, numeroCuentaDeposito);
            rs = ps.executeQuery();
            if (rs.next()) {
                BigDecimal saldoActual = rs.getBigDecimal("saldo");
                BigDecimal nuevoSaldo = saldoActual.add(montoDeposito);

                query = "UPDATE cuentas SET saldo = ? WHERE numero_cuenta = ?";
                ps = conn.prepareStatement(query);
                ps.setBigDecimal(1, nuevoSaldo);
                ps.setString(2, numeroCuentaDeposito);
                ps.executeUpdate();

                actualizarSaldo();

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Depósito exitoso", "El depósito se ha realizado con éxito"));
                PrimeFaces.current().executeScript("PF('dlgDeposito').hide()");
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "La cuenta ingresada no existe"));
            }
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
        }
    }

    private BigDecimal obtenerSaldo(String numeroCuenta) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BigDecimal saldo = BigDecimal.ZERO;

        try {
            conn = ConexionBD.obtenerConexion();
            String query = "SELECT saldo FROM cuentas WHERE numero_cuenta = ?";
            ps = conn.prepareStatement(query);
            ps.setString(1, numeroCuenta);
            rs = ps.executeQuery();
            if (rs.next()) {
                saldo = rs.getBigDecimal("saldo");
            }
//            PrimeFaces.current().executeScript("update=@form");
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
        }

        return saldo;
    }

    public void actualizarSaldo() {
        Usuario usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        if (usuario != null && usuario.getCuenta() != null) {
            BigDecimal nuevoSaldo = obtenerSaldo(usuario.getCuenta().getNumero_cuenta());
            usuario.getCuenta().setSaldo(nuevoSaldo);
        } else {
            System.out.println("El usuario o su cuenta son nulos");
        }
    }

    public BigDecimal getMontoDeposito() {
        return montoDeposito;
    }

    public void setMontoDeposito(BigDecimal montoDeposito) {
        this.montoDeposito = montoDeposito;
    }

    public String getNumeroCuentaDeposito() {
        return numeroCuentaDeposito;
    }

    public void setNumeroCuentaDeposito(String numeroCuentaDeposito) {
        this.numeroCuentaDeposito = numeroCuentaDeposito;
    }

}
