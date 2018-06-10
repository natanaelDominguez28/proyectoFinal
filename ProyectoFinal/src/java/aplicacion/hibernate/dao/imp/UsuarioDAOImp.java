/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.hibernate.dao.imp;

import aplicacion.datos.hibernate.dao.IUsuarioDAO;
import aplicacion.modelo.dominio.Usuario;

/**
 *
 * @author natan
 */
public class UsuarioDAOImp  implements IUsuarioDAO{

    @Override
    public Usuario validarUsuario(String nombreUsuario, String password) {
       
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
 
    }

    @Override
    public void modificar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
