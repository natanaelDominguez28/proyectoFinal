/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;

import aplicacion.datos.hibernate.dao.IUsuarioDAO;
import aplicacion.datos.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author natan
 */
@ManagedBean
@RequestScoped
public class UsuarioBean implements Serializable{

    private Usuario usuario;
   
    public UsuarioBean() {
        Usuario usuarioSesion=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        if(usuarioSesion!=null){
            String nombreUsuario=usuarioSesion.getNombreUsuario();
             IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
             usuario=usuarioDAO.obtenerUsuario(nombreUsuario);
             if(usuario==null){
                // usuario.setCodigo(2);
                 usuario.setNombreUsuario("lore");
                 usuario.setPassword("lore");
                 usuario.setTipoUsuario("normal");
                 usuario.setEstado(true);
             }
                     
        }
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
     public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
