/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.vinni.bean;

import co.vinni.dao.OperacionesVehiculo;
import co.vinni.dto.Vehiculo;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Vinni
 */
//@Named(value = "beanVehiculos")
//@Dependent
@ManagedBean
@ViewScoped
public class BeanVehiculos implements Serializable{
    
    private String lamarca;
    private String laplaca;
    private long elprecio;
    private String  mensaje;
    

    /**
     * Creates a new instance of BeanVehiculos
     */
    public BeanVehiculos() {
        
    }

    public String getLamarca() {
        return lamarca;
    }

    public void setLamarca(String lamarca) {
        this.lamarca = lamarca;
    }

    public String getLaplaca() {
        return laplaca;
    }

    public void setLaplaca(String laplaca) {
        this.laplaca = laplaca;
    }

    public long getElprecio() {
        return elprecio;
    }

    public void setElprecio(long elprecio) {
        this.elprecio = elprecio;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public void guardar(){
        System.out.println(" Placa "+this.laplaca);
        System.out.println(" Marca "+this.lamarca);
        System.out.println("Precio "+this.elprecio);
        
        Vehiculo v = new Vehiculo();
        v.setMarca(lamarca);
        v.setPlaca(laplaca);
        v.setPrecio(elprecio);
        
        
        OperacionesVehiculo oper = new OperacionesVehiculo();
        int r = oper.insertar(v);
        System.out.println("rta "+r);
        if (r >0){
        //this.mensaje = "Inserto "+r;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "SE INSERTO VEHICULO PLACA"+"\n"+v.getPlaca()));
        }else{
          FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "NO INSERTO VEHICULO PORQUE YA EXISTE"));
         
        }
    }
    
}
