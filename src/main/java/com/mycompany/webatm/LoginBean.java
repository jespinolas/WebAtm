package com.mycompany.webatm;

import com.mycompany.webatm.Vo.Cuenta;
import com.mycompany.webatm.Vo.Usuario;
import com.mycompany.webatm.conexion.ConexionBD;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.primefaces.PrimeFaces;

@Named
@SessionScoped
public class LoginBean implements Serializable {

    private String email;
    private String password;
    private boolean loggedIn;
    private Usuario usuario;
    private BigDecimal montoDeposito;
    private String numeroCuentaDeposito;

    public LoginBean() {
        this.loggedIn = false;
        this.usuario = null;
    }

    public String login() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = ConexionBD.obtenerConexion();
            String query = "SELECT * FROM usuarios u JOIN cuentas c ON u.id = c.id_usuario WHERE u.correo_electronico=? AND u.contrasena=?";
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                this.loggedIn = true;
                Cuenta cuenta = new Cuenta(
                        rs.getInt("id"),
                        rs.getString("numero_cuenta"),
                        rs.getBigDecimal("saldo"),
                        rs.getInt("id_usuario")
                );
                this.usuario = new Usuario(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("correo_electronico"),
                        rs.getString("numero_telefono"),
                        rs.getString("contrasena"),
                        cuenta
                );
                return "home?faces-redirect=true";
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Correo electrónico o contraseña incorrectos"));
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
            return null;
        }
    }

    public String logout() {
        this.loggedIn = false;
        this.usuario = null;
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true";
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
