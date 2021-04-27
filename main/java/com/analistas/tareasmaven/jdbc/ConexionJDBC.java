package com.analistas.tareasmaven.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionJDBC {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/tareas_db", "root", "root"); //Cadena de conexión...
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
