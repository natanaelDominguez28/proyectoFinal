/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Usuario;

/**
 *
 * @author natan
 */
public interface IUsuarioDAO {
    Usuario validarUsuario(String nombreUsuario, String password);
    void modificar(Usuario unUsuario);
    Usuario obtenerUsuario(String nombreUsuario);
    void agregarUsuario(Usuario usuario);
    
}
