package com.mycompany.webatm.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static Connection conn;
    
    public static Connection obtenerConexion() {
        if (conn != null) {
            return conn;
        } else {
            try {
                String url = "jdbc:sqlserver://localhost:1433;databaseName=webATM;encrypt=false";
                String user = "tronkten";
                String pass = "gogetassj4";
                conn = DriverManager.getConnection(url, user, pass);
            } catch (SQLException e) {
                System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
            }
            return conn;
        }
    }
}
