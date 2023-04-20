package com.clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexionDB {
    
    private static final String base = "com";
    private static final String user = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/" + base;
    
    public Connection getConexion(){
        Connection con = null;
        try{
        //Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, password); 
    }   catch (Exception ex)
        {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex" + ex);
        }
        
        return con;
    }
}
