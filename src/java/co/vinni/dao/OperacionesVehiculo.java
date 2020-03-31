/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.dao;

import co.vinni.dto.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vinni
 */
public class OperacionesVehiculo {
    
    public int insertar(Vehiculo dato){
        Conexion conn = new Conexion();
        Connection miconex = conn.conectarse();
        if(miconex != null){
            try {
                PreparedStatement ps = miconex.prepareStatement(
                        "INSERT INTO vehiculo(placa, precio, marca)VALUES (?, ?, ?)");
                
                ps.setString(1, dato.getPlaca());
                ps.setString(3, dato.getMarca());
                ps.setLong(2, dato.getPrecio());
                
                int rta = ps.executeUpdate();//Insert/Update/delete
                return rta;
                
                
            } catch (SQLException ex) {
                Logger.getLogger(OperacionesVehiculo.class.getName()).log(Level.SEVERE, "Error al insertar Vehiculo", ex);
            }finally{
                conn.desConexion(miconex);
            }
            
        }
        
        
      return 0;  
    }
    public int modificar(Vehiculo dato){
        return 0;
    }
    public int borrar(Vehiculo dato){
        return 0;
    }
    public Vehiculo consultar(String pk){
        return null;
        
    }
    public List<Vehiculo> consultarTodos(){
        return null;
    }
}
