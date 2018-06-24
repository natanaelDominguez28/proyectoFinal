/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IUsuarioDAO;
import aplicacion.modelo.dominio.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author Lorena
 */
public class UsuarioDAOImp implements IUsuarioDAO{

     @Override
    public Usuario validarUsuario(String nombreUsuario, String password) {
        Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombreUsuario", nombreUsuario));
        criteria.add(Restrictions.like("password", password));
        criteria.add(Restrictions.eq("estado", true));
        if(!criteria.list().isEmpty()){
            usuario = (Usuario)criteria.list().get(0);
        }
        //session.close();
        return usuario;
    }
    
    
    @Override
    public void agregarUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(usuario);
        session.getTransaction().commit();
        session.close();
    }
    
     @Override
    public Usuario obtenerUsuario(String nombre) {
         Usuario usuario=null;
        Session session = HibernateUtil.getSessionFactory().openSession();
       // session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombreUsuario", nombre));
       // Usuario usuario=null;
       // session.getTransaction().commit();
        if(!criteria.list().isEmpty()){
            usuario = (Usuario)criteria.list().get(0);
        }
        //session.getTransaction().commit();
       // session.close();
        return usuario;
    }
    
    @Override
    public void modificar(Usuario unUsuario) {
       Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       session.update(unUsuario);
       session.getTransaction().commit();
       //session.getTransaction();
       session.close();
    }

   /* @Override
    public Usuario validarUsuario(String nombreUsuario, String password) {
       Usuario u = null;
       boolean esHallado=false;
       for(int i=0;i<ListadoUsuarios.listadoUsuarios.length && esHallado != true;i++){
           Usuario usuarioDelListado=ListadoUsuarios.listadoUsuarios[i];
           if(usuarioDelListado!=null&&usuarioDelListado.getNombreUsuario().equals(nombreUsuario)&&
                   usuarioDelListado.getPassword().equals(password)){
               u=usuarioDelListado;
               esHallado=true;
           }
       }
       return u;
    }

    @Override
    public void modificar(Usuario unUsuario) {
        boolean esHallado=false;
        for(int i=0;i<ListadoUsuarios.listadoUsuarios.length && esHallado!=true;i++){
            Usuario usuarioDelListado=ListadoUsuarios.listadoUsuarios[i];
           if(usuarioDelListado.getNombreUsuario().equals(unUsuario.getNombreUsuario())){
               ListadoUsuarios.listadoUsuarios[i]=unUsuario;
               esHallado=true;
            }
        } 
    }  */  
}
