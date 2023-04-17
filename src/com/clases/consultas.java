package com.clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class consultas extends ConexionDB {

    public boolean registrar(com usr) {

        PreparedStatement ps = null;
        ConexionDB condb = new ConexionDB();
        Connection con = condb.getConexion();
        System.out.println("Conexion" + con);
        String sql = "INSERT INTO tipo_usuario (user, password) VALUES (?,?)";

        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getPassword());
            ps.execute();

            return true;
        } catch (SQLException ex)
        {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ex" + ex);
            return false;
        }

    }  
    
        public boolean login(com usr) {

        ResultSet rs = null;
        PreparedStatement ps = null;
        //ConexionDB condb = new ConexionDB();
        Connection con = getConexion();
        //System.out.println("Conexion" + con);
        String sql = "SELECT id, user, password FROM tipo_usuario WHERE user = ?";

        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                if(usr.getPassword().equals(rs.getString(3))){
                    usr.setId(rs.getInt(1));
                    return true;
                }else{
                    return false;
                }
            }
            return false;
            
        } catch (SQLException ex)
        {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public int existeuser(String usuario) {

        ResultSet rs = null;
        PreparedStatement ps = null;
        //ConexionDB condb = new ConexionDB();
        Connection con = getConexion();
        //System.out.println("Conexion" + con);
        String sql = "SELECT count(id) tipo_usuario WHERE user = ?";

        try
        {
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                return rs.getInt(1);
            }
            return 1;
            
        } catch (SQLException ex)
        {
            Logger.getLogger(consultas.class.getName()).log(Level.SEVERE, null, ex);
            return 1;
        }
    }
    
}
