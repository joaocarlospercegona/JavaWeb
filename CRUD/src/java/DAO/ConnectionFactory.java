/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joao
 */
public class ConnectionFactory {
    public static Connection getConnection() throws ClassNotFoundException { 
    
            try {
                Class.forName("org.postgresql.Driver");
                return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/java",
                "postgres", "1804");
            }
            catch(SQLException e) {
                throw new RuntimeException(e);
            }
            //return null;
            
        }
}
