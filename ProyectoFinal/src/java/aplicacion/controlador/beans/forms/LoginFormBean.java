/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;


import aplicacion.datos.hibernate.dao.IUsuarioDAO;
import aplicacion.datos.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lorena
 */
@ManagedBean
@RequestScoped
public class LoginFormBean implements Serializable{
    private String nombreUsuario;
    private String password;
    /**
     * Creates a new instance of loginFormBean
     */
    public LoginFormBean() {
    }

    public LoginFormBean(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }
    
    
    public String validarUsuario(){
        String resultado=null;
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        Usuario usuario = usuarioDAO.validarUsuario(nombreUsuario, password);
        if(usuario!=null){
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"usuario valido","usuario valido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado", usuario);
            resultado="menu?faces-redirect=true";
        }else{
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,"credenciales invalidas","credenciales invalidas");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        return resultado;
    }
    
   /* public boolean verificarUsuarioAdm(){
        boolean resultado=false;
         Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioAdmin");
       // String tipo=usuario.getTipoUsuario();
         if(usuario.getTipoUsuario().compareTo("administrador")==0){
           resultado=true; 
        }
        return resultado;
    }*/
    
    public boolean verificarUsuarioAdm(){
        boolean resultado=false;
         if(getTipoUsuario().equals("administrador")){
           resultado=true; 
        }
        return resultado;
    }
    
     public boolean verificarUsuarioSuper(){
        boolean resultado=false;
         if(getTipoUsuario().equals("supervisor")){
           resultado=true; 
        }
        return resultado;
    }
    
     public boolean verificarUsuarioNormal(){
        boolean resultado=false;
         if(getTipoUsuario().equals("normal")){
           resultado=true; 
        }
        return resultado;
    } 
   
    public boolean verificarSesion(){
        boolean sesionValida=false;
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado")!=null){
           sesionValida=true; 
        }
        return sesionValida;
    } 
    
     public String getNombreUsuarioValido() {
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        return usuario.getNombreUsuario();
    }
     
     public String getTipoUsuario() {
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        return usuario.getTipoUsuario();
    }

    public String cerarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesMessage facesMessage=new FacesMessage(FacesMessage.SEVERITY_INFO,"Sesion Cerrada","sesion Cerrada");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        String resultado="/index?faces-redirect=true";
        return resultado;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
