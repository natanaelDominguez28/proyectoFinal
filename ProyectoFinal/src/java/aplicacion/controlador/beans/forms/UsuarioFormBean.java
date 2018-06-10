/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.datos.hibernate.dao.IUsuarioDAO;
import aplicacion.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author natan
 */
@ManagedBean
@RequestScoped
public class UsuarioFormBean implements Serializable{

     private String nombreUsuario;
    private String password;
    
    /**
     * Creates a new instance of LoginFormBean
     */
    public UsuarioFormBean() {
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

    //validacion del usuario 
    public String validarUsuario(){
        String resultado = null;
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        
        Usuario usuario = usuarioDAO.validarUsuario(nombreUsuario, password);
        
        if(usuario != null){
            //session.put("user", usuario);
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario valido", "Usuario válido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValido", usuario);
            resultado = "menu?faces-redirect=true";
        }else{
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales Invalidas", "Credenciales Invalidas");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            
        }
        return resultado;
    }

    public String getNombreUsuarioValidado(){
        Usuario usuario = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValido");
        return usuario.getNombreUsuario();
    }
    public boolean verificarSesion(){
        boolean sesionValida = false;
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValido")!=null){
            sesionValida=true;
        }
        return sesionValida;
    }
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesión Cerrada", "");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        
        String resultado = "/index?faces-redirect=true";
        return resultado;
    }
    
    
    
    
    
    
   
}