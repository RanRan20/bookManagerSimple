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
    
    private static final String URL = "jdbc:sqlserver://testlibrary.database.windows.net:1433;database=library;user=user1234@testlibrary;password=Contraseña1;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static final String USER = "user1234@testlibrary";
    private static final String PASSWORD = "Contraseña1";

    public static Connection getConnection() {
        Connection connection = null;
        try {
           
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion realizada con exito");
        } catch (ClassNotFoundException e) {
            System.out.println("no se ha encontrado el jdbc driver");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("no se ha podido establecer una conexion con la base de datos");
            e.printStackTrace();
        }
        return connection;
}
}
