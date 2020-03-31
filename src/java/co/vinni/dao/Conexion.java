/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinni
 */
public class Conexion {
    public Connection conectarse(){
        
        try {
            Class.forName("org.postgresql.Driver");
            Connection c = DriverManager.getConnection(
            "jdbc:postgresql://127.0.0.1:5432/basehoy", "pruebahoy", "123");
            return c;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error de driver postgres", ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error de datos de conexion postgres", ex);
        }
        return null;
    }
    public void desConexion(Connection c){
        try {
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, "Error al cerrar la conexion", ex);
        }
    }
}
