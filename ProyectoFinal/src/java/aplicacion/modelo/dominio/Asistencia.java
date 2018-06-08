/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.util.Date;

/**
 *
 * @author natan
 */
public class Asistencia {
    private int codigo;
    private Date fecha;
    private String valor;
    private boolean estado;
    private AulaPorMateria aula;
    private InscripcionAlumno alumnoInscripto;

    public Asistencia() {
    }

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public AulaPorMateria getAula() {
        return aula;
    }

    public void setAula(AulaPorMateria aula) {
        this.aula = aula;
    }

    public InscripcionAlumno getAlumnoInscripto() {
        return alumnoInscripto;
    }

    public void setAlumnoInscripto(InscripcionAlumno alumnoInscripto) {
        this.alumnoInscripto = alumnoInscripto;
    }
    
    
    
}
