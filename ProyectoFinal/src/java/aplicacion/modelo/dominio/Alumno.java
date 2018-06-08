/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

/**
 *
 * @author natan
 */
public class Alumno {
    private int codigo;
    private String libreta;
    private Carrera carrera;
    private Perfil perfilAlumno;

    public Alumno() {
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLibreta() {
        return libreta;
    }

    public void setLibreta(String libreta) {
        this.libreta = libreta;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Perfil getPerfilAlumno() {
        return perfilAlumno;
    }

    public void setPerfilAlumno(Perfil perfilAlumno) {
        this.perfilAlumno = perfilAlumno;
    }
    
    
}
