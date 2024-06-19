/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class Conection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/library"; 
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        Connection connection = null;
        try {
           
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Obtener la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver JDBC no encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo establecer la conexión a la base de datos.");
            e.printStackTrace();
        }
        return connection;
}
}
