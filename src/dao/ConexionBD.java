package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3308/TiendaElect",
                    "root",
                    "");
        } catch (Exception e) {
            System.out.println("Error conexión: " + e);
            return null;
        }
    }
}
